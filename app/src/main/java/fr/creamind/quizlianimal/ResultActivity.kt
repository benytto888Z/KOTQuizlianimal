package fr.creamind.quizlianimal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        val intent = intent
        val pseudo = intent.getStringExtra(Constants.USER_NAME)
        val score = intent.getIntExtra(Constants.TCORRECT_ANSWERS,0)
        val totalQuest = intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)

        tv_pseudo.setText(pseudo)

        when{
            (score < totalQuest/2)->{
                tv_felicity.text="Hey ! Vous devez faire un effort pour mieux connaître les animaux"
            }

            (score == totalQuest/2)->{
                tv_felicity.text="Hey ! passable vous pouvez mieux faire"
            }

            else->{
                tv_felicity.text="Wey ! Félicitation"
            }
        }

        tv_inforesult.text =" Vous avez obtenu $score / $totalQuest"

        btn_finish.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }

    }
}

