class TestClass {

}

fun main() {
    val inputs = arrayListOf("test.email+alex@leetcode.com"
        ,"test.e.mail+bob.cathy@leetcode.com"
        ,"testemail+david@lee.tcode.com"
    )

    val result = inputs.map {
        val index = getIndexOfAtTheRete(it)
        val localName = it.substring(0,index).replace(".","")
        val domainName = it.substring(index)
        val output = getLocalNameWithoutPlus(localName)
        "$output$domainName"
    }

    println(result)

//    val secondString = "test.e.mail+bob.cathy@leetcode.com"
//    val index = getIndexOfAtTheRete(secondString)
//    val localName = secondString.substring(0,index)
//    println(localName)
//    val result = getLocalNameWithoutPlus(localName)
//    println(result)

}

fun getIndexOfAtTheRete(string: String):Int{
    var index = 0
    for (i in string){
        if (i=='@'){
            break
        }
        index++
    }
    return index
}

fun getLocalNameWithoutPlus(string: String):String{
    var output=""
    for (i in string){
        if (i=='+') break
        output = "$output$i"
    }
    return output
}