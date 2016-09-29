package com.yauhenl.pibot.web;

import com.yauhenl.pibot.control.action.ActionType;
import com.yauhenl.pibot.service.ActionService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/action/{actionId}")
public class BotController {

    @GET
    public void performAction(@PathParam("actionId") String actionId) {
        ActionService.getInstance().performAction(ActionType.valueOf(actionId));
    }
}
