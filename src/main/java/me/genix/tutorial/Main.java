package me.genix.tutorial;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;

/**
 * @author github.com/genixzero
 * @created 04/01/2021 - 9:59 AM
 */
public class Main extends ListenerAdapter {

    public static final String prefix = ".";

    public static void main(String[] args) throws LoginException {
        JDABuilder.createDefault("").addEventListeners(new Main()).setActivity(Activity.playing("Tutorial Bot | .ping")).build();
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String message = event.getMessage().getContentRaw().toLowerCase();
        if (message.startsWith(prefix)) {
            message = message.substring(1);
            switch (message) {
                case "ping":
                    event.getChannel().sendMessage("Pong!").queue();
                    break;
            }
        }
    }
}
