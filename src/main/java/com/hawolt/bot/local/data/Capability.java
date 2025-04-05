package com.hawolt.bot.local.data;

import java.util.Locale;

public enum Capability {
    COMMANDS, MEMBERSHIP, TAGS;

    @Override
    public String toString() {
        return String.join(
                "/",
                "twitch.tv",
                name().toLowerCase(Locale.ENGLISH)
        );
    }
}
