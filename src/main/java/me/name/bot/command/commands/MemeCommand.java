package me.name.bot.command.commands;

import com.fasterxml.jackson.databind.JsonNode;
import me.duncte123.botcommons.messaging.EmbedUtils;
import me.duncte123.botcommons.web.WebUtils;
import me.name.bot.command.CommandContext;
import me.name.bot.command.iCommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageChannel;

public class MemeCommand implements iCommand {
    @Override
    public void handle(CommandContext ctx) {
        MessageChannel channel = ctx.getChannel();
        WebUtils.ins.getJSONObject("https://apis.duncte123.me/meme").async( (jsonNodes) -> {
            if (!jsonNodes.get("success").asBoolean()) {
                channel.sendMessage("Error!").queue();
                System.out.println(jsonNodes);
                return;
            }

            final JsonNode node = jsonNodes.get("data");
            final String title = node.get("title").asText();
            final String url = node.get("url").asText();
            final String image = node.get("image").asText();
            final EmbedBuilder embed = EmbedUtils.embedImageWithTitle(title, url, image);
            channel.sendMessage(embed.build()).queue();
        });
    }

    @Override
    public String getName() {
        return "!meme";
    }
}
