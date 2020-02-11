package ksensial;

import org.bukkit.plugin.java.JavaPlugin;

import ksensial.commands.*;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("spawn").setExecutor(new SpawnCommand());
        getCommand("vanish").setExecutor(new VanishCommand());
        getCommand("wd").setExecutor(new WorldCommand());
    }
}
