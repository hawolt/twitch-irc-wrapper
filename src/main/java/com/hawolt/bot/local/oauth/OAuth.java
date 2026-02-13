package com.hawolt.bot.local.oauth;

import java.io.IOException;

public interface OAuth {
    String getAccessToken() throws IOException;
}
