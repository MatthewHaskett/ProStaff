package me.enderaura.prostaff.data;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Enderaura
 * @since 24/11/2017 17:18.
 */
public final class StaffModeData {

    private static List<Player> inStaffMode = new ArrayList<>();

    public static boolean isInStaffMode(Player player){
        System.out.println(inStaffMode.contains(player) ? player.getName() + " is in staff mode!" : player.getName() + " is not in staff mode!");
        return inStaffMode.contains(player);
    }

    public static void removeFromStaffMode(Player player){
        inStaffMode.remove(player);
    }

    public static void addToStaffMode(Player player){
        inStaffMode.add(player);
    }

    public static void toggleStaffMode(Player player){
        if(isInStaffMode(player)) removeFromStaffMode(player); else addToStaffMode(player);
    }

}