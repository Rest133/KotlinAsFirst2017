@file:Suppress("UNUSED_PARAMETER")

package lesson4.task1

import lesson1.task1.discriminant
import lesson1.task1.sqr
import lesson3.task1.digitNumber
import lesson3.task1.isPrime
import lesson3.task1.minDivisor
import java.lang.Math.pow
import java.lang.Math.sqrt

/**
 * Пример
 *
 * Найти все корни уравнения x^2 = y
 */
fun sqRoots(y: Double) =
        when {
            y < 0 -> listOf()
            y == 0.0 -> listOf(0.0)
            else -> {
                val root = Math.sqrt(y)
                // Результат!
                listOf(-root, root)
            }
        }

/**
 * Пример
 *
 * Найти все корни биквадратного уравнения ax^4 + bx^2 + c = 0.
 * Вернуть список корней (пустой, если корней нет)
 */
fun biRoots(a: Double, b: Double, c: Double): List<Double> {
    if (a == 0.0) {
        return if (b == 0.0) listOf()
        else sqRoots(-c / b)
    }
    val d = discriminant(a, b, c)
    if (d < 0.0) return listOf()
    if (d == 0.0) return sqRoots(-b / (2 * a))
    val y1 = (-b + Math.sqrt(d)) / (2 * a)
    val y2 = (-b - Math.sqrt(d)) / (2 * a)
    return sqRoots(y1) + sqRoots(y2)
}

/**
 * Пример
 *
 * Выделить в список отрицательные элементы из заданного списка
 */
fun negativeList(list: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (element in list) {
        if (element < 0) {
            result.add(element)
        }
    }
    return result
}

/**
 * Пример
 *
 * Изменить знак для всех положительных элементов списка
 */
fun invertPositives(list: MutableList<Int>) {
    for (i in 0 until list.size) {
        val element = list[i]
        if (element > 0) {
            list[i] = -element
        }
    }
}

/**
 * Пример
 *
 * Из имеющегося списка целых чисел, сформировать список их квадратов
 */
fun squares(list: List<Int>) = list.map { it * it }

/**
 * Пример
 *
 * По заданной строке str определить, является ли она палиндромом.
 * В палиндроме первый символ должен быть равен последнему, второй предпоследнему и т.д.
 * Одни и те же буквы в разном регистре следует считать равными с точки зрения данной задачи.
 * Пробелы не следует принимать во внимание при сравнении символов, например, строка
 * "А роза упала на лапу Азора" является палиндромом.
 */
fun isPalindrome(str: String): Boolean {
    val lowerCase = str.toLowerCase().filter { it != ' ' }
    for (i in 0..lowerCase.length / 2) {
        if (lowerCase[i] != lowerCase[lowerCase.length - i - 1]) return false
    }
    return true
}

/**
 * Пример
 *
 * По имеющемуся списку целых чисел, например [3, 6, 5, 4, 9], построить строку с примером их суммирования:
 * 3 + 6 + 5 + 4 + 9 = 27 в данном случае.
 */
fun buildSumExample(list: List<Int>) = list.joinToString(separator = " + ", postfix = " = ${list.sum()}")

/**
 * Простая
 *
 * Найти модуль заданного вектора, представленного в виде списка v,
 * по формуле abs = sqrt(a1^2 + a2^2 + ... + aN^2).
 * Модуль пустого вектора считать равным 0.0.
 */
fun abs(v: List<Double>): Double {
    var Abs = 0.0
    for (i in 0 until v.size)
        Abs += sqr(v[i])
    return sqrt(Abs)
}

/**
 * Простая
 *
 * Рассчитать среднее арифметическое элементов списка list. Вернуть 0.0, если список пуст
 */
fun mean(list: List<Double>): Double = if (list.size == 0) 0.0 else list.sum() / list.size

/**
 * Средняя
 *
 * Центрировать заданный список list, уменьшив каждый элемент на среднее арифметическое всех элементов.
 * Если список пуст, не делать ничего. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun center(list: MutableList<Double>): MutableList<Double> {
    var mean1 = mean(list)
    for (i in 0 until list.size) {
        list[i] -= mean1
    }
    return list
}

/**
 * Средняя
 *
 * Найти скалярное произведение двух векторов равной размерности,
 * представленные в виде списков a и b. Скалярное произведение считать по формуле:
 * C = a1b1 + a2b2 + ... + aNbN. Произведение пустых векторов считать равным 0.0.
 */
fun times(a: List<Double>, b: List<Double>): Double {
    var C = 0.0
    for (i in 0 until a.size)
        C += a[i] * b[i]
    return C

}

/**
 * Средняя
 *
 * Рассчитать значение многочлена при заданном x:
 * p(x) = p0 + p1*x + p2*x^2 + p3*x^3 + ... + pN*x^N.
 * Коэффициенты многочлена заданы списком p: (p0, p1, p2, p3, ..., pN).
 * Значение пустого многочлена равно 0.0 при любом x.
 */
fun polynom(p: List<Double>, x: Double): Double {
    var P = 0.0
    for (i in 0 until p.size)
        P += p[i] * pow(x, i.toDouble())

    return P
}

/**
 * Средняя
 *
 * В заданном списке list каждый элемент, кроме первого, заменить
 * суммой данного элемента и всех предыдущих.
 * Например: 1, 2, 3, 4 -> 1, 3, 6, 10.
 * Пустой список не следует изменять. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun accumulate(list: MutableList<Double>): MutableList<Double> {
    var sum = 0.0
    for (i in 0 until list.size) {
        sum += list[i]
        list[i] = sum
    }
    return list
}

/**
 * Средняя
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде списка множителей, например 75 -> (3, 5, 5).
 * Множители в списке должны располагаться по возрастанию.
 */
fun factorize(n: Int): List<Int> {
    var N = n
    val m = mutableListOf<Int>()
    while (!isPrime(N)) {
        var d = minDivisor(N)
        m += d
        N /= d
    }
    m += N
    m.sorted()
    return m
}

/**
 * Сложная
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде строки, например 75 -> 3*5*5
 */
fun factorizeToString(n: Int): String = factorize(n).joinToString(separator = "*")

/**
 * Средняя
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием base > 1.
 * Результат перевода вернуть в виде списка цифр в base-ичной системе от старшей к младшей,
 * например: n = 100, base = 4 -> (1, 2, 1, 0) или n = 250, base = 14 -> (1, 3, 12)
 */
fun convert(n: Int, base: Int): List<Int> = TODO()

/**
 * Сложная
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием 1 < base < 37.
 * Результат перевода вернуть в виде строки, цифры более 9 представлять латинскими
 * строчными буквами: 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: n = 100, base = 4 -> 1210, n = 250, base = 14 -> 13c
 */
fun convertToString(n: Int, base: Int): String = TODO()

/**
 * Средняя
 *
 * Перевести число, представленное списком цифр digits от старшей к младшей,
 * из системы счисления с основанием base в десятичную.
 * Например: digits = (1, 3, 12), base = 14 -> 250
 */
fun decimal(digits: List<Int>, base: Int): Int {
    var number = 0.0
    var sqr = digits.size - 1
    for (i in 0 until digits.size - 1) {
        number += digits[i] * pow(base.toDouble(), sqr.toDouble())
        sqr--
    }
    number += digits.last()
    return number.toInt()
}

/**
 * Сложная
 *
 * Перевести число, представленное цифровой строкой str,
 * из системы счисления с основанием base в десятичную.
 * Цифры более 9 представляются латинскими строчными буквами:
 * 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: str = "13c", base = 14 -> 250
 */
fun decimalFromString(str: String, base: Int): Int {
    TODO()
}

/**
 * Сложная
 *
 * Перевести натуральное число n > 0 в римскую систему.
 * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
 * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
 * Например: 23 = XXIII, 44 = XLIV, 100 = C
 */
fun roman(n: Int): String {
    var number = ""
    var N = n
    N /= 1000
    while (N != 0) {
        number += 'M'
        N--
    }
    N = n % 1000
    when {
        N / 100 == 9 -> number += "CM"
        N / 100 == 8 -> number += "DCCC"
        N / 100 == 7 -> number += "DCC"
        N / 100 == 6 -> number += "DC"
        N / 100 == 5 -> number += "D"
        N / 100 == 4 -> number += "CD"
        N / 100 == 3 -> number += "CCC"
        N / 100 == 2 -> number += "CC"
        N / 100 == 1 -> number += "C"
    }
    N = n % 100
    when {
        N / 10 == 9 -> number += "XC"
        N / 10 == 8 -> number += "LXXX"
        N / 10 == 7 -> number += "LXX"
        N / 10 == 6 -> number += "LX"
        N / 10 == 5 -> number += "L"
        N / 10 == 4 -> number += "XL"
        N / 10 == 3 -> number += "XXX"
        N / 10 == 2 -> number += "XX"
        N / 10 == 1 -> number += "X"
    }
    N = n % 10
    when {
        N == 9 -> number += "IX"
        N == 8 -> number += "VIII"
        N == 7 -> number += "VII"
        N == 6 -> number += "VI"
        N == 5 -> number += "V"
        N == 4 -> number += "IV"
        N == 3 -> number += "III"
        N == 2 -> number += "II"
        N == 1 -> number += "I"
    }

    return number
}

/**
 * Очень сложная
 *
 * Записать заданное натуральное число 1..999999 прописью по-русски.
 * Например, 375 = "триста семьдесят пять",
 * 23964 = "двадцать три тысячи девятьсот шестьдесят четыре"
 */
fun russian(n: Int): String {
    val numbers = listOf(" ", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять")
    val tens = listOf(" ", "десять ", "двадцать ", "тридцать ", "сорок ",
            "пятьдесят ", "шестьдесят ", "семьдесят ", "восемьдесят ", "девяносто ")
    val eleven = listOf("десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать",
            "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать")
    val hundred = listOf(" ", " сто ", " двести ", " триста ", " четыреста ", " пятьсот ", " шестьсот ", " семьсот ", " восемьсот ", " девятьсот ")
    val thousands = listOf(" ", "одна", "две", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять")
    val thousand = listOf(" тысяча ", " тысячи ", " тысяч ")
    var N = ""
    var k = n / 1000
    when {
        k % 100 in 10 until 20 -> N += hundred[n / 100000] + eleven[k % 10] + thousand[2]
        else -> if (k % 10 == 1) N += hundred[n / 100000] + tens[k % 100 / 10] + thousands[k % 10] + thousand[0]
        else if (k % 10 == 2 || k % 10 == 3 || k % 10 == 4) N += hundred[n / 100000] + tens[k % 100 / 10] + thousands[k % 10] + thousand[1]
        else
            N += hundred[n / 100000] + tens[k % 100 / 10] + thousands[k % 10] + thousand[2]
    }
    N = N.trim()
    when {N == "тысяч" || N == "тысяч" || N == "тысяч" -> N = ""
    }
    k = n % 1000
    when {
        k % 100 in 10 until 20 -> N += hundred[n % 1000 / 100] + eleven[k % 10]
        else -> N += hundred[n % 1000 / 100] + tens[k % 100 / 10] + numbers[k % 10]
    }
    N = N.trim().replace("  ", " ")
    N = N.replace("  ", " ")
    return N
}
