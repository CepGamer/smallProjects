object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        println(SadJavaClass.maxSubArray(listOf(1, 2, 3)))
        println(SadJavaClass.maxSubArray(listOf(-500)))
        println(SadJavaClass.maxSubArray(listOf(1, 3, -3, 4)))

    }
}