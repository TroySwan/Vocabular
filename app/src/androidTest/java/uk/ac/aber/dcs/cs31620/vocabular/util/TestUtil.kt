/**
 * Test utility functions for JUnit tests
 * @author Troy Wenham
 * @version 1
 */
package uk.ac.aber.dcs.cs31620.vocabular.util
import uk.ac.aber.dcs.cs31620.vocabular.model.Dictionary
import uk.ac.aber.dcs.cs31620.vocabular.model.DictionaryItem;
class TestUtil {
        fun createDictionaryItem():DictionaryItem{
            var dictionaryItem = DictionaryItem(0,"oui","yes")
            return dictionaryItem
        }

        fun createDictionary():Dictionary {
            var dictionary = Dictionary(0,"french","english")
            return dictionary
        }
}