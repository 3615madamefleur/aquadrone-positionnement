package fr.onema.lib.tools;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by Jérôme on 06/02/2017.
 */
public class ConfigurationTest {
    private final static String content = "divedata.delaicapteurhs=30\n" +
            "offset.acc.x=0.0\n" +
            "database.base=test\n" +
            "database.user=test\n" +
            "database.password=test\n" +
            "geo.srid=4326\n" +
            "divedata.frequencetestmavlink=1\n" +
            "database.port=5432\n" +
            "divedata.precision=0.5\n" +
            "divedata.mouvementsmax=4\n" +
            "database.notify-key=siren_key\n" +
            "divedata.dureemax=120\n" +
            "divedata.frequencetestdatabase=1\n" +
            "divedata.coefficientrangeimu=0.732\n" +
            "offset.acc.z=0.0\n" +
            "database.host=aquadrone.local\n" +
            "offset.acc.y=140.0\n" +
            "geo.magneticnorthlatitude=86.5";
    private Configuration config = Configuration.getInstance();
    private File filePath;

    public ConfigurationTest() throws FileNotFoundException {
    }

    @Before
    public void setUp() throws Exception {
        try {
            filePath = File.createTempFile("test", "properties");
            PrintWriter writer = new PrintWriter(filePath.getCanonicalFile(), "UTF-8");
            writer.println(content);
            writer.close();
        } catch (IOException e) {
            fail();
        }
    }

    @After
    public void tearDown() throws Exception {
        filePath.delete();
    }

    @Test(expected = NullPointerException.class)
    public void testNoPath() throws Exception {
        Configuration.build(null);
    }

    @Test(expected = IllegalStateException.class)
    public void testBadPath() throws Exception {
        Configuration.build("/toto/test/abcd");
    }

    @Test
    public void testRead() throws Exception {
        Configuration.build(filePath.getAbsolutePath());

        assertEquals(0, config.getOffset().getAccelerationOffsetX(), 0);
        assertEquals(140, config.getOffset().getAccelerationOffsetY(), 0);
        assertEquals(0, config.getOffset().getAccelerationOffsetZ(), 0);

        assertEquals("aquadrone.local", config.getDatabaseInformation().getHostname());
        assertEquals(5432, config.getDatabaseInformation().getPort());
        assertEquals("test", config.getDatabaseInformation().getBase());
        assertEquals("test", config.getDatabaseInformation().getUsername());
        assertEquals("test", config.getDatabaseInformation().getPassword());
        assertEquals("siren_key", config.getDatabaseInformation().getNotifyKey());

        assertEquals(4326, config.getGeo().getSrid());

        assertEquals(0.5, config.getDiveData().getPrecision(), 0);
        assertEquals(120, config.getDiveData().getDureemax());
        assertEquals(4, config.getDiveData().getMouvementsmax());
        assertEquals(30, config.getDiveData().getDelaicapteurhs());
        assertEquals(1, config.getDiveData().getFrequencetestmavlink());
        assertEquals(1, config.getDiveData().getFrequencetestdatabase());
    }
}
