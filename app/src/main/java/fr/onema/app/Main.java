package fr.onema.app;

import fr.onema.app.view.RootLayoutController;
import fr.onema.lib.network.ServerListener;
import fr.onema.lib.tools.Configuration;
import fr.onema.lib.worker.DatabaseWorker;
import fr.onema.lib.worker.MessageWorker;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.commons.cli.*;

import java.util.logging.Level;
import java.util.logging.Logger;

/***
 * Classe Main de l'application graphique
 */
public class Main extends Application {
    public static final double HORIZONTAL_DEFAULT_VALUE = 0;
    public static final double VERTICAL_DEFAULT_VALUE = 0;
    public static final double DEPTH_DEFAULT_VALUE = 0;
    private static final String DEBUG_ARGUMENT_SHORT = "d";
    private static final String DEBUG_ARGUMENT = "debug";
    private static final int NUMBER_OF_ARGS_DEBUG = 1;
    private static final String JAR_NAME = "simulator";
    private static final String USAGE = "\t" + JAR_NAME +
            "\t" + JAR_NAME + " --" + DEBUG_ARGUMENT + " log.csv" +
            "\n\n\n";
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    private static String LOG_FILE = null;
    private Stage parent;
    private ServerListener server;
    private Configuration configuration;
    private DatabaseWorker databaseWorker;
    private MessageWorker messageWorker;
    private RootLayoutController rlc;

    public static void main(String[] args) {
        CommandLineParser parser = new DefaultParser();
        Options options = initOptions();

        try {
            CommandLine command = parser.parse(options, args);
            action(command);
            launch(args);
        } catch (ParseException e) {
            printHelp(options);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        } finally {
            System.exit(0);
        }

    }

    /**
     * Initialisation des options pour l'interface ligne de commande
     *
     * @return Options instanciées
     */
    private static Options initOptions() {
        Option debugOption = Option.builder(DEBUG_ARGUMENT_SHORT)
                .longOpt(DEBUG_ARGUMENT)
                .argName(DEBUG_ARGUMENT)
                .desc("Permet de generer un fichier de debug representant les messages MAVLink. Le fichier de sortie est" +
                        "au format \"Simulation\".")
                .numberOfArgs(NUMBER_OF_ARGS_DEBUG)
                .build();

        return new Options()
                .addOption(debugOption);
    }

    /**
     * Affichage de l'aide sur [System.out]
     *
     * @param options liste des options à afficher
     */
    private static void printHelp(Options options) {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp(JAR_NAME, USAGE, options, "", false);
    }

    /**
     * Filtre et exécute les actions relativent au paramètres passés en paramètres
     */
    private static void action(CommandLine command) {
        if (command.hasOption(DEBUG_ARGUMENT_SHORT)) {
            LOG_FILE = command.getOptionValues(DEBUG_ARGUMENT_SHORT)[0];
        }
    }

    public RootLayoutController getRlc() {
        return rlc;
    }

    /***
     * Méthode start appelée lors de l'initialisation de l'application pour définir les paramètres du conteneur de base
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        this.configuration = Configuration.getInstance();
        this.databaseWorker = DatabaseWorker.getInstance();
        this.databaseWorker.init(configuration);
        this.databaseWorker.start();
        this.server = new ServerListener(14550);
        this.server.start();
        this.messageWorker = server.getMessageWorker();
        // TODO : load Tracer if LOG_FILE != null
        this.parent = primaryStage;
        this.parent.setTitle("App");
        this.parent.resizableProperty().set(false);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("view/RootLayout.fxml"));
        rlc = new RootLayoutController(this);
        fxmlLoader.setController(rlc);
        fxmlLoader.load();
        primaryStage.setScene(new Scene(fxmlLoader.getRoot()));
        primaryStage.sizeToScene();
        primaryStage.setAlwaysOnTop(true);
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        server.stop();
        databaseWorker.stop();
    }

    public void execute() {
        messageWorker.startRecording();
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public MessageWorker getMessageWorker() {
        return messageWorker;
    }

    public Stage getParent() {
        return parent;
    }

    public void stopExecution() {
        messageWorker.stopRecording();
    }
}
