package com.yauhenl.pibot;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.GpioPinPwmOutput;
import com.pi4j.wiringpi.Shift;

import static com.pi4j.io.gpio.PinState.LOW;
import static com.pi4j.io.gpio.RaspiPin.*;

public class TestGpio {
    private static final GpioController gpio = GpioFactory.getInstance();

    private static final GpioPinPwmOutput dc1 = gpio.provisionPwmOutputPin(GPIO_26, 1000);
    private static final GpioPinPwmOutput dc2 = gpio.provisionPwmOutputPin(GPIO_01, 1000);
    private static final GpioPinPwmOutput dc3 = gpio.provisionPwmOutputPin(GPIO_24, 1000);
    private static final GpioPinPwmOutput dc4 = gpio.provisionPwmOutputPin(GPIO_23, 1000);

    private static final GpioPinDigitalOutput clk = gpio.provisionDigitalOutputPin(GPIO_29, LOW);
    private static final GpioPinDigitalOutput ser = gpio.provisionDigitalOutputPin(GPIO_27, LOW);
    private static final GpioPinDigitalOutput latch = gpio.provisionDigitalOutputPin(GPIO_28, LOW);

    public static void main(String[] args) throws InterruptedException {
        allHigh();

        forward();
        Thread.sleep(2000);
        backward();
        Thread.sleep(2000);
        toRight();
        Thread.sleep(2000);
        toLeft();
        Thread.sleep(2000);

        allLow();
        stop();
        gpio.shutdown();
    }

    private static void forward() {
        writeShift(99);
    }

    private static void backward() {
        writeShift(156);
    }

    private static void toRight() {
        writeShift(209);
    }

    private static void toLeft() {
        writeShift(46);
    }

    private static void stop() {
        writeShift(0);
    }

    private static void allHigh() {
        dc1.setPwm(1000);
        dc2.setPwm(1000);
        dc3.setPwm(1000);
        dc4.setPwm(1000);
    }

    private static void allLow() {
        dc1.setPwm(0);
        dc2.setPwm(0);
        dc3.setPwm(0);
        dc4.setPwm(0);
    }

    private static void setPwm(int value) {
        dc3.setPwm(value);
    }

    private static void writeShift(int value) {
        latch.low();
        Shift.shiftOut((byte) ser.getPin().getAddress(), (byte) clk.getPin().getAddress(), (byte) Shift.LSBFIRST, (byte) value);
        latch.high();
    }
}
