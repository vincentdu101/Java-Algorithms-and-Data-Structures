package com.company.Arrays;

public class BasicProblems {

    /*
        Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the remaining elements to the right.
        Note that elements beyond the length of the original array are not written.
        Do the above modifications to the input array in place, do not return anything from your function.

        Example 1:
        Input: [1,0,2,3,0,4,5,0]
        Output: null
        Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]

        Example 2:
        Input: [1,2,3]
        Output: null
        Explanation: After calling your function, the input array is modified to: [1,2,3]
    */
    public void duplicateZeros(int[] arr) {
        // copy over the original elements into a new array so we can
        // change it freely without impacting the input array
        int[] arr_copy = new int[arr.length];
        int copy_index = 0;
        
        // as we go through each element copy over elements into the 
        // copy array and duplicate with 0 as needed
        for (int i = 0; i < arr.length && copy_index < arr.length; i++) {
            if (arr[i] == 0) {
                arr_copy[copy_index] = 0;

                // keep a separate index for the copy array so we know when
                // we've reached the limit
                if (copy_index + 1 < arr_copy.length) {
                    arr_copy[copy_index + 1] = 0;
                    copy_index++;   
                }
            } else {
                arr_copy[copy_index] = arr[i];
            }
            copy_index++;
        }
        
        // override the original array with the copy array once
        // we've finalized the expected input since we aren't
        // returning anything and instead updating it in place
        for (int i = 0; i < arr_copy.length; i++) {
            arr[i] = arr_copy[i];
        }
        
    }

    /*

        Given an array nums and a value val, remove all instances of that value in-place and return the new length.
        Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
        The order of elements can be changed. It doesn't matter what you leave beyond the new length.

        Example 1:

        Given nums = [3,2,2,3], val = 3,
        Your function should return length = 2, with the first two elements of nums being 2.
        It doesn't matter what you leave beyond the returned length.
        
        Example 2:

        Given nums = [0,1,2,2,3,0,4,2], val = 2,
        Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4.
        Note that the order of those five elements can be arbitrary.

        It doesn't matter what values are set beyond the returned length.
        
        Clarification:

        Confused why the returned value is an integer but your answer is an array?
        Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.
        Internally you can think of this:

        // nums is passed in by reference. (i.e., without making a copy)
        int len = removeElement(nums, val);

        // any modification to nums in your function would be known by the caller.
        // using the length returned by your function, it prints the first len elements.
        for (int i = 0; i < len; i++) {
            print(nums[i]);
        }

    */
    public int removeElement(int[] nums, int val) {
        
        int[] copy = new int[nums.length];
        int count = 0;
        int size = 0;
        
        // save a copy of the original input into a new array, 
        // but only save the values that is the value we want
        // to remove
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                // use two separate indexes to point to the 
                // copy index and to keep the new size
                copy[count] = nums[i];  
                count++;
                size++;
            }
        }
        
        // resave the copy values to the original input to 
        // override it
        for (int i = 0; i < nums.length; i++) {
            nums[i] = copy[i];
        }
        
        return size;
    }

    /*
        Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
        The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.

        Note:
        Your returned answers (both index1 and index2) are not zero-based.
        You may assume that each input would have exactly one solution and you may not use the same element twice.
        

        Example 1:
        Input: numbers = [2,7,11,15], target = 9
        Output: [1,2]
        Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
    */
    public int[] twoSum(int[] numbers, int target) {
        int lo = 0, hi = numbers.length - 1;
        while (lo < hi) {
            int curSum = numbers[lo] + numbers[hi];
            if (curSum == target) {
                return new int[]{lo + 1, hi + 1};
            } else if (curSum > target) {
                hi--;
            } else {
                lo++;
            }
        }
        return new int[]{-1, -1};
    }


}
