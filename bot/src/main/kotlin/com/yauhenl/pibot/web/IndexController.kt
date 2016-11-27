package com.yauhenl.pibot.web

import com.yauhenl.pibot.control.ActionType
import com.yauhenl.pibot.service.ActionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class IndexController {

    @Autowired
    private val actionService: ActionService? = null

    @GetMapping("/action/{actionName}")
    fun performAction(@RequestParam("actionName") actionName: String) = actionService?.performAction(ActionType.valueOf(actionName))
}
