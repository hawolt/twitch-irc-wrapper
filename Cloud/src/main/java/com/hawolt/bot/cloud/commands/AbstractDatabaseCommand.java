package com.hawolt.bot.cloud.commands;

import com.hawolt.bot.local.commands.Command;
import com.hawolt.bot.local.commands.Permission;
import com.hawolt.bot.local.events.impl.MessageEvent;

public abstract class AbstractDatabaseCommand extends Command {
    private final Permission permission;
    private final boolean enabled;
    private final long cooldown;
    private final String name;

    public AbstractDatabaseCommand(String name, long cooldown, boolean enabled, Permission permission) {
        this.permission = permission;
        this.cooldown = cooldown;
        this.enabled = enabled;
        this.name = name;
    }

    @Override
    public Permission getMinimumPermission() {
        return permission;
    }

    @Override
    public String getCommandName() {
        return name;
    }

    @Override
    public long getCooldownDurationInMillis() {
        return cooldown;
    }

    @Override
    public boolean isEnabled(MessageEvent event) {
        return enabled;
    }
}
