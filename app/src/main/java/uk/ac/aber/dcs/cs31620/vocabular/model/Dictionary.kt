/**
 * Dictionary entity for database
 * @author Troy Wenham
 * @version 1
 */
package uk.ac.aber.dcs.cs31620.vocabular.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dictionary_table")
data class Dictionary(
    @PrimaryKey
    @NonNull
    var dictionaryId: Int = 0,
    var langaugeLearning: String = "",
    var nativeLanguage: String = "",)