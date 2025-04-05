package com.hawolt.bot.local.events.impl.synthetic;

import com.hawolt.bot.local.events.BaseEvent;
import com.hawolt.bot.local.events.Event;

public class SelfJoinEvent extends Event {
    private final String type, channel;

    public SelfJoinEvent(BaseEvent base) {
        super(base);
        this.type = base.data()[0];
        this.channel = base.data()[1];
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
        return "SelfJoinEvent{" +
                "type='" + type + '\'' +
                ", channel='" + channel + '\'' +
                '}';
    }
}
