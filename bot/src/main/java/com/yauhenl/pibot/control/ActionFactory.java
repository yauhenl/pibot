package com.yauhenl.pibot.control;

import com.yauhenl.pibot.control.action.Action;
import com.yauhenl.pibot.control.action.ActionType;

/**
 * Created by Stsiapan_Shablinski on 7/28/2016.
 */
public interface ActionFactory {

    Action getAction(ActionType actionType);

}
