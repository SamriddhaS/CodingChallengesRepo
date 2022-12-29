import java.util.*


class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map: MutableMap<Int, Int> = HashMap()
        for (i in nums.indices) {
            val temp = target - nums[i]
            if (map.containsKey(temp)) {
                val x = IntArray(2)
                x[1] = i
                x[0] = map[temp]!!
                return x
            }
            map[nums[i]] = i
        }
        return nums
    }

}