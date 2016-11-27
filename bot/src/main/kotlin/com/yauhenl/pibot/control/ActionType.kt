package com.yauhenl.pibot.control

import com.yauhenl.pibot.control.Actions.allMotorsPowerOffAction
import com.yauhenl.pibot.control.Actions.allMotorsPowerOnAction
import com.yauhenl.pibot.control.Actions.moveBackwardAction
import com.yauhenl.pibot.control.Actions.moveForwardAction
import com.yauhenl.pibot.control.Actions.moveLeftAction
import com.yauhenl.pibot.control.Actions.moveRightAction
import com.yauhenl.pibot.control.Actions.stopMovingAction
import com.yauhenl.pibot.service.BotControl

enum class ActionType constructor(val action: (botControl: BotControl) -> Unit) {
    // Power
    ALL_MOTORS_POWER_ON(allMotorsPowerOnAction),
    ALL_MOTORS_POWER_OFF(allMotorsPowerOffAction),

    // Movement
    MOVE_FORWARD(moveForwardAction),
    MOVE_BACKWARD(moveBackwardAction),
    MOVE_LEFT(moveLeftAction),
    MOVE_RIGHT(moveRightAction),
    MOVE_STOP(stopMovingAction)
}
