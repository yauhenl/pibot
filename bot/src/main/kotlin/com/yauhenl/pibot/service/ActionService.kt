package com.yauhenl.pibot.service

import com.yauhenl.pibot.control.ActionType
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ActionService {

    @Autowired
    lateinit var botControl: BotControl

    fun performAction(actionType: ActionType) = actionType.action.invoke(botControl)
}
