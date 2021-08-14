package com.gmail.hankwu0501

import com.gmail.hankwu0501.database.MySQLSetUp.tablecreate
import com.gmail.hankwu0501.listeners.JoinHandle
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin


class MySQLCMD :JavaPlugin(){
    companion object{
        lateinit var instance:MySQLCMD
    }
    init{
        instance = this
    }

    override fun onEnable(){
        tablecreate()
        Bukkit.getPluginManager().registerEvents(JoinHandle(), this)
    }

}