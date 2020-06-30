import java.util.*
import kotlin.collections.ArrayList

private val scanner = Scanner(System.`in`)

fun printResult(n: Int) {
    println(n)
}

fun areEq(s: String): Boolean {
    val c = s[0]
    for (nc in s.drop(1)) {
        if (c != nc) {
            return false
        }
    }
    return true
}

fun isDesc(s: String): Boolean {
    var c = s[0]
    for (nc in s.drop(1)) {
        if (c > nc) {
            c = nc
        } else {
            return false
        }
    }
    return true
}

data class Friend(
    val name: String,
    var taxis: Int = 0,
    var pizzas: Int = 0,
    var girls: Int = 0
)

fun B() {
    scanner.apply {
        val n = nextInt()
        val friends = ArrayList<Friend>()

        for (i in 0 until n) {
            val k = nextInt()
            val name = next()
            val friend = Friend(name)
            for (j in 0 until k) {
                val s = next().filter { c -> c in '0'..'9' }
                when {
                    areEq(s) -> friend.taxis++
                    isDesc(s) -> friend.pizzas++
                    else -> friend.girls++
                }
            }
            friends.add(friend)
        }

        val maxTaxis = friends.maxBy { friend -> friend.taxis }?.taxis ?: 0
        val taxiFriends = friends.filter { it.taxis == maxTaxis }.map { it.name }.joinToString()

        val maxPizzas = friends.maxBy { it.pizzas }?.pizzas ?: 0
        val pizzaFriends = friends.filter { it.pizzas == maxPizzas }.map { it.name }.joinToString()

        val maxGirls = friends.maxBy { it.girls }?.girls ?: 0
        val girlsFriends = friends.filter { it.girls == maxGirls }.map { it.name }.joinToString()

        println(
            """If you want to call a taxi, you should call: ${taxiFriends}.
If you want to order a pizza, you should call: ${pizzaFriends}.
If you want to go to a cafe with a wonderful girl, you should call: ${girlsFriends}."""
        )
    }
}
