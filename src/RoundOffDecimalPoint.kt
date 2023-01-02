import java.math.RoundingMode
import java.text.DecimalFormat

class MyClass {
}

fun main() {
//    val value = 30000000
//    val result = value.toFloat()/100000
//    println("${roundOffDecimal(result)} Lakh")
    var answer = "[\"Running\",\"Strength Training\"]"
    if (answer.contains("[")) answer = answer.replace("[","")
    if (answer.contains("\"")) answer = answer.replace("\"","")
    if (answer.contains("]")) answer = answer.replace("]","")
    println(answer)
}

fun roundOffDecimal(number: Float): Double {
    val df = DecimalFormat("##.##")
    df.roundingMode = RoundingMode.CEILING
    return df.format(number).toDouble()
}