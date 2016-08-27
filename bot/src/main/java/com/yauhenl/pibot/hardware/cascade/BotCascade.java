package com.yauhenl.pibot.hardware.cascade;

import java.util.EnumMap;
import java.util.Map;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.RaspiPin;


/**
 * Created by Stsiapan_Shablinski on 7/29/2016.
 */
public class BotCascade {

    private Map<MotorKey, Motor> motors;
    private Shift shift;

    public void initCascade(GpioController controller) {
        motors = new EnumMap<>(MotorKey.class);
        motors.put(MotorKey.DC1, new Motor(controller.provisionPwmOutputPin(RaspiPin.GPIO_26, 1000)));
        motors.put(MotorKey.DC2, new Motor(controller.provisionPwmOutputPin(RaspiPin.GPIO_01, 1000)));
        motors.put(MotorKey.DC3, new Motor(controller.provisionPwmOutputPin(RaspiPin.GPIO_24, 1000)));
        motors.put(MotorKey.DC4, new Motor(controller.provisionPwmOutputPin(RaspiPin.GPIO_23, 1000)));

        shift = new Shift(controller.provisionDigitalOutputPin(RaspiPin.GPIO_29),
                controller.provisionDigitalOutputPin(RaspiPin.GPIO_27),
                controller.provisionDigitalOutputPin(RaspiPin.GPIO_28));
    }

    public Map<MotorKey, Motor> getMotors() {
        return motors;
    }

    public Shift getShift() {
        return shift;
    }

    private enum MotorKey {
        DC1, DC2, DC3, DC4
    }
}
