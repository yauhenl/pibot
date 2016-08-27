package com.yauhenl.pibot.hardware.cascade;

import com.pi4j.io.gpio.GpioPinPwmOutput;

/**
 * Created by Stsiapan_Shablinski on 7/29/2016.
 */
public class Motor {

    private GpioPinPwmOutput outputChannel;

    public Motor(GpioPinPwmOutput outputChannel) {
        this.outputChannel = outputChannel;
    }

    public void setSpeed(int value) {
        outputChannel.setPwm(value);
    }
}
