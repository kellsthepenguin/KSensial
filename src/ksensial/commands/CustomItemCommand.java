package ksensial.commands;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.apache.commons.lang.math.NumberUtils;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class CustomItemCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(sender.getName() + ", only players can execute this command!");
            return true;
        } else {
            Player p = (Player) sender;
            if (args.length >= 1) {
                switch (args[0]) {
                    case "enchant": {
                        if (Enchantment.getByName(args[1]) == null) {
                            p.sendMessage("§c올바른 사용법: /customitem <바꿀거(name/description/enchant> <인챈트 레벨>");
                        } else {
                            if (!(p.getInventory().getItemInMainHand() == null)) {
                                if (args.length == 3) {
                                    try {
                                        p.getInventory().getItemInMainHand().addEnchantment(Enchantment.getByName(args[1]), NumberUtils.toInt(args[2]));
                                    } catch (IllegalArgumentException ignored) {
                                        p.sendMessage("§c인챈트 대상이 잘못되었거나 인챈트 최대 레벨을 넘어섰습니다");
                                    } catch (IndexOutOfBoundsException ignored) {
                                        p.sendMessage("§c올바른 사용법: /customitem enchant <인챈트 이름> <인챈트 레벨>");
                                    }
                                }
                            } else {
                                p.sendMessage("§c인챈트할 아이템을 손에 들어야 합니다");
                            }
                        }
                        break;
                    }
                    case "name": {
                        if (!(p.getInventory().getItemInMainHand() == null)) {
                            ItemMeta im = p.getInventory().getItemInMainHand().getItemMeta();
                            if (args.length == 2) {
                                im.setDisplayName(args[1]);
                                p.getInventory().getItemInMainHand().setItemMeta(im);
                            } else {
                                p.sendMessage("§c올바른 사용법: /customitem name <변경할 이름>");
                            }
                        } else {
                            p.sendMessage("§c인챈트할 아이템을 손에 들어야 합니다");
                        }
                        break;
                    }
                    case "description": {
                        if (!(p.getInventory().getItemInMainHand() == null)) {
                            if (args.length == 2) {
                                List<String> loreList = new ArrayList<String>();
                                ItemMeta im = p.getInventory().getItemInMainHand().getItemMeta();
                                loreList.add(args[1]);
                                im.setLore(loreList);
                                p.getInventory().getItemInMainHand().setItemMeta(im);
                            } else {
                                p.sendMessage("§c올바른 사용법: /customitem description <변경할 설명>");
                            }
                        } else {
                            p.sendMessage("§c인챈트할 아이템을 손에 들어야 합니다");
                        }
                        break;
                    }
                    default: {
                        p.sendMessage("§c올바른 사용법: /customitem <바꿀거(name/description/enchant>");
                    }
                }
            } else {
                p.sendMessage("§c올바른 사용법: /customitem <바꿀거(name/description/enchant>");
            }
        }
        return true;
    }
}
