package me.name.bot;

import me.name.bot.command.CommandContext;
import me.name.bot.command.commands.*;
import me.name.bot.command.iCommand;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import org.graalvm.compiler.core.common.type.ArithmeticOpTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CommandManager {

    /**
     * Map of command to iCommand object
     **/
    private final Map<String, iCommand> commands = new HashMap<>();

    /**
     * Constructor that adds available commands in
     **/
    public CommandManager(){
        addCommand(new PingCommand());
        addCommand(new HelpCommand());
        addCommand(new MemeCommand());
        addCommand(new LinkCommand());
        addCommand(new EightBallCommand());
        addCommand(new FlipCoinCommand());
        addCommand(new GuessWhatCommand());
        addCommand(new AddBannedWordCommand());
        addCommand(new GetBannedWordsCommand());
    }

    /**
     * @param cmd iCommand object
     */
    private void addCommand(iCommand cmd){
        if(commands.containsKey(cmd.getName())){
            throw new IllegalArgumentException("Command already exists!");
        }
        commands.put(cmd.getName(), cmd);
    }

    /**
     * @param name name of the command
     * @returns iCommand object if it exists, null if not
     */
    private iCommand getCommand(String name){
        if(commands.containsKey(name)){
            return commands.get(name);
        }else{
            return null;
        }
    }

    /**
     * @param event event object that needs to be handled
     **/
    void handle(GuildMessageReceivedEvent event){
        String commandName = event.getMessage().getContentRaw();
        String[] temp = commandName.split("\\s+");
        ArrayList<String> split = new ArrayList<String>(Arrays.asList(temp));
        // Separate command from arguments
        commandName = split.remove(0);

        System.out.println("The commandName is: " + commandName);
        System.out.println(("The args are: " + split));

        iCommand cmd = this.getCommand(commandName);
        if(cmd != null){
            event.getChannel().sendTyping().queue();
            CommandContext ctx = new CommandContext(event, split);
            cmd.handle(ctx);
        }else{
            event.getChannel().sendMessage("Command not found").queue();
        }
    }

}
