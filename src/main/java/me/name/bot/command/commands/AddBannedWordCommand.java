package me.name.bot.command.commands;

import com.mongodb.client.MongoDatabase;
import me.name.bot.Bot;
import me.name.bot.Mongo;
import me.name.bot.command.CommandContext;
import me.name.bot.command.iCommand;
import net.dv8tion.jda.api.entities.MessageChannel;

public class AddBannedWordCommand implements iCommand {

    @Override
    public void handle(CommandContext ctx) {
        MessageChannel channel = ctx.getChannel();
        if(ctx.getArgs().size() != 1){
            channel.sendMessage("Wrong format! Please enter command followed by a single word.").queue();
            return;
        }
        String word = ctx.getArgs().get(0);
        Mongo m = new Mongo();
        m.addBannedWord(word);
        channel.sendMessage(word + " added to banned word list.").queue();
    }

    @Override
    public String getName() {
        return "!addBWord";
    }
}
