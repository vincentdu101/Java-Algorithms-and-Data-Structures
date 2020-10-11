package com.company.Sorting;

public class QuickSort {

    private int[] input;

    public QuickSort(int[] input){
        this.input = input;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /* This function takes last element as pivot, places
       the pivot element at its correct position in sorted
        array, and places all smaller (smaller than pivot)
       to left of pivot and all greater elements to right
       of pivot */
    private int partition(int[] arr, int low, int high) {
        // pivot (element to be placed at right position
        int p = arr[high];

        // index of smaller element
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {
            // if current element is smaller than the pivot
            if (arr[j] < p) {
                i++;
                // swap arr[i] and arr[j]
                swap(arr, i, j);
            }
        }

        // swap arr[i + 1] and arr[high]
        swap(arr, i + 1, high);
        return (i + 1);
    }

    private void sort(int[] arr, int low, int high) {

        if (low < high) {

            // p is partitioning index, arr[p] is now
            // at the right place
            int p = partition(arr, low, high);

            sort(arr, low, p - 1);
            sort(arr, p + 1, high);
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
