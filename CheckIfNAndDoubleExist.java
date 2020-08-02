/*
Given an array arr of integers, check if there exists two integers N and M such that N is the double of M ( i.e. N = 2 * M).

More formally check if there exists two indices i and j such that :

i != j
0 <= i, j < arr.length
arr[i] == 2 * arr[j]
 

Example 1:

Input: arr = [10,2,5,3]
Output: true
Explanation: N = 10 is the double of M = 5,that is, 10 = 2 * 5.
Example 2:

Input: arr = [7,1,14,11]
Output: true
Explanation: N = 14 is the double of M = 7,that is, 14 = 2 * 7.
Example 3:

Input: arr = [3,1,7,11]
Output: false
Explanation: In this case does not exist N and M, such that N = 2 * M.
 

Constraints:

2 <= arr.length <= 500
-10^3 <= arr[i] <= 10^3
*/

class Solution {
    public boolean checkIfExist(int[] arr) {
        if(arr.length < 2) return false;
        quickSort(arr, 0, arr.length - 1);
        boolean duplicateFlag = false;
        int doubledArr[] = new int[arr.length];
        for(int i = 0; i<arr.length; i++) {
            doubledArr[i] = 2 * arr[i];
            if(arr[i] >= 0){
                for(int j = i + 1; j < arr.length; j++) {
                    if ( doubledArr[i] == arr[j] ) {
                        duplicateFlag = true;
                    }
                }
            } else {
                for(int j = 0; j < i; j++) {
                    if ( doubledArr[i] == arr[j] ) {
                        duplicateFlag = true;
                    }
                }
            }
        }
        return duplicateFlag;
    }
    
    private void quickSort(int[] arr, int low, int high) {
        if( low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }   
    }
    
    private int partition(int[] arr, int low, int high) {
        int i = low - 1;
        int j = low;
        int temp;
        while(j < high) {
            if (arr[j] < arr[high]){
                i++;
                temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            } 
            j++;
        }
        temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}
