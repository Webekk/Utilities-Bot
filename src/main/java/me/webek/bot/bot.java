package me.webek.bot;



import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;

import commands.Ping;
import commands.ServerInfo;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.Command;



public class bot extends ListenerAdapter {




    public static void main(String[]args) throws Exception{
        JDA jda = JDABuilder.createDefault("TOKEN").build();
        
        
        CommandClientBuilder pong = new CommandClientBuilder();
        pong.setOwnerId("Client ID");
        pong.setPrefix("$");
        pong.setHelpWord("helpme");
        pong.addCommand(new Ping());


        CommandClientBuilder builder = new CommandClientBuilder();
        builder.setOwnerId("Client ID");
        builder.setPrefix("$");
        builder.setHelpWord("helpme");
        builder.addCommand(new ServerInfo());
        
        

        CommandClient client = builder.build();
        CommandClient ping = pong.build();


        jda.addEventListener(client);
        jda.addEventListener(ping);



    }
}
