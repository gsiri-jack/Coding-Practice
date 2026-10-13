package org.PracticeCoding.Arrays;

import java.util.Arrays;

/*

 ------- Leet code problem - 1 TWO SUM -------
*You are given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.


Input: nums = [2,7,11,15], target = 9
Output: [0,1]

Input: nums = [3,2,4], target = 6
Output: [1,2]

Input: nums = [3,3], target = 6
Output: [0,1]*
*
*
 */
public class TwoSum {


    static void main() {
        Solution solution = new Solution();
    int[] nums = {2,7,11,15};
    int[] nums1 = {2,7,11,15};
    int[] nums2 = {2,7,11,15};

        System.out.println(Arrays.toString(solution.twoSum(nums, 30)));

    }

}


class Solution {
    public int[] twoSum(int[] nums, int target) {
        //Brute Force technique
        int[] res = {-1,-1};
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i]+nums[j]==target){
                   res[0]=i;
                   res[1]=j;
                    System.out.println(nums[i]+ "- "+nums[j]);
                   return res;
                }
            }
        }

        return res;

    }

    public int[] twoSumOptimise(int[] nums, int target){
//        optimal approach is using two pointers
        return nums;
    }
}
