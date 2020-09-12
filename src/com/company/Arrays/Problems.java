package com.company.Arrays;

public class Problems {

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


}
