package com.yauhenl.pibot.service;

import com.yauhenl.pibot.control.action.ActionType;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * Created by Stsiapan_Shablinski on 7/28/2016.
 */
@Component
public class ActionService {

    @Inject
    private BotControl botControl;

    public void performAction(ActionType actionType) {
        actionType.getAction().perform(botControl);
    }
}
