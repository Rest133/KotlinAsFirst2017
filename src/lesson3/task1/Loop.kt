@file:Suppress("UNUSED_PARAMETER")

package lesson3.task1

import lesson1.task1.sqr
import java.lang.Math.*

/**
 * Пример
 *
 * Вычисление факториала
 */
fun factorial(n: Int): Double {
    var result = 1.0
    for (i in 1..n) {
        result = result * i // Please do not fix in master
    }
    return result
}

/**
 * Пример
 *
 * Проверка числа на простоту -- результат true, если число простое
 */
fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    for (m in 2..Math.sqrt(n.toDouble()).toInt()) {
        if (n % m == 0) return false
    }
    return true
}

/**
 * Пример
 *
 * Проверка числа на совершенность -- результат true, если число совершенное
 */
fun isPerfect(n: Int): Boolean {
    var sum = 1
    for (m in 2..n / 2) {
        if (n % m > 0) continue
        sum += m
        if (sum > n) break
    }
    return sum == n
}

/**
 * Пример
 *
 * Найти число вхождений цифры m в число n
 */
fun digitCountInNumber(n: Int, m: Int): Int =
        when {
            n == m -> 1
            n < 10 -> 0
            else -> digitCountInNumber(n / 10, m) + digitCountInNumber(n % 10, m)
        }

/**
 * Тривиальная
 *
 * Найти количество цифр в заданном числе n.
 * Например, число 1 содержит 1 цифру, 456 -- 3 цифры, 65536 -- 5 цифр.
 */
fun digitNumber(n: Int): Int {
    if (n == 0)
        return 1
    var num = n
    var counter = 0
    while (num != 0) {
        num /= 10
        counter++
    }
    return counter
}

/**
 * Простая
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
fun fib(n: Int): Int {
    var m = 2
    var fib1 = 1
    var fib2 = 1
    var fib = 0
    if (n == 1)
        return 1
    if (n == 2)
        return 1
    while (m < n) {
        fib = fib1 + fib2
        fib1 = fib2
        fib2 = fib
        m++
    }
    return fib

}


/**
 * Простая
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */
fun lcm(m: Int, n: Int): Int {
    var fnum = m
    var snum = n
    while (fnum != 0 && snum != 0) {
        if (fnum > snum) fnum %= snum else snum %= fnum
    }
    return m * n / (fnum + snum)
}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int {
    val num = n
    var q = 2
    while (q <= num && num % q != 0) {
        q++
    }
    return q
}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int {
    val num = n
    var q1 = n - 1
    while (num % q1 != 0) {
        q1--
    }
    return q1
}

/**
 * Простая
 *
 * Определить, являются ли два заданных числа m и n взаимно простыми.
 * Взаимно простые числа не имеют общих делителей, кроме 1.
 * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
 */
fun isCoPrime(m: Int, n: Int): Boolean {
    return m * n == lcm(m, n)
}

/**
 * Простая
 *
 * Для заданных чисел m и n, m <= n, определить, имеется ли хотя бы один точный квадрат между m и n,
 * то есть, существует ли такое целое k, что m <= k*k <= n.
 * Например, для интервала 21..28 21 <= 5*5 <= 28, а для интервала 51..61 квадрата не существует.
 */
fun squareBetweenExists(m: Int, n: Int): Boolean {
    for (k in 0..sqrt(n.toDouble()).toInt()) {
        if (k * k in m..n) return true
    }
    return false
}

/**
 *
 */
fun function(x: Double, eps: Double, i: Int): Double {
    var i = i
    var p = 2.0
    var resault = 0.0
    val n = x % (2 * PI)
    do {
        val trigfun = pow(n, i.toDouble()) / factorial(i) * pow(-1.0, p)
        resault += trigfun
        i += 2
        p++
    } while (abs(trigfun) > eps)
    return resault
}

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun sin(x: Double, eps: Double): Double {
    return function(x, eps, 1)
}

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun cos(x: Double, eps: Double): Double {
    return function(x, eps, 0)
}

/**
 * Средняя
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 * Не использовать строки при решении задачи.
 */
fun revert(n: Int): Int {
    var k = 0
    var count = 0
    var num = n
    while (num / 10 != 0) {
        num /= 10
        count++
    }
    num = n
    while (count != 0) {
        k += num % 10
        num /= 10
        k *= 10
        count--
    }
    k += num % 10
    return k
}

/**
 * Средняя
 *
 * Проверить, является ли заданное число n палиндромом:
 * первая цифра равна последней, вторая -- предпоследней и так далее.
 * 15751 -- палиндром, 3653 -- нет.
 */
fun isPalindrome(n: Int): Boolean {
    return n == revert(n)
}

/**
 * Средняя
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 */
fun hasDifferentDigits(n: Int): Boolean {
    var k = 0
    var m = 0
    var num = n
    while (num / 10 != 0) {
        k = num % 10
        m = (num / 10) % 10
        if (m != k) break
        num /= 10
    }
    return m != k
}

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из квадратов целых чисел:
 * 149162536496481100121144...
 * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
 */
fun squareSequenceDigit(n: Int): Int {
    var num = 0//цифра
    var sequence = 0//последовательность
    var seq = 0
    var sq = 0
    var i = 1
    while (sequence < n) {
        num++
        sq = num * num
        seq = digitNumber(sq)
        sequence += seq
    }
    num = sequence - n
    while (num != 0) {
        i *= 10
        num--
    }
    sq = sq / i % 10
    return sq
}

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
 * 1123581321345589144...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 */
fun fibSequenceDigit(n: Int): Int {
    var fib = 0
    var fib1 = 1
    var fib2 = 1
    var i = 0
    var number: String
    var string: String = "11"
    if (n <= 2) return 1
    while (string.length < n) {
        fib = fib1 + fib2
        string += fib
        fib1 = fib2
        fib2 = fib
    }
    number = string.last().toString()
    string[i]
    if (string.length == n) return number.toInt() else while (i != n) {
        i--
    }
    number = string[i - 1].toString()
    return number.toInt()
}
