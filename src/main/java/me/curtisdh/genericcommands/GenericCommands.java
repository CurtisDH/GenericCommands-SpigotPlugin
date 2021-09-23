package me.curtisdh.genericcommands;

import org.bukkit.plugin.java.JavaPlugin;

public final class GenericCommands extends JavaPlugin
{

    @Override
    public void onEnable()
    {
        PrintWithClassName(this,"Starting...");
        onCommandEvent CE = new onCommandEvent();
        PrintWithClassName(this,"Setting up command 'heal'");
        this.getCommand("heal").setExecutor(CE);
        PrintWithClassName(this,"Done");
        PrintWithClassName(this,"Setting up command 'food'");
        this.getCommand("food").setExecutor(CE);
        PrintWithClassName(this,"Done");
        PrintWithClassName(this,"Setting up command 'top'");
        this.getCommand("top").setExecutor(CE);
        PrintWithClassName(this,"Done");
        PrintWithClassName(this,"Setting up command 'SetXPLevel'");
        this.getCommand("SetXPLevel").setExecutor(CE);
        PrintWithClassName(this,"Done");
        PrintWithClassName(this,"Finished Initialising");
    }

    @Override
    public void onDisable()
    {

    }
    public static void PrintWithClassName(Object classObject, String str)
    {
        String response = classObject.getClass().getName()+"::"+str;
        System.out.println(response);
    }
}
