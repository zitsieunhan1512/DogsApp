package com.example.quizapp

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.quizapp.databinding.ActivityQuizQuestionsBinding

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var viewBinding: ActivityQuizQuestionsBinding
    private var mCurrentPosition: Int = 1
    private var mQuestionsList: ArrayList<Questions>? = null
    private var mSelectedOptionPosition: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityQuizQuestionsBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        mQuestionsList = Constans.getQuestions()

        setQuestion()

        viewBinding.tvOptionOne.setOnClickListener(this)
        viewBinding.tvOptionTwo.setOnClickListener(this)
        viewBinding.tvOptionThree.setOnClickListener(this)
        viewBinding.tvOptionFour.setOnClickListener(this)
        viewBinding.btnSubmit.setOnClickListener(this)
    }

    private fun setQuestion() {

        val question = mQuestionsList!![mCurrentPosition - 1]

        defaultOptionsView()

        if(mCurrentPosition == mQuestionsList!!.size){
           viewBinding.btnSubmit.text = "FINISH"
        }else{
            viewBinding.btnSubmit.text = "SUBMIT"
        }

        viewBinding.progressBar.progress = mCurrentPosition
        viewBinding.tvProgress.text = "$mCurrentPosition" + "/" + viewBinding.progressBar.max

        viewBinding.tvQuestion.text = question!!.question
        viewBinding.ivImage.setImageResource(question.image)
        viewBinding.tvOptionOne.text = question.optionOne
        viewBinding.tvOptionTwo.text = question.optionTwo
        viewBinding.tvOptionThree.text = question.optionThree
        viewBinding.tvOptionFour.text = question.optionFour
    }

    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()
        options.add(0, viewBinding.tvOptionOne)
        options.add(1, viewBinding.tvOptionTwo)
        options.add(2, viewBinding.tvOptionThree)
        options.add(3, viewBinding.tvOptionFour)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.tv_option_one -> {
                selectedOptionView(viewBinding.tvOptionOne, 1)
            }
            R.id.tv_option_two -> {
                selectedOptionView(viewBinding.tvOptionTwo, 2)
            }
            R.id.tv_option_three -> {
                selectedOptionView(viewBinding.tvOptionThree, 3)
            }
            R.id.tv_option_four -> {
                selectedOptionView(viewBinding.tvOptionFour, 4)
            }
            R.id.btn_submit -> {
                if (mSelectedOptionPosition == 0) {
                    mCurrentPosition++

                    when {
                        mCurrentPosition <= mQuestionsList!!.size -> {
                            setQuestion()
                        }
                        else -> {
                            Toast.makeText(
                                this,
                                "You have successfully completed the Quiz",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                } else {
                    val question = mQuestionsList?.get(mCurrentPosition - 1)
                    if(question!!.correctAnswer != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition,R.drawable.wrong_option_border_bg)
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if(mCurrentPosition == mQuestionsList!!.size){
                        viewBinding.btnSubmit.text = "FINISH"
                    }else{
                        viewBinding.btnSubmit.text = "GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int) {
        when (answer) {
            1 -> {
                viewBinding.tvOptionOne.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            2 -> {
                viewBinding.tvOptionTwo.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            3 -> {
                viewBinding.tvOptionThree.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            4 -> {
                viewBinding.tvOptionFour.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )
    }

}