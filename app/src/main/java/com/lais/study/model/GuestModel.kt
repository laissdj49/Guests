package com.lais.study.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * o entity tem a capacidade de perceber que o GuestModel vai ser
 * persistido no banco de dados e vai conseguir criar, temos com ele
 * as colunas e os tipos das entidades.
 */
@Entity(tableName = "Guest")
class GuestModel{

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0

    @ColumnInfo(name = "name")
    var name: String = ""

    @ColumnInfo(name = "presence")
    var presence: Boolean = false

}
