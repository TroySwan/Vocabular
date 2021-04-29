/**
 * Dictionary Dao for making queries to the database
 * @author Troy Wenham
 * @version 1
 */
package uk.ac.aber.dcs.cs31620.vocabular.model
import androidx.lifecycle.LiveData
import androidx.room.*
import uk.ac.aber.dcs.cs31620.vocabular.model.Dictionary
import uk.ac.aber.dcs.cs31620.vocabular.model.DictionaryItem
import uk.ac.aber.dcs.cs31620.vocabular.model.DictionaryAndDictionaryItem


@Dao
interface DictionaryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDictionary(dictionary: Dictionary)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateDictionary(dictionary: Dictionary)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDictionaryItem(dictionaryItem: DictionaryItem)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateDictionaryItem(dictionaryItem: DictionaryItem)

    @Delete
    fun deleteDictionaryItem(dictionaryItem: DictionaryItem)

    @Query("DELETE FROM dictionary_item_table")
    fun deleteAll()

    @Query("SELECT * FROM dictionary_item_table")
    fun getAllDictionaryItems(): LiveData<List<DictionaryItem>>

    @Query("SELECT * FROM dictionary_item_table")
    fun getDictionaryItemsAsList(): List<DictionaryItem>

    @Transaction
    @Query("SELECT * FROM dictionary_table")
    fun getDictionaryWithDictionaryItems(): List<DictionaryAndDictionaryItem>

}