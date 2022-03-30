package br.com.ifpb.newjogodaforca.jogo

class Forca (var word: String, var tip: String) {
    val usedWords = linkedSetOf<String>()
    var attempt: Int
    var hint: Int
    val layout = arrayListOf<String>()
    lateinit var menssagem: String

    init {
        this.attempt = 6
        this.hint = 0
        this.word.forEach { it
            this.layout.add("*")
        }

    }


    fun startGame(letter: String): Boolean{
        // verificar se o jogo está ativo
        // informar que o jogo já encerrou
        if(this.done(letter)){
            return false;
        }

        // verificar se a letter é "nova", ou seja, não informada anteriormente
        // registrar a letter no banco de letters jogadas
        if(!verifyLetter(letter.toUpperCase())){
            return false;
        }
        // verificar se faz parte da word secreta
        // atualizar o layout
        // registrar pontuação

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
            print("Você precisa digitar um caracter!!\n")
            this.attempt = this.attempt - 1;
            return false
        }else if(this.usedWords.contains(letter)){
            // informar que a tentativa não é válida
            print("A letra já selecionada anteriormente!\n")
            return false;
        }
        this.usedWords.add(letter.toUpperCase())
        return true;
    }

    fun done(letter: String):Boolean {
        if(letter.uppercase() == this.word.uppercase()){
            this.menssagem = "Parabéns você acertou a word"
            return true
        }else if(this.word == null){
            this.menssagem = "Jogo não foi iniciado corretamente"
            return true;
        } else if(this.hint == this.word.length){
            this.menssagem ="word: " + this.word + "\n" + "Parabéns você ganhou!!"
            return true;
        }else if(this.attempt == 0){
            this.menssagem ="Fim de Jogo, você alcançou o limite de attempt!!"
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

}