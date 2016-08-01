package com.yauhenl.pibot.control.action;

import static com.yauhenl.pibot.control.action.Actions.*;

/**
 * Created by Stsiapan_Shablinski on 7/28/2016.
 */
public enum ActionType {
    // Power

    ALL_MOTORS_POWER_ON(allMotorsPowerOnAction),
    ALL_MOTORS_POWER_OFF(allMotorsPowerOffAction),
    ALL_MOTORS_SET_SPEED(allMotorsSetSpeedAction),

    // Movement

    MOVE_FORWARD(moveForwardAction),
    MOVE_BACKWARD(moveBackwardAction),
    MOVE_LEFT(moveLeftAction),
    MOVE_RIGHT(moveRightAction),
    MOVE_STOP(stopMovingAction);

    private Action action;

    ActionType(Action action) {
        this.action = action;
    }

    public Action getAction() {
        return action;
    }
}
