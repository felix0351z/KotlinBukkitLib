package de.felix0351.kotlinbukkitlib

import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.plugin.java.JavaPlugin

class KotlinBukkitLib : JavaPlugin(), CommandExecutor {

    override fun onEnable() {
        getCommand("kotlinbukkitlib")?.setExecutor(this)
        server.consoleSender.sendMessage(ChatColor.LIGHT_PURPLE.toString() + "Keep Calm and Love Kotlin!")
        super.onEnable()
    }


    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>?): Boolean {
        sender.sendMessage("§dKeep Calm and Love Kotlin!")
        return true
    }


}