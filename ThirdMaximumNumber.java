/*
Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).

Example 1:
Input: [3, 2, 1]

Output: 1

Explanation: The third maximum is 1.
Example 2:
Input: [1, 2]

Output: 2

Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
Example 3:
Input: [2, 2, 3, 1]

Output: 1

Explanation: Note that the third maximum here means the third maximum distinct number.
Both numbers with value 2 are both considered as second maximum.
*/

class Solution {
    public int thirdMax(int[] nums) {
        if(nums.length == 1) return nums[0];
        int maxNumber = nums[0];
        int secondMaxNumber = 0;
        int thirdMaxNumber = 0;
        int sFlag = 0;
        int tFlag = 0;
        for(int element : nums){
            if(element > maxNumber) {
                if(sFlag == 1){
                    thirdMaxNumber = secondMaxNumber;
                    tFlag = 1;
                }
                secondMaxNumber = maxNumber;
                maxNumber = element; 
                sFlag = 1;
            } else if(element < maxNumber) {
                if((sFlag == 0) || (element > secondMaxNumber)) {
                    if(sFlag == 1){
                        thirdMaxNumber = secondMaxNumber;
                        tFlag = 1;
                    }
                    thirdMaxNumber = secondMaxNumber;
                    secondMaxNumber = element;
                    sFlag = 1;
                } else if(element < secondMaxNumber) {
                    if((tFlag == 0) || (element > thirdMaxNumber)) {
                    thirdMaxNumber = element;
                    tFlag = 1;
                    }
                }
            }
        }
        if((sFlag == 0) || (tFlag == 0)) return maxNumber;
        return thirdMaxNumber;
    }
}
