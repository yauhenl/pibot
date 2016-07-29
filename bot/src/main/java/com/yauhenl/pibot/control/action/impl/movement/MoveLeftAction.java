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
@ConfiguredAction(actionType = ActionType.MOVE_LEFT)
public class MoveLeftAction implements Action {

    private static final int LEFT_SHIFT_VAL = 46;

    @Autowired
    private BotControl botControl;

    @Override
    public ActionResult perform() {
        botControl.getCascade().getShift().writeShift(LEFT_SHIFT_VAL);
        return ActionResult.STATUS_SUCCESS;
    }

}
