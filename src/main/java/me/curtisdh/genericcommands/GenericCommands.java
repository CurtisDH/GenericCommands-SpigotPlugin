package me.curtisdh.genericcommands;

import org.bukkit.plugin.java.JavaPlugin;

public final class GenericCommands extends JavaPlugin
{

    @Override
    public void onEnable()
    {
        PrintWithClassName(this,"Initialising...");
        onCommandEvent CE = new onCommandEvent();
        this.getCommand("heal").setExecutor(CE);
        this.getCommand("food").setExecutor(CE);
        this.getCommand("top").setExecutor(CE);
        this.getCommand("SetXPLevel").setExecutor(CE);
        PrintWithClassName(this,"Setup Complete");
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
