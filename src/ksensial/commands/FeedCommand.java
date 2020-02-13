package ksensial.commands;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FeedCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] strings) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(sender.getName() + ", only players can execute this command!");
        } else {
            Player p = (Player) sender;
            if (p.hasPermission("ksensial.feed")) {
                p.setFoodLevel(20);
                p.sendMessage("§e성공적으로 배고픔을 채웠습니다");
            }
        }
        return true;
    }
}
