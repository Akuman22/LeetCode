/*
Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.

 

Example 1:

Input: [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Example 2:

Input: [-7,-3,2,3,11]
Output: [4,9,9,49,121]
 

Note:

1 <= A.length <= 10000
-10000 <= A[i] <= 10000
A is sorted in non-decreasing order.
*/

class Solution {
    public int[] sortedSquares(int[] A) {
        int negLength = 0;
        int posLength = 0;
        int finalArray[] = new int[A.length];
        for (int i = 0; i<A.length; i++) {
            if(A[i] <=0) negLength +=1;
            else posLength +=1;
        }

        int negativeArray[] = new int[negLength];
        int positiveArray[] = new int[posLength];

        for (int i = 0; i<A.length; i++) {
            if(A[i] <= 0) {
                negativeArray[negLength - i - 1] = A[i] * A[i];
            } else {
                positiveArray[i - negLength] = A[i] * A[i];
            }
        }
        int i = 0;
        int j = 0;
        int k = 0;
 
        while (k < A.length) {
            if ((j >= posLength ) || (i < negLength && negativeArray[i] <= positiveArray[j])) {
                finalArray[k] = negativeArray[i];
                i++;
                k++;
            } else if (j < posLength){
                finalArray[k] = positiveArray[j];
                j++;
                k++;
            }
        }
        return finalArray;
    }
}
