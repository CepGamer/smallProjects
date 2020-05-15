object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        println(SadJavaClass().solve(readLine()?.toInt() ?: 5))
    }
}