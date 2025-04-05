package com.hawolt.bot.cloud.commands;

import com.hawolt.bot.local.commands.Permission;
import com.hawolt.bot.local.events.impl.MessageEvent;
import com.hawolt.logger.Logger;
import com.hawolt.netherscript.NetherScript;

import java.io.IOException;

public class DatabaseCommand extends AbstractDatabaseCommand {

    private static final NetherScript<MessageEvent> script = new NetherScript<>();

    public static NetherScript<MessageEvent> getScriptEngine() {
        return DatabaseCommand.script;
    }

    public DatabaseCommand(String name, long cooldown, boolean enabled, Permission permission) {
        super(name, cooldown, enabled, permission);
    }

    @Override
    public void execute(MessageEvent event) {
        try {
            event.respond(script.parse(event, event.getMessage()));
        } catch (Exception e) {
            Logger.error(e);
            try {
                event.respond("Failed to execute custom command.");
            } catch (IOException ex) {
                Logger.error(ex);
            }
        }
    }
}
