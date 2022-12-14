package com.example.calculadoraimc

internal fun getImcResult(pesoTxt: String, alturaTxt: String): IMCResult {

    //passando pesoTxt para float
    val peso = pesoTxt.toFloat()
    //passanndo alturaTxt para float
    val altura = alturaTxt.toFloat()
    //realizando o calculo e armazenando na variavel imc
    val imc = peso / (altura * altura)

    //condição para validar se usuário está com peso elevado ou nao
    if (imc < 16){
        return IMCResult(Result.MAGREZA_III)
    } else if (imc < 17){
        return IMCResult(Result.MAGREZA_II)
    } else if (imc < 18.5){
        return IMCResult(Result.MAGREZA_I)
    } else if (imc < 25){
        return IMCResult(Result.OK)
    } else if (imc < 30){
        return IMCResult(Result.SOBREPESO)
    } else if (imc < 35){
        return IMCResult(Result.OBESIDADE_I)
    } else if (imc < 40){
        return IMCResult(Result.OBESIDADE_II)
    } else {
        return IMCResult(Result.OBESIDADE_III)
    }
}

// classe que tem as label que vai ser apresentada para o usuarios quando clicar no
// botao calcular

data class IMCResult(val result: Result)
enum class Result(val label: String) {
    MAGREZA_III("Magreza Severa"),
    MAGREZA_II("Magreza moderada"),
    MAGREZA_I("Magreza leve"),
    OK("Saudável"),
    SOBREPESO("Sobrepeso"),
    OBESIDADE_I("Obesidade Grau I"),
    OBESIDADE_II("Obesidade GHrau II (severa)"),
    OBESIDADE_III("Obesidade GHrau III (mórbida)"),
    BLANK("Insira os valores de peso e altura corretamente!")
}