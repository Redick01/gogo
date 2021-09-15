package org.gogo.week05;

/**
 * @author Redick
 * @date 2021/9/15 11:23 下午
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] array = {2, 3, 4, 1, 423, 21, 41, 45, 78};
        new MergeSort().sort(array);
    }

    public void sort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    public void mergeSort(int[] array, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int mid = (begin + end) >> 1;
        mergeSort(array, begin, mid);
        mergeSort(array, mid + 1, end);
        merge(array, begin, mid, end);
    }

    private void merge(int[] array, int begin, int mid, int end) {
        // 临时数组
        int[] temp = new int[end - begin + 1];
        int i = begin, j = mid + 1, k = 0;
        while (i <= mid && j <= end) {
            temp[k++] = array[i] <= array[j] ? array[i++] : array[j++];
        }
        while (i <= mid) {
            temp[k++] = array[i++];
        }
        while (j <= end) {
            temp[k++] = array[j++];
        }
        System.arraycopy(temp, 0, array, begin, temp.length);
    }
}
