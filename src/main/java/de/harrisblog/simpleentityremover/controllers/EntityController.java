package de.harrisblog.simpleentityremover.controllers;

import de.harrisblog.simpleentityremover.SimpleEntityRemover;
import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;

import java.util.HashMap;

public class EntityController {
    HashMap<String, EntityType> entityList;

    public EntityController(){
        entityList = new HashMap<>();
        loadEntities();
    }

    public void loadEntities(){
        for(String entityString : SimpleEntityRemover.getPlugin().getConfig().getStringList(".entities")){
            EntityType entityType = EntityType.fromName(entityString);
            entityList.put(entityString, entityType);
        }
    }

    public EntityType getEntityTypeFromEntityString(String s){
        return entityList.get(s);
    }

    public HashMap<String, EntityType> getEntityList(){
        return entityList;
    }


}
