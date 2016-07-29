package com.yauhenl.pibot.hardware.cascade.shift;

import com.pi4j.io.gpio.GpioPinDigitalOutput;

/**
 * Created by Stsiapan_Shablinski on 7/29/2016.
 */
public class Shift {

    private GpioPinDigitalOutput clk;
    private GpioPinDigitalOutput ser;
    private GpioPinDigitalOutput latch;

    public GpioPinDigitalOutput getClk() {
        return clk;
    }

    public void setClk(GpioPinDigitalOutput clk) {
        this.clk = clk;
    }

    public GpioPinDigitalOutput getSer() {
        return ser;
    }

    public void setSer(GpioPinDigitalOutput ser) {
        this.ser = ser;
    }

    public GpioPinDigitalOutput getLatch() {
        return latch;
    }

    public void setLatch(GpioPinDigitalOutput latch) {
        this.latch = latch;
    }

    public void writeShift(int value) {
        latch.low();
        com.pi4j.wiringpi.Shift.shiftOut((byte) ser.getPin().getAddress(), (byte) clk.getPin().getAddress(), (byte) com.pi4j.wiringpi.Shift.LSBFIRST, (byte) value);
        latch.high();
    }

}
