package me.name.bot;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class CensorSarah extends ListenerAdapter {
    private final String sarah = Config.get("SARAH");
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        User user = event.getAuthor();
        //If someone other than Sarah sent it, ignore
        if(!user.getId().equals(sarah)){
            return;
        }
        Message message = event.getMessage();
        String content = message.getContentRaw();
        if(content.contains(":ChopChop:767996373139587082")){
            message.delete().queue();
            MessageChannel channel = event.getChannel();
            channel.sendMessage("BANNED WORD DETECTED VROOM VROOM  :police_car:  :police_car:").queue();

        }
    }
}
