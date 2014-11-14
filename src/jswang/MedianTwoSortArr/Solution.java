package jswang.MedianTwoSortArr;

/**
 * Created by willwjs on 11/13/14.
 */
public class Solution {
    private double findKthSortedArrays(int A[], int B[], int starta, int startb, int k){
        if (k == 1) return A[starta] < B[startb] ? A[starta] : B[startb];
        if ((A.length - starta) > (B.length - startb)) //Assume A is shorter
            return findKthSortedArrays(B, A, startb, starta, k);
        int ka = k / 2;
        if (A.length - starta < ka)
            ka = A.length - starta;
        int kb = k - ka;

        if (A[starta + ka - 1] < B[startb + kb - 1])
            return findKthSortedArrays(A, B, starta + ka, startb, k - ka);
        else
            return findKthSortedArrays(A, B, starta, startb + kb, k - kb);
    }

    public double findMedianSortedArrays(int A[], int B[]) {
        int num = A.length + B.length;
        if (num % 2 == 0)
            return (findKthSortedArrays(A, B, 0, 0, num / 2)
                    + findKthSortedArrays(A, B, 0, 0, (num + 1) / 2)) / 2.0;
        else
            return findKthSortedArrays(A, B, 0, 0, (num + 1) / 2);
    }
}
