package ksensial.commands;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(sender.getName() + ", only players can execute this command!");
            return true;
        } else {
            Player p = (Player) sender;

            if (p.hasPermission("ksensial.fly")) {
                if (p.isFlying()) {
                    p.setAllowFlight(false);
                    p.setFlying(false);
                    p.sendMessage("Your fly is disabled.");
                } else {
                    p.setAllowFlight(true);
                    p.setFlying(true);
                    p.sendMessage("Your fly is enabled.");
                }
            }
        }
        return false;
    }
}
