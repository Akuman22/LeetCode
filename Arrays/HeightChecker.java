/*
Students are asked to stand in non-decreasing order of heights for an annual photo.

Return the minimum number of students that must move in order for all students to be standing in non-decreasing order of height.

Notice that when a group of students is selected they can reorder in any possible way between themselves and the non selected students remain on their seats.

 

Example 1:

Input: heights = [1,1,4,2,1,3]
Output: 3
Explanation: 
Current array : [1,1,4,2,1,3]
Target array  : [1,1,1,2,3,4]
On index 2 (0-based) we have 4 vs 1 so we have to move this student.
On index 4 (0-based) we have 1 vs 3 so we have to move this student.
On index 5 (0-based) we have 3 vs 4 so we have to move this student.
Example 2:

Input: heights = [5,1,2,3,4]
Output: 5
Example 3:

Input: heights = [1,2,3,4,5]
Output: 0
 

Constraints:

1 <= heights.length <= 100
1 <= heights[i] <= 100
*/


class Solution {
    public int heightChecker(int[] heights) {
        if(heights.length < 2) return 0;
        int changedStudents = 0;
        int sortedHeights[] = heights.clone();
        quickSort(sortedHeights, 0, sortedHeights.length - 1);
        for(int i = 0; i < heights.length; i++) {
            if(sortedHeights[i] != heights[i]) changedStudents ++;
        }
        return changedStudents;
    }
    
    private void quickSort(int[] arr, int low, int high) {
        if(low < high) {
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
            if(arr[j] > arr[high]) {
                j++;
            } else {
                i++;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
        temp = arr[i + 1];
        arr[i + 1] = arr[high ];
        arr[high] = temp;
        return i + 1;
    }
}
