package com.company.Sorting;

public class SelectionSort {

    private int[] input;

    public SelectionSort(int[] input){
        this.input = input;
    }

    public int[] sortArray() {

        // one by one move boundary of unsorted subarray
        for (int i = 0; i < input.length; i++) {

            // find the minimum element in unsorted array
            int minIdx = i;
            for (int j = i + 1; j < input.length; j++) {

                if (input[j] < input[minIdx]) {
                    minIdx = j;
                }

            }


            // swap the found minimum element with the first element
            int temp = input[minIdx];
            input[minIdx] = input[i];
            input[i] = temp;
        }

        return input;
    }

    public void printArray() {
        for (int val : input) {
            System.out.println(val);
        }
    }


}
