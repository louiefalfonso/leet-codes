/* 
Duplicate Integer
Given an integer array nums, return true if any value appears more than once in the array, 
otherwise return false.


Input: nums = [1, 2, 3, 3]
Output: true

*/

class Solution {
  /**
   * @param {number[]} nums
   * @return {boolean}
   */
  hasDuplicate(nums) {
    return new Set(nums).size !== nums.length;
  }
}

class Solution {
  
  hasDuplicate(nums) {
    const numsSet = new Set();
    for (const num of nums) {
      if (numsSet.has(num)) return true;

      numsSet.add(num);
    }

    return false;
  }
}