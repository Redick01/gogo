package org.gogo.week05;

/**
 * @author Redick
 * @date 2021/9/17 11:40 下午
 */
public class RelativeSortArray {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int i = 0;
        int [] hash = new int [1001];
        for (int n : arr1) {
            hash[n]++;
        }

        for (int n : arr2) {
            while (hash[n] > 0) {
                arr1[i++] = n;
                hash[n]--;
            }
        }

        for (int n = 0; n < hash.length; ++n) {
            while (hash[n] > 0) {
                arr1[i++] = n;
                hash[n]--;
            }
        }

        return arr1;
    }
}
