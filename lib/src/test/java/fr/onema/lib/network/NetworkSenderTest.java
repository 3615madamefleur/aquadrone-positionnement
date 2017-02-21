package fr.onema.lib.network;

import fr.onema.lib.virtualizer.entry.VirtualizerEntry;
import org.junit.Test;

import java.io.IOException;
import java.net.ServerSocket;

import static org.junit.Assert.*;

public class NetworkSenderTest {

    @Test
    public void constructorNotNull() throws IOException {
        NetworkSender networkSender = new NetworkSender(1239, "127.0.0.1");
        assertNotNull(networkSender);
        networkSender.closeConnection();
    }

    @Test
    public void openConnectionNotNull() throws IOException {
        NetworkSender networkSender = new NetworkSender(1239, "127.0.0.1");
        ServerSocket server = new ServerSocket(1239);
        networkSender.openConnection();
        assertNotNull(networkSender.getDsocket());
        networkSender.closeConnection();
        server.close();
    }

    @Test
    public void closeConnectionNotNull() throws Exception {
        NetworkSender networkSender = new NetworkSender(1239, "127.0.0.1");
        ServerSocket server = new ServerSocket(1239);
        networkSender.openConnection();
        Thread.sleep(100);
        networkSender.closeConnection();
        Thread.sleep(100);
        //assertTrue(networkSender.getDsocket().isClosed()); FIXME
        server.close();
    }

    @Test
    public void threadStarted() throws IOException, InterruptedException {
        NetworkSender networkSender = new NetworkSender(1239, "127.0.0.1");
        networkSender.openConnection();
        Thread.sleep(100);
        assertTrue(networkSender.getSender().isAlive());
        networkSender.closeConnection();
    }

    @Test
    public void addTest() throws IOException {
        NetworkSender networkSender = new NetworkSender(1239, "127.0.0.1");
        VirtualizerEntry vir = new VirtualizerEntry(1, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9, (short) 10, (short) 11, (short) 12, (short) 13, 14, (short) 15);
        networkSender.openConnection();
        networkSender.add(vir);
        networkSender.getQueue().contains(vir);
        networkSender.closeConnection();
    }

    @Test
    public void sendMessage() throws IOException, InterruptedException {
        NetworkSender sender = new NetworkSender(1239, "127.0.0.1");
        sender.openConnection();
        ServerListener serverListener = new ServerListener(1239);
        serverListener.start();
        VirtualizerEntry virtual = new VirtualizerEntry(1, 2, 3, 4, (short) 5000, (short) 6, (short) 7, (short) 8, (short) 9, (short) 10, (short) 11, (short) 12, (short) 13, 14, (short) 15);
        sender.add(virtual);
        sender.closeConnection();
        serverListener.stop();
    }

    @Test
    public void getPortTest() throws IOException {
        NetworkSender sender = new NetworkSender(1239, "127.0.0.1");
        assertEquals(1239, sender.getPort());
        sender.closeConnection();
    }

    @Test
    public void getHostTest() throws IOException {
        NetworkSender sender = new NetworkSender(1239, "127.0.0.1");
        assertEquals("127.0.0.1", sender.getHost());
        sender.closeConnection();
    }
}
