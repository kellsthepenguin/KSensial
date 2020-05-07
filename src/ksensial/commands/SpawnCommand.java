package ksensial.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(sender.getName() + ", only players can execute this command!");
        } else {
            Player p = (Player) sender;
            p.teleport(Bukkit.getWorld("world").getSpawnLocation());
            p.sendMessage("스폰으로 이동시켜드렸습니다!");
        }
        return true;
    }
}
