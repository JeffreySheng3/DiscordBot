package me.name.bot.command.commands;

import me.name.bot.command.CommandContext;
import me.name.bot.command.iCommand;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.MessageChannel;

import java.util.Random;

public class FlipCoinCommand implements iCommand {
    @Override
    public void handle(CommandContext ctx) {
        JDA jda = ctx.getJDA();
        MessageChannel channel = ctx.getChannel();
        Random r = new Random();
        int temp = r.nextInt(2);
        if(temp == 0){
            channel.sendMessage("Heads").queue();
        }else{
            channel.sendMessage("Tails").queue();
        }
    }

    @Override
    public String getName() {
        return "!flip";
    }
}
