package me.enderaura.prostaff.gui;

import me.enderaura.prostaff.ProStaff;
import me.enderaura.prostaff.common.text.Text;
import me.enderaura.prostaff.data.Messages;
import me.enderaura.prostaff.data.StaffModeData;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import me.enderaura.prostaff.common.items.ItemStackBuilder;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * @author Enderaura
 * @since 23/11/2017 20:00.
 */
public class MainMenu {

    private ProStaff plugin;
    private Inventory inventory = Bukkit.createInventory(null, 54, Text.UTIL.centerTitle("§c§lStaff Menu"));
    private ItemStack filler =  new ItemStackBuilder(Material.STAINED_GLASS_PANE)
            .withData(7)
            .withName(" ")
            .buildStack();
    public MainMenu(ProStaff plugin){
        this.plugin = plugin;
    }

    public void execute(Player player){

        ItemStack toggleButton;

        if(StaffModeData.isInStaffMode(player)){
            toggleButton = new ItemStackBuilder(Material.ENDER_PEARL)
                    .withName("&a&lToggle Staff Mode")
                    .withLore("", "&eDisables staff mode!")
                    .addEnchantment(Enchantment.DAMAGE_ALL, 2)
                    .withItemFlags(ItemFlag.HIDE_ENCHANTS)
                    .buildStack();
        }else{
            toggleButton = new ItemStackBuilder(Material.ENDER_PEARL)
                    .withName("&a&lToggle Staff Mode")
                    .withLore("", "&eEnables staff mode!")
                    .buildStack();
        }

        inventory.setItem(8, toggleButton);
        inventory.setItem(0, filler);
        inventory.setItem(1, filler);
        inventory.setItem(2, filler);
        inventory.setItem(3, filler);
        inventory.setItem(4, filler);
        inventory.setItem(5, filler);
        inventory.setItem(6, filler);
        inventory.setItem(7, filler);
        inventory.setItem(9, filler);
        inventory.setItem(17, filler);
        inventory.setItem(18, filler);
        inventory.setItem(26, filler);
        inventory.setItem(27, filler);
        inventory.setItem(35, filler);
        inventory.setItem(36, filler);
        inventory.setItem(44, filler);
        inventory.setItem(45, filler);
        inventory.setItem(46, filler);
        inventory.setItem(47, filler);
        inventory.setItem(48, filler);
        inventory.setItem(49, filler);
        inventory.setItem(50, filler);
        inventory.setItem(51, filler);
        inventory.setItem(52, filler);
        inventory.setItem(53, filler);



        player.openInventory(inventory);
    }

    public void clickEvent(InventoryClickEvent event, Player player){

        if(ChatColor.stripColor(event.getCurrentItem().getItemMeta().getDisplayName()).equals("Toggle Staff Mode")){
            StaffModeData.toggleStaffMode(player);
            player.sendMessage(Messages.TOGGLED_STAFF_MODE);
            ItemStack toggleButton;
            ItemStack removeToggle;

            if(StaffModeData.isInStaffMode(player)){
                toggleButton = new ItemStackBuilder(Material.ENDER_PEARL)
                        .withName("&a&lToggle Staff Mode")
                        .withLore("", "&eDisables staff mode!")
                        .addEnchantment(Enchantment.DAMAGE_ALL, 2)
                        .withItemFlags(ItemFlag.HIDE_ENCHANTS)
                        .buildStack();

                removeToggle = new ItemStackBuilder(Material.ENDER_PEARL)
                        .withName("&a&lToggle Staff Mode")
                        .withLore("", "&eEnables staff mode!")
                        .buildStack();
            }else{
                toggleButton = new ItemStackBuilder(Material.ENDER_PEARL)
                        .withName("&a&lToggle Staff Mode")
                        .withLore("", "&eEnables staff mode!")
                        .buildStack();

                removeToggle = new ItemStackBuilder(Material.ENDER_PEARL)
                        .withName("&a&lToggle Staff Mode")
                        .withLore("", "&eDisables staff mode!")
                        .addEnchantment(Enchantment.DAMAGE_ALL, 2)
                        .withItemFlags(ItemFlag.HIDE_ENCHANTS)
                        .buildStack();
            }

            inventory.remove(removeToggle);
            inventory.setItem(8, toggleButton);
            player.updateInventory();
        }
    }

}
