package commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;
import java.util.Arrays;


public class ServerInfo extends Command {

    public ServerInfo(){
        this.name = "serverinfo";
        this.aliases = new String[]{"server"};
        this.help = "Gives information about the server";
    }

    @Override
    protected void execute(CommandEvent e) {

        String[] members = new String[e.getGuild().getMembers().size()];
        for (int i = 0;i<e.getGuild().getMembers().size();i++){
            members[i] = e.getGuild().getMembers().get(i).getEffectiveName();
        }

        EmbedBuilder eb = new EmbedBuilder();
        eb.setColor(Color.orange);
        eb.setAuthor(getName());
        eb.setThumbnail("https://i.pinimg.com/originals/b1/59/dc/b159dcb12e263619114705765d623ec1.png");
        eb.addField("Server Owner: ",e.getGuild().getOwner().getEffectiveName(),true);
        eb.addField("Member Count:",Integer.toString(e.getGuild().getMembers().size()),true);
        eb.setDescription("**Members:** \n" + Arrays.toString(members) + "\n **Invite Link:**" + "https://przyklad.com");


        e.getChannel().sendMessage(eb.build()).queue();


    }
}
