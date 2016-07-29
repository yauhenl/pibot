package com.yauhenl.pibot.control.action.impl.power;

import com.yauhenl.pibot.control.action.Action;
import com.yauhenl.pibot.control.action.ActionResult;
import com.yauhenl.pibot.control.action.ActionType;
import com.yauhenl.pibot.control.action.ConfiguredAction;
import com.yauhenl.pibot.hardware.BotControl;
import com.yauhenl.pibot.hardware.cascade.BotCascade;
import com.yauhenl.pibot.hardware.cascade.motor.Motor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Stsiapan_Shablinski on 7/28/2016.
 */
@Component
@ConfiguredAction(actionType = ActionType.ALL_MOTORS_POWER_OFF)
public class AllMotorsPowerOffAction implements Action {

    @Autowired
    private BotControl botControl;

    @Override
    public ActionResult perform() {
        for (BotCascade.MotorKey motorKey : botControl.getCascade().getMotors().keySet()) {
            Motor motor = botControl.getCascade().getMotors().get(motorKey);
            motor.setLowOutput();
        }
        return ActionResult.STATUS_SUCCESS;
    }

}
