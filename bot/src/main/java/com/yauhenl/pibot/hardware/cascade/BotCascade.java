package com.yauhenl.pibot.hardware.cascade;

import com.pi4j.io.gpio.GpioController;

import java.util.EnumMap;
import java.util.Map;

import static com.pi4j.io.gpio.PinState.LOW;
import static com.pi4j.io.gpio.RaspiPin.*;
import static com.yauhenl.pibot.hardware.cascade.MotorKey.*;

/**
 * Created by Stsiapan_Shablinski on 7/29/2016.
 */
public class BotCascade {

    private Map<MotorKey, Motor> motors;
    private Shift shift;

    public void initCascade(GpioController controller) {
        motors = new EnumMap<>(MotorKey.class);
        motors.put(DC1, new Motor(controller.provisionDigitalOutputPin(GPIO_25, LOW)));
        motors.put(DC2, new Motor(controller.provisionDigitalOutputPin(GPIO_22, LOW)));
        motors.put(DC3, new Motor(controller.provisionDigitalOutputPin(GPIO_24, LOW)));
        motors.put(DC4, new Motor(controller.provisionDigitalOutputPin(GPIO_23, LOW)));

        shift = new Shift(controller.provisionDigitalOutputPin(GPIO_26, LOW),
                controller.provisionDigitalOutputPin(GPIO_27, LOW),
                controller.provisionDigitalOutputPin(GPIO_28, LOW));
    }

    public Map<MotorKey, Motor> getMotors() {
        return motors;
    }

    public Shift getShift() {
        return shift;
    }
}
