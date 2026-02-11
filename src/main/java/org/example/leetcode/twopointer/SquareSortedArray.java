package org.example.leetcode.twopointer;

import java.util.Arrays;

public class SquareSortedArray {
    public static void main(String[] args) {
        int arr[] = new int[] {-2, -1, 0, 2, 3};
        int squares[] = makeSquares(arr);
        Arrays.stream(squares).forEach(System.out::print);
    }

    public static int[] makeSquares(int[] arr) {
        int n = arr.length;
        int[] squares = new int[n];
        int lp = 0, rp = n-1;
        while(lp<=rp) {
            int leftValue = arr[lp]*arr[lp];
            int rightValue = arr[rp]*arr[rp];
            if(leftValue > rightValue) {
                lp++;
                squares[n-1] = leftValue;
            }
            else{
                rp--;
                squares[n-1] = rightValue;
            }
            n--;
        }
        return squares;
    }
}
