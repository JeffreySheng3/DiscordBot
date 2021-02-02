package me.name.bot.command;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


public class ReactionListener extends ListenerAdapter {
    final String roleChannel = "806038758717522010";
    final String iseeRole = "806038872081432576";

    @Override
    public void onMessageReactionAdd(MessageReactionAddEvent e){
        MessageChannel channel = e.getChannel();
        if(e.getChannel().getId().equals(roleChannel)){
            Member m = e.getMember();
            Role role = e.getGuild().getRoleById(iseeRole);
            e.getGuild().addRoleToMember(m, role).queue();
        }
    }
}
