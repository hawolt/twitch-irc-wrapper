package com.hawolt.bot.cloud.commands;

import com.hawolt.bot.local.commands.Permission;

import java.util.function.Function;

public class CommandFunction implements Function<Object[], DatabaseCommand> {
    @Override
    public DatabaseCommand apply(Object[] o) {
        return new DatabaseCommand(
                o[1].toString(),
                Long.parseLong(o[2].toString()),
                Boolean.parseBoolean(o[3].toString()),
                Permission.valueOf(o[4].toString())
        );
    }
}
