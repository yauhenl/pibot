package com.yauhenl.pibot;

/*
    dc1 32, 16
    dc2 8, 64
    dc3 1, 4
    dc4 128, 2
*/
public enum Direction {
    forward(169), //32+8+1+128
    backward(86), //16+64+4+2
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
