package com.jkantrell.mc.underilla.spigot.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerLoadEvent;
import com.jkantrell.mc.underilla.spigot.Underilla;

public class WorldListener implements Listener {
    @EventHandler
    public void onServerEndLoading(ServerLoadEvent event) { Underilla.getInstance().runNextStepsAfterWorldInit(); }
}
