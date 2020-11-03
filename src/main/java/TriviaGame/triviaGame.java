package TriviaGame;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class triviaGame extends ListenerAdapter {

    boolean triviaStart = false;

    public void onMessageReceived(MessageReceivedEvent event){

        Message msg = event.getMessage();
        String name = event.getMember().getUser().getName();
        if(msg.getContentRaw().equalsIgnoreCase("infoPing")){
            event.getChannel().sendMessage(name + " started the trivia game!").queue();
                triviaStart = true;
        }




    }

}