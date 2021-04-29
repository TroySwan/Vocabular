/**
 * Database repository
 * @author Troy Wenham
 * @version 1
 */
package uk.ac.aber.dcs.cs31620.vocabular.datasource

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uk.ac.aber.dcs.cs31620.vocabular.model.Dictionary
import uk.ac.aber.dcs.cs31620.vocabular.model.DictionaryItem

class VocabularRepository(application: Application) {
    private val dictionaryDao = VocabularRoomDatabase.getDatabase(application)!!.dictionaryDao()
    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    fun insert(dictionary: Dictionary){
        coroutineScope.launch(Dispatchers.IO) {
            dictionaryDao.insertDictionary(dictionary)
        }
    }
    fun insert(dictionaryItem: DictionaryItem){
        coroutineScope.launch(Dispatchers.IO) {
            dictionaryDao.insertDictionaryItem(dictionaryItem)
        }
    }

    fun deleteAll(){
        coroutineScope.launch(Dispatchers.IO) {
            dictionaryDao.deleteAll()
        }
    }
    fun delete(dictionaryItem: DictionaryItem){
        coroutineScope.launch(Dispatchers.IO) {
            dictionaryDao.deleteDictionaryItem(dictionaryItem)
        }
    }

    fun getAllDictionaryItems() = dictionaryDao.getAllDictionaryItems()

    fun getDictionaryWithDictionaryItems() = dictionaryDao.getDictionaryWithDictionaryItems()

    fun getDictionaryItemsAsList() = dictionaryDao.getDictionaryItemsAsList()

}