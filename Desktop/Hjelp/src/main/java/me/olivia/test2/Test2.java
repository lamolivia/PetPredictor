package me.olivia.test2;

import org.bukkit.Material;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import static org.bukkit.entity.EntityType.*;

public final class Test2 extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        System.out.println("hi");
        PluginManager manager = getServer().getPluginManager();
        manager.registerEvents(this, this);

    }

    @EventHandler
    public void event(CreatureSpawnEvent event) {
        if (event.getEntityType() == CREEPER) {
            Creeper creeper = (Creeper) event.getEntity();
            creeper.setPowered(true);
        }

        if (event.getEntityType() == ZOMBIE) {
            Zombie zombie = (Zombie) event.getEntity();
            zombie.getEquipment().setHelmet(new ItemStack(Material.DIAMOND_HELMET));
        }
    }


    @Override
    public void onDisable() {
        System.out.println("bye");
    }
}
