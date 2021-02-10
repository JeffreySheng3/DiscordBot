package me.name.bot.command.commands;

import me.name.bot.command.CommandContext;
import me.name.bot.command.iCommand;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.MessageChannel;

import java.util.ArrayList;
import java.util.Random;

public class EightBallCommand implements iCommand {
    ArrayList<String> responses = new ArrayList<>();

    public EightBallCommand(){
        responses.add("Ask again later.");
        responses.add("As I see it, yes.");
        responses.add("Better not tell you now.");
        responses.add("Cannot predict now :(");
        responses.add("Do you really wanna know?");
        responses.add("Concentrate and ask again.");
        responses.add("Don't count on it.");
    }
    @Override
    public void handle(CommandContext ctx) {
        JDA jda = ctx.getJDA();
        MessageChannel channel = ctx.getChannel();
        if(ctx.getArgs().size() == 0){
            channel.sendMessage("What do you want to ask?").queue();
            return;
        }
        Random r = new Random();
        int temp = r.nextInt(responses.size());
        channel.sendMessage(responses.get(temp)).queue();
    }

    @Override
    public String getName() {
        return "!8ball";
    }
}
