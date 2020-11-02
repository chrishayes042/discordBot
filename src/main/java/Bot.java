import events.HelloEvents;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import trivia.trivia;

import javax.security.auth.login.LoginException;

public class Bot {
    public static String prefix = "~";

    public static void main(String[]args) throws LoginException {
        JDA jda = JDABuilder.createDefault("NzcyNTY3Mjg0NzAyNzczMjY4.X58jWg.a2eCDwuBjNug1Oaw5UOE1i8tD28").build();

        jda.addEventListener(new HelloEvents());
        jda.addEventListener(new trivia());


    }


}
