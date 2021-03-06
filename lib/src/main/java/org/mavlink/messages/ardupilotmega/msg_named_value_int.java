/**
 * Generated class : msg_named_value_int
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
 * Class msg_named_value_int
 * Send a key-value pair as integer. The use of this message is discouraged for normal packets, but a quite efficient way for testing new messages and getting experimental debug output.
 **/
public class msg_named_value_int extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_NAMED_VALUE_INT = 252;
    private static final long serialVersionUID = MAVLINK_MSG_ID_NAMED_VALUE_INT;
    /**
     * Timestamp (milliseconds since system boot)
     */
    public long time_boot_ms;
    /**
     * Signed integer value
     */
    public long value;
    /**
     * Name of the debug variable
     */
    public char[] name = new char[10];

    public msg_named_value_int() {
        this(1, 1);
    }

    public msg_named_value_int(int sysId, int componentId) {
        messageType = MAVLINK_MSG_ID_NAMED_VALUE_INT;
        this.sysId = sysId;
        this.componentId = componentId;
        length = 18;
    }

    public String getName() {
        String result = "";
        for (int i = 0; i < 10; i++) {
            if (name[i] != 0) result = result + name[i];
            else break;
        }
        return result;
    }

    public void setName(String tmp) {
        int len = Math.min(tmp.length(), 10);
        for (int i = 0; i < len; i++) {
            name[i] = tmp.charAt(i);
        }
        for (int i = len; i < 10; i++) {
            name[i] = 0;
        }
    }

    /**
     * Decode message with raw data
     */
    public void decode(LittleEndianDataInputStream dis) throws IOException {
        time_boot_ms = (int) dis.readInt() & 0x00FFFFFFFF;
        value = (int) dis.readInt();
        for (int i = 0; i < 10; i++) {
            name[i] = (char) dis.readByte();
        }
    }

    /**
     * Encode message with raw data and other informations
     */
    public byte[] encode() throws IOException {
        byte[] buffer = new byte[8 + 18];
        LittleEndianDataOutputStream dos = new LittleEndianDataOutputStream(new ByteArrayOutputStream());
        dos.writeByte((byte) 0xFE);
        dos.writeByte(length & 0x00FF);
        dos.writeByte(sequence & 0x00FF);
        dos.writeByte(sysId & 0x00FF);
        dos.writeByte(componentId & 0x00FF);
        dos.writeByte(messageType & 0x00FF);
        dos.writeInt((int) (time_boot_ms & 0x00FFFFFFFF));
        dos.writeInt((int) (value & 0x00FFFFFFFF));
        for (int i = 0; i < 10; i++) {
            dos.writeByte(name[i]);
        }
        dos.flush();
        byte[] tmp = dos.toByteArray();
        for (int b = 0; b < tmp.length; b++) buffer[b] = tmp[b];
        int crc = MAVLinkCRC.crc_calculate_encode(buffer, 18);
        crc = MAVLinkCRC.crc_accumulate((byte) IMAVLinkCRC.MAVLINK_MESSAGE_CRCS[messageType], crc);
        byte crcl = (byte) (crc & 0x00FF);
        byte crch = (byte) ((crc >> 8) & 0x00FF);
        buffer[24] = crcl;
        buffer[25] = crch;
        dos.close();
        return buffer;
    }

    public String toString() {
        return "MAVLINK_MSG_ID_NAMED_VALUE_INT : " + "  time_boot_ms=" + time_boot_ms + "  value=" + value + "  name=" + getName();
    }
}
