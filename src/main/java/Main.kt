object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        main()

        println(listOf(2, 4, 6, 8, 10, 12, 14, 16).reduce(Int::plus) - listOf(1, 3, 5, 7, 9, 11, 13, 23).reduce(Int::plus))
    }
}