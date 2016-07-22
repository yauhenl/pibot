package com.yauhenl.pibot;

/*
    dc1 32, 16
    dc2 64, 8
    dc3 1, 4
    dc4 2, 128
 */
public enum Direction {
    forward(99), //32+64+1+2
    backward(156), //16+8+4+128
    left(46),     //32+8+4+2
    right(209),   //16+64+1+128
    stop(0);

    private int shift;

    Direction(int shift) {
        this.shift = shift;
    }

    public int getShift() {
        return shift;
    }
}
