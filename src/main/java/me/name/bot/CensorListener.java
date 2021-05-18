package me.name.bot;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bson.Document;

public class CensorListener extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event/*, MongoCollection<Document> data*/){
        User user = event.getAuthor();
        Message message = event.getMessage();
        String content = message.getContentRaw();
//        Bot b = new Bot();
//        MongoDatabase mongodb = b.getMongoDB();
        if(content.contains(":ChopChop:767996373139587082")){
            message.delete().queue();
            MessageChannel channel = event.getChannel();
            channel.sendMessage("BANNED WORD DETECTED VROOM VROOM  :police_car:  :police_car:").queue();

        }
    }

}
