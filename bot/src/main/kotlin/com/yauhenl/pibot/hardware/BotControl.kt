package com.yauhenl.pibot.hardware

import com.pi4j.io.gpio.GpioFactory
import com.pi4j.io.gpio.PinState.LOW
import com.pi4j.io.gpio.RaspiPin.*
import com.pi4j.wiringpi.Shift
import com.yauhenl.pibot.Direction


object BotControl {
    private val gpio = GpioFactory.getInstance()

    private val dc1 = gpio.provisionDigitalOutputPin(GPIO_25, LOW)
    private val dc2 = gpio.provisionDigitalOutputPin(GPIO_22, LOW)
    private val dc3 = gpio.provisionDigitalOutputPin(GPIO_24, LOW)
    private val dc4 = gpio.provisionDigitalOutputPin(GPIO_23, LOW)

    private val clk = gpio.provisionDigitalOutputPin(GPIO_26, LOW)
    private val ser = gpio.provisionDigitalOutputPin(GPIO_27, LOW)
    private val latch = gpio.provisionDigitalOutputPin(GPIO_28, LOW)

    private val motors = arrayOf(dc1, dc2, dc3, dc4)

    private var currentDirection: Direction? = null

    fun doMove(direction: Direction) {
        if (currentDirection != direction) {
            writeShift(direction.shift)
            currentDirection = direction
        }
    }

    fun allHigh() {
        motors.forEach{ it.high() }
    }

    fun allLow() {
        motors.forEach{ it.low() }
    }

    private fun writeShift(value: Int) {
        latch.low()
        Shift.shiftOut(ser.pin.address.toByte(), clk.pin.address.toByte(), Shift.LSBFIRST.toByte(), value.toByte())
        latch.high()
    }
}
