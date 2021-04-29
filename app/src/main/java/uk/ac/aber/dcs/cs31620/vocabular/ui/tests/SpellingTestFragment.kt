/**
 * Fragment for the spelling test
 * @author Troy Wenham
 * @version 1
 */
package uk.ac.aber.dcs.cs31620.vocabular.ui.tests

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import com.google.android.material.bottomnavigation.BottomNavigationView
import uk.ac.aber.dcs.cs31620.vocabular.R
import uk.ac.aber.dcs.cs31620.vocabular.databinding.FragmentSpellingTestBinding
import uk.ac.aber.dcs.cs31620.vocabular.databinding.FragmentTestsBinding
import uk.ac.aber.dcs.cs31620.vocabular.model.DictionaryItem
import uk.ac.aber.dcs.cs31620.vocabular.ui.dictionary.DictionaryViewModel

class SpellingTestFragment : Fragment() {

    private lateinit var spellingTestsFragmentBinding: FragmentSpellingTestBinding
    private val spellingTestViewModel: SpellingTestViewModel by viewModels()
    private var dictionaryList: MutableList<DictionaryItem>? = null
    private var currentQuestionItem: DictionaryItem = DictionaryItem()
    private var wordForQuestion: String = ""
    private var answerToQuestion: String = ""
    private var questionsLeft: Int = 0
    private var questionsAnswered: Int = 0
    private var questionsCorrect: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        spellingTestsFragmentBinding =
            FragmentSpellingTestBinding.inflate(inflater,container,false)
        getActivity()?.getWindow()?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)

        val bottomNavView: BottomNavigationView = requireActivity().findViewById(R.id.nav_view)
        bottomNavView.isVisible = false

        createSpellingTest()
        setOnClickListeners()

        return spellingTestsFragmentBinding.root
    }

    private fun createSpellingTest() {
        dictionaryList = spellingTestViewModel.getDictionaryItemsForTest().toMutableList()

        dictionaryList!!.shuffle()
        val isTestOver = nextQuestion()
        if(isTestOver){
            endQuiz()
        }
    }

    private fun nextQuestion(): Boolean {
        val dictionaryListSize = dictionaryList?.size ?: 0
        val questionList = dictionaryList ?: return true
        if(dictionaryListSize > 0 )  {
            questionsLeft = questionList.size
            currentQuestionItem = questionList.first()
            val rand = (0..1).random()
            if(rand == 0) {
                wordForQuestion = currentQuestionItem.word
                answerToQuestion = currentQuestionItem.meaning
                populateQuiz()
            } else {
                wordForQuestion = currentQuestionItem.meaning
                answerToQuestion = currentQuestionItem.word
                populateQuiz()
            }
            return false
        } else {
            return true
        }
    }

    private fun setOnClickListeners(){
        spellingTestsFragmentBinding.EndTestButton.setOnClickListener{
            endQuiz()
        }
        spellingTestsFragmentBinding.SkipQuestionButton.setOnClickListener{
            questionsAnswered++
            if (nextQuestion()) {
                endQuiz()
            }
        }
        spellingTestsFragmentBinding.SubmitAnswerButton.setOnClickListener{
            val answer = spellingTestsFragmentBinding.SubmissionField.text.toString()
            if(answer.equals(answerToQuestion, ignoreCase = true)) {
                questionsCorrect++
                spellingTestsFragmentBinding.ScoreNumberTextView.text = questionsCorrect.toString()
            }
            questionsAnswered++
            if (nextQuestion()) {
                endQuiz()
            }
        }
    }
    private fun populateQuiz() {
        dictionaryList?.removeFirst()
        spellingTestsFragmentBinding.QuestionsLeftNumberTextView.text = dictionaryList?.size.toString()
        spellingTestsFragmentBinding.WordToSpellTextView.text = wordForQuestion
    }

    private fun endQuiz(){
        spellingTestsFragmentBinding.SubmitAnswerButton.isVisible = false
        spellingTestsFragmentBinding.SkipQuestionButton.isVisible = false
        spellingTestsFragmentBinding.SubmissionField.isVisible = false
        spellingTestsFragmentBinding.SpellWordTextView.isVisible = false
        spellingTestsFragmentBinding.EndTestButton.isVisible = false
        spellingTestsFragmentBinding.WordToSpellTextView.text = "You Scored:$questionsCorrect/$questionsAnswered"

        val bottomNavView: BottomNavigationView = requireActivity().findViewById(R.id.nav_view)
        bottomNavView.isVisible = true

    }
}