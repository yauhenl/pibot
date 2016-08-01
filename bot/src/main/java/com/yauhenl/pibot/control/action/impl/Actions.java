package com.yauhenl.pibot.control.action.impl;

import com.yauhenl.pibot.control.action.Action;
import com.yauhenl.pibot.hardware.cascade.motor.Motor;
import org.springframework.stereotype.Service;

@Service
public class Actions {
    private static final int BACKWARD_SHIFT_VAL = 156;
    private static final int FORWARD_SHIFT_VAL = 99;
    private static final int LEFT_SHIFT_VAL = 46;
    private static final int RIGHT_SHIFT_VAL = 209;
    private static final int STOP_SHIFT_VAL = 0;

    public static Action moveBackwardAction = botControl -> {
        botControl.getCascade().getShift().writeShift(BACKWARD_SHIFT_VAL);
    };

    public static Action moveForwardAction = botControl -> {
        botControl.getCascade().getShift().writeShift(FORWARD_SHIFT_VAL);
    };

    public static Action moveLeftAction = botControl -> {
        botControl.getCascade().getShift().writeShift(LEFT_SHIFT_VAL);
    };

    public static Action moveRightAction = botControl -> {
        botControl.getCascade().getShift().writeShift(RIGHT_SHIFT_VAL);
    };

    public static Action stopMovingAction = botControl -> {
        botControl.getCascade().getShift().writeShift(STOP_SHIFT_VAL);
    };

    public static Action allMotorsPowerOffAction = botControl -> botControl.getCascade().getMotors().values().forEach(Motor::setLowOutput);

    public static Action allMotorsPowerOnAction = botControl -> botControl.getCascade().getMotors().values().forEach(Motor::setHighOutput);
}
