package br.com.ifpb.newjogodaforca

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import br.com.ifpb.newjogodaforca.banco.Banco
import br.com.ifpb.newjogodaforca.jogo.Forca


class MainActivity : AppCompatActivity() {
    private lateinit var jogo: Forca
    private lateinit var banco: Banco
    private lateinit var tip: TextView
    private lateinit var letter: EditText
    private lateinit var layout: TextView
    private lateinit var button: Button
    private lateinit var imagesBank: imagesBank
    private lateinit var usedWords: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTitle("HangMan - Jogo da Forca")

        this.imagesBank = imagesBank()


        this.tip = findViewById(R.id.tvtip)
        this.letter = findViewById(R.id.tvletter)
        this.button = findViewById(R.id.button);
        this.layout = findViewById(R.id.Tvlayout)
        this.img = findViewById(R.id.imageView)

        this.start()

        this.button.setOnClickListener(){
            if(letter.text.length == 1) {
                if (jogo.startGame(letter.text.first().toString())) {
                    Toast.makeText(this@MainActivity, "Parabens!! voce acertou a letter ", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this@MainActivity, "Voce errou a letter ", Toast.LENGTH_LONG).show()
                }

                if (jogo.done(letter.text.toString())) {
                    Thread.sleep(2000)
                    this.start()
                }

                this.layout.text = jogo.layout.toString()
            }else{
                Toast.makeText(this@MainActivity, "Digite uma unica letter por vez!", Toast.LENGTH_LONG).show()
            }
        }

    }

    fun start(){
        this.banco = Banco()
        val word = this.banco.word()
        val tip = this.banco.tip()

        this.jogo = Forca(word, tip)
        this.tip.text = this.jogo.tip
        this.layout.text = jogo.layout.toString()
        this.usedWords.text = jogo.usedWords.toString()
        this.img.setImageResource(this.imagesBank.loadingImg(jogo.attempt);
    }
}