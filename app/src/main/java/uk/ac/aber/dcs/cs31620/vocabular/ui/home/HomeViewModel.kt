/**
 * Viewmodel to fetch database data for homepage
 * @author Troy Wenham
 * @version 1
 */
package uk.ac.aber.dcs.cs31620.vocabular.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import uk.ac.aber.dcs.cs31620.vocabular.datasource.VocabularRepository
import uk.ac.aber.dcs.cs31620.vocabular.model.DictionaryAndDictionaryItem
import uk.ac.aber.dcs.cs31620.vocabular.model.DictionaryItem

class HomeViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: VocabularRepository = VocabularRepository(application)
    var dictionary: List<DictionaryAndDictionaryItem> = repository.getDictionaryWithDictionaryItems()
        private set

    private var dictionaryItems: List<DictionaryItem> = repository.getDictionaryItemsAsList()

    fun getDictionaryData(): List<DictionaryAndDictionaryItem> {
        dictionary = repository.getDictionaryWithDictionaryItems()
        return dictionary
    }

    fun getDictionaryItems(): List<DictionaryItem> {
        dictionaryItems = repository.getDictionaryItemsAsList()
        return dictionaryItems
    }
}