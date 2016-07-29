package com.yauhenl.pibot.control.action.impl.movement;

import com.yauhenl.pibot.control.action.Action;
import com.yauhenl.pibot.control.action.ActionResult;
import com.yauhenl.pibot.control.action.ActionType;
import com.yauhenl.pibot.control.action.ConfiguredAction;
import com.yauhenl.pibot.hardware.BotControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Stsiapan_Shablinski on 7/29/2016.
 */
@Component
@ConfiguredAction(actionType = ActionType.MOVE_STOP)
public class StopMovingAction implements Action {

    private static final int STOP_SHIFT_VAL = 0;

    @Autowired
    private BotControl botControl;

    @Override
    public ActionResult perform() {
        botControl.getCascade().getShift().writeShift(STOP_SHIFT_VAL);
        return ActionResult.STATUS_SUCCESS;
    }

}
