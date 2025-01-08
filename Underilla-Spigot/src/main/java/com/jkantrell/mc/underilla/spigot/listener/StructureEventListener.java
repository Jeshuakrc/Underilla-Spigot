package com.jkantrell.mc.underilla.spigot.listener;

import java.util.HashMap;
import java.util.Map;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.AsyncStructureSpawnEvent;
import com.jkantrell.mc.underilla.spigot.Underilla;
import com.jkantrell.mc.underilla.spigot.io.UnderillaConfig.SetStructureKeys;

public class StructureEventListener implements Listener {
    private final Map<String, Integer> structureCount;

    public StructureEventListener() { structureCount = new HashMap<>(); }

    public Map<String, Integer> getStructureCount() { return structureCount; }

    @EventHandler(ignoreCancelled = true)
    public void onStructureSpawn(AsyncStructureSpawnEvent e) {
        // If in the list of structure to keep then log & count else cancel the event.
        if (Underilla.getUnderillaConfig().isStructureInSet(SetStructureKeys.SURUCTURE_ONLY, e.getStructure())) {
            Underilla.debug(() -> e.getStructure().key().asString() + " spawned at " + e.getChunkX() + " " + e.getChunkZ() + " in biome "
                    + e.getWorld().getBiome(e.getChunkX() * 16, 0, e.getChunkZ() * 16));
            String structureName = e.getStructure().key().asString();
            structureCount.put(structureName, structureCount.getOrDefault(structureName, 0) + 1);
        } else {
            e.setCancelled(true);
        }
    }

}
