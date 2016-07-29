package com.yauhenl.pibot.control;

import com.yauhenl.pibot.control.action.ActionResult;
import com.yauhenl.pibot.control.action.ActionType;

/**
 * Created by Stsiapan_Shablinski on 7/28/2016.
 */
public interface ActionService {

    ActionResult performAction(ActionType actionType);

}
