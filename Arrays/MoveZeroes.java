/*
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.
*/

class Solution {
    public void moveZeroes(int[] nums) {
        if(nums.length < 2) return;
        int i = 0;
        int j;
        while(i < nums.length - 1) {
            if(nums[i] == 0){
                j = i + 1;
                while(nums[j] == 0) {
                    j ++;
                    if (j == nums.length) return;
                }
                nums[i] = nums[j];
                nums[j] = 0;
            }
            i++;
        }
        return;
    }
}
