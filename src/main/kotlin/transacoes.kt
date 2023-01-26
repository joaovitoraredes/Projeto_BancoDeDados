@file:JvmName("TransacoesKt")

var Clientes: MutableSet<Account> = mutableSetOf()

class Transacoes {

    fun linhaDeItens(itens : List<String>): Account{
        return Account(
            itens[0], //AGENCIA
            itens[1], //CONTA
            itens[2], //BANCO
            itens[3], //TITULAR
            itens[4], //OPERACAO
            itens[5], //DATAHORA
            itens[6].toDouble() //VALOR
        )
    }

    fun verificarDuplicadas(op: List<Account>){
        for (index in 0..op.lastIndex){
            for (indexPlus in index+1..op.lastIndex){
                if (op[index].dataHora == op[indexPlus].dataHora){
                    println("Dados Duplicados Encontrados!!")
                    println("${op[index]} \n${op[indexPlus]}\n")
                    Clientes.remove(op[index])
                    break
                }
            }
        }
    }

}

fun main() {

    //Criando variável para guardar valor do read
    val csv = readCsv("src/main/kotlin/transacoes.csv")

    //Criando uma mutableList que irá guardar os dados do arquivo csv para podermos manipular
    val linhaDeOperacoes = mutableListOf<Account>()

    //Guardando os valores do arquivo csv na linhaDaOperação(MutableList)
    csv.forEach{linhaDeOperacoes.add(Transacoes().linhaDeItens(it))}
    linhaDeOperacoes.forEach {
        Clientes.add(Account(agencia = it.agencia,conta = it.conta, banco = it.banco, titular = it.titular, operacao = it.operacao, dataHora = it.dataHora, valor = it.valor))
    }

    //Organizando por titular
    println("Transações:")
    val ordenacaoTitular = Clientes.sortedBy { it.titular }
    ordenacaoTitular.forEach { println(it) }
    println()

    //Encontrando dados iguais e removendo das transações
    Transacoes().verificarDuplicadas(ordenacaoTitular)

    println("Transações Finais")
    val transacoesUnicas = Clientes.sortedBy { it.titular }
    transacoesUnicas.forEach { println(it) }

}