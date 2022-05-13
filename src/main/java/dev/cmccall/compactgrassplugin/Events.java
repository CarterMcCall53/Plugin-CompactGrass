package dev.cmccall.compactgrassplugin;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
public class Events implements Listener {
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
        var world = e.getPlayer().getWorld();
        var x = e.getPlayer().getLocation().getX();
        var y = e.getPlayer().getLocation().getY();
        var z = e.getPlayer().getLocation().getZ();
        int X = (int) x;
        int Y = (int) y;
        int Z = (int) z;
        for (int i = Y; i > -65; i--) {
            if (world.getType(X, i, Z) == Material.GRASS) {
                var loc = e.getPlayer().getLocation();
                e.getPlayer().getWorld().setType(loc, Material.AIR);
                e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_GRASS_BREAK, 5f, 1);
                break;
            }
        }
    }
}