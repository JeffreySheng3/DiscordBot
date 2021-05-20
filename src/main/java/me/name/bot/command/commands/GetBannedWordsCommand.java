package me.name.bot.command.commands;

import me.name.bot.Mongo;
import me.name.bot.command.CommandContext;
import me.name.bot.command.iCommand;
import net.dv8tion.jda.api.entities.MessageChannel;

import java.util.List;

public class GetBannedWordsCommand implements iCommand {
    @Override
    public void handle(CommandContext ctx) {
        MessageChannel channel = ctx.getChannel();
        Mongo m = new Mongo();
        List<String> bannedWords = m.getBannedWord();
        String message = "";
        for(int i = 0; i < bannedWords.size(); i++){
            message += bannedWords.get(i) + ", ";
        }
        channel.sendMessage(message).queue();
    }

    @Override
    public String getName() {
        return "!getBWord";
    }
}
