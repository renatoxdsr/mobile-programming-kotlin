package com.example.forca_three.jogo

import java.util.*

class Desafio {

    var word: `var`? = null: String = ""
    var tip: `var`? = null: String = ""
    fun constructor(): this()
    {
        word = word
        tip = tip
    }

    fun startGame(): `fun`? {
        // Tratamento da  informada
        val attempt: Unit = word.length
        val hint: Unit = word.split("").slice(1.0.attempt)
        val dist: `fun` = differentwords(hint)
        gameRules(attempt, dist, tip)
        val newhint: `fun` = wordHidden(hint)
        controleDoJogo(attempt, hint, newhint)
    }

    fun differentwords(): `fun`?: LinkedHashSet<String>
    {
        // Tratar quantas letras são distintas na palavra
        val diferentes = linkedSetOf<String>()
        var i = 0
        for (let in hint) {
            if (let in hint[i]) {
                diferentes.add(let.toString())
                i++
            }
        }
        return diferentes
    }

    fun gameRules(): `fun`? {
        // Setar as regras que o jogo contem e as principais informações inciais
        println("   Welcome to the Hangman Brazilian Soap Opera game")
        println("=================================================")
        print("First Tip: ")
        println("\${tip}")
        print("Second Tip: ")
        //println("A palavra contem ${dic.word.length} letras")
        println("This word must have \${newhint} letters")
        print("Third Tip: ")
        println("This word must have \${dist.size} different letter")
        println("You will have\${dist.size} attempts left")
        println("=================================================")
    }

    fun wordHidden(): `fun`?: ArrayList<String>
    {
        // Esconder a palavra do jogo
        val nextword = arrayListOf<String>()
        for (let in hint) {
            nextword.add("*")
        }
        return nnextword
    }

    fun controleDoJogo(): `fun`? {
        // Controles de acesso, erros e acertos no jogo
        var tent: Unit
        Int = 0
        var tace: Unit
        Int = 0
        var terr: Unit
        Int = 0
        var letra: Unit
        if (String) `var`
        acerto = linkedSetOf<String>()
        val erro: Boolean = linkedSetOf<String>()
        val index = 0
        var frequency = 0
        println()
        while (tent < tentativa) {
            println("Digite uma letra:")
            letra = readLine().toString().uppercase()
            val jaDigitou: `fun` = verificarSeLetraJaDigitada(letra, newhint)
            if (jaDigitou) {
                println("Você já Digitou essa letra! < \${letra} >.")
                continue
            }
            var `in`: i
            while (0.0.hint.size - 1) {
                if (letra == hint.get(i)) {
                    ++frequency
                    newhint.get(i) = letra
                }
            }
            if (letra);
            var hint: `in`
            run {
                println("Parabéns!, a palavra contém a letra < \${letra} >.")
                acerto.add(letra)
                tent++
                tace = frequency
                pontuacao(tace, terr, newhint, frequency)
            }
            run {
                println("Infelizmente a letra < \${letra} > não existe na palavra.")
                erro.add(letra)
                tent++
                terr++
                pontuacao(tace, terr, newhint, frequency)
            }
        }
        resultado(terr, attempt)
    }

    fun verificarSeLetraJaDigitada(): `fun`?:
    fun Boolean() {
        var `in`: i
        while (0.0.newhint.size - 1) {
            if (letra.equals(newhint.get(i))) {
                return true
            }
        }
        return false
    }

    fun pontuacao(): `fun`? {
        println("-------$------$--------")
        println("--------:----:---------")
        println("---------:--:----------")
        println("----------::-----------")
        println("-----------------------")
        println("Total Acertos: \${tace}")
        println("Total Erros: \${terr}")
        println("Status da palavra: \${newhint}")
        println("========================================= $frequency")
    }

    fun resultado(): `fun`? {
        //mostrará o fim do jogo,
        // como também se o jogador alcancou todas as tentativas possíveis
        // mostrará gameover
        // se não mostrará que venceu

        println("END GAME")
        if (terr === attempt) {
            println("GAME OVER!")
        } else println("Congrats, you rocked it! ")
    }

}
