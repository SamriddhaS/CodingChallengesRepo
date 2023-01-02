
fun main(){
    margeSortedArray(intArrayOf(1,3,6,7,99), intArrayOf(1,2,22,44)).forEach {
        println(it)
    }
}

fun margeSortedArray(array1: IntArray,array2: IntArray):IntArray{
    var result = IntArray(array1.size+array2.size)
    var currentPos1=0
    var currentPos2=0
    var newPos = 0
    for (i in result.indices){
        if (currentPos1>array1.size-1) {
            for (j in currentPos2 until array2.size){
                result[newPos]=array2[j]
                newPos++
            }
        }else if (currentPos2>array2.size-1) {
            for (j in currentPos1 until array1.size){
                result[newPos]=array1[j]
                newPos++
            }
        }else if (array1[currentPos1]<=array2[currentPos2]){
            result[newPos]=array1[currentPos1]
            currentPos1++
            newPos++
        }else{
            result[newPos]=array2[currentPos2]
            currentPos2++
            newPos++
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