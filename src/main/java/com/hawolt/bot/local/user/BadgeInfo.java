package com.hawolt.bot.local.user;

public record BadgeInfo(String name, String value) {
    public BadgeInfo(String[] pair) {
        this(
                pair[0],
                pair[1]
        );
    }
}
