package com.yauhenl.pibot.hardware

import com.pi4j.io.gpio.GpioController
import com.pi4j.io.gpio.PinState.LOW
import com.pi4j.io.gpio.RaspiPin.*
import com.yauhenl.pibot.hardware.MotorKey.*
import java.util.*

class BotCascade {

    var motors: EnumMap<MotorKey, Motor>? = null
    var shiftRegister: ShiftRegister? = null

    fun initCascade(controller: GpioController) {
        motors = EnumMap<MotorKey, Motor>(MotorKey::class.java)
        motors?.put(DC1, Motor(controller.provisionDigitalOutputPin(GPIO_25, LOW)))
        motors?.put(DC2, Motor(controller.provisionDigitalOutputPin(GPIO_22, LOW)))
        motors?.put(DC3, Motor(controller.provisionDigitalOutputPin(GPIO_24, LOW)))
        motors?.put(DC4, Motor(controller.provisionDigitalOutputPin(GPIO_23, LOW)))

        shiftRegister = ShiftRegister(controller.provisionDigitalOutputPin(GPIO_26, LOW),
                controller.provisionDigitalOutputPin(GPIO_27, LOW),
                controller.provisionDigitalOutputPin(GPIO_28, LOW))
    }
}