package com.hawolt.bot.local.events;

import com.hawolt.bot.local.Bot;

public record BaseEvent(Bot bot, String[] data) {

}