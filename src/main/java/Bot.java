import TriviaGame.triviaGame;
import events.HelloEvents;
import infoPing.infoPing;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.exceptions.RateLimitedException;


import javax.security.auth.login.LoginException;
import java.io.IOException;

public class Bot {


    public static void main(String[]args) throws LoginException, IOException, IllegalArgumentException, RateLimitedException {
        JDA jda = JDABuilder.createDefault("token").build();

        new JDABuilder(AccountType.BOT);




        jda.addEventListener(new HelloEvents());
        jda.addEventListener(new infoPing());
        jda.addEventListener(new triviaGame());




    }


}
