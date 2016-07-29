package com.yauhenl.pibot.control.impl;

import com.yauhenl.pibot.control.ActionFactory;
import com.yauhenl.pibot.control.ActionService;
import com.yauhenl.pibot.control.action.Action;
import com.yauhenl.pibot.control.action.ActionResult;
import com.yauhenl.pibot.control.action.ActionType;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Stsiapan_Shablinski on 7/28/2016.
 */
@Component
public class DefaultActionService implements ActionService {

    private static final Logger LOG = Logger.getLogger(DefaultActionService.class);

    @Autowired
    ActionFactory actionFactory;

    @Override
    public ActionResult performAction(ActionType actionType) {
        Action action = actionFactory.getAction(actionType);
        if (action == null) {
            LOG.warn("Can't perform unsupported action: " + actionType);
            return ActionResult.STATUS_FAILURE;
        } else {
            LOG.debug("Performing action: " + actionType);
            return action.perform();
        }
    }

}
