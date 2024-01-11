package de.harrisblog.simpleentityremover;

import de.harrisblog.simpleentityremover.commands.EntityRemoverCommand;
import de.harrisblog.simpleentityremover.controllers.EntityController;
import de.harrisblog.simpleentityremover.events.SpawnEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class SimpleEntityRemover extends JavaPlugin {

    private static Plugin plugin;

    private static EntityController entityController;

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
        plugin = this;
        entityController = new EntityController();
        getCommand("er").setExecutor(new EntityRemoverCommand());
        Bukkit.getServer().getPluginManager().registerEvents(new SpawnEvent(), this);
        Bukkit.getScheduler().runTaskLater(this, SimpleEntityRemover::removeAllEntities, 20L);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Plugin getPlugin() {
        return plugin;
    }

    public static EntityController getEntityController() {
        return entityController;
    }

    public static void removeAllEntities(){
        for(EntityType entityType : entityController.getEntityList().values()){
            String s = entityType.name().toLowerCase();
            String command = "kill @e[type=" + s + "]";
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), command);

        }
    }
}
