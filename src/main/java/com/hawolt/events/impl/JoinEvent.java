package com.hawolt.events.impl;

import com.hawolt.events.BaseEvent;
import com.hawolt.events.Event;
import com.hawolt.user.UserMetadata;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class JoinEvent extends Event {
    private final String channel, type;

    public JoinEvent(BaseEvent base) {
        super(base);
        this.type = base.data()[1];
        this.channel = base.data()[2];
    }

    @Override
    public String getType() {
        return type;
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
