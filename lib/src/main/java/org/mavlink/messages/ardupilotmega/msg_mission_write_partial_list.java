/**
 * Generated class : msg_mission_write_partial_list
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
 * Class msg_mission_write_partial_list
 * This message is sent to the MAV to write a partial list. If start index == end index, only one item will be transmitted / updated. If the start index is NOT 0 and above the current list size, this request should be REJECTED!
 **/
public class msg_mission_write_partial_list extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_MISSION_WRITE_PARTIAL_LIST = 38;
    private static final long serialVersionUID = MAVLINK_MSG_ID_MISSION_WRITE_PARTIAL_LIST;
    /**
     * Start index, 0 by default and smaller / equal to the largest index of the current onboard list.
     */
    public int start_index;
    /**
     * End index, equal or greater than start index.
     */
    public int end_index;
    /**
     * System ID
     */
    public int target_system;
    /**
     * Component ID
     */
    public int target_component;

    public msg_mission_write_partial_list() {
        this(1, 1);
    }

    public msg_mission_write_partial_list(int sysId, int componentId) {
        messageType = MAVLINK_MSG_ID_MISSION_WRITE_PARTIAL_LIST;
        this.sysId = sysId;
        this.componentId = componentId;
        length = 6;
    }

    /**
     * Decode message with raw data
     */
    public void decode(LittleEndianDataInputStream dis) throws IOException {
        start_index = (int) dis.readShort();
        end_index = (int) dis.readShort();
        target_system = (int) dis.readUnsignedByte() & 0x00FF;
        target_component = (int) dis.readUnsignedByte() & 0x00FF;
    }

    /**
     * Encode message with raw data and other informations
     */
    public byte[] encode() throws IOException {
        byte[] buffer = new byte[8 + 6];
        LittleEndianDataOutputStream dos = new LittleEndianDataOutputStream(new ByteArrayOutputStream());
        dos.writeByte((byte) 0xFE);
        dos.writeByte(length & 0x00FF);
        dos.writeByte(sequence & 0x00FF);
        dos.writeByte(sysId & 0x00FF);
        dos.writeByte(componentId & 0x00FF);
        dos.writeByte(messageType & 0x00FF);
        dos.writeShort(start_index & 0x00FFFF);
        dos.writeShort(end_index & 0x00FFFF);
        dos.writeByte(target_system & 0x00FF);
        dos.writeByte(target_component & 0x00FF);
        dos.flush();
        byte[] tmp = dos.toByteArray();
        for (int b = 0; b < tmp.length; b++) buffer[b] = tmp[b];
        int crc = MAVLinkCRC.crc_calculate_encode(buffer, 6);
        crc = MAVLinkCRC.crc_accumulate((byte) IMAVLinkCRC.MAVLINK_MESSAGE_CRCS[messageType], crc);
        byte crcl = (byte) (crc & 0x00FF);
        byte crch = (byte) ((crc >> 8) & 0x00FF);
        buffer[12] = crcl;
        buffer[13] = crch;
        dos.close();
        return buffer;
    }

    public String toString() {
        return "MAVLINK_MSG_ID_MISSION_WRITE_PARTIAL_LIST : " + "  start_index=" + start_index + "  end_index=" + end_index + "  target_system=" + target_system + "  target_component=" + target_component;
    }
}
