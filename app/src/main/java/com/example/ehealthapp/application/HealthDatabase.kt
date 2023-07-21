package com.example.ehealthapp.application

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.ehealthapp.dao.HealthDao
import com.example.ehealthapp.model.Health

@Database(entities = [Health::class], version = 2, exportSchema = false)
abstract class HealthDatabase: RoomDatabase(){
    abstract fun healthDao(): HealthDao

    companion object{
        private var INSTANCE: HealthDatabase? = null

        private val migration1To2: Migration = object: Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE health_table ADD COLUMN latitude Double DEFAULT 0.0")
                database.execSQL("ALTER TABLE health_table ADD COLUMN longitude Double DEFAULT 0.0")
            }
        }

        fun getDatabase(context: Context): HealthDatabase {
            return  INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    HealthDatabase::class.java,
                    "health_database"
                )
                    .addMigrations(migration1To2)
                    .allowMainThreadQueries()
                    .build()

                INSTANCE= instance
                instance
            }
        }
    }
}