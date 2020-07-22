package fr.creamind.quizlianimal

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_quiz_questions.*

class QuizQuestionsActivity : AppCompatActivity() {

    private var mCurrentPosition: Int = 0
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mTvChoices = ArrayList<TextView>()
    private var mCorrectResp: Int = 0
    private var mRespChosen: Boolean = false
    private var mChoiceSubmit: Boolean = false
    private var mEndGame:Boolean=false
    private  var mScore:Int = 0
    private var mPseudo:String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mTvChoices.add(0, tv_option_one)
        mTvChoices.add(1, tv_option_two)
        mTvChoices.add(2, tv_option_three)
        mTvChoices.add(3, tv_option_four)

        mQuestionList = Constants.getQuestions()
        setQuestion()

        val intent = intent
         mPseudo = intent.getStringExtra(Constants.USER_NAME)



    }

    private fun setQuestion() {
        mCurrentPosition++
        val question = mQuestionList!![mCurrentPosition - 1]
        mCorrectResp = mQuestionList!![mCurrentPosition - 1].correctAnswer

        defaultOptionView()
        progressBar.progress = mCurrentPosition

        tv_progress.text = " $mCurrentPosition/${progressBar.max}"

        tv_question.text = question!!.question
        iv_image.setImageResource(question.image)
        tv_option_one.text = question.optionOne
        tv_option_two.text = question.optionTwo
        tv_option_three.text = question.optionThree
        tv_option_four.text = question.optionFour
    }


    fun makeChoice(v: View?) {
        when (v?.id) {
            R.id.tv_option_one -> {
                selectedOptionView(tv_option_one, 1)
            }

            R.id.tv_option_two -> {
                selectedOptionView(tv_option_two, 2)
            }

            R.id.tv_option_three -> {
                selectedOptionView(tv_option_three, 3)
            }

            R.id.tv_option_four -> {
                selectedOptionView(tv_option_four, 4)
            }
        }
    }

    private fun defaultOptionView() {

        for (v in mTvChoices) {
            v.setTextColor(Color.parseColor("#7A8089"))
            v.typeface = Typeface.DEFAULT
            v.setBackgroundResource(R.drawable.default_option_border_bg)
            // v.background = ContextCompat.getDrawable(this,R.drawable.default_option_border_bg)
        }

    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {

        if (!mChoiceSubmit) {

            defaultOptionView()
            mSelectedOptionPosition = selectedOptionNum

            tv.setTextColor(Color.parseColor("#363A43"))
            tv.setTypeface(tv.typeface, Typeface.BOLD)
            tv.setBackgroundResource(R.drawable.selected_option_border_bg)
            mRespChosen = true
        }

    }

    fun onSubmit(view: View) {

        if (mRespChosen && !mChoiceSubmit && !mEndGame) {

            val tvUserChoice: TextView = mTvChoices[mSelectedOptionPosition - 1]
            val tvAnswer: TextView = mTvChoices[mCorrectResp - 1]
            defaultOptionView()
            if (mSelectedOptionPosition == mCorrectResp) {
                tvUserChoice.setBackgroundResource(R.drawable.correct_option_border_bg)
                tvUserChoice.setTextColor(Color.parseColor("#FFFFFF"))
                tvUserChoice.setTypeface(tvUserChoice.typeface, Typeface.BOLD)
                mScore++
            } else {
                tvUserChoice.setBackgroundResource(R.drawable.incorrect_option_border_bg)
                tvAnswer.setBackgroundResource(R.drawable.correct_option_border_bg)
                tvUserChoice.setTextColor(Color.parseColor("#FFFFFF"))
                tvAnswer.setTextColor(Color.parseColor("#FFFFFF"))
                tvUserChoice.setTypeface(tvUserChoice.typeface, Typeface.BOLD)
                tvAnswer.setTypeface(tvAnswer.typeface, Typeface.BOLD)
            }
            mChoiceSubmit = true
            //on verifie si on est à la fin du quesionnaire
            when {
                mCurrentPosition < mQuestionList!!.size -> {
                    btn_submit.setText("Question Suivante")
                }
                else -> {
                    btn_submit.setText("FIN ! / Voir le Resultat")
                    mEndGame = true

                }
            }
            return

        }
        // passer à la question suivante si on est pas à la fin de la partie

        if (mChoiceSubmit && !mEndGame) {
            defaultOptionView()
            mChoiceSubmit = false
            mRespChosen = false

            setQuestion()

            btn_submit.setText("Valider")
        }

        // si fin de la partie on affiche ecran de resultat
        if(mEndGame){
             val intent = Intent(this,ResultActivity::class.java)
              intent.putExtra(Constants.USER_NAME,mPseudo)
              intent.putExtra(Constants.TCORRECT_ANSWERS,mScore)
              intent.putExtra(Constants.TOTAL_QUESTIONS,mQuestionList!!.size)
             startActivity(intent)
            finish()
        }



    }


}
