package me.enderaura.prostaff;

import me.enderaura.prostaff.commands.ProStaffCommand;
import me.enderaura.prostaff.gui.MainMenu;
import me.enderaura.prostaff.listeners.MasterListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class ProStaff extends JavaPlugin {

    private MainMenu mainMenu = new MainMenu(this);

    @Override
    public void onEnable() {
        registerEvents();
        registerCommands();

        getConfig().options().copyDefaults(true);
        saveConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void registerEvents(){
        getServer().getPluginManager().registerEvents(new MasterListener(this), this);
    }

    private void registerCommands(){
        getCommand("prostaff").setExecutor(new ProStaffCommand(this));
        //getCommand("staff").setExecutor(new StaffCommand());
    }

    public MainMenu getMainMenu() {
        return mainMenu;
    }
}
