package com.yauhenl.pibot.web

import com.yauhenl.pibot.Direction
import com.yauhenl.pibot.Power
import com.yauhenl.pibot.Power.off
import com.yauhenl.pibot.Power.on
import com.yauhenl.pibot.hardware.BotControl.allHigh
import com.yauhenl.pibot.hardware.BotControl.allLow
import com.yauhenl.pibot.hardware.BotControl.doMove
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod.GET
import org.springframework.web.bind.annotation.RestController

@RestController
class BotController {

    @RequestMapping(value = "/switch/{power}", method = arrayOf(GET))
    fun shutdown(@PathVariable power: String) {
        when (Power.valueOf(power)) {
            on -> allHigh()
            off -> allLow()
        }
    }

    @RequestMapping(value = "/move/{direction}", method = arrayOf(GET))
    fun move(@PathVariable direction: String) {
        doMove(Direction.valueOf(direction))
    }
}
