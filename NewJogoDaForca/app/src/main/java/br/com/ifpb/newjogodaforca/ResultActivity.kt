package br.com.ifpb.newjogodaforca

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    private lateinit var textResult : TextView
    private lateinit var startGame : Button
    private lateinit var exitGame : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result2)
        setTitle("Hangman - Jogo da Forca *--*")

        this.textResult = findViewById(R.id.tvMensage)
        this.startGame = findViewById(R.id.tvstartGame)
        this.exitGame = findViewById(R.id.tvexitGame)

        this.textResult.text = intent.getStringExtra("result")

        startGame.setOnClickListener(){
            startGame()
        }

        exitGame.setOnClickListener(){
            finishAffinity()
        }
    }

    fun startGame(){
        val gameLayoutPage = Intent(this, MainActivity::class.java)
        startActivity(gameLayoutPage)
    }
}
