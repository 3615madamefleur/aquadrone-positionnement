/**
 * Generated class : msg_terrain_check
 * DO NOT MODIFY!
 **/
package org.mavlink.messages.ardupilotmega;

import org.mavlink.IMAVLinkCRC;
import org.mavlink.MAVLinkCRC;
import org.mavlink.io.LittleEndianDataInputStream;
import org.mavlink.io.LittleEndianDataOutputStream;
import org.mavlink.messages.MAVLinkMessage;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Class msg_terrain_check
 * Request that the vehicle report terrain height at the given location. Used by GCS to check if vehicle has all terrain data needed for a mission.
 **/
public class msg_terrain_check extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_TERRAIN_CHECK = 135;
    private static final long serialVersionUID = MAVLINK_MSG_ID_TERRAIN_CHECK;
    /**
     * Latitude (degrees *10^7)
     */
    public long lat;
    /**
     * Longitude (degrees *10^7)
     */
    public long lon;

    public msg_terrain_check() {
        this(1, 1);
    }

    public msg_terrain_check(int sysId, int componentId) {
        messageType = MAVLINK_MSG_ID_TERRAIN_CHECK;
        this.sysId = sysId;
        this.componentId = componentId;
        length = 8;
    }

    /**
     * Decode message with raw data
     */
    public void decode(LittleEndianDataInputStream dis) throws IOException {
        lat = (int) dis.readInt();
        lon = (int) dis.readInt();
    }

    /**
     * Encode message with raw data and other informations
     */
    public byte[] encode() throws IOException {
        byte[] buffer = new byte[8 + 8];
        LittleEndianDataOutputStream dos = new LittleEndianDataOutputStream(new ByteArrayOutputStream());
        dos.writeByte((byte) 0xFE);
        dos.writeByte(length & 0x00FF);
        dos.writeByte(sequence & 0x00FF);
        dos.writeByte(sysId & 0x00FF);
        dos.writeByte(componentId & 0x00FF);
        dos.writeByte(messageType & 0x00FF);
        dos.writeInt((int) (lat & 0x00FFFFFFFF));
        dos.writeInt((int) (lon & 0x00FFFFFFFF));
        dos.flush();
        byte[] tmp = dos.toByteArray();
        for (int b = 0; b < tmp.length; b++) buffer[b] = tmp[b];
        int crc = MAVLinkCRC.crc_calculate_encode(buffer, 8);
        crc = MAVLinkCRC.crc_accumulate((byte) IMAVLinkCRC.MAVLINK_MESSAGE_CRCS[messageType], crc);
        byte crcl = (byte) (crc & 0x00FF);
        byte crch = (byte) ((crc >> 8) & 0x00FF);
        buffer[14] = crcl;
        buffer[15] = crch;
        dos.close();
        return buffer;
    }

    public String toString() {
        return "MAVLINK_MSG_ID_TERRAIN_CHECK : " + "  lat=" + lat + "  lon=" + lon;
    }
}
