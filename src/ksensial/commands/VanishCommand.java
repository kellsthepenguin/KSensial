package ksensial.commands;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class VanishCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(sender.getName() + ", only players can execute this command!");
        } else {
            Player p = (Player) sender;
            if (p.hasPermission("ksensial.vanish")) {
                if (p.hasPotionEffect(PotionEffectType.INVISIBILITY)) {
                    p.removePotionEffect(PotionEffectType.INVISIBILITY);
                    p.sendMessage("§e당신의 투명화 상태가 풀렸습니다.");
                } else {
                    p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 999999999, 1));
                    p.sendMessage("§e당신은 이제 유저들에게 보이지 않습니다.");
                }
            }
        }
        return true;
    }
}
