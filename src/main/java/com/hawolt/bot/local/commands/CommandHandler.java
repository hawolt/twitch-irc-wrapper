package com.hawolt.bot.local.commands;

import com.hawolt.bot.local.events.EventHandler;
import com.hawolt.bot.local.events.impl.MessageEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CommandHandler implements EventHandler<MessageEvent> {

    private final String prefix;

    protected final Map<String, Command> commands = new HashMap<>();

    public CommandHandler() {
        this("!");
    }

    public CommandHandler(String prefix) {
        this.prefix = prefix;
    }

    public void addCommand(Command command) {
        this.commands.put(command.getCommandName(), command);
    }

    public boolean isCommand(String name) {
        return commands.containsKey(name);
    }

    public Set<String> getCommandList() {
        return commands.keySet();
    }

    @Override
    public void onEvent(MessageEvent event) {
        String message = event.getMessage();
        if (!event.getMessage().startsWith(prefix)) return;
        if (message.length() > prefix.length()) {
            String command = message.substring(prefix.length()).split(" ")[0].toLowerCase();
            if (!commands.containsKey(command)) return;
            event.getUserMetadata().ifPresent(user -> {
                Command target = commands.get(command);
                if (!target.isEnabled(event)) return;
                Permission permission = target.getMinimumPermission(event);
                boolean permitted = switch (permission) {
                    case EVERYONE:
                        yield true;
                    case MOD:
                        yield user.mod() || user.broadcaster() || user.userId() == 747734304L;
                    case BROADCASTER:
                        yield user.broadcaster() || user.userId() == 747734304L;
                    case DEVELOPER:
                        yield user.userId() == 747734304L;
                };
                if (!permitted) return;
                target.onEvent(event);
            });
        }
    }
}
