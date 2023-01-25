fun main() {

    val csv = readCsv("src/main/kotlin/transacoes.csv")

    csv.forEach{
        println(it)
    }

}