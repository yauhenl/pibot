package com.yauhenl.pibot.web;

import com.yauhenl.pibot.control.action.ActionType;
import com.yauhenl.pibot.service.ActionService;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Component
@Path("/action/{actionId}")
public class BotController {

    @Inject
    private ActionService actionService;

    @GET
    public void performAction(@PathParam("actionId") String actionId) {
        actionService.performAction(ActionType.valueOf(actionId));
    }
}
