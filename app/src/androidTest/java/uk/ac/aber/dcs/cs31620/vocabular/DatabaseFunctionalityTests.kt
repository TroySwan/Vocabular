/**
 * Junit tests
 * @author Troy Wenham
 * @version 1
 */
package uk.ac.aber.dcs.cs31620.vocabular

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.InstrumentationRegistry
import org.junit.After
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

import uk.ac.aber.dcs.cs31620.vocabular.datasource.RoomDatabaseI
import uk.ac.aber.dcs.cs31620.vocabular.datasource.VocabularRoomDatabase
import uk.ac.aber.dcs.cs31620.vocabular.model.Dictionary
import uk.ac.aber.dcs.cs31620.vocabular.model.DictionaryDao
import uk.ac.aber.dcs.cs31620.vocabular.util.LiveDataTestUtil
import uk.ac.aber.dcs.cs31620.vocabular.util.TestUtil


class DatabaseFunctionalityTests {

    @JvmField @Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var dictionaryDao: DictionaryDao
    private lateinit var database: RoomDatabaseI
    private val testUtil = TestUtil()

    @Before
    @Throws(Exception::class)
    fun createDatabase(){
        val context = InstrumentationRegistry.getTargetContext()
        database = VocabularRoomDatabase.getDatabase(context)!!
        dictionaryDao = database.dictionaryDao()
    }

    @After
    fun closeDatabase() {
        database.closeDb()
    }

    @Test
    fun onInsertDictionaryItem_checkInsertWasSuccessful() {
        val dictionaryItem = testUtil.createDictionaryItem()
        // To Ensure Db is empty as it is initialised to size 1 on creation.
        dictionaryDao.deleteAll()
        var dictionaryItems = dictionaryDao.getAllDictionaryItems()
        assertEquals(0,LiveDataTestUtil.getValue(dictionaryItems).size)

        dictionaryDao.insertDictionaryItem(dictionaryItem)
        dictionaryItems = dictionaryDao.getAllDictionaryItems()
        assertEquals(1,LiveDataTestUtil.getValue(dictionaryItems).size)
    }

    @Test
    fun onUpdateDictionary_checkUpdateWasSuccessful() {
        val dictionary = testUtil.createDictionary()
        dictionaryDao.updateDictionary(dictionary)
        var newDictionary = dictionaryDao.getDictionaryWithDictionaryItems()
        assertEquals("french",newDictionary[0].user.langaugeLearning)
        assertEquals("english",newDictionary[0].user.nativeLanguage)
        dictionaryDao.updateDictionary(Dictionary(0,"welsh","french"))
        newDictionary = dictionaryDao.getDictionaryWithDictionaryItems()
        assertEquals("welsh",newDictionary[0].user.langaugeLearning)
    }
}