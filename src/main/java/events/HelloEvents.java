package events;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class HelloEvents extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        String[] messageSent = event.getMessage().getContentRaw().split(" ");
        String name = event.getMember().getUser().getName();




        if(messageSent[0].equalsIgnoreCase("hello")){
            if(!event.getMember().getUser().isBot()){
                event.getChannel().sendMessage("hello " + name).queue();
            }

        }
    }



}
