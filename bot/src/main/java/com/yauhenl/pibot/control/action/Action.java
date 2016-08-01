package com.yauhenl.pibot.control.action;

import com.yauhenl.pibot.service.BotControl;

/**
 * Created by Stsiapan_Shablinski on 7/28/2016.
 */
public interface Action {
    void perform(BotControl botControl, String... params);
}
