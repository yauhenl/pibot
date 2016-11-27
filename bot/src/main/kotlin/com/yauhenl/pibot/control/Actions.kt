package com.yauhenl.pibot.control

import com.yauhenl.pibot.hardware.Motor
import com.yauhenl.pibot.service.BotControl

object Actions {
    private val BACKWARD_SHIFT_VAL = 156
    private val FORWARD_SHIFT_VAL = 99
    private val LEFT_SHIFT_VAL = 46
    private val RIGHT_SHIFT_VAL = 209
    private val STOP_SHIFT_VAL = 0

    val moveBackwardAction = { botControl: BotControl -> botControl.shiftRegister.writeShift(BACKWARD_SHIFT_VAL) }
    val moveForwardAction = { botControl: BotControl -> botControl.shiftRegister.writeShift(FORWARD_SHIFT_VAL) }
    val moveLeftAction = { botControl: BotControl -> botControl.shiftRegister.writeShift(LEFT_SHIFT_VAL) }
    val moveRightAction = { botControl: BotControl -> botControl.shiftRegister.writeShift(RIGHT_SHIFT_VAL) }
    val stopMovingAction = { botControl: BotControl -> botControl.shiftRegister.writeShift(STOP_SHIFT_VAL) }
    val allMotorsPowerOffAction = { botControl: BotControl -> botControl.motors.values.forEach(Motor::setLowOutput) }
    val allMotorsPowerOnAction = { botControl: BotControl -> botControl.motors.values.forEach(Motor::setHighOutput) }
}