package com.yauhenl.pibot.service;

import com.yauhenl.pibot.control.action.ActionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Stsiapan_Shablinski on 7/28/2016.
 */
@Service
public class ActionService {

    @Autowired
    private BotControl botControl;

    public void performAction(ActionType actionType) {
        actionType.getAction().perform(botControl);
    }

    public void performAction(ActionType actionType, String... params) {
        actionType.getAction().perform(botControl, params);
    }
}
