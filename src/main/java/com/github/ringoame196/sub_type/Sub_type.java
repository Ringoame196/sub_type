package com.github.ringoame196.sub_type;

import com.github.ringoame196.sub_type.Commands.subtype;
import org.bukkit.plugin.java.JavaPlugin;

public final class Sub_type extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        super.onEnable();
        getCommand("subtype").setExecutor(new subtype());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        super.onDisable();
    }
}
