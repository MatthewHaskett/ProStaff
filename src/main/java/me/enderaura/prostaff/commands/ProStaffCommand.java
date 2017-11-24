package me.enderaura.prostaff.commands;

import me.enderaura.prostaff.ProStaff;
import me.enderaura.prostaff.data.Messages;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * @author Enderaura
 * @since 23/11/2017 20:25.
 */
public class ProStaffCommand implements CommandExecutor {

    private ProStaff plugin;

    public ProStaffCommand(ProStaff plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender.hasPermission("prostaff.staff") || sender.isOp()){

            if(sender instanceof Player){

                Player player = (Player) sender;
                player.sendMessage(Messages.OPENED_MENU);

                plugin.getMainMenu().execute(player);
                return true;

            }else {
                sender.sendMessage(Messages.SENDER_NOT_PLAYER);
                return true;
            }

        }else {
            sender.sendMessage(Messages.NO_PERMISSION);
            return true;
        }

    }
}
