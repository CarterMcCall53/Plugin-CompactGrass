package dev.cmccall.compactgrassplugin;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
public class Events implements Listener {
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
        if (e.getFrom().getBlockX() == e.getTo().getBlockX()) {
            if (e.getFrom().getBlockY() == e.getTo().getBlockY()) {
                if (e.getFrom().getBlockZ() == e.getTo().getBlockZ()) {
                    return;
                }
            }
        }
        if (!e.getPlayer().isOnGround()) {
            return;
        }
        var x = e.getPlayer().getLocation().getX();
        var y = e.getPlayer().getLocation().getY();
        var z = e.getPlayer().getLocation().getZ();
        int X = (int) x;
        int Y = (int) y;
        int Z = (int) z;
        for (int i = Y; i > -65; i--) {
            var loc = e.getPlayer().getLocation();
            if (e.getPlayer().getWorld().getType(X, i, Z) == Material.GRASS) {
                e.getPlayer().getWorld().setType(loc, Material.AIR);
                e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_GRASS_BREAK, 1f, 1);
                break;
            }
        }
    }
}