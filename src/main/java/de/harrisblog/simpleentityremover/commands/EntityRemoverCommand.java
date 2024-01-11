package de.harrisblog.simpleentityremover.commands;

import de.harrisblog.simpleentityremover.SimpleEntityRemover;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class EntityRemoverCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(strings.length == 1 && strings[0].equalsIgnoreCase("reload") && commandSender.hasPermission("er.reload")){
            SimpleEntityRemover.getPlugin().reloadConfig();
            SimpleEntityRemover.getEntityController().loadEntities();
            SimpleEntityRemover.removeAllEntities();
            commandSender.sendMessage(ChatColor.GREEN + "SimpleEntityRemover Successfully Reloaded!");
            return true;
        }else if (commandSender.hasPermission("er.er")){
            Set<String> entities = SimpleEntityRemover.getEntityController().getEntityList().keySet();
            commandSender.sendMessage("Entities being removed:");
            for(String str : entities){
                commandSender.sendMessage(str);
            }
            return true;
        }
        return false;
    }

}
