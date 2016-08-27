package com.yauhenl.pibot.service;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.wiringpi.GpioUtil;
import com.yauhenl.pibot.hardware.cascade.BotCascade;
import com.yauhenl.pibot.hardware.cascade.Motor;
import com.yauhenl.pibot.hardware.cascade.Shift;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * Created by Stsiapan_Shablinski on 7/29/2016.
 */
@Component
public class BotControl {

    private BotCascade cascade;

    public BotControl() {
        cascade = new BotCascade();
        cascade.initCascade(getController());
    }

    public Shift getShift() {
        return cascade.getShift();
    }

    public Collection<Motor> getMotors() {
        return cascade.getMotors().values();
    }

    private GpioController getController() {
        GpioUtil.enableNonPrivilegedAccess();
        return GpioFactory.getInstance();
    }
}
