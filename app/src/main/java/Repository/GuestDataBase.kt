package Repository

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import constants.DataBaseConstants

class GuestDataBase(context: Context) : SQLiteOpenHelper(context, NAME, null, VERSION) {

    companion object {
        private const val NAME = "guest.db"
        private const val VERSION = 1
    }

    override fun onCreate(dataBase: SQLiteDatabase?) {
        //criaçao do banco
        dataBase?.execSQL(
            "create table " + DataBaseConstants.GUEST.TABLE_NAME + " ("
                    + DataBaseConstants.GUEST.COLUMNS.ID + " integer primary key autoincrement, "
                    + DataBaseConstants.GUEST.COLUMNS.NAME + " text, "
                    + DataBaseConstants.GUEST.COLUMNS.PRESENCE + " integer);"
        )
    }

    override fun onUpgrade(dadaBse: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}