package com.yauhenl.pibot.web;

import com.yauhenl.pibot.hardware.BotControl;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.yauhenl.pibot.hardware.BotControl.*;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class RunController {
    private enum Direction {
        forward,
        backward,
        left,
        right
    }

    @RequestMapping(value = "/run/{direction}", method = GET)
    public void run(@PathVariable String direction) {
        allHigh();
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
        }
    }

    @RequestMapping(value = "/stop", method = GET)
    public void stop() {
        BotControl.stop();
        allLow();
    }
}
