package fr.onema.lib.File;

import fr.onema.lib.database.entity.MeasureEntity;
import fr.onema.lib.file.FileManager;
import fr.onema.lib.geo.GPSCoordinate;
import fr.onema.lib.sensor.Temperature;
import fr.onema.lib.sensor.position.GPS;
import fr.onema.lib.virtualizer.entry.ReferenceEntry;
import fr.onema.lib.virtualizer.entry.VirtualizerEntry;
import org.junit.*;
import org.mavlink.messages.ardupilotmega.msg_global_position_int;
import org.mavlink.messages.ardupilotmega.msg_scaled_pressure;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Created by you on 07/02/2017.
 */
public class FileManagerTest {
    private final static String refFile = System.getProperty("user.dir") + "/src/test/java/fr/onema/lib/File/rawInput.csv";
    private final static String virtualizedFile = System.getProperty("user.dir") + "/src/test/java/fr/onema/lib/File/virtualizedOutput.csv";
    private final static String resultsFile = System.getProperty("user.dir") + "/src/test/java/fr/onema/lib/File/resultsOutput.csv";
    private final static FileManager fm = new FileManager(refFile, virtualizedFile, resultsFile);

    @BeforeClass
    public static void prepare() throws Exception {
        File ref = new File(refFile);
        ref.delete();
        File v = new File(virtualizedFile);
        v.delete();
        File res = new File(resultsFile);
        res.delete();
        msg_global_position_int msg = new msg_global_position_int();
        msg.time_boot_ms = 1;
        msg.lat = 2;
        msg.lon = 3;
        msg.alt = 4;
        msg.hdg = 5;
        msg_scaled_pressure msg2 = new msg_scaled_pressure();
        msg2.time_boot_ms = 0;
        msg2.temperature = 6;
        fm.appendRaw(GPS.build(msg), Temperature.build(msg2));
        fm.appendVirtualized(new VirtualizerEntry(1, 2, 3, 4, (short)5, (short)6, (short)7, (short)8, (short)9,
                (short)10, (short)11, (short)12, (short)13, 14, (short)15));
    }

    @Test
    public void readReferenceEntries() throws Exception {
        ReferenceEntry r = fm.readReferenceEntries().get(0);
        assertEquals(r.getTimestamp(), 1);
        assertEquals(r.getLat(), 2);
        assertEquals(r.getLon(), 3);
        assertEquals(r.getAlt(), 4);
        assertEquals(r.getDirection(), (float)5, 0);
        assertEquals(r.getTemperature(), 6);
    }

    @Test
    public void readVirtualizedEntries() throws Exception {
        VirtualizerEntry v = fm.readVirtualizedEntries().get(0);
        assertEquals(v.getTimestamp(), 1);
        assertEquals(v.getGpsLon(), 3);
        assertEquals(v.getGpsLat(), 2);
        assertEquals(v.getGpsAlt(), 4);
        assertEquals(v.getXacc(),5);
        assertEquals(v.getYacc(),6);
        assertEquals(v.getZacc(),7);
        assertEquals(v.getXgyro(),8);
        assertEquals(v.getYgyro(),9);
        assertEquals(v.getZgyro(),10);
        assertEquals(v.getXmag(),11);
        assertEquals(v.getYmag(),12);
        assertEquals(v.getZmag(),13);
        assertEquals(v.getTemperature(),15);
    }

    @Test
    public void appendRaw() throws Exception {
        msg_global_position_int msg = new msg_global_position_int();
        msg.time_boot_ms = 0;
        msg.lat = 1;
        msg.lon = 2;
        msg.alt = 3;
        msg.hdg = 4;
        msg_scaled_pressure msg2 = new msg_scaled_pressure();
        msg2.time_boot_ms = 0;
        msg2.temperature = 5;
        fm.appendRaw(GPS.build(msg), Temperature.build(msg2));
    }

    @Test
    public void appendVirtualized() throws Exception {
        fm.appendVirtualized(new VirtualizerEntry(0, 1, 2, 3, (short)4, (short)5, (short)6,
                (short)7, (short)8, (short)9,(short)10,(short)11,(short)12,13,(short) 14));
    }

    @Test
    public void appendResults() throws Exception {
        FileManager fm = new FileManager(refFile, virtualizedFile, resultsFile);
        fm.openFileForResults();
        ReferenceEntry re = new ReferenceEntry(0,4,5,6,(float)7,(short)8);
        MeasureEntity m = new MeasureEntity(
                0, new GPSCoordinate(4,5,6), new GPSCoordinate(1,2,3), 0, 0, 0, 0, 0, 0, 13, "test");
        fm.appendResults(re, m, 14);
    }

    @AfterClass
    public static void delete() {
        File ref = new File(refFile);
        ref.delete();
        File v = new File(virtualizedFile);
        v.delete();
        File res = new File(resultsFile);
        res.delete();
    }
}