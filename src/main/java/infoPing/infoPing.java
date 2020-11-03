package infoPing;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class infoPing {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {

        String channelSent = event.getMessage().getContentRaw();
        String[] info = event.getMessage().getContentRaw().split(" ");
        String name = event.getMember().getUser().getName();
        String answer = event.getMember().getUser().getName();


        if (info[0].equalsIgnoreCase("info")) {
            event.getChannel().sendMessage("@" + name).queue();
            event.getChannel().sendMessage("Bot info").queue();
            event.getChannel().sendMessage("#############################################").queue();
            event.getChannel().sendMessage("This is a trivia bot").queue();
            event.getChannel().sendMessage("Say 'trivia' to start the game.").queue();
            event.getChannel().sendMessage("Say 'stop' to stop the game.").queue();
            event.getChannel().sendMessage("#############################################").queue();

        }


    }
    public void onMessageReceived(MessageReceivedEvent event){

        Message msg = event.getMessage();
        if (msg.getContentRaw().equals("!ping")){
            MessageChannel channel = event.getChannel();
            long time = System.currentTimeMillis();
            channel.sendMessage("Pong!")
                    .queue(response ->{
                        response.editMessageFormat("Pong: %d ms", System.currentTimeMillis() - time).queue();
                    });
        }
    }
}
