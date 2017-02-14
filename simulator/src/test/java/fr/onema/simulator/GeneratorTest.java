package fr.onema.simulator;

import fr.onema.lib.file.FileManager;
import fr.onema.lib.sensor.Temperature;
import fr.onema.lib.sensor.position.GPS;
import fr.onema.lib.virtualizer.entry.VirtualizerEntry;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mavlink.messages.ardupilotmega.msg_global_position_int;
import org.mavlink.messages.ardupilotmega.msg_gps_raw_int;
import org.mavlink.messages.ardupilotmega.msg_scaled_pressure;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Created by you on 13/02/2017.
 */
public class GeneratorTest {
    private final static String refFile = System.getProperty("user.dir") + "/src/test/java/fr/onema/simulator/rawInput.csv";
    private final static String virtualizedFile = System.getProperty("user.dir") + "/src/test/java/fr/onema/simulator/virtualizedOutput.csv";
    private final static FileManager fm = new FileManager(refFile, virtualizedFile);

    @BeforeClass
    public static void prepare() throws Exception {
        File ref = new File(refFile);
        ref.delete();
        File v = new File(virtualizedFile);
        v.delete();
        msg_gps_raw_int msg = new msg_gps_raw_int();
        msg.time_usec = System.currentTimeMillis();
        msg.lat = 2;
        msg.lon = 3;
        msg.alt = 4;
        msg.cog = 5;
        msg_scaled_pressure msg2 = new msg_scaled_pressure();
        msg2.time_boot_ms = msg.time_usec;
        msg2.temperature = 6;
        fm.appendRaw(GPS.build(msg), Temperature.build(msg2));
        msg.time_usec = System.currentTimeMillis();
        msg2.time_boot_ms = msg.time_usec;
        fm.appendRaw(GPS.build(msg), Temperature.build(msg2));
        msg.time_usec = System.currentTimeMillis();
        msg2.time_boot_ms = msg.time_usec;
        fm.appendRaw(GPS.build(msg), Temperature.build(msg2));
    }

    @Test
    public void convert() throws Exception {
        Generator g = new Generator(refFile, virtualizedFile);
        g.convert();
    }

    @AfterClass
    public static void delete() {
        File ref = new File(refFile);
        ref.delete();
        File v = new File(virtualizedFile);
        v.delete();
    }
}