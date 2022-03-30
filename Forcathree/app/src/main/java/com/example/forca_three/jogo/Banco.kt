package com.example.forca_three.jogo

class Banco {

    val map: LinkedHashMap<String, String>
    lateinit var wordEscolhida: String

    init {
        this.map = linkedMapOf<String, String>()
        this.bingo()
        this.sorteio()
    }

    private fun bingo(){

        this.map.put("PARAISO", "Uma novela criada no pantanal")
        this.map.put("CLONE", "Uma novela criada no Middle East")
        this.map.put("CAMINHODASINDIAS", "Uma novela criada na India")
        this.map.put("MUTANTES", "Uma novela futurista")
        this.map.put("ESCRAVAISAURA", "Uma novela de época")
    }

    fun sorteio() {
        this.palavraEscolhida = this.map.keys.random()
    }

    fun word(): String{
        return this.palavraEscolhida
    }

    fun tip(): String {
        return this.map[palavraEscolhida].toString()
    }

}

