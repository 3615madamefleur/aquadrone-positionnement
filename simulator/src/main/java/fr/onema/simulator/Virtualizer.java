package fr.onema.simulator;

import fr.onema.lib.database.DatabaseDriver;
import fr.onema.lib.database.entity.DiveEntity;
import fr.onema.lib.database.entity.MeasureEntity;
import fr.onema.lib.database.repository.MeasureRepository;
import fr.onema.lib.file.FileManager;
import fr.onema.lib.geo.GPSCoordinate;
import fr.onema.lib.geo.GeoMaths;
import fr.onema.lib.network.NetworkSender;
import fr.onema.lib.tools.Configuration;
import fr.onema.lib.virtualizer.entry.ReferenceEntry;
import fr.onema.lib.virtualizer.entry.VirtualizerEntry;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Jérôme on 08/02/2017.
 */

public class Virtualizer {
    private FileManager fileManager;
    private int speed;
    private String simulationName;
    private int port;
    private String host;
    private long start;
    private long stop;

    private static final Logger LOGGER = Logger.getLogger(Virtualizer.class.getName());

    /**
     * Constructeur qui initialise un FileManager, un entier de vitesse et un nom de simulation
     *
     * @param filePathInput  FileManager
     * @param speed          valeur de la vitesse
     * @param simulationName Nom de la simulation
     * @param host           Adresse de l'hôte
     * @param port           Port sur lequel on se connecte à l'hôte
     */
    public Virtualizer(FileManager filePathInput, int speed, String simulationName, String host, int port) {
        if(speed < 1 || port < 1){
            throw new IllegalArgumentException("Speed and port cannot be negative");
        }else{
            this.port = port;
            this.speed = speed;
        }
        this.fileManager = Objects.requireNonNull(filePathInput);
        this.simulationName = Objects.requireNonNull(simulationName);
        this.host = Objects.requireNonNull(host);
    }

    /**
     * Lance une simulation
     */
    public void start() throws IOException {
        start = System.currentTimeMillis(); //Pour avoir un start en millisecondes
        List<VirtualizerEntry> entries = fileManager.readVirtualizedEntries();
        NetworkSender sender = new NetworkSender(port, host);
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);

        entries.forEach(x -> {
            ScheduledFuture<?> scheduled = executor.schedule(() -> sender.add(x), 1000/speed, TimeUnit.MILLISECONDS);
            try {
                scheduled.get();
            } catch (InterruptedException |ExecutionException e) {
                LOGGER.log(Level.SEVERE, "Interrupted during sending", e);
            }
        });

        stop = System.currentTimeMillis(); //Pour avoir un stop en millisecondes
    }

    /**
     * Récupère la durée de la simulation en millisecondes
     *
     * @return la durée
     */
    public long getDuration() {
        return getStop() - getStart();
    }

    public void compare(FileManager fm, Configuration config, int errorAllowed) throws ComparisonException {
        Objects.requireNonNull(fm);
        Objects.requireNonNull(config);

        DatabaseDriver driver = DatabaseDriver.build(config);
        driver.initAsReadable();
        try {
            List<ReferenceEntry> listRefEntry = fm.readReferenceEntries();
            MeasureRepository repository = MeasureRepository.MeasureRepositoryBuilder.getRepositoryReadable(config);
            DiveEntity dive = repository.getLastDive();
            List<MeasureEntity> listMeasures = driver.getMeasureFrom(dive);
            int minimum = Math.min(listMeasures.size(),listRefEntry.size());
            for(int i = 0; i < minimum;i++){
                sendMessage(fm, listRefEntry.get(i), listMeasures.get(i), errorAllowed);
            }
        } catch (IOException | SQLException e) {
            throw new ComparisonException(e);
        }
    }

    private void sendMessage(FileManager fm, ReferenceEntry ref, MeasureEntity measure, int errVal) {
        try {
            if (ref.getTimestamp() == measure.getTimestamp()) {
                int realLat = ref.getLat();
                int realLon = ref.getLon();
                int realAlt = ref.getAlt();
                GPSCoordinate realPoint = new GPSCoordinate(realLat, realLon, realAlt);
                GPSCoordinate calculatedPoint = measure.getLocationCorrected();
                double distance = GeoMaths.gpsDistance(realPoint, calculatedPoint);

                if (distance > errVal) {
                    fm.appendResults(ref,measure,errVal);
                }
            } else {
                fm.appendResults(ref, measure, errVal);
            }
        }catch(IOException e){
            LOGGER.log(Level.SEVERE, "Couldn't write error in the error file", e);
        }
    }


    /**
     * Récupère le FileManager
     *
     * @return fileManager
     */
    public FileManager getFileManager() {
        return fileManager;
    }

    /**
     * Récupère le vitesse d'obtention de données
     *
     * @return speed
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Récupère le nom de la simulation
     *
     * @return simulationName
     */
    public String getSimulationName() {
        return simulationName;
    }

    /**
     * Récupère le temps de départ
     *
     * @return start
     */
    private long getStart() {
        return start;
    }

    /**
     * Récupère le temps de fin
     *
     * @return stop
     */
    private long getStop() {
        return stop;
    }

    /**
     * Récupère le port vers la base
     *
     * @return port
     */
    public int getPort() {
        return port;
    }

    /**
     * Récupère le host de la base
     *
     * @return host
     */
    public String getHost() {
        return host;
    }
}