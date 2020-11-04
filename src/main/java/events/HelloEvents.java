package events;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Objects;
import java.util.Random;

public class HelloEvents extends ListenerAdapter {

// works fine

    String[] joinMessage = {
            "Look into my eyes [member], you will see...",
            "Bitch boy [member] has joined",
            "We've been expecting you [member]",
            "YOOOO WTF [member] has just joined",
            "[member] fucking sucks"
    };



    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        String[] messageSent = event.getMessage().getContentRaw().split(" ");
        String name = event.getMember().getUser().getName();
        String member = event.getMember().getAsMention();


        // if message is hello on the first word
        if(messageSent[0].equalsIgnoreCase("hello")){
            if(!event.getMember().getUser().isBot()){// as long as the message is not a bot
                event.getChannel().sendMessage("hello " + member).queue(); // send message out
            }

        }
    }
    public void onGuildMemberJoin(GuildMemberJoinEvent event){
        Random rand = new Random();  // random number gen

        int number = rand.nextInt(joinMessage.length); // added var to random
                                // takes the length of the array

        EmbedBuilder join = new EmbedBuilder(); // embedded
        join.setColor(0x66d8ff);
        //                  random message from array  | replaces member from string    | mention person @user
        join.setDescription(joinMessage[number].replace("[member]", event.getMember().getAsMention()));

        // Built
        event.getGuild().getDefaultChannel().sendMessage(join.build()).queue();
    }






}
