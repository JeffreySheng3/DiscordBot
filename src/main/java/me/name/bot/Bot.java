package me.name.bot;

import me.duncte123.botcommons.messaging.EmbedUtils;
import me.name.bot.command.ReactionListener;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.MessageEmbed;

//TODO: add role on reaction
public class Bot {
    public static void main (String[] args) throws Exception{
        EmbedUtils.setEmbedBuilder(
                () -> new EmbedBuilder().setColor(0x3883d9)
        );
        JDA jda = null;
        JDABuilder api = JDABuilder.createDefault(Config.get("TOKEN"));
        api.addEventListeners(new MyListener());
        api.setActivity(Activity.watching("Being built"));
        api.addEventListeners(new CensorSarah());
        api.addEventListeners(new ReactionListener());
        jda = api.build();
    }


}
