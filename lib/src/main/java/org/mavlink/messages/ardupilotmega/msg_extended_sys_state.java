/**
 * Generated class : msg_extended_sys_state
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
 * Class msg_extended_sys_state
 * Provides state for additional features
 **/
public class msg_extended_sys_state extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_EXTENDED_SYS_STATE = 245;
    private static final long serialVersionUID = MAVLINK_MSG_ID_EXTENDED_SYS_STATE;
    /**
     * The VTOL state if applicable. Is set to MAV_VTOL_STATE_UNDEFINED if UAV is not in VTOL configuration.
     */
    public int vtol_state;
    /**
     * The landed state. Is set to MAV_LANDED_STATE_UNDEFINED if landed state is unknown.
     */
    public int landed_state;

    public msg_extended_sys_state() {
        this(1, 1);
    }

    public msg_extended_sys_state(int sysId, int componentId) {
        messageType = MAVLINK_MSG_ID_EXTENDED_SYS_STATE;
        this.sysId = sysId;
        this.componentId = componentId;
        length = 2;
    }

    /**
     * Decode message with raw data
     */
    public void decode(LittleEndianDataInputStream dis) throws IOException {
        vtol_state = (int) dis.readUnsignedByte() & 0x00FF;
        landed_state = (int) dis.readUnsignedByte() & 0x00FF;
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
        dos.writeByte(vtol_state & 0x00FF);
        dos.writeByte(landed_state & 0x00FF);
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
        return "MAVLINK_MSG_ID_EXTENDED_SYS_STATE : " + "  vtol_state=" + vtol_state + "  landed_state=" + landed_state;
    }
}
