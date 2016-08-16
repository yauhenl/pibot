package com.yauhenl.pibot.hardware.cascade;

import com.pi4j.io.gpio.GpioPinDigitalOutput;

/**
 * Created by Stsiapan_Shablinski on 7/29/2016.
 */
public class Shift {

    private GpioPinDigitalOutput clk;
    private GpioPinDigitalOutput ser;
    private GpioPinDigitalOutput latch;

    public Shift(GpioPinDigitalOutput clk, GpioPinDigitalOutput ser, GpioPinDigitalOutput latch) {
        this.clk = clk;
        this.ser = ser;
        this.latch = latch;
    }

    public void writeShift(int value) {
        latch.low();
        com.pi4j.wiringpi.Shift.shiftOut((byte) ser.getPin().getAddress(), (byte) clk.getPin().getAddress(), (byte) com.pi4j.wiringpi.Shift.LSBFIRST, (byte) value);
        latch.high();
    }
}