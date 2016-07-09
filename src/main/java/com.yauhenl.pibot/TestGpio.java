package com.yauhenl.pibot;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.wiringpi.Shift;

import static com.pi4j.io.gpio.PinState.LOW;
import static com.pi4j.io.gpio.RaspiPin.*;

public class TestGpio {
    private static final GpioController gpio = GpioFactory.getInstance();

    private static final GpioPinDigitalOutput dc1 = gpio.provisionDigitalOutputPin(GPIO_25, LOW);
    private static final GpioPinDigitalOutput dc2 = gpio.provisionDigitalOutputPin(GPIO_22, LOW);
    private static final GpioPinDigitalOutput dc3 = gpio.provisionDigitalOutputPin(GPIO_24, LOW);
    private static final GpioPinDigitalOutput dc4 = gpio.provisionDigitalOutputPin(GPIO_23, LOW);

    private static final GpioPinDigitalOutput clk = gpio.provisionDigitalOutputPin(GPIO_26, LOW);
    private static final GpioPinDigitalOutput ser = gpio.provisionDigitalOutputPin(GPIO_27, LOW);
    private static final GpioPinDigitalOutput latch = gpio.provisionDigitalOutputPin(GPIO_28, LOW);

    /*
    dc1 32, 16
    dc2 8, 64
    dc3 1, 4
    dc4 128, 2
     */
    public static void main(String[] args) throws InterruptedException {
        allHigh();

        forward();
        Thread.sleep(2000);
        backward();
        Thread.sleep(2000);
        toLeft();
        Thread.sleep(2000);
        toRight();
        Thread.sleep(2000);

        stop();
        allLow();
        gpio.shutdown();
    }

    private static void forward() {
        writeShift(169);
    }

    private static void backward() {
        writeShift(86);
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
        dc1.high();
        dc2.high();
        dc3.high();
        dc4.high();
    }

    private static void allLow() {
        dc1.low();
        dc2.low();
        dc3.low();
        dc4.low();
    }

    private static void writeShift(int value) {
        latch.low();
        Shift.shiftOut((byte) GPIO_27.getAddress(), (byte) GPIO_26.getAddress(), (byte) Shift.LSBFIRST, (byte) value);
        latch.high();
    }
}
