/**
 * Generated class : msg_attitude_target
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
 * Class msg_attitude_target
 * Reports the current commanded attitude of the vehicle as specified by the autopilot. This should match the commands sent in a SET_ATTITUDE_TARGET message if the vehicle is being controlled this way.
 **/
public class msg_attitude_target extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_ATTITUDE_TARGET = 83;
    private static final long serialVersionUID = MAVLINK_MSG_ID_ATTITUDE_TARGET;
    /**
     * Timestamp in milliseconds since system boot
     */
    public long time_boot_ms;
    /**
     * Attitude quaternion (w, x, y, z order, zero-rotation is 1, 0, 0, 0)
     */
    public float[] q = new float[4];
    /**
     * Body roll rate in radians per second
     */
    public float body_roll_rate;
    /**
     * Body roll rate in radians per second
     */
    public float body_pitch_rate;
    /**
     * Body roll rate in radians per second
     */
    public float body_yaw_rate;
    /**
     * Collective thrust, normalized to 0 .. 1 (-1 .. 1 for vehicles capable of reverse trust)
     */
    public float thrust;
    /**
     * Mappings: If any of these bits are set, the corresponding input should be ignored: bit 1: body roll rate, bit 2: body pitch rate, bit 3: body yaw rate. bit 4-bit 7: reserved, bit 8: attitude
     */
    public int type_mask;

    public msg_attitude_target() {
        this(1, 1);
    }

    public msg_attitude_target(int sysId, int componentId) {
        messageType = MAVLINK_MSG_ID_ATTITUDE_TARGET;
        this.sysId = sysId;
        this.componentId = componentId;
        length = 37;
    }

    /**
     * Decode message with raw data
     */
    public void decode(LittleEndianDataInputStream dis) throws IOException {
        time_boot_ms = (int) dis.readInt() & 0x00FFFFFFFF;
        for (int i = 0; i < 4; i++) {
            q[i] = (float) dis.readFloat();
        }
        body_roll_rate = (float) dis.readFloat();
        body_pitch_rate = (float) dis.readFloat();
        body_yaw_rate = (float) dis.readFloat();
        thrust = (float) dis.readFloat();
        type_mask = (int) dis.readUnsignedByte() & 0x00FF;
    }

    /**
     * Encode message with raw data and other informations
     */
    public byte[] encode() throws IOException {
        byte[] buffer = new byte[8 + 37];
        LittleEndianDataOutputStream dos = new LittleEndianDataOutputStream(new ByteArrayOutputStream());
        dos.writeByte((byte) 0xFE);
        dos.writeByte(length & 0x00FF);
        dos.writeByte(sequence & 0x00FF);
        dos.writeByte(sysId & 0x00FF);
        dos.writeByte(componentId & 0x00FF);
        dos.writeByte(messageType & 0x00FF);
        dos.writeInt((int) (time_boot_ms & 0x00FFFFFFFF));
        for (int i = 0; i < 4; i++) {
            dos.writeFloat(q[i]);
        }
        dos.writeFloat(body_roll_rate);
        dos.writeFloat(body_pitch_rate);
        dos.writeFloat(body_yaw_rate);
        dos.writeFloat(thrust);
        dos.writeByte(type_mask & 0x00FF);
        dos.flush();
        byte[] tmp = dos.toByteArray();
        for (int b = 0; b < tmp.length; b++) buffer[b] = tmp[b];
        int crc = MAVLinkCRC.crc_calculate_encode(buffer, 37);
        crc = MAVLinkCRC.crc_accumulate((byte) IMAVLinkCRC.MAVLINK_MESSAGE_CRCS[messageType], crc);
        byte crcl = (byte) (crc & 0x00FF);
        byte crch = (byte) ((crc >> 8) & 0x00FF);
        buffer[43] = crcl;
        buffer[44] = crch;
        dos.close();
        return buffer;
    }

    public String toString() {
        return "MAVLINK_MSG_ID_ATTITUDE_TARGET : " + "  time_boot_ms=" + time_boot_ms + "  q=" + q + "  body_roll_rate=" + body_roll_rate + "  body_pitch_rate=" + body_pitch_rate + "  body_yaw_rate=" + body_yaw_rate + "  thrust=" + thrust + "  type_mask=" + type_mask;
    }
}