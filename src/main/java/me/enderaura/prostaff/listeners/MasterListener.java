package me.enderaura.prostaff.listeners;

import me.enderaura.prostaff.ProStaff;
import me.enderaura.prostaff.common.text.Text;
import me.enderaura.prostaff.gui.MainMenu;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

/**
 * @author Enderaura
 * @since 24/11/2017 17:36.
 */
public class MasterListener implements Listener {

    private ProStaff plugin;

    public MasterListener(ProStaff plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onInvClick(InventoryClickEvent event){
        if(event.getInventory() == null) return;
        if(event.getCurrentItem() == null) return;
        if(event.getClickedInventory() == null) return;
        if(!(event.getWhoClicked() instanceof Player)) return;

        Player player = (Player) event.getWhoClicked();
        String name = event.getClickedInventory().getName();

        if(name.equals(Text.UTIL.centerTitle("§c§lStaff Menu"))){
            event.setCancelled(true);
            new MainMenu(plugin).clickEvent(event, player);
            return;
        }
    }

}
