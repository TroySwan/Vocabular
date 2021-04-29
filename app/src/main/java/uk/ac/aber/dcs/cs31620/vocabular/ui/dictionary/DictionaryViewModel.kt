/**
 * View model for viewing the vocabulary list
 * @author Troy Wenham
 * @version 1
 */
package uk.ac.aber.dcs.cs31620.vocabular.ui.dictionary

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import uk.ac.aber.dcs.cs31620.vocabular.datasource.VocabularRepository
import uk.ac.aber.dcs.cs31620.vocabular.model.DictionaryItem

class DictionaryViewModel(application: Application) : AndroidViewModel(application){
private val repository: VocabularRepository = VocabularRepository(application)
    var dictionaryItemList: LiveData<List<DictionaryItem>> = repository.getAllDictionaryItems()
        private set

    fun getDictionary(): LiveData<List<DictionaryItem>> {
        dictionaryItemList = repository.getAllDictionaryItems()
        return dictionaryItemList
    }

    fun deleteDictionaryItem(dictionaryItem: DictionaryItem){
        repository.delete(dictionaryItem)
    }

    override fun onCleared() {
        super.onCleared()
    }
}