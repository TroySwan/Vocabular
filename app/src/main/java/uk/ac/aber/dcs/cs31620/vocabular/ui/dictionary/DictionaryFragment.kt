/**
 * Fragment for viewing the vocabulary list
 * @author Troy Wenham
 * @version 1
 */
package uk.ac.aber.dcs.cs31620.vocabular.ui.dictionary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import uk.ac.aber.dcs.cs31620.vocabular.databinding.FragmentDictionaryBinding
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import uk.ac.aber.dcs.cs31620.vocabular.R
import uk.ac.aber.dcs.cs31620.vocabular.model.DictionaryItem

class DictionaryFragment : Fragment(), DictionaryRecyclerWithListAdapter.OnDeleteClickListener {
    private var oldDictionaryList: LiveData<List<DictionaryItem>>? = null
    private lateinit var dictionaryRecyclerAdapter: DictionaryRecyclerWithListAdapter
    private lateinit var dictionaryFragmentBinding: FragmentDictionaryBinding
    private val dictionaryViewModel: DictionaryViewModel by viewModels()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        dictionaryFragmentBinding = FragmentDictionaryBinding.inflate(inflater,container,false)

        addDictionaryRecyclerView()

        setupFab()

        return dictionaryFragmentBinding.root
    }

    private fun setupFab() {
        val floatingActionButton = dictionaryFragmentBinding.floatingActionButton

        floatingActionButton.setOnClickListener {
            val navController = findNavController()
            navController.navigate(R.id.navigation_add_dictionary_item)
        }
    }

    private fun addDictionaryRecyclerView() {
        val listDictionaryItems = dictionaryFragmentBinding.DictionaryView
        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        listDictionaryItems.layoutManager = layoutManager

        dictionaryRecyclerAdapter = DictionaryRecyclerWithListAdapter(context, this)
        listDictionaryItems.adapter = dictionaryRecyclerAdapter

        val dictionaryList = populateDictionary()

        if(oldDictionaryList != dictionaryList) {
            oldDictionaryList?.removeObservers(viewLifecycleOwner)
            oldDictionaryList = dictionaryList
        }
        if(!dictionaryList.hasObservers()) {
            dictionaryList.observe(viewLifecycleOwner) { dictionaryItems ->
                dictionaryRecyclerAdapter.changeDataSet(dictionaryItems.toMutableList())
            }
        }
    }

    private fun populateDictionary(): LiveData<List<DictionaryItem>> {
        return dictionaryViewModel.getDictionary()
    }

    override fun onDeleteClick(dictionaryItem: DictionaryItem) {
        dictionaryViewModel.deleteDictionaryItem(dictionaryItem)
    }

}