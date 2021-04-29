/**
 * Fragment for the tests page
 * @author Troy Wenham
 * @version 1
 */
package uk.ac.aber.dcs.cs31620.vocabular.ui.tests

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import uk.ac.aber.dcs.cs31620.vocabular.R
import uk.ac.aber.dcs.cs31620.vocabular.databinding.FragmentTestsBinding

class TestsFragment : Fragment() {

    private lateinit var testsFragmentBinding: FragmentTestsBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        testsFragmentBinding =
            FragmentTestsBinding.inflate(inflater,container,false)

        setOnClickListeners()
        return testsFragmentBinding.root
    }

    private fun setOnClickListeners(){
        val navController = findNavController()
        testsFragmentBinding.includeSpellingTest.SpellingTestInfoCard.setOnClickListener {
            navController.navigate(R.id.navigation_spelling_test)
        }
    }
}