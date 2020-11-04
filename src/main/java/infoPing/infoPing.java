package infoPing;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class infoPing extends ListenerAdapter{




    public void onMessageReceived(MessageReceivedEvent event) {


        String member = event.getMember().getAsMention();
        String channelSent = event.getMessage().getContentRaw();
        String[] info = event.getMessage().getContentRaw().split(" ");
        String name = event.getMember().getUser().getName();
        String answer = event.getMember().getUser().getName();

// TODO make a better list for info
        if (info[0].equalsIgnoreCase("!botinfo")) {

            event.getChannel().sendMessage("Bot info").queue();
            event.getChannel().sendMessage("-----------------------").queue();
            event.getChannel().sendMessage("This is a bot. Don't fuck around with me").queue();
            event.getChannel().sendMessage("Say 'trivia start' to start the game.").queue();
            event.getChannel().sendMessage("Say 'trivia stop' to stop the game.").queue();
            event.getChannel().sendMessage("-----------------------").queue();

        }

        // works fine
        Message msg = event.getMessage();
        if (msg.getContentRaw().equals("!ping")){
            MessageChannel channel = event.getChannel();
            long time = System.currentTimeMillis();
            channel.sendMessage("Pong!")
                    .queue(response ->{
                        response.editMessageFormat(member + " Pong: %d ms",
                                System.currentTimeMillis() - time).queue();
                    });
        }


    }



}
