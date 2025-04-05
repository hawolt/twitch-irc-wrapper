package com.hawolt.bot.local.events.impl;

import com.hawolt.bot.local.events.BaseEvent;
import com.hawolt.bot.local.events.Event;

public class UnknownEvent extends Event {
    public UnknownEvent(BaseEvent base) {
        super(base);
    }

    @Override
    public String getType() {
        return "UNKNOWN";
    }
}
