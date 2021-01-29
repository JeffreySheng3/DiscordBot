package me.name.bot.command.commands;

import me.name.bot.command.CommandContext;
import me.name.bot.command.iCommand;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.MessageChannel;

public class HelpCommand implements iCommand {

    @Override
    public void handle(CommandContext ctx){
        JDA jda = ctx.getJDA();
        MessageChannel channel = ctx.getChannel();
        channel.sendMessage("Currently supported commands:\n" +
                "\t !ping -- Checks your ping to discord servers\n" +
                "\t !help -- List of available commands\n").queue();
    }

    @Override
    public String getName(){
        return "!help";
    }
}
