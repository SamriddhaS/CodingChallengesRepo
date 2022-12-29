
fun main(){

    margeSortedArray(intArrayOf(1,3,6,7,9), intArrayOf(1,2,2,4,8)).forEach {
        println(it)
    }
}

fun margeSortedArray(array1: IntArray,array2: IntArray):IntArray{
    val sizeOfArray = if (array1.size>array2.size) array1.size else array2.size
    var result = IntArray(array1.size+array2.size)
    var currentPos=0
    for (i in 0 until sizeOfArray){
        if (array1[i]<=array2[i]){
            result[currentPos]=array1[i]
            currentPos++
            result[currentPos]=array2[i]
            currentPos++
        }else{
            result[currentPos]=array2[i]
            currentPos++
            result[currentPos]=array1[i]
            currentPos++
        }
    }

    return result
}
/*
* 5 jars - 100 tabs
* 4 jars - 10 gm / each
* 1 jar - 9 gram / each
*
* */