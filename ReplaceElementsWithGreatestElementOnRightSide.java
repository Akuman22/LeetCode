/*
Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.

After doing so, return the array.

 

Example 1:

Input: arr = [17,18,5,4,6,1]
Output: [18,6,6,6,1,-1]
 

Constraints:

1 <= arr.length <= 10^4
1 <= arr[i] <= 10^5
*/

class Solution {
    public int[] replaceElements(int[] arr) {
        int greatestIndex;
        for(int i = 0; i < arr.length - 1; i++) {
            greatestIndex = i + 1;
            for(int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[greatestIndex]) {
                    greatestIndex = j;
                }
            }
            arr[i] = arr[greatestIndex];
        }
        arr[arr.length - 1] = -1;
        return arr;
    }
}
