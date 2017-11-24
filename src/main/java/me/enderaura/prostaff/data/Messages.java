package me.enderaura.prostaff.data;

import me.enderaura.prostaff.ProStaff;
import org.bukkit.ChatColor;

/**
 * @author Enderaura
 * @since 23/11/2017 20:27.
 */
public final class Messages {

    private static final ProStaff PLUGIN = ProStaff.getPlugin(ProStaff.class);

    public static final String NO_PERMISSION = getString("messages.no-permission");
    public static final String SENDER_NOT_PLAYER = getString("messages.sender-not-player");
    public static final String OPENED_MENU = getString("messages.opened-menu");
    public static final String TOGGLED_STAFF_MODE = getString("messages.toggled-staff-mode");

    private static String getString(String path){
        return ChatColor.translateAlternateColorCodes('&', PLUGIN.getConfig().getString(path));
    }

}
