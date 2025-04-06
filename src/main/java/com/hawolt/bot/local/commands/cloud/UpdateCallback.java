package com.hawolt.bot.local.commands.cloud;

public interface UpdateCallback<T> {
    void onUpdate(T reference);
}
