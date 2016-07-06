package com.yauhenl.pibot;

import com.pi4j.io.gpio.*;
import com.pi4j.wiringpi.Shift;

import static com.pi4j.io.gpio.PinState.LOW;
import static com.pi4j.io.gpio.RaspiPin.*;

public class TestGpio {

    public static void main(String[] args) throws InterruptedException {
        final GpioController gpio = GpioFactory.getInstance();

        final GpioPinDigitalOutput dc1 = gpio.provisionDigitalOutputPin(GPIO_25, LOW);
        final GpioPinDigitalOutput dc2 = gpio.provisionDigitalOutputPin(GPIO_22, LOW);
        final GpioPinDigitalOutput dc3 = gpio.provisionDigitalOutputPin(GPIO_23, LOW);
        final GpioPinDigitalOutput dc4 = gpio.provisionDigitalOutputPin(GPIO_24, LOW);

        final GpioPinDigitalOutput clk = gpio.provisionDigitalOutputPin(GPIO_26, LOW);
        final GpioPinDigitalOutput ser = gpio.provisionDigitalOutputPin(GPIO_27, LOW);
        final GpioPinDigitalOutput latch = gpio.provisionDigitalOutputPin(GPIO_28, LOW);

        dc1.setShutdownOptions(true, LOW);
        dc2.setShutdownOptions(true, LOW);
        dc3.setShutdownOptions(true, LOW);
        dc4.setShutdownOptions(true, LOW);

        System.out.println("DC1");
        dc1.high();
        Thread.sleep(1000);

        System.out.println("write 4");
        latch.low();
        writeShift((byte) 4);
        latch.high();
        Thread.sleep(1000);

        System.out.println("write 4");
        latch.low();
        writeShift((byte) 8);
        latch.high();
        Thread.sleep(1000);

        gpio.shutdown();
    }

    private static void writeShift(byte value) {
        Shift.shiftOut((byte) GPIO_27.getAddress(), (byte) GPIO_26.getAddress(), (byte) Shift.LSBFIRST, value);
    }
}
