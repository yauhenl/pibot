package com.yauhenl.pibot.control.action;

import com.yauhenl.pibot.hardware.cascade.motor.Motor;

public class Actions {
    private static final int BACKWARD_SHIFT_VAL = 156;
    private static final int FORWARD_SHIFT_VAL = 99;
    private static final int LEFT_SHIFT_VAL = 46;
    private static final int RIGHT_SHIFT_VAL = 209;
    private static final int STOP_SHIFT_VAL = 0;

    public static Action moveBackwardAction = (botControl, params) -> botControl.getCascade().getShift().writeShift(BACKWARD_SHIFT_VAL);

    public static Action moveForwardAction = (botControl, params) -> botControl.getCascade().getShift().writeShift(FORWARD_SHIFT_VAL);

    public static Action moveLeftAction = (botControl, params) -> botControl.getCascade().getShift().writeShift(LEFT_SHIFT_VAL);

    public static Action moveRightAction = (botControl, params) -> botControl.getCascade().getShift().writeShift(RIGHT_SHIFT_VAL);

    public static Action stopMovingAction = (botControl, params) -> botControl.getCascade().getShift().writeShift(STOP_SHIFT_VAL);

    public static Action allMotorsPowerOffAction = (botControl, params) -> botControl.getCascade().getMotors().values().forEach(Motor::setMinSpeed);

    public static Action allMotorsPowerOnAction = (botControl, params) -> botControl.getCascade().getMotors().values().forEach(Motor::setMaxSpeed);

    public static Action allMotorsSetSpeedAction = (botControl, params) -> botControl.getCascade().getMotors().values().forEach(it -> it.setSpeed(Integer.valueOf(params[0].toString())));
}
