package me.name.bot.command;

import me.name.bot.Config;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Map;


public class ReactionListener extends ListenerAdapter {

    final String thumbsUp = "806040739434856449";
    final String lewd = "806040739434856449";

    //Emote ID to Role ID
    private final Map<String, String> roleMap = new HashMap<>();
    public ReactionListener(){
        roleMap.put(thumbsUp, Config.get("ISEEROLE"));
        roleMap.put(lewd, Config.get("VROLE"));
    }

    @Override
    public void onMessageReactionAdd(MessageReactionAddEvent e){

        MessageChannel channel = e.getChannel();
        if(e.getChannel().getId().equals(Config.get("ROLECHANNEL"))){

            Member m = e.getMember();
            String messageID = e.getMessageId();
            //getID() method for Emote class currently broken, unable to get ID for emotes and thus unable to assign roles accordingly.
            //String temp = roleMap.get(e.getReactionEmote().getId());
            if(messageID.equals(Config.get("VMESSAGE"))){

                Role role = e.getGuild().getRoleById(Config.get("VROLE"));
                e.getGuild().addRoleToMember(m, role).queue();
            }
            if(messageID.equals(Config.get("ALLSEERMESSAGE"))){

                Role role = e.getGuild().getRoleById(Config.get("ISEEROLE"));
                e.getGuild().addRoleToMember(m, role).queue();
            }


        }
    }

    @Override
    public void onMessageReactionRemove(MessageReactionRemoveEvent e) {
        MessageChannel channel = e.getChannel();
        if(e.getChannel().getId().equals(Config.get("ROLECHANNEL"))){
            Member m = e.getMember();
            String messageID = e.getMessageId();

            if(messageID.equals(Config.get("VMESSAGE"))){

                Role role = e.getGuild().getRoleById(Config.get("VROLE"));
//                e.getGuild().removeRoleFromMember(m, role).queue();
                e.getGuild().removeRoleFromMember(e.getUserId(),role).queue();
            }
            if(messageID.equals(Config.get("ALLSEERMESSAGE"))){

                Role role = e.getGuild().getRoleById(Config.get("ISEEROLE"));
//                e.getGuild().removeRoleFromMember(m, role).queue();
                e.getGuild().removeRoleFromMember(e.getUserId(),role).queue();
            }
        }
    }
}
