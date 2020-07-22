package fr.creamind.quizlianimal
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // get off the statusbar
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        btn_start.setOnClickListener{
            if(et_pseudo.text.toString().isEmpty()){
                Toast.makeText(this,"Entrez un pseudo svp",Toast.LENGTH_LONG).show();
            }else{
                val pseudo = et_pseudo.text.toString();
                val intent = Intent(this,QuizQuestionsActivity::class.java);
                intent.putExtra(Constants.USER_NAME,pseudo);
                startActivity(intent);
                finish();
            }
        }
    }
}