/**
 * View model for adding dictionary items
 * @author Troy Wenham
 * @version 1
 */
package uk.ac.aber.dcs.cs31620.vocabular.ui.add_dictionary_item

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import uk.ac.aber.dcs.cs31620.vocabular.datasource.VocabularRepository
import uk.ac.aber.dcs.cs31620.vocabular.model.DictionaryItem

class AddDictionaryItemViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: VocabularRepository = VocabularRepository(application)

    fun insertDictionaryItem(dictionaryItem: DictionaryItem) {
        repository.insert(dictionaryItem)
    }
}