package com.hawolt.bot.local.commands;

import com.hawolt.bot.local.events.EventHandler;
import com.hawolt.bot.local.events.impl.MessageEvent;
import com.hawolt.logger.Logger;

import java.util.HashMap;
import java.util.Map;

public abstract class Command implements EventHandler<MessageEvent> {

    private final Map<Long, Long> mapping = new HashMap<>();
    private final Object lock = new Object();

    public abstract String getCommandName();

    public abstract Permission getMinimumPermission(MessageEvent event);

    public abstract long getCooldownDurationInMillis(MessageEvent event);

    public abstract boolean isEnabled(MessageEvent event);

    @Override
    public void onEvent(MessageEvent event) {
        synchronized (lock) {
            event.getUserMetadata().ifPresent(metadata -> {
                long lastCommandExecution = mapping.getOrDefault(metadata.room(), 0L);
                if (System.currentTimeMillis() - lastCommandExecution < getCooldownDurationInMillis(event)) return;
                mapping.put(metadata.room(), System.currentTimeMillis());
                try {
                    execute(event);
                } catch (Exception e) {
                    Logger.error(e);
                }
            });
        }
    }

    public abstract void execute(MessageEvent event) throws Exception;
}
