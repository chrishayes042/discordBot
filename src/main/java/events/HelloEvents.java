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




        if(messageSent[0].equalsIgnoreCase("hello")){
            if(!event.getMember().getUser().isBot()){
                event.getChannel().sendMessage("hello " + name).queue();
            }

        }
    }
    public void onGuildMemberJoin(GuildMemberJoinEvent event){
        Random rand = new Random();

        int number = rand.nextInt(joinMessage.length);

        EmbedBuilder join = new EmbedBuilder();
        join.setColor(0x66d8ff);
        join.setDescription(joinMessage[number].replace("[member]", event.getMember().getAsMention()));

        event.getGuild().getDefaultChannel().sendMessage(join.build()).queue();
    }






}
