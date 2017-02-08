package fr.onema.lib.tools;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Objects;
import java.util.Properties;

/**
 * Class permettant de maipuler la configuration de l'application.
 * <p>
 * Utilisation :
 * Configuration exemple = Configuration.build(path/production.properties);
 * exemple.getDatabaseInformation.getHostname() // Permet de récupérer les informations de connexion de la BDD
 */
public class Configuration {
    private static final String DB_HOST = "database.host";
    private static final String DB_PORT = "database.port";
    private static final String DB_BASE = "database.base";
    private static final String DB_USER = "database.user";
    private static final String DB_TOKEN = "database.password";
    private static final String DB_NOTIFY_KEY = "database.notify-key";
    private static final String GEO_SRID = "geo.srid";
    private static final String FLOW_LAT = "flow.lat";
    private static final String FLOW_LON = "flow.lon";
    private static final String FLOW_ALT = "flow.alt";

    private final String path;
    private final Database database;
    private final Geo geo;
    private final Flow flow;

    private Configuration(String path, Properties properties) throws FileNotFoundException {
        this.path = path;
        this.database = new Database(
                properties.getProperty(DB_HOST),
                Integer.parseInt(properties.getProperty(DB_PORT)),
                properties.getProperty(DB_BASE),
                properties.getProperty(DB_USER),
                properties.getProperty(DB_TOKEN),
                properties.getProperty(DB_NOTIFY_KEY)
        );
        this.geo = new Geo(Integer.parseInt(properties.getProperty(GEO_SRID)));
        this.flow = new Flow(
                Integer.parseInt(properties.getProperty(FLOW_LAT)),
                Integer.parseInt(properties.getProperty(FLOW_LON)),
                Integer.parseInt(properties.getProperty(FLOW_ALT))
        );
    }

    /**
     * Builder permettant de créer une représentation des paramètres
     *
     * @param path CHemin d'accès au fichier de configuration
     * @return La représentation du fichier de configuration
     * @throws FileNotFoundException En cas d'absence de fichier de configuration
     */
    public static Configuration build(String path) throws FileNotFoundException {
        Objects.requireNonNull(path, "A non null path is required for the settings");

        try (FileInputStream input = new FileInputStream(path)) {
            Properties properties = new Properties();
            properties.load(input);

            return new Configuration(path, properties);
        } catch (FileNotFoundException e) {
            throw e;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * On entre une latitude, une longitude et une altitude. Ces valeurs sont comparées
     * à celles présentes dans notre fichier de configuration. En cas de différence on remplace, à l'intérieur
     * du fichier, l'ancienne valeur par la nouvelle valeur
     *
     * @param x Latitude
     * @param y Longitude
     * @param z Altitude
     * @throws IOException -Si le fichier n'est pas trouvé
     *                     -Si l'écriture dans ce fichier plante
     *                     -Si on ne peut pas fermer le fichier de sortie(probablement parce qu'il l'est déjà)
     */
    public void setCorrection(int x, int y, int z) throws IOException {
        if (flow.update(x, y, z)) {
            update();
        }
    }

    private void update() throws IOException {
        Properties properties = new Properties();
        properties.put(DB_HOST, database.getHostname());
        properties.put(DB_PORT, Integer.toString(database.getPort()));
        properties.put(DB_BASE, database.getBase());
        properties.put(DB_USER, database.getUsername());
        properties.put(DB_TOKEN, database.getPassword());
        properties.put(DB_NOTIFY_KEY, database.getNotifyKey());

        properties.put(GEO_SRID, Integer.toString(geo.getSrid()));

        properties.put(FLOW_LAT, Integer.toString(flow.getLat()));
        properties.put(FLOW_LON, Integer.toString(flow.getLon()));
        properties.put(FLOW_ALT, Integer.toString(flow.getAlt()));

        PrintStream output = new PrintStream(path);
        properties.store(output, null);
    }

    /**
     * Méthode permettant de récupérer la configuration de la base de données.
     * Pour plus de détails se référer à {@link Database}.
     *
     * @return La configuration de la base de données
     */
    public Database getDatabaseInformation() {
        return database;
    }

    /**
     * Méthode permettant de récupérer les informations relatives à la géographie de l'application.
     * Pour plus de détails se référer à {@link Geo}.
     *
     * @return La configuration géographique de l'application
     */
    public Geo getGeo() {
        return geo;
    }

    /**
     * Méthode permettant de récupérer la configuration des courrants (pour la correction de position.
     * Pour plus de détails se référer à {@link Flow} et {@link Dive}.
     *
     * @return La configuration géographique de l'application
     */
    public Flow getFlow() {
        return flow;
    }

    /**
     * Class représentant le courant d'eau
     */
    public final class Flow {
        private int lat;
        private int lon;
        private int alt;

        Flow(int lat, int lon, int alt) {
            this.lat = lat;
            this.lon = lon;
            this.alt = alt;
        }

        /**
         * Méthode permettant d'obtenir le courant présent sur l'axe latitudinale
         *
         * @return Le courant en latitude
         */
        public int getLat() {
            return lat;
        }

        /**
         * Méthode permettant d'obtenir le courant présent sur l'axe longitudinal
         *
         * @return Le courant en longitude
         */
        public int getLon() {
            return lon;
        }

        /**
         * Méthode permettant d'obtenir le courant présent sur l'axe de la profondeur
         *
         * @return Le courant en profondeur
         */
        public int getAlt() {
            return alt;
        }

        boolean update(int lat, int lon, int alt) {
            boolean edited = false;

            if (lat != this.lat) {
                this.lat = lat;
                edited = true;
            }

            if (lon != this.lon) {
                this.lon = lon;
                edited = true;
            }

            if (alt != this.alt) {
                this.alt = alt;
                edited = true;
            }

            return edited;
        }
    }

    /**
     * Class représentant la configuration de la base de données
     */
    public final class Database {
        private final String hostname;
        private final int port;
        private final String base;
        private final String username;
        private final String password;
        private final String notifyKey;

        Database(String hostname, int port, String base, String username, String password, String notifyKey) {
            this.hostname = hostname;
            this.port = port;
            this.base = base;
            this.username = username;
            this.password = password;
            this.notifyKey = notifyKey;
        }

        /**
         * Méthode permettant d'obtenir le nom d'hôte de la BDD
         *
         * @return Nom d'hôte de la BDD
         */
        public String getHostname() {
            return hostname;
        }

        /**
         * Méthode permettant d'obtenir le port de la BDD
         *
         * @return Port de la BDD
         */
        public int getPort() {
            return port;
        }

        /**
         * Méthode permettant d'obtenir le nom de la base relatif à l'application
         *
         * @return Le nom de la base
         */
        public String getBase() {
            return base;
        }

        /**
         * Méthode permettant d'obtenir le nom d'utilisateur pour la connexion à la BDD
         *
         * @return Le nom d'utilisateur
         */
        public String getUsername() {
            return username;
        }

        /**
         * Méthode permettant d'obtenir le mot de passe pour la connexion à la BDD
         *
         * @return Le mot de passe
         */
        public String getPassword() {
            return password;
        }

        /**
         * Méthode permettant d'obtenir la clé de notification pour la BDD
         *
         * @return La clé de notification
         */
        public String getNotifyKey() {
            return notifyKey;
        }
    }

    /**
     * Class représentant la configuration des données géographiques
     */
    public final class Geo {
        private final int srid;

        Geo(int srid) {
            this.srid = srid;
        }

        /**
         * Méthode permettant d'obtenir le SRID des données à stocker en base
         *
         * @return Le SRID souhaité
         */
        public int getSrid() {
            return srid;
        }
    }
}
