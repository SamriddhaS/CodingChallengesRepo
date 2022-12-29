import java.util.*
import kotlin.collections.HashMap

fun main(){
//    val input = "Ssamrddhhaa"
//    val output = countNumOfChar(input)
//    print(output)

//    val intArray = intArrayOf(1,2,4,5,6,7)
//    val output = sumOfTwo(intArray,9)
//    output.forEach {
//        println(it)
//    }

//    val intArray = intArrayOf(4,2,5,2,9,3,19,1,2,5)
//    val output = bestProfitFun(intArray)
//    print(output)

    //println(isValid("[{(})]"))

//    val intArray = intArrayOf(5,4,-1,7,8)
//    val output = maxSumSubArray(intArray)
//    print(output)

//    print(palindromOrNot("bblbb"))


    moveZero(intArrayOf(0,2,1,0,22,34,1,0,9)).forEach {
        println(it)
    }

}

/*
* Given a string = "Ssamrddhhaa"
* Write a program to find out occurence of each char inside that string.
* Out put {a=3, r=1, S=1, s=1, d=2, h=2, m=1}
*
* */
fun countNumOfChar(input:String):HashMap<Char,Int>{
    var hashMap = HashMap<Char,Int>()
    input.forEach {
        if (hashMap.containsKey(it)){
            var num = hashMap[it]?:1
            num++
            hashMap[it] = num
        }else{
            hashMap[it] = 1
        }
    }
    return hashMap
}


/*
* 1) Two Sum
* Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
*
* Input: nums = [2,7,11,15], target = 9
* Output: [0,1]
* Output: Because nums[0] + nums[1] == 9, we return [0, 1].
*
* */
fun sumOfTwo(numbers:IntArray,target:Int):IntArray{
    val map = HashMap<Int,Int>()
    numbers.forEachIndexed { index, i ->
        val sub = target-i
        if (map.containsKey(sub)){
            val result=IntArray(2)
            result[0] = map[sub]?:-1
            result[1] = index
            return result
        }
        map[i] = index
    }
    return numbers
}

/*
* 2. Best Time to Buy and Sell Stock
*
* You are given an array prices where prices[i] is the price of a given stock on the ith day.
* Input: prices = [7,1,5,3,6,4]
* Output: 5
* Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
* Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
* You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
* Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0
* */
fun bestProfitFun(prices:IntArray):Int{
    var maxProfit = 0
    var minPrice = Int.MAX_VALUE
    prices.forEach {
        if (it<minPrice) minPrice=it
        if (it-minPrice>=maxProfit) maxProfit = it-minPrice
    }
    return maxProfit
}


/*
* 3. Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
* An input string is valid if:
* Open brackets must be closed by the same type of brackets.
* Open brackets must be closed in the correct order.
* Every close bracket has a corresponding open bracket of the same type.
* */

fun isValid(s: String): Boolean {
    val stack = Stack<Char>()
    for (c in s.toCharArray()) {
        if (c == '(') stack.push(')')
        else if (c == '{') stack.push('}')
        else if (c == '[') stack.push(']')
        else if (stack.isEmpty() || stack.pop() != c) return false
    }
    return stack.isEmpty()
}

/*
* 4. Maximum Subarray
*
* Given an integer array nums, find the subarray
* which has the largest sum and return its sum.
*
* Example 1:
* Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
* Output: 6
* Explanation: [4,-1,2,1] has the largest sum = 6.
*
* Example 2:
* Input: nums = [1]
* Output: 1
*
* Example 3:
* Input: nums = [5,4,-1,7,8]
* Output: 23
* */
fun maxSumSubArray(prices:IntArray):Int{
    var maxSum = 0
    var currentSum = 0
    prices.forEach {
        currentSum += it
        if (currentSum>maxSum) maxSum = currentSum
        if (currentSum<0) currentSum=0
    }
    return maxSum
}


/*
* Check if a Sting is palindrom or not.
* */
fun palindromOrNot(input:String):Boolean{
    input.forEachIndexed { index, c ->
        if (input[index]!=input[(input.length-1)-index]) return false
    }
    return true
}

/*
* 9) Move Zeroes
* Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
* Note that you must do this in-place without making a copy of the array.
* Input: nums = [0,1,0,3,12]
* Output: [1,3,12,0,0]
* */
fun moveZero(numbers: IntArray):IntArray{
    var current = 0
    numbers.forEach {
        if (it!=0){
            numbers[current] = it
            current++
        }
    }
    for(i in current until numbers.size){
        numbers[i] = 0
    }
    return numbers
}