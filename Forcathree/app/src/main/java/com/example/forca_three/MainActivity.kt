package com.example.forca_three

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.forca_three.jogo.Banco
import com.example.forca_three.jogo.Desafio

class MainActivity : AppCompatActivity() {
    private lateinit var tvword: TextView
    private lateinit var tvtip: TextView
    private lateinit var banco: Banco
    private lateinit var desafio: Desafio

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.banco = Banco()
        this.desafio = Desafio(this.banco.word(),this.banco.tip())

        this.tvword = findViewById(R.id.tvword)
        this.tvtip = findViewById(R.id.tvtip)

        this.tvword.text = this.desafio.word
        this.tvtip.text = this.desafio.tip
    }
}