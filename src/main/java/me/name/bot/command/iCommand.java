package me.name.bot.command;


public interface iCommand {
    void handle(CommandContext ctx);

    // Used to get command name for command manager
    String getName();

}
