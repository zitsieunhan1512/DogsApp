package com.example.quizapp

object Constans{
    fun getQuestions() : ArrayList<Questions>{
        val questionsList = ArrayList<Questions>()

        val que1 = Questions(
            1,
            "What country does this flag belong to?",
            R.drawable.bg,
            "Argentina",
            "Australia",
            "VietNam",
            "China",
            1
        )
        val que2 = Questions(
            2,
            "What country does this flag belong to?",
            R.drawable.bg,
            "Argentina",
            "Australia",
            "Hahahaha",
            "China",
            1
        )
        questionsList.add(que1)
        questionsList.add(que2)
        return questionsList
    }
}