package me.name.bot;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MyListener extends ListenerAdapter {
    private final CommandManager manager = new CommandManager();

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event)
    {
        //Name of user who used command
        User user = event.getAuthor();

        //Do not reply to itself
        if (event.getAuthor().isBot()) return;

        Message message = event.getMessage();
        String content = message.getContentRaw();
        // getContentRaw() is an atomic getter
        // getContentDisplay() is a lazy getter which modifies the content for e.g. console view (strip discord formatting)

        if(content.charAt(0) == '!' && content.length() != 1){
            if(!allSameChar(content)) {
                manager.handle(event);
            }
        }

    }

    private boolean allSameChar(String str){
        char character = str.charAt(0);
        for(int i = 1; i < str.length(); i++){
            if(str.charAt(i) != character){
                return false;
            }
        }
        return true;
    }
}
