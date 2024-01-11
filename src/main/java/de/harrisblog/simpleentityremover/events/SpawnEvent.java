package de.harrisblog.simpleentityremover.events;

import de.harrisblog.simpleentityremover.SimpleEntityRemover;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class SpawnEvent implements Listener {
    @EventHandler
    public void onSpawn(EntitySpawnEvent e){
        EntityType entityType = e.getEntityType();
        if(SimpleEntityRemover.getEntityController().getEntityList().containsValue(entityType)) {
            e.setCancelled(true);
        }
    }
}
