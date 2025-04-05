package com.hawolt.commands;

import com.hawolt.events.EventHandler;
import com.hawolt.events.impl.MessageEvent;
import com.hawolt.logger.Logger;

import java.util.HashMap;
import java.util.Map;

public abstract class Command implements EventHandler<MessageEvent> {

    private final Map<String, Long> mapping = new HashMap<>();
    private final Object lock = new Object();

    public abstract Permission getMinimumPermission();

    public abstract String getCommandName();

    public abstract long getCooldownDurationInMillis();

    public abstract boolean isEnabled(MessageEvent event);

    @Override
    public void onEvent(MessageEvent event) {
        synchronized (lock) {
            long lastCommandExecution = mapping.getOrDefault(event.getChannel(), 0L);
            if (System.currentTimeMillis() - lastCommandExecution < getCooldownDurationInMillis()) return;
            mapping.put(event.getChannel(), System.currentTimeMillis());
            try {
                execute(event);
            } catch (Exception e) {
                Logger.error(e);
            }
        }
    }

    public abstract void execute(MessageEvent event) throws Exception;
}
