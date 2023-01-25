data class Account(
    val agencia : Int,
    val conta : Int,
    val banco : String,
    val titular: String,
    val operacao : String,
    val dataHora : String,
    val valor: Double
    ){
    override fun toString(): String {
        return """
            Agência: $agencia | Conta: $conta | Banco: $banco | Titular: $titular | Operação: $operacao | Data e Hora: $dataHora | Valor: $valor
        """.trimIndent()
    }
}