package com.hawolt.bot.local.events.impl;

import com.hawolt.bot.local.events.BaseEvent;
import com.hawolt.bot.local.events.Event;

public class JoinEvent extends Event {
    private final String user, channel, type;

    public JoinEvent(BaseEvent base) {
        super(base);
        this.user = base.data()[0];
        this.type = base.data()[1];
        this.channel = base.data()[2];
    }

    @Override
    public String getType() {
        return type;
    }

    public String getUser() {
        return user;
    }

    public String getChannel() {
        return channel;
    }

    @Override
    public String toString() {
        return "JoinEvent{" +
                "channel='" + channel + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
