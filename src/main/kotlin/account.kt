open class Account(
    var agencia : String,
    var conta : String,
    var banco : String,
    var titular: String,
    var operacao : String,
    var dataHora : String,
    var valor: Double,
    ){
    override fun toString(): String {
        return """
            Agência: $agencia | Conta: $conta | Banco: $banco | Titular: $titular | Operação: $operacao | Data e Hora: $dataHora | Valor: $valor
        """.trimIndent()
    }
}

