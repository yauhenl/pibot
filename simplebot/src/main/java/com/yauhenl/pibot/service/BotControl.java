package com.yauhenl.pibot.service;

import com.pi4j.io.gpio.GpioFactory;
import com.yauhenl.pibot.hardware.cascade.BotCascade;
import com.yauhenl.pibot.hardware.cascade.Motor;
import com.yauhenl.pibot.hardware.cascade.MotorKey;
import com.yauhenl.pibot.hardware.cascade.Shift;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by Stsiapan_Shablinski on 7/29/2016.
 */
@Component
public class BotControl {

    private BotCascade cascade;

    public BotControl() {
        cascade = new BotCascade();
        cascade.initCascade(GpioFactory.getInstance());
    }

    public Shift getShift() {
        return cascade.getShift();
    }

    public Map<MotorKey, Motor> getMotors() {
        return cascade.getMotors();
    }
}
