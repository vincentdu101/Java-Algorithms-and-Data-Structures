package com.company.Sorting;

public class BubbleSort {

    private int[] input;

    public BubbleSort(int[] input){
        this.input = input;
    }

    public int[] sortArray() {

        int n = input.length;

        for (int i = 0; i < n; i++) {

            // we check all of the elements and slowly
            // with each step check less as we are sorting
            // the larger elements to the back
            for (int j = 0; j < n - i - 1; j++) {
                // we swap the values if one is larger than the other
                if (input[j] > input[j + 1]) {
                    int temp = input[j];
                    input[j] = input[j + 1];
                    input[j + 1] = temp;
                }
            }

        }

        return input;
    }

    public void printArray() {
        for (int val : input) {
            System.out.println(val);
        }
    }


}
