package com.yauhenl.pibot.service

import com.pi4j.io.gpio.GpioFactory
import com.yauhenl.pibot.hardware.BotCascade
import com.yauhenl.pibot.hardware.Motor
import com.yauhenl.pibot.hardware.MotorKey
import com.yauhenl.pibot.hardware.ShiftRegister
import org.springframework.stereotype.Service

@Service
class BotControl {

    private val cascade: BotCascade = BotCascade(GpioFactory.getInstance())

    val shiftRegister: ShiftRegister = cascade.shiftRegister

    val motors: Map<MotorKey, Motor> = cascade.motors
}
