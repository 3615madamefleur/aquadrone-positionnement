/**
 * Generated class : msg_autopilot_version_request
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
 * Class msg_autopilot_version_request
 * Request the autopilot version from the system/component.
 **/
public class msg_autopilot_version_request extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_AUTOPILOT_VERSION_REQUEST = 183;
    private static final long serialVersionUID = MAVLINK_MSG_ID_AUTOPILOT_VERSION_REQUEST;
    /**
     * System ID
     */
    public int target_system;
    /**
     * Component ID
     */
    public int target_component;

    public msg_autopilot_version_request() {
        this(1, 1);
    }

    public msg_autopilot_version_request(int sysId, int componentId) {
        messageType = MAVLINK_MSG_ID_AUTOPILOT_VERSION_REQUEST;
        this.sysId = sysId;
        this.componentId = componentId;
        length = 2;
    }

    /**
     * Decode message with raw data
     */
    public void decode(LittleEndianDataInputStream dis) throws IOException {
        target_system = (int) dis.readUnsignedByte() & 0x00FF;
        target_component = (int) dis.readUnsignedByte() & 0x00FF;
    }

    /**
     * Encode message with raw data and other informations
     */
    public byte[] encode() throws IOException {
        byte[] buffer = new byte[8 + 2];
        LittleEndianDataOutputStream dos = new LittleEndianDataOutputStream(new ByteArrayOutputStream());
        dos.writeByte((byte) 0xFE);
        dos.writeByte(length & 0x00FF);
        dos.writeByte(sequence & 0x00FF);
        dos.writeByte(sysId & 0x00FF);
        dos.writeByte(componentId & 0x00FF);
        dos.writeByte(messageType & 0x00FF);
        dos.writeByte(target_system & 0x00FF);
        dos.writeByte(target_component & 0x00FF);
        dos.flush();
        byte[] tmp = dos.toByteArray();
        for (int b = 0; b < tmp.length; b++) buffer[b] = tmp[b];
        int crc = MAVLinkCRC.crc_calculate_encode(buffer, 2);
        crc = MAVLinkCRC.crc_accumulate((byte) IMAVLinkCRC.MAVLINK_MESSAGE_CRCS[messageType], crc);
        byte crcl = (byte) (crc & 0x00FF);
        byte crch = (byte) ((crc >> 8) & 0x00FF);
        buffer[8] = crcl;
        buffer[9] = crch;
        dos.close();
        return buffer;
    }

    public String toString() {
        return "MAVLINK_MSG_ID_AUTOPILOT_VERSION_REQUEST : " + "  target_system=" + target_system + "  target_component=" + target_component;
    }
}
