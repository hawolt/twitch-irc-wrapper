package com.hawolt.bot.local.events.impl.synthetic;

import com.hawolt.bot.local.events.BaseEvent;
import com.hawolt.bot.local.events.Event;

public class ConnectEvent extends Event {

    public ConnectEvent(BaseEvent base) {
        super(base);
    }

    @Override
    public String getType() {
        return "connect";
    }
}
