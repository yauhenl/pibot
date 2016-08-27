package com.yauhenl.pibot.control.action;

public class Actions {
    private static final int BACKWARD_SHIFT_VAL = 156;
    private static final int FORWARD_SHIFT_VAL = 99;
    private static final int LEFT_SHIFT_VAL = 46;
    private static final int RIGHT_SHIFT_VAL = 209;
    private static final int STOP_SHIFT_VAL = 0;

    public static Action moveBackwardAction = botControl -> botControl.getShift().writeShift(BACKWARD_SHIFT_VAL);

    public static Action moveForwardAction = botControl -> botControl.getShift().writeShift(FORWARD_SHIFT_VAL);

    public static Action moveLeftAction = botControl -> botControl.getShift().writeShift(LEFT_SHIFT_VAL);

    public static Action moveRightAction = botControl -> botControl.getShift().writeShift(RIGHT_SHIFT_VAL);

    public static Action stopMovingAction = botControl -> botControl.getShift().writeShift(STOP_SHIFT_VAL);

    public static Action allMotorsPowerOffAction = botControl -> botControl.getMotors().values().forEach(it -> it.setSpeed(0));

    public static Action allMotorsPowerOnAction = botControl -> botControl.getMotors().values().forEach(it -> it.setSpeed(1000));
}
