/**
 * Homepage fragment for showing homepage and statistic data
 * @author Troy Wenham
 * @version 1
 */
package uk.ac.aber.dcs.cs31620.vocabular.ui.home

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import uk.ac.aber.dcs.cs31620.vocabular.MainActivity
import uk.ac.aber.dcs.cs31620.vocabular.R
import uk.ac.aber.dcs.cs31620.vocabular.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var homeFragmentBinding: FragmentHomeBinding
    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeFragmentBinding =
            FragmentHomeBinding.inflate(inflater,container,false)

        setupLanguages()
        setupChangeLanguages()
        setupStats()

        return homeFragmentBinding.root
    }

    private fun setupLanguages() {
        val languagesCard = homeFragmentBinding.LanguagesCard
        val dictionaryData = homeViewModel.getDictionaryData()
        languagesCard.LearningLanguageTextView.text = dictionaryData[0].user.langaugeLearning.toLowerCase().capitalize()
        languagesCard.NativeLanguageTextView.text = dictionaryData[0].user.nativeLanguage.toLowerCase().capitalize()
    }

    private fun setupChangeLanguages() {
        val changeLanguages = homeFragmentBinding.ChangeLanguagesCard.ChangeLanguagesCard
        changeLanguages.setOnClickListener{
            displayWarningDialog()
        }
    }

    private fun displayWarningDialog() {
        val alertDialogBuilder = AlertDialog.Builder(context)
        alertDialogBuilder.setTitle("Are you sure you want to change languages?")
        alertDialogBuilder.setMessage("This will clear all your data.\nAre you sure you want to continue?")
        alertDialogBuilder.setPositiveButton("YES DELETE DATA") { _,_ ->
            (activity as MainActivity?)?.navigateToChangeLanguages()
        }
        alertDialogBuilder.setNeutralButton("Cancel"){_,_ ->
            Toast.makeText(context, "Languages Not Changed",Toast.LENGTH_SHORT)
        }
        val dialog: AlertDialog = alertDialogBuilder.create()
        dialog.show()
    }

    private fun setupStats() {
        val dictionaryItems = homeViewModel.getDictionaryItems()
        homeFragmentBinding.DictionaryNumberTextView.text = dictionaryItems.size.toString()
        if(dictionaryItems.isNotEmpty()) {
            homeFragmentBinding.MostRecentWordCard.WordTextView.text =
                dictionaryItems.last().word
            homeFragmentBinding.MostRecentWordCard.MeaningTextView.text =
                dictionaryItems.last().meaning
        } else {
            homeFragmentBinding.MostRecentWordCard.WordTextView.text = getString(R.string.no_words_in_dictionary_text)
            homeFragmentBinding.MostRecentWordCard.MeaningTextView.text = ""
        }
    }
}