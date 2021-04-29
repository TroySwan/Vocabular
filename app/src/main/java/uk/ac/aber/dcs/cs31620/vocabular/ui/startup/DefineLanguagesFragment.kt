/**
 * Fragment for defining dictionary languages
 * @author Troy Wenham
 * @version 1
 */
package uk.ac.aber.dcs.cs31620.vocabular.ui.startup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import uk.ac.aber.dcs.cs31620.vocabular.MainActivity
import uk.ac.aber.dcs.cs31620.vocabular.R
import uk.ac.aber.dcs.cs31620.vocabular.databinding.FragmentDefineLanguagesBinding
import uk.ac.aber.dcs.cs31620.vocabular.datasource.VocabularRepository
import uk.ac.aber.dcs.cs31620.vocabular.model.Dictionary


class DefineLanguagesFragment : DialogFragment() {
    private lateinit var defineLanguagesFragmentBinding: FragmentDefineLanguagesBinding
    private val defineLangaugesViewModel: DefineLangaugesViewModel by viewModels()

    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val repository = VocabularRepository(requireActivity().application)
        val data = repository.getDictionaryWithDictionaryItems()

        defineLanguagesFragmentBinding = FragmentDefineLanguagesBinding.inflate(
            inflater,
            container,
            false
        )

        (activity as MainActivity?)?.hideActionBarAndDisableBack()
        val bottomNavView: BottomNavigationView = requireActivity().findViewById(R.id.nav_view)
        bottomNavView.isVisible = false

        defineLanguagesFragmentBinding.button.setOnClickListener {
            initialiseLanguages()
        }


        return defineLanguagesFragmentBinding.root
    }

    override fun getTheme(): Int {
        return R.style.DialogTheme
    }

    private fun initialiseLanguages() {
        val learningLanguage = defineLanguagesFragmentBinding.LearningLanguageField.text.toString()
        val nativeLanguage = defineLanguagesFragmentBinding.NativeLanguageField.text.toString()
        if(learningLanguage.isNotBlank() && nativeLanguage.isNotBlank()){
            val dictionary = Dictionary(0,learningLanguage,nativeLanguage)
            defineLangaugesViewModel.insertDictionary(dictionary)
            navigateToHome()

        } else {
        Toast.makeText(
            requireContext(),
            (R.string.toast_fields_must_be_filled),
            Toast.LENGTH_SHORT
        ).show()
    }

    }
    private fun navigateToHome() {
        (activity as MainActivity?)?.declareFirstRunOver()
        (activity as MainActivity?)?.showActionBar()
        val bottomNavView: BottomNavigationView = requireActivity().findViewById(R.id.nav_view)
        bottomNavView.isVisible = true
        findNavController().navigateUp()
    }
}