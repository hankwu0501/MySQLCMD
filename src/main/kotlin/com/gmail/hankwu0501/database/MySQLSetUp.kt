package com.gmail.hankwu0501.database

import com.gmail.hankwu0501.MySQLCMD
import me.vagdedes.mysql.database.SQL

object MySQLSetUp {
    fun tablecreate(){
        SQL.createTable("MySQLCMD", "`command` TEXT NOT NULL COLLATE 'utf8_unicode_ci'")
        MySQLCMD.instance.logger.info("資料庫初始化完畢")
    }
}