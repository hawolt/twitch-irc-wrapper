package com.hawolt.bot.local.events;

public interface EventHandler<T extends Event> {
    void onEvent(T t);
}
