package trivia;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.io.FileInputStream;


public class trivia extends ListenerAdapter {
    boolean startGame = false;
    int i = 0;

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {

        String channelSent = event.getMessage().getContentRaw();
        String[] info = event.getMessage().getContentRaw().split(" ");
        String name = event.getMember().getUser().getName();
        String answer = event.getMember().getUser().getName();


        if(info[0].equalsIgnoreCase("info")){
            event.getChannel().sendMessage("@"+name).queue();
            event.getChannel().sendMessage("Bot info").queue();
            event.getChannel().sendMessage("#############################################").queue();
            event.getChannel().sendMessage("This is a trivia bot").queue();
            event.getChannel().sendMessage("Say 'trivia' to start the game.").queue();
            event.getChannel().sendMessage("Say 'stop' to stop the game.").queue();
            event.getChannel().sendMessage("#############################################").queue();

        }


       /* if (channelSent.equalsIgnoreCase("trivia")) {

            if (!event.getMember().getUser().isBot()) {
                event.getChannel().sendMessage(name + " Started the Trivia Game!").queue();

            }
        }
        System.out.println(startGame);


        if(startGame = true){
            event.getChannel().sendMessage("What is 1 + 1 ?").queue();

        }



        if (channelSent.equalsIgnoreCase("2")) {
            event.getChannel().sendMessage(name + " Got it right! The answer is 2").queue();


       }
        */

    }

}
