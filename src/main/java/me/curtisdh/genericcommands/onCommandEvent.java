package me.curtisdh.genericcommands;

import com.sun.tools.javac.jvm.Gen;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.attribute.Attribute;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class onCommandEvent implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if (!(sender instanceof Player))
        {
            sender.sendMessage("Only players can use that command");
            return true;
        }
        if(!sender.isOp())
        {
            sender.sendMessage("You do not have the required permissions for this command.");
            return true;
        }
        Player player = (Player) sender;
        switch (command.getName())
        {
            case "heal":
                player.setHealth(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getDefaultValue());
                break;
            case "food":
                player.setFoodLevel(20); // Not sure how to grab max food level
                break;
            case "top":
                Block block = player.getWorld().getHighestBlockAt(player.getLocation());
                Location idealLocation = block.getLocation();
                idealLocation.add(0, 1, 0); // Otherwise we spawn inside the block.
                if (block != null)
                {
                    player.teleport(idealLocation);
                }
                break;
            case "SetXPLevel":
                //TODO allow for player specification

                if (args.length > 0)
                {
                    try
                    {
                        Player targetPlayer = Bukkit.getPlayer(args[0]);
                        Integer test;
                        if(targetPlayer == null)
                        {
                            targetPlayer = (Player)sender;
                            test = Integer.parseInt(args[0]);
                        }
                        else
                        {
                            test = Integer.parseInt(args[1]);
                        }
                        targetPlayer.setLevel(test);
                        break;
                    } catch (Exception e)
                    {
                        GenericCommands.PrintWithClassName(this,"Error with :SetXPLevel:"+e.getMessage());
                        sender.sendMessage("Incorrect usage:'" + args[0] + "'");
                        sender.sendMessage("Is the player name correct?");
                    }
                }
                break;


            default:
                throw new IllegalStateException("Unexpected value: " + command.getName());
        }
        return true;
    }
}
