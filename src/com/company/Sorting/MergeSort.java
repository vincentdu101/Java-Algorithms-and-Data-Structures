package com.company.Sorting;

public class MergeSort {

    private int[] input;

    public MergeSort(int[] input){
        this.input = input;
    }

    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    private void merge(int[] arr, int l, int m, int r) {

        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // create temp arrs
        int L[] = new int[n1];
        int R[] = new int[n2];

        // copy data to temp arrays
        for (int i = 0; i < n1; i++) {
            L[i] = arr[l + i];
        }

        for (int i = 0; i < n2; i++) {
            R[i] = arr[m + 1 + i];
        }

        // merge the temp arrays
        // initial indexes of first and second subarrays
        // keeps track of the left and right temp arrays
        int i = 0, j = 0;

        // initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {

            // check if left is smaller than right
            // put the one that is smaller into the
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    private void sort(int[] arr, int l, int r) {
        if (l < r) {
            // find the middle point
            int m = (l + r) / 2;

            // sort the first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    public int[] sortArray() {
        sort(input, 0, input.length - 1);
        return input;
    }

    public void printArray() {
        for (int val : input) {
            System.out.println(val);
        }
    }

}
