package com.yauhenl.pibot.control.impl;

import com.yauhenl.pibot.control.ActionFactory;
import com.yauhenl.pibot.control.action.Action;
import com.yauhenl.pibot.control.action.ActionType;
import com.yauhenl.pibot.control.action.ConfiguredAction;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Stsiapan_Shablinski on 7/28/2016.
 */
@Component
public class DefaultActionFactory implements ActionFactory {

    private final static Logger LOG = Logger.getLogger(DefaultActionFactory.class);

    private Map<ActionType, Action> actionMap;

    public DefaultActionFactory() {
        actionMap = new HashMap<>();
    }

    @EventListener
    private void handleContextRefresh(ContextRefreshedEvent event) {
        ApplicationContext context = event.getApplicationContext();
        Map<String, Object> beans = context.getBeansWithAnnotation(ConfiguredAction.class);

        LOG.info("Context refreshed - initializing control subsystem...");
        actionMap.clear();
        for (String bean : beans.keySet()) {
            Object candidate = beans.get(bean);
            ActionType actionType = candidate.getClass().getAnnotation(ConfiguredAction.class).actionType();
            if (candidate instanceof Action) {
                actionMap.put(actionType, (Action) candidate);
            }
        }
        LOG.info("Control subsystem initialized with " + actionMap.keySet().size() + " commands");
    }

    @Override
    public Action getAction(ActionType actionType) {
        return actionMap.get(actionType);
    }

}
