package com.yauhenl.pibot.web

import com.yauhenl.pibot.control.ActionType
import com.yauhenl.pibot.service.ActionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Controller
class IndexController() {

    @Autowired
    lateinit var actionService: ActionService

    @GetMapping("/action/{actionName}")
    fun performAction(@PathVariable actionName: String) = actionService.performAction(ActionType.valueOf(actionName))
}
