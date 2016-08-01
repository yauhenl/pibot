package com.yauhenl.pibot.hardware.cascade;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.RaspiPin;
import com.yauhenl.pibot.hardware.cascade.motor.Motor;
import com.yauhenl.pibot.hardware.cascade.shift.Shift;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by Stsiapan_Shablinski on 7/29/2016.
 */
public class BotCascade {

    private Map<MotorKey, Motor> motors;
    private Shift shift;

    public void initCascade(GpioController controller) {
        motors = new HashMap<>();
        motors.put(MotorKey.DC1, new Motor(controller.provisionDigitalOutputPin(RaspiPin.GPIO_25)));
        motors.put(MotorKey.DC2, new Motor(controller.provisionDigitalOutputPin(RaspiPin.GPIO_22)));
        motors.put(MotorKey.DC3, new Motor(controller.provisionDigitalOutputPin(RaspiPin.GPIO_24)));
        motors.put(MotorKey.DC4, new Motor(controller.provisionDigitalOutputPin(RaspiPin.GPIO_23)));

        shift = new Shift();
        shift.setClk(controller.provisionDigitalOutputPin(RaspiPin.GPIO_26));
        shift.setLatch(controller.provisionDigitalOutputPin(RaspiPin.GPIO_28));
        shift.setSer(controller.provisionDigitalOutputPin(RaspiPin.GPIO_27));
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
