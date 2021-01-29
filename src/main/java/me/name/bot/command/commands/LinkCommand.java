package me.name.bot.command.commands;

import me.name.bot.Config;
import me.name.bot.command.CommandContext;
import me.name.bot.command.iCommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.MessageEmbed;

import java.awt.*;

public class LinkCommand implements iCommand {
    @Override
    public void handle(CommandContext ctx) {
        MessageChannel channel = ctx.getChannel();
        channel.sendMessage(createEmbed(ctx)).queue();
    }

    @Override
    public String getName() {
        return "!linkme";
    }

    //TODO: Use locally stored links according to user
    //TODO2: Use databases to store links?
    public MessageEmbed createEmbed(CommandContext ctx){
        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setTitle(ctx.getEvent().getAuthor().getName() + "'s links");
        embedBuilder.setThumbnail("https://github.githubassets.com/images/modules/open_graph/github-mark.png");
        embedBuilder.setColor(new Color(2496714));
        embedBuilder.addField(":one:","[Github]("+ Config.get("GITHUB") + ")", false);
        embedBuilder.addField(":two:","[LinkedIn]("+ Config.get("LINKEDIN") +")", false);
        embedBuilder.setFooter("By EXDream", "https://images-na.ssl-images-amazon.com/images/I/41dYF4chcmL._AC_SY1000_.jpg");
        return embedBuilder.build();
    }
}
