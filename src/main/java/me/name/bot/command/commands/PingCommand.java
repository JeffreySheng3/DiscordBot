package me.name.bot.command.commands;

import me.name.bot.command.CommandContext;
import me.name.bot.command.iCommand;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.MessageChannel;

public class PingCommand implements iCommand {

    /**
     * @param ctx context of current command that needs to be handled
     */
    @Override
    public void handle(CommandContext ctx){
        JDA jda = ctx.getJDA();
        MessageChannel channel = ctx.getChannel();
        jda.getRestPing().queue( (time)  ->
                channel.sendMessageFormat("Ping: %d ms", time).queue()
        );
    }

    /**
     * @return name of command
     */
    @Override
    public String getName(){
        return "!ping";
    }
}
