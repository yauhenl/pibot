package com.yauhenl.pibot.service;

import com.yauhenl.pibot.control.action.ActionType;

/**
 * Created by Stsiapan_Shablinski on 7/28/2016.
 */
public class ActionService {

    private static ActionService actionService = new ActionService();

    private ActionService() {
    }

    public static ActionService getInstance() {
        return actionService;
    }

    public void performAction(ActionType actionType) {
        actionType.getAction().perform(BotControl.getInstance());
    }
}
