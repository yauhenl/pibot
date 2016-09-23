package com.yauhenl.pibot.hardware.cascade;

import com.pi4j.io.gpio.GpioPinDigitalOutput;

/**
 * Created by Stsiapan_Shablinski on 7/29/2016.
 */
public class Motor {

    private GpioPinDigitalOutput outputChannel;

    public Motor(GpioPinDigitalOutput outputChannel) {
        this.outputChannel = outputChannel;
    }

    public void setHighOutput() {
        outputChannel.high();
    }

    public void setLowOutput() {
        outputChannel.low();
    }
}
