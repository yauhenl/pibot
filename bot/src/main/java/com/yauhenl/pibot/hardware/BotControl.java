package com.yauhenl.pibot.hardware;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.wiringpi.GpioUtil;
import com.pi4j.wiringpi.Shift;
import com.yauhenl.pibot.Direction;

import java.util.Arrays;
import java.util.List;

import static com.pi4j.io.gpio.PinState.LOW;
import static com.pi4j.io.gpio.RaspiPin.*;


public class BotControl {
    private static final GpioController gpio = getGpioController();

    private static final GpioPinDigitalOutput dc1 = gpio.provisionDigitalOutputPin(GPIO_25, LOW);
    private static final GpioPinDigitalOutput dc2 = gpio.provisionDigitalOutputPin(GPIO_22, LOW);
    private static final GpioPinDigitalOutput dc3 = gpio.provisionDigitalOutputPin(GPIO_24, LOW);
    private static final GpioPinDigitalOutput dc4 = gpio.provisionDigitalOutputPin(GPIO_23, LOW);

    private static final GpioPinDigitalOutput clk = gpio.provisionDigitalOutputPin(GPIO_26, LOW);
    private static final GpioPinDigitalOutput ser = gpio.provisionDigitalOutputPin(GPIO_27, LOW);
    private static final GpioPinDigitalOutput latch = gpio.provisionDigitalOutputPin(GPIO_28, LOW);

    private static final List<GpioPinDigitalOutput> motors = Arrays.asList(dc1, dc2, dc3, dc4);

    private static Direction currentDirection;

    public static void doMove(Direction direction) {
        if (currentDirection != direction) {
            writeShift(direction.getShift());
            currentDirection = direction;
        }
    }

    public static void allHigh() {
        motors.forEach(GpioPinDigitalOutput::high);
    }

    public static void allLow() {
        motors.forEach(GpioPinDigitalOutput::low);
    }

    private static void writeShift(int value) {
        latch.low();
        Shift.shiftOut((byte) ser.getPin().getAddress(), (byte) clk.getPin().getAddress(), (byte) Shift.LSBFIRST, (byte) value);
        latch.high();
    }

    private static GpioController getGpioController() {
        GpioUtil.enableNonPrivilegedAccess();
        return GpioFactory.getInstance();
    }
}
