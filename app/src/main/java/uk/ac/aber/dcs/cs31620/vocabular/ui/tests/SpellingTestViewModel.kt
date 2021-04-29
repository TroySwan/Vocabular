/**
 * View model for the spelling test
 * @author Troy Wenham
 * @version 1
 */
package uk.ac.aber.dcs.cs31620.vocabular.ui.tests

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import uk.ac.aber.dcs.cs31620.vocabular.datasource.VocabularRepository
import uk.ac.aber.dcs.cs31620.vocabular.model.DictionaryItem

class SpellingTestViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: VocabularRepository = VocabularRepository(application)
    var dictionaryItemList: List<DictionaryItem> = repository.getDictionaryItemsAsList()
        private set

    fun getDictionaryItemsForTest(): List<DictionaryItem> {
        dictionaryItemList = repository.getDictionaryItemsAsList()
        return dictionaryItemList
    }

}