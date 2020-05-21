object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        SadJavaClass().apply {
            println(isPrime(16777199))
            println(primesum(16777214))
        }
    }
}