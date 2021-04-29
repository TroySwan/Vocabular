/**
 * dictionary Item entity class
 * @author Troy Wenham
 * @version 1
 */
package uk.ac.aber.dcs.cs31620.vocabular.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "dictionary_item_table")
data class DictionaryItem(

    @PrimaryKey(autoGenerate = true)
    @NonNull
    var id: Int = 0,
    var word: String = "",
    var meaning: String = "")