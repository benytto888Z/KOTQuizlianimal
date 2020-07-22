package fr.creamind.quizlianimal

object Constants {

    const val USER_NAME:String = "username"
    const val TOTAL_QUESTIONS:String = "total_question"
    const val TCORRECT_ANSWERS:String = "correct_answers"


    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()
        val que1 = Question(
            1,
            "Reconnaissez-vous cet animal ?",
             R.drawable.buffle,
            "Elephant",
            "Girafe",
            "hyppopotame",
            "Buffle",
            4
        )
        val que2 = Question(
            2,
            "Reconnaissez-vous cet animal ?",
             R.drawable.autruche,
            "Coq",
            "Autruche",
            "Aigle",
            "calao",
            2
        )
        val que3 = Question(
            3,
            "Reconnaissez-vous cet animal ?",
             R.drawable.okapi,
            "Okapi",
            "Biche",
            "Girafe",
            "Mouton",
            1
        )
        val que4 = Question(
            4,
            "Reconnaissez-vous cet animal ?",
             R.drawable.panthere,
            "Chat",
            "Panthère",
            "Lion",
            "Guépard",
            2
        )

        val que5 = Question(
            5,
            "Reconnaissez-vous cet animal ?",
            R.drawable.hyene,
            "Hyene",
            "Okapi",
            "Biche",
            "Lièvre",
            1
        )
        val que6 = Question(
            6,
            "Reconnaissez-vous cet animal ?",
             R.drawable.babouinjpg,
            "Gorille",
            "Chimpanzé",
            "Babouin",
            "Orang-outan",
            3
        )

        val que7 = Question(
            7,
            "Reconnaissez-vous cet animal ?",
            R.drawable.elephant,
            "hyppopotame",
            "Elephant",
            "Gorille",
            "Lion",
            2
        )

        val que8 = Question(
            8,
            "Reconnaissez-vous cet animal ?",
            R.drawable.girafe,
            "Lion",
            "Girafe",
            "Buffle",
            "Taureau",
            2
        )

        val que9 = Question(
            9,
            "Reconnaissez-vous cet animal ?",
            R.drawable.lion,
            "Lion",
            "Tigre",
            "Elephant",
            "Hyppopotame",
            1
        )

        val que10 = Question(
            10,
            "Reconnaissez-vous cet animal ?",
            R.drawable.otocyon,
            "Chèvre",
            "Renard",
            "Hyène",
            "Otocyon",
            4
        )


        questionsList.add(que1);
        questionsList.add(que2);
        questionsList.add(que3);
        questionsList.add(que4);
        questionsList.add(que5);
        questionsList.add(que6);
        questionsList.add(que7);
        questionsList.add(que8);
        questionsList.add(que9);
        questionsList.add(que10);

        return questionsList;
    }
}