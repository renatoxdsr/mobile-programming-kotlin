package br.com.ifpb.newjogodaforca.banco

class Banco {
    val words: LinkedHashMap<String, String>
    lateinit var raffle: String

    init{
        this.words = linkedMapOf()
        this.bingo()
        this.lottery()
    }

    private  fun bingo(){
        this.map.put("PARAISO", "Uma novela criada no pantanal")
        this.map.put("CLONE", "Uma novela criada no Middle East")
        this.map.put("CAMINHODASINDIAS", "Uma novela criada na India")
        this.map.put("MUTANTES", "Uma novela futurista")
        this.map.put("ESCRAVAISAURA", "Uma novela de época")
    }

    private fun lottery(){
        this.raffle = this.words.keys.random()
    }

    fun word(): String{
        return this.raffle
    }

    fun tip(): String{
        return this.words.getValue(this.raffle)
    }

}