package com.hawolt.bot.local;

import java.io.IOException;

public interface Presence {
    void part(String channel) throws IOException;

    void part(String... channels) throws IOException;

    void join(String channel) throws IOException;

    void join(String... channels) throws IOException;
}
