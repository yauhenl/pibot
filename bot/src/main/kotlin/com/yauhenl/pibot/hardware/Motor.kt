package com.yauhenl.pibot.hardware

import com.pi4j.io.gpio.GpioPinDigitalOutput

class Motor(private val outputChannel: GpioPinDigitalOutput) {

    fun setHighOutput() = outputChannel.high()

    fun setLowOutput() = outputChannel.low()
}
