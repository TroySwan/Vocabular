/**
 * Fragment for adding dictionary items
 * @author Troy Wenham
 * @version 1
 */
package uk.ac.aber.dcs.cs31620.vocabular.ui.add_dictionary_item

import android.app.ActionBar
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import uk.ac.aber.dcs.cs31620.vocabular.R
import uk.ac.aber.dcs.cs31620.vocabular.databinding.FragmentAddDictionaryItemBinding
import uk.ac.aber.dcs.cs31620.vocabular.model.DictionaryItem

class AddDictionaryItemFragment : Fragment() {

    private lateinit var addDictionaryItemFragmentBinding: FragmentAddDictionaryItemBinding
    private val addDictionaryItemViewModel: AddDictionaryItemViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        handleBackButton()

        addDictionaryItemFragmentBinding = FragmentAddDictionaryItemBinding.inflate(
            inflater,
            container,
            false
        )

        addDictionaryItemFragmentBinding.AddDictionaryItem.setOnClickListener {
            insertDictionaryItem()
        }

        return addDictionaryItemFragmentBinding.root
    }


    private fun handleBackButton() {
        val callback: OnBackPressedCallback =
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    findNavController().navigateUp()
                }
            }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)

    }

    private fun insertDictionaryItem() {
        val word = addDictionaryItemFragmentBinding.WordInLearningLanguageField.text.toString()
        val meaning = addDictionaryItemFragmentBinding.MeaningNativeLanguageField.text.toString()
        if (word.isNotBlank() && meaning.isNotBlank()) {
            val dictionaryItem = DictionaryItem(
                0,
                word,
                meaning,
            )
            addDictionaryItemViewModel.insertDictionaryItem(dictionaryItem)

            findNavController().navigateUp()
        } else {
            Toast.makeText(
                requireContext(),
                (R.string.toast_fields_must_be_filled),
                Toast.LENGTH_SHORT
            ).show()
        }
    }



}