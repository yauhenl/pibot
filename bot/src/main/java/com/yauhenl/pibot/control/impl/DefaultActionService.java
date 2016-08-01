package com.yauhenl.pibot.control.impl;

import com.yauhenl.pibot.control.ActionService;
import com.yauhenl.pibot.control.action.ActionType;
import com.yauhenl.pibot.hardware.BotControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Stsiapan_Shablinski on 7/28/2016.
 */
@Component
public class DefaultActionService implements ActionService {

    @Autowired
    private BotControl botControl;

    @Override
    public void performAction(ActionType actionType) {
        actionType.getAction().perform(botControl);
    }

}
