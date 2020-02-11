package ksensial.commands;

import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.WorldCreator;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.WorldType;
import org.bukkit.entity.Player;

public class WorldCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender.hasPermission("penguinPlugin.wd")) {
            if (args.length < 1) {
                sender.sendMessage("§c올바른 사용법: /wd create <월드 이름> <World type(normal, FLAT, LARGEBIOMES, AMPLIFIED>, /wd warp <월드 이름>, /wd diffculty <월드> <난이도(0 = PEACEFUL, 1 = EASY, 2 = NORMAL, 3 = HARD)>");
            } else {
                switch (args[0]) {
                    case "create": {
                        if (args.length == 3) {
                            WorldCreator wdc = new WorldCreator(args[1]);
                            switch (args[2].toLowerCase()) {
                                case "normal":
                                    wdc.type(WorldType.NORMAL);
                                    wdc.createWorld();
                                    break;
                                case "flat":
                                    wdc.type(WorldType.FLAT);
                                    wdc.createWorld();
                                    break;
                                case "large_biomes":
                                    wdc.type(WorldType.LARGE_BIOMES);
                                    wdc.createWorld();
                                    break;
                                case "amplified":
                                    wdc.type(WorldType.AMPLIFIED);
                                    wdc.createWorld();
                                    break;
                                default:
                                    sender.sendMessage("§c올바른 사용법: /wd create <월드 이름> <월드 타입(NORMAL, FLAT, largebiomes, amplified>");
                                    break;
                            }
                        } else {
                            sender.sendMessage("§c올바른 사용법: /wd create <월드 이름> <월드 타입(normal, flat, largebiomes, amplified>");
                        }
                        break;
                    }
                    case "warp": {
                        if (args.length == 2) {
                            if (!(sender instanceof Player)) {
                                sender.sendMessage(sender.getName() + ", only player can execute this command");
                            } else {
                                Player p = (Player) sender;

                                if (!(Bukkit.getWorld(args[1]) == null)) {
                                    p.teleport(Bukkit.getWorld(args[1]).getSpawnLocation());
                                    p.sendMessage("§cSuccessfully Teleported!");
                                } else {
                                    p.sendMessage("§c올바른 월드가 아닙니다");
                                }
                            }
                            break;
                        }
                    }
                    case "difficulty": {
                        if (args.length == 3) {
                            if (!(Bukkit.getWorld(args[1]) == null)) {
                                switch (args[2]) {
                                    case "0":
                                        Bukkit.getWorld("" + args[1]).setDifficulty(Difficulty.PEACEFUL);
                                        sender.sendMessage("§e성공적으로 난이도를 바꿨습니다.");
                                        break;
                                    case "1":
                                        Bukkit.getWorld("" + args[1]).setDifficulty(Difficulty.EASY);
                                        sender.sendMessage("§e성공적으로 난이도를 바꿨습니다.");
                                        break;
                                    case "2":
                                        Bukkit.getWorld("" + args[1]).setDifficulty(Difficulty.NORMAL);
                                        sender.sendMessage("§e성공적으로 난이도를 바꿨습니다.");
                                        break;
                                    case "3":
                                        Bukkit.getWorld("" + args[1]).setDifficulty(Difficulty.HARD);
                                        sender.sendMessage("§e성공적으로 난이도를 바꿨습니다.");
                                        break;
                                    default:
                                        sender.sendMessage("§c올바른 사용법: /wd diffculty <월드> <난이도(0 = PEACEFUL, 1 = EASY, 2 = NORMAL, 3 = HARD)>");
                                        break;
                                }
                            } else {
                                sender.sendMessage("§c올바른 월드가 아닙니다");
                            }
                        } else {
                            sender.sendMessage("§c올바른 월드가 아닙니다");
                        }
                    }
                }
            }
        }
        return true;
    }
}

