package me.name.bot.command;

import java.util.Arrays;
import java.util.List;

public interface iCommand {
    void handle(CommandContext ctx);

    // Used to get command name for command manager
    String getName();

    default List<String> getAliases(){
        return Arrays.asList();
    }
}
