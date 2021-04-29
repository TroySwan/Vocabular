/**
 * Dictionary and Dictionary Item database
 * @author Troy Wenham
 * @version 1
 */
package uk.ac.aber.dcs.cs31620.vocabular.model

import androidx.room.Embedded
import androidx.room.Relation

data class DictionaryAndDictionaryItem(
    @Embedded val user : Dictionary,
    @Relation(
    parentColumn = "dictionaryId",
    entityColumn = "id"
    )
    val dictionary : List<DictionaryItem>
)
