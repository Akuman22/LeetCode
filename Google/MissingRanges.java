/*
Given a sorted integer array nums, where the range of elements are in the inclusive range [lower, upper], return its missing ranges.

Example:

Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
Output: ["2", "4->49", "51->74", "76->99"]
*/

class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        ArrayList<String> retArr = new ArrayList<>();
        if(nums.length == 0) {
            addToArr(retArr, lower, upper, 3);
            return retArr;
        }
        int i = nums[0];
        int pointer = 0;
        addToArr(retArr, lower, i, 0);
        while((i < nums[nums.length - 1]) && (pointer < nums.length)) {
            if(pointer > 0 && nums[pointer] == nums[pointer - 1]) {
                pointer++;
                continue;
            }
            if(nums[pointer] != i) {
                addToArr(retArr, i, nums[pointer], 2);
                i = nums[pointer] + 1;
                pointer++;
                continue;
            }
            i++;
            pointer++;
        }
        addToArr(retArr, nums[nums.length - 1], upper, 1);
        return retArr;
    }
    
    private void addToArr(ArrayList<String> arr, int bottom, int top, int dir) {
        if(top == bottom) {
            if(dir == 3) {
                arr.add(String.valueOf(bottom));
            }
            return;
        }
        if((top - bottom) != 1) {
            if(dir == 0) {
                arr.add(String.valueOf(bottom) + "->" + String.valueOf(top - 1));
            } else if(dir == 1) {
                arr.add(String.valueOf(bottom + 1) + "->" + String.valueOf(top));
            } else if(dir == 2) { 
                arr.add(String.valueOf(bottom) + "->" + String.valueOf(top - 1));
            } else arr.add(String.valueOf(bottom) + "->" + String.valueOf(top));
        } else {
            if(dir == 0 || dir == 2) {
                arr.add(String.valueOf(bottom));
            } else arr.add(String.valueOf(top));
        }
    }
}
