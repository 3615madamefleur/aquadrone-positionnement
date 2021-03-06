/**
 * Generated class : MAVLinkMessageFactory
 * DO NOT MODIFY!
 **/
package org.mavlink.messages;

import org.mavlink.IMAVLinkMessage;
import org.mavlink.io.LittleEndianDataInputStream;
import org.mavlink.messages.ardupilotmega.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * Class MAVLinkMessageFactory
 * Generate MAVLink message classes from byte array
 **/
public class MAVLinkMessageFactory implements IMAVLinkMessage, IMAVLinkMessageID {
    public static MAVLinkMessage getMessage(int msgid, int sysId, int componentId, byte[] rawData) throws IOException {
        MAVLinkMessage msg = null;
        LittleEndianDataInputStream dis = new LittleEndianDataInputStream(new ByteArrayInputStream(rawData));
        switch (msgid) {
            case MAVLINK_MSG_ID_REQUEST_DATA_STREAM:
                msg = new msg_request_data_stream(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_ACTUATOR_CONTROL_TARGET:
                msg = new msg_actuator_control_target(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_SETUP_SIGNING:
                msg = new msg_setup_signing(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_HIL_SENSOR:
                msg = new msg_hil_sensor(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_CAMERA_TRIGGER:
                msg = new msg_camera_trigger(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_PARAM_REQUEST_LIST:
                msg = new msg_param_request_list(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_GPS_RTK:
                msg = new msg_gps_rtk(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_POSITION_TARGET_LOCAL_NED:
                msg = new msg_position_target_local_ned(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_CONTROL_SYSTEM_STATE:
                msg = new msg_control_system_state(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_DIGICAM_CONFIGURE:
                msg = new msg_digicam_configure(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_MOUNT_STATUS:
                msg = new msg_mount_status(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_TIMESYNC:
                msg = new msg_timesync(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_MISSION_ITEM_REACHED:
                msg = new msg_mission_item_reached(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_AP_ADC:
                msg = new msg_ap_adc(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_FENCE_POINT:
                msg = new msg_fence_point(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_V2_EXTENSION:
                msg = new msg_v2_extension(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_DEBUG_VECT:
                msg = new msg_debug_vect(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_BATTERY_STATUS:
                msg = new msg_battery_status(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_MISSION_CURRENT:
                msg = new msg_mission_current(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_VISION_POSITION_ESTIMATE:
                msg = new msg_vision_position_estimate(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_GOPRO_GET_RESPONSE:
                msg = new msg_gopro_get_response(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_MISSION_CLEAR_ALL:
                msg = new msg_mission_clear_all(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_LED_CONTROL:
                msg = new msg_led_control(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_ATT_POS_MOCAP:
                msg = new msg_att_pos_mocap(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_COMMAND_ACK:
                msg = new msg_command_ack(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_HIL_GPS:
                msg = new msg_hil_gps(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_LOG_REQUEST_LIST:
                msg = new msg_log_request_list(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_LOG_REQUEST_DATA:
                msg = new msg_log_request_data(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_LOG_ERASE:
                msg = new msg_log_erase(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_RALLY_FETCH_POINT:
                msg = new msg_rally_fetch_point(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_DISTANCE_SENSOR:
                msg = new msg_distance_sensor(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_GOPRO_SET_RESPONSE:
                msg = new msg_gopro_set_response(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_WIND:
                msg = new msg_wind(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_LOCAL_POSITION_NED_COV:
                msg = new msg_local_position_ned_cov(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_ATTITUDE_TARGET:
                msg = new msg_attitude_target(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_CHANGE_OPERATOR_CONTROL:
                msg = new msg_change_operator_control(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_MISSION_REQUEST:
                msg = new msg_mission_request(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_GLOBAL_POSITION_INT:
                msg = new msg_global_position_int(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_AUTOPILOT_VERSION:
                msg = new msg_autopilot_version(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_DATA64:
                msg = new msg_data64(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_GIMBAL_CONTROL:
                msg = new msg_gimbal_control(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_VICON_POSITION_ESTIMATE:
                msg = new msg_vicon_position_estimate(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_AUTH_KEY:
                msg = new msg_auth_key(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_HIL_CONTROLS:
                msg = new msg_hil_controls(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_MISSION_WRITE_PARTIAL_LIST:
                msg = new msg_mission_write_partial_list(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_HWSTATUS:
                msg = new msg_hwstatus(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_EXTENDED_SYS_STATE:
                msg = new msg_extended_sys_state(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_RC_CHANNELS_RAW:
                msg = new msg_rc_channels_raw(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_TERRAIN_DATA:
                msg = new msg_terrain_data(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_HIL_STATE:
                msg = new msg_hil_state(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_FILE_TRANSFER_PROTOCOL:
                msg = new msg_file_transfer_protocol(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_AHRS3:
                msg = new msg_ahrs3(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_AHRS2:
                msg = new msg_ahrs2(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_REMOTE_LOG_BLOCK_STATUS:
                msg = new msg_remote_log_block_status(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_ENCAPSULATED_DATA:
                msg = new msg_encapsulated_data(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_MISSION_COUNT:
                msg = new msg_mission_count(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_SET_MODE:
                msg = new msg_set_mode(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_VIBRATION:
                msg = new msg_vibration(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_EKF_STATUS_REPORT:
                msg = new msg_ekf_status_report(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_SYSTEM_TIME:
                msg = new msg_system_time(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_DATA32:
                msg = new msg_data32(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_REMOTE_LOG_DATA_BLOCK:
                msg = new msg_remote_log_data_block(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_SCALED_PRESSURE2:
                msg = new msg_scaled_pressure2(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_SAFETY_SET_ALLOWED_AREA:
                msg = new msg_safety_set_allowed_area(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_GLOBAL_VISION_POSITION_ESTIMATE:
                msg = new msg_global_vision_position_estimate(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_SCALED_PRESSURE3:
                msg = new msg_scaled_pressure3(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_PING:
                msg = new msg_ping(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_HOME_POSITION:
                msg = new msg_home_position(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_MISSION_ITEM:
                msg = new msg_mission_item(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_RAW_IMU:
                msg = new msg_raw_imu(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_FENCE_FETCH_POINT:
                msg = new msg_fence_fetch_point(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_RANGEFINDER:
                msg = new msg_rangefinder(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_HIGHRES_IMU:
                msg = new msg_highres_imu(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_MAG_CAL_PROGRESS:
                msg = new msg_mag_cal_progress(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_OPTICAL_FLOW:
                msg = new msg_optical_flow(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_LANDING_TARGET:
                msg = new msg_landing_target(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_COMMAND_LONG:
                msg = new msg_command_long(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_ATTITUDE_QUATERNION:
                msg = new msg_attitude_quaternion(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_SCALED_IMU2:
                msg = new msg_scaled_imu2(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_DATA_STREAM:
                msg = new msg_data_stream(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_SCALED_IMU3:
                msg = new msg_scaled_imu3(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_CHANGE_OPERATOR_CONTROL_ACK:
                msg = new msg_change_operator_control_ack(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_TERRAIN_REQUEST:
                msg = new msg_terrain_request(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_TERRAIN_CHECK:
                msg = new msg_terrain_check(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_ADSB_VEHICLE:
                msg = new msg_adsb_vehicle(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_MEMORY_VECT:
                msg = new msg_memory_vect(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_LIMITS_STATUS:
                msg = new msg_limits_status(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_HIL_RC_INPUTS_RAW:
                msg = new msg_hil_rc_inputs_raw(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_GPS_RTCM_DATA:
                msg = new msg_gps_rtcm_data(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_RADIO:
                msg = new msg_radio(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_RAW_PRESSURE:
                msg = new msg_raw_pressure(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_BATTERY2:
                msg = new msg_battery2(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_WIND_COV:
                msg = new msg_wind_cov(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_MOUNT_CONFIGURE:
                msg = new msg_mount_configure(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_DATA96:
                msg = new msg_data96(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_LOCAL_POSITION_NED:
                msg = new msg_local_position_ned(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_NAV_CONTROLLER_OUTPUT:
                msg = new msg_nav_controller_output(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_GPS2_RTK:
                msg = new msg_gps2_rtk(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_SET_GPS_GLOBAL_ORIGIN:
                msg = new msg_set_gps_global_origin(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_DIGICAM_CONTROL:
                msg = new msg_digicam_control(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_DATA16:
                msg = new msg_data16(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_AIRSPEED_AUTOCAL:
                msg = new msg_airspeed_autocal(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_LOG_DATA:
                msg = new msg_log_data(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_ESTIMATOR_STATUS:
                msg = new msg_estimator_status(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_ATTITUDE:
                msg = new msg_attitude(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_SERIAL_CONTROL:
                msg = new msg_serial_control(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_PARAM_VALUE:
                msg = new msg_param_value(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_SIM_STATE:
                msg = new msg_sim_state(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_SET_ATTITUDE_TARGET:
                msg = new msg_set_attitude_target(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_SAFETY_ALLOWED_AREA:
                msg = new msg_safety_allowed_area(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_GPS_GLOBAL_ORIGIN:
                msg = new msg_gps_global_origin(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_LOG_REQUEST_END:
                msg = new msg_log_request_end(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_RADIO_STATUS:
                msg = new msg_radio_status(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_FOLLOW_TARGET:
                msg = new msg_follow_target(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_GOPRO_GET_REQUEST:
                msg = new msg_gopro_get_request(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_GPS_RAW_INT:
                msg = new msg_gps_raw_int(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_SYS_STATUS:
                msg = new msg_sys_status(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_MISSION_ITEM_INT:
                msg = new msg_mission_item_int(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_MISSION_REQUEST_INT:
                msg = new msg_mission_request_int(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_MANUAL_SETPOINT:
                msg = new msg_manual_setpoint(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_NAMED_VALUE_FLOAT:
                msg = new msg_named_value_float(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_SCALED_IMU:
                msg = new msg_scaled_imu(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_RC_CHANNELS_SCALED:
                msg = new msg_rc_channels_scaled(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_ALTITUDE:
                msg = new msg_altitude(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_MISSION_REQUEST_PARTIAL_LIST:
                msg = new msg_mission_request_partial_list(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_GLOBAL_POSITION_INT_COV:
                msg = new msg_global_position_int_cov(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_CAMERA_STATUS:
                msg = new msg_camera_status(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_MAG_CAL_REPORT:
                msg = new msg_mag_cal_report(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_VISION_SPEED_ESTIMATE:
                msg = new msg_vision_speed_estimate(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_AHRS:
                msg = new msg_ahrs(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_RC_CHANNELS_OVERRIDE:
                msg = new msg_rc_channels_override(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_SENSOR_OFFSETS:
                msg = new msg_sensor_offsets(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_MEMINFO:
                msg = new msg_meminfo(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_VFR_HUD:
                msg = new msg_vfr_hud(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_OPTICAL_FLOW_RAD:
                msg = new msg_optical_flow_rad(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_SET_POSITION_TARGET_LOCAL_NED:
                msg = new msg_set_position_target_local_ned(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_LOG_ENTRY:
                msg = new msg_log_entry(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_DATA_TRANSMISSION_HANDSHAKE:
                msg = new msg_data_transmission_handshake(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_AUTOPILOT_VERSION_REQUEST:
                msg = new msg_autopilot_version_request(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_SET_HOME_POSITION:
                msg = new msg_set_home_position(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_GPS2_RAW:
                msg = new msg_gps2_raw(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_POSITION_TARGET_GLOBAL_INT:
                msg = new msg_position_target_global_int(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_NAMED_VALUE_INT:
                msg = new msg_named_value_int(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_GOPRO_HEARTBEAT:
                msg = new msg_gopro_heartbeat(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_HEARTBEAT:
                msg = new msg_heartbeat(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_TERRAIN_REPORT:
                msg = new msg_terrain_report(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_RPM:
                msg = new msg_rpm(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_MISSION_ACK:
                msg = new msg_mission_ack(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_CAMERA_FEEDBACK:
                msg = new msg_camera_feedback(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_MISSION_REQUEST_LIST:
                msg = new msg_mission_request_list(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_PARAM_SET:
                msg = new msg_param_set(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_GPS_STATUS:
                msg = new msg_gps_status(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_SET_POSITION_TARGET_GLOBAL_INT:
                msg = new msg_set_position_target_global_int(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_MANUAL_CONTROL:
                msg = new msg_manual_control(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_MESSAGE_INTERVAL:
                msg = new msg_message_interval(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_SET_MAG_OFFSETS:
                msg = new msg_set_mag_offsets(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_SCALED_PRESSURE:
                msg = new msg_scaled_pressure(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_SIMSTATE:
                msg = new msg_simstate(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_HIL_STATE_QUATERNION:
                msg = new msg_hil_state_quaternion(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_STATUSTEXT:
                msg = new msg_statustext(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_GIMBAL_TORQUE_CMD_REPORT:
                msg = new msg_gimbal_torque_cmd_report(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_PARAM_MAP_RC:
                msg = new msg_param_map_rc(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_FENCE_STATUS:
                msg = new msg_fence_status(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_POWER_STATUS:
                msg = new msg_power_status(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_COMPASSMOT_STATUS:
                msg = new msg_compassmot_status(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_MOUNT_CONTROL:
                msg = new msg_mount_control(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_ATTITUDE_QUATERNION_COV:
                msg = new msg_attitude_quaternion_cov(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_PID_TUNING:
                msg = new msg_pid_tuning(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_HIL_OPTICAL_FLOW:
                msg = new msg_hil_optical_flow(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_SERVO_OUTPUT_RAW:
                msg = new msg_servo_output_raw(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_DEBUG:
                msg = new msg_debug(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_GIMBAL_REPORT:
                msg = new msg_gimbal_report(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_PARAM_REQUEST_READ:
                msg = new msg_param_request_read(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_COMMAND_INT:
                msg = new msg_command_int(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_GPS_INPUT:
                msg = new msg_gps_input(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_MISSION_SET_CURRENT:
                msg = new msg_mission_set_current(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_RC_CHANNELS:
                msg = new msg_rc_channels(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_GPS_INJECT_DATA:
                msg = new msg_gps_inject_data(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_SET_ACTUATOR_CONTROL_TARGET:
                msg = new msg_set_actuator_control_target(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_LOCAL_POSITION_NED_SYSTEM_GLOBAL_OFFSET:
                msg = new msg_local_position_ned_system_global_offset(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_RESOURCE_REQUEST:
                msg = new msg_resource_request(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_RALLY_POINT:
                msg = new msg_rally_point(sysId, componentId);
                msg.decode(dis);
                break;
            case MAVLINK_MSG_ID_GOPRO_SET_REQUEST:
                msg = new msg_gopro_set_request(sysId, componentId);
                msg.decode(dis);
                break;
            default:
                System.out.println("Mavlink Factory Error : unknown MsgId : " + msgid);
        }
        return msg;
    }
}
