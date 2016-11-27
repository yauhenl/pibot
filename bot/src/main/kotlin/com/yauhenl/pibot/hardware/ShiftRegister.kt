package com.yauhenl.pibot.hardware

import com.pi4j.io.gpio.GpioPinDigitalOutput
import com.pi4j.wiringpi.Shift

class ShiftRegister(private val clk: GpioPinDigitalOutput, private val ser: GpioPinDigitalOutput, private val latch: GpioPinDigitalOutput) {

    fun writeShift(value: Int) {
        latch.low()
        Shift.shiftOut(ser.pin.address.toByte(), clk.pin.address.toByte(), Shift.LSBFIRST.toByte(), value.toByte())
        latch.high()
    }
}
