package com.yauhenl.pibot.hardware.cascade.motor;

import com.pi4j.io.gpio.GpioPinPwmOutput;

/**
 * Created by Stsiapan_Shablinski on 7/29/2016.
 */
public class Motor {
    private static final Integer maxRange = 1024;

    private GpioPinPwmOutput outputChannel;

    public Motor(GpioPinPwmOutput outputChannel) {
        this.outputChannel = outputChannel;
    }

    public void setMaxSpeed() {
        outputChannel.setPwm(maxRange);
    }

    public void setMinSpeed() {
        outputChannel.setPwm(0);
    }

    public void setSpeed(int value) {
        if (value <=maxRange && value >= 0) {
            outputChannel.setPwm(value);
        }
    }
}
