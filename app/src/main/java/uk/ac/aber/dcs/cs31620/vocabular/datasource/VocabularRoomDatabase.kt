/**
 * Room Database
 * @author Troy Wenham
 * @version 1
 */
package uk.ac.aber.dcs.cs31620.vocabular.datasource

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import uk.ac.aber.dcs.cs31620.vocabular.model.DictionaryItem
import uk.ac.aber.dcs.cs31620.vocabular.model.DictionaryDao
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uk.ac.aber.dcs.cs31620.vocabular.model.Dictionary

@Database(entities = [Dictionary::class, DictionaryItem::class], version = 1)
abstract class VocabularRoomDatabase : RoomDatabase(), RoomDatabaseI {
    abstract override fun dictionaryDao(): DictionaryDao

    override fun closeDb() {
        instance?.close()
        instance = null
    }

    companion object{
        private var instance: VocabularRoomDatabase? = null
        private val coroutineScope = CoroutineScope(Dispatchers.Main)

        fun getDatabase(context: Context): VocabularRoomDatabase?{
            synchronized(this) {
                if(instance == null){
                    instance = Room.databaseBuilder<VocabularRoomDatabase>(
                        context.applicationContext,
                        VocabularRoomDatabase::class.java,
                        "vocabular_database")
                        .allowMainThreadQueries()
                        .addCallback(roomDatabaseCallback(context))
                        .build()
                }
                return instance!!
            }
        }

        private fun roomDatabaseCallback(context: Context): Callback {
            return object : Callback(){
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)

                    coroutineScope.launch(Dispatchers.IO) {
                        populateDatabase(getDatabase(context)!!)
                    }
                }
            }
        }

        private fun populateDatabase(instance: VocabularRoomDatabase) {
            val dictionary = Dictionary(
                dictionaryId = 0,
                langaugeLearning = "",
                nativeLanguage = ""
            )
            val dictionaryItem0 = DictionaryItem(
                id = 0,
                word = "word",
                meaning = "meaning"
            )
            val dao = instance.dictionaryDao()
            dao.insertDictionary(dictionary)
            dao.insertDictionaryItem(dictionaryItem0)
        }
    }
}