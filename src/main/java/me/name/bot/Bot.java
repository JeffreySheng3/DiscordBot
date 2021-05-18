package me.name.bot;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import me.duncte123.botcommons.messaging.EmbedUtils;
import me.name.bot.command.ReactionListener;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import org.bson.Document;

//TODO: add role on reaction
public class Bot {

    public static void main (String[] args) throws Exception{
        EmbedUtils.setEmbedBuilder(
                () -> new EmbedBuilder().setColor(0x3883d9)
        );
        JDA jda = null;
        JDABuilder api = JDABuilder.createDefault(Config.get("TOKEN"));
        api.addEventListeners(new CommandListener());
        api.setActivity(Activity.watching("Being built"));
        api.addEventListeners(new ReactionListener());
        api.addEventListeners(new CensorListener());

//        Bot b = new Bot();
        jda = api.build();
    }


}
