package com.gmail.hankwu0501.listeners

import com.gmail.hankwu0501.MySQLCMD
import me.vagdedes.mysql.database.MySQL
import org.bukkit.Bukkit
import org.bukkit.Bukkit.getServer
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent


class JoinHandle : Listener {
    @EventHandler
    fun onJoinEvent(e: PlayerJoinEvent) {
        val status = MySQL.isConnected()
        val command = "SELECT * FROM `MySQLCMD`"
        Bukkit.getScheduler().runTaskAsynchronously(MySQLCMD.instance, Runnable {
            val result = MySQL.query(command)
            Bukkit.getScheduler().runTask(MySQLCMD.instance, Runnable {
                while (result.next()) {
                    val mysqlcommand = result.getString("command")
                    getServer().dispatchCommand(getServer().consoleSender, mysqlcommand)
                }
            })
        })
    }
}