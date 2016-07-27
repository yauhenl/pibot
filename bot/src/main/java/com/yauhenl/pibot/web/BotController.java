package com.yauhenl.pibot.web;

import com.yauhenl.pibot.Direction;
import com.yauhenl.pibot.Power;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.yauhenl.pibot.hardware.BotControl.*;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class BotController {
    @RequestMapping(value = "/switch/{power}", method = GET)
    public void shutdown(@PathVariable String power) {
        switch (Power.valueOf(power)) {
            case on:
                allHigh();
                break;
            case off:
                allLow();
                break;
        }
    }

    @RequestMapping(value = "/move/{direction}", method = GET)
    public void move(@PathVariable String direction) {
        doMove(Direction.valueOf(direction));
    }
}
