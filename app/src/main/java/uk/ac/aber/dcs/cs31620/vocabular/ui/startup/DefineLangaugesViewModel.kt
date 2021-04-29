/**
 * View model for defining the dictionary languages
 * @author Troy Wenham
 * @version 1
 */
package uk.ac.aber.dcs.cs31620.vocabular.ui.startup

import android.app.Application
import android.content.SharedPreferences
import androidx.lifecycle.AndroidViewModel
import uk.ac.aber.dcs.cs31620.vocabular.MainActivity
import uk.ac.aber.dcs.cs31620.vocabular.datasource.VocabularRepository
import uk.ac.aber.dcs.cs31620.vocabular.model.Dictionary
import uk.ac.aber.dcs.cs31620.vocabular.model.DictionaryItem

class DefineLangaugesViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: VocabularRepository = VocabularRepository(application)

    fun insertDictionary(dictionary: Dictionary) {
        repository.deleteAll()
        repository.insert(dictionary)
    }
}