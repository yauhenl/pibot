package com.yauhenl.pibot.web;

import com.yauhenl.pibot.control.action.ActionType;
import com.yauhenl.pibot.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BotController {

    @Autowired
    private ActionService actionService;


    @RequestMapping(value = "/action/{actionId}/${params}", method = RequestMethod.GET)
    public void performAction(@PathVariable String actionId, @PathVariable String params) {
        ActionType action = ActionType.valueOf(actionId);
        actionService.performAction(action, params.split(","));
    }
}
