package com.hawolt.events.impl.synthetic;

import com.hawolt.events.BaseEvent;
import com.hawolt.events.Event;

public class SelfPartEvent extends Event {
    private final String type, channel;

    public SelfPartEvent(BaseEvent base) {
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
        return "SelfPartEvent{" +
                "type='" + type + '\'' +
                ", channel='" + channel + '\'' +
                '}';
    }
}
