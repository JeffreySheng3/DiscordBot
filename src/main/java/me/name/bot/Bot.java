package me.name.bot;

import me.duncte123.botcommons.messaging.EmbedUtils;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.MessageEmbed;


public class Bot {
    public static void main (String[] args) throws Exception{
        EmbedUtils.setEmbedBuilder(
                () -> new EmbedBuilder().setColor(0x3883d9)
        );
        JDA api = JDABuilder.createDefault(Config.get("TOKEN")).build();
        api.getPresence().setActivity(Activity.watching("Being built"));
        api.addEventListener(new MyListener());
        api.addEventListener(new CensorSarah());
    }


}
