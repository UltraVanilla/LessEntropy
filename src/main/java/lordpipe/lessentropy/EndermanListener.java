package lordpipe.lessentropy;

import java.util.Random;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

public class EndermanListener implements Listener {
    private LessEntropy plugin;

    private static Random rng = new Random();
    private double chance = 0.0;

    public EndermanListener(LessEntropy pl) {
        plugin = pl;
        chance = pl.getConfig().getDouble("enderman-block-pickup-chance");
    }

    @EventHandler(ignoreCancelled = true)
    public void onEntityChangeBlock(EntityChangeBlockEvent event) {
        Entity entity = event.getEntity();

        if (entity != null && entity.getType() == EntityType.ENDERMAN) {
            if (rng.nextDouble() >= chance) {
                event.setCancelled(true);
            }
        }
    }
}
