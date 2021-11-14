package commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import java.time.temporal.ChronoUnit;

public class Ping extends Command {

    public Ping(){
        this.name = "ping";
        this.help = "sprawdza opoznienie bota";
        this.guildOnly = false;
        this.aliases = new String[]{"Pong"};
    }

    @Override
    protected void execute(CommandEvent e) {
        e.reply("Ping ...", m ->{
        long ping = e.getMessage().getTimeCreated().until(m.getTimeCreated(), ChronoUnit.MILLIS);
        m.editMessage("Pong: " + ping + "ms | Websocket: "+ e.getJDA().getGatewayPing() + "ms").queue();
        });
    }
}
