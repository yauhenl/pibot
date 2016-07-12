package com.yauhenl.pibot.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.yauhenl.pibot.hardware.BotControl.*;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class BotController {
    private enum Direction {
        forward,
        backward,
        left,
        right,
        stop
    }

    @RequestMapping(value = "/switch/{state}", method = GET)
    public void shutdown(@PathVariable String state) {
        switch (state) {
            case "ON":
                allHigh();
                break;
            case "OFF":
                allLow();
                break;
        }
    }

    @RequestMapping(value = "/move/{direction}", method = GET)
    public void move(@PathVariable String direction) {
        switch (Direction.valueOf(direction)) {
            case forward:
                forward();
                break;
            case backward:
                backward();
                break;
            case left:
                toLeft();
                break;
            case right:
                toRight();
                break;
            case stop:
                dcStop();
                break;
        }
    }
}
