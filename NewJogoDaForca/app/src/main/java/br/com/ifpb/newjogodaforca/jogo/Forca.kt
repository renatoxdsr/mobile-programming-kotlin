package br.com.ifpb.newjogodaforca.jogo

class Forca (var word: String, var tip: String) {
    val usedWords = linkedSetOf<String>()
    var attempt: Int
    var hint: Int
    val layout = arrayListOf<String>()
    lateinit var message: String

    init {
        this.attempt = 6
        this.hint = 0
        this.word.forEach { it
            this.layout.add("*")
        }

    }


    fun startGame(letter: String): Boolean{
        // verificar se o jogo tem começado
        // informar que o jogo terminou
        if(this.done(letter)){
            return false;
        }

        // verificar se a letter é uma letra nova, ou seja, não inserida no jogo antes
        // registrar a letter no banco de letters(letras) jogadas na rodada
        if(!verifyLetter(letter.toUpperCase())){
            return false;
        }
        // verificar se faz parte da unrevealedword (palavra não revelada)
        // registrar/atualizar a pontuação, como também layout do jogo

        if(this.word.toUpperCase().contains(letter.toUpperCase())){
            updateLayout(letter)
        }else{
            // else
            // registrar o erro
            this.attempt = this.attempt - 1;

            return false;
        }
        return true
    }

    private fun verifyLetter(letter: String): Boolean{

        if(letter.length > 1){
            print("Você precisa digitar uma letra!!\n")
            this.attempt = this.attempt - 1;
            return false
        }else if(this.usedWords.contains(letter)){
            //retornar se a tentativa foi validada ou não
            print("A letra já selecionada anteriormente!\n")
            return false;
        }
        this.usedWords.add(letter.toUpperCase())
        return true;
    }

    fun done(letter: String):Boolean {
        if(letter.uppercase() == this.word.uppercase()){
            this.message = "Parabéns você acertou uma letra da palavra"
            return true
        }else if(this.word == null){
            this.message = "Jogo não foi iniciado corretamente"
            return true;
        } else if(this.hint == this.word.length){
            this.message ="word: " + this.word + "\n" + "Parabéns você consegui desvendar a palavra!!"
            return true;
        }else if(this.attempt == 0){
            this.message ="Fim de Jogo. Infelizmente você alcançou o limite de tentativas possíveis. Reinicie o jogo!!"
            return true;
        };
        return false;
    }

    private fun updateLayout(letter: String){
        this.word.forEachIndexed { index, c ->
            if(c.toString().toUpperCase() == letter.toUpperCase()){
                this.hint =  this.hint + 1
                this.layout.set(index, c.toString())
            }
        }

    }

    public fun getUsedWords():String{
        var unrevealedWord = "";
        this.layout.forEach {it
            unrevealedWord +=  it;
        }
        System.out.println(unrevealedWord)
        return unrevealedWord
    }

}