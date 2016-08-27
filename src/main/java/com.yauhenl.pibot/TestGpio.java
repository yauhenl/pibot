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

    private static final GpioPinDigitalOutput dc1 = gpio.provisionDigitalOutputPin(GPIO_25, LOW);
    private static final GpioPinDigitalOutput dc2 = gpio.provisionDigitalOutputPin(GPIO_22, LOW);
    private static final GpioPinPwmOutput dc3 = gpio.provisionPwmOutputPin(GPIO_24, 1000);
    private static final GpioPinDigitalOutput dc4 = gpio.provisionDigitalOutputPin(GPIO_23, LOW);

    private static final GpioPinDigitalOutput clk = gpio.provisionDigitalOutputPin(GPIO_26, LOW);
    private static final GpioPinDigitalOutput ser = gpio.provisionDigitalOutputPin(GPIO_27, LOW);
    private static final GpioPinDigitalOutput latch = gpio.provisionDigitalOutputPin(GPIO_28, LOW);

    public static void main(String[] args) throws InterruptedException {
        forward();
        setPwm(1000);
        Thread.sleep(2000);
//        backward();
//        setPwm(50);
//        Thread.sleep(2000);
//        forward();
//        setPwm(75);
//        Thread.sleep(2000);
//        backward();
//        setPwm(100);
//        Thread.sleep(2000);

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
        dc2.high();
        dc4.high();
    }

    private static void allLow() {
        dc2.low();
        dc4.low();
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
