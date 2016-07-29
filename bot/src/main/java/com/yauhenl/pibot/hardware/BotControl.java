package com.yauhenl.pibot.hardware;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.wiringpi.GpioUtil;
import com.yauhenl.pibot.hardware.cascade.BotCascade;
import org.springframework.stereotype.Component;

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

    public BotCascade getCascade() {
        return cascade;
    }

    protected GpioController getController() {
        GpioUtil.enableNonPrivilegedAccess();
        return GpioFactory.getInstance();
    }

}
