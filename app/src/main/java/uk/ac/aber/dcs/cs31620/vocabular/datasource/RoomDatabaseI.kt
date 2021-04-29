/**
 * Room database interface
 * @author Troy Wenham
 * @version 1
 */
package uk.ac.aber.dcs.cs31620.vocabular.datasource

import uk.ac.aber.dcs.cs31620.vocabular.model.DictionaryDao

interface RoomDatabaseI {
    fun dictionaryDao(): DictionaryDao
    fun closeDb()
}
