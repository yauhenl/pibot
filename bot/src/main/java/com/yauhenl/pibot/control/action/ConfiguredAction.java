package com.yauhenl.pibot.control.action;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Stsiapan_Shablinski on 7/28/2016.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface ConfiguredAction {

    ActionType actionType();

}
