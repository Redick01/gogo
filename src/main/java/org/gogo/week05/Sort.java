package org.gogo.week05;

/**
 * @author liupenghui
 * @date 2020/12/22 12:22 上午
 */
public class Sort {

    public static void main(String[] args) {
        int[] array = {2, 3, 4, 1, 423, 21, 41, 45, 78};
        new Sort().selectSort(array);
    }

    /**
     * 快速排序
     * @param n
     * @param left
     * @param right
     */
    public static void quickSort(int[] n,int left,int right) {
        int dp;
        if (left < right) {
            dp = partition(n, left, right);
            quickSort(n, left, dp - 1);
            quickSort(n, dp + 1, right);
        }
    }

    public static int partition(int n[], int left, int right) {
        int pivot = n[left];
        while (left < right) {
            while (left < right && n[right] >= pivot)
                right--;
            if (left < right)
                n[left++] = n[right];
            while (left < right && n[left] <= pivot)
                left++;
            if (left < right)
                n[right--] = n[left];
        }
        n[left] = pivot;
        return left;
    }

    /**
     * 计数排序
     * @param n
     * @return
     */
    public static int[] countingSort(int[] n) {
        // 找到待排序数组中最大值
        int max = Integer.MIN_VALUE;
        for (int a : n) {
            max = Math.max(max, a);
        }
        // 创建中间数组，数组长度最大值+1
        int[] count = new int[max + 1];
        for (int a : n) {
            count[a]++;
        }
        // 创建结果数组
        int[] result = new int[n.length];
        // 创建结果数组的起始索引
        int index = 0;
        // 遍历计数数组，将计数数组的索引填充到结果数组中
        for (int i=0; i<count.length; i++) {
            while (count[i]>0) {
                result[index++] = i;
                count[i]--;
            }
        }
        // 返回结果数组
        return result;
    }

    /**
     * 优化后的计数排序
     * @param n
     * @return
     */
    public static int[] countingSort2(int[] n) {
        // 找到待排序数组中最大值
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int a : n) {
            max = Math.max(max, a);
            min = Math.min(min, a);
        }
        // 创建中间数组，数组长度最大值+1
        int[] count = new int[max - min + 1];
        for (int a : n) {
            count[a - min]++;
        }
        // 创建结果数组
        int[] result = new int[n.length];
        // 创建结果数组的起始索引
        int index = 0;
        // 遍历计数数组，将计数数组的索引填充到结果数组中
        for (int i=0; i<count.length; i++) {
            while (count[i]>0) {
                result[index++] = i + min;
                count[i]--;
            }
        }
        // 返回结果数组
        return result;
    }


    public void maoPao(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = 0;
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int preIndex = i - 1;
            int current = array[i];
            while (preIndex >= 0 && array[preIndex] > current) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
    }

    public void selectSort(int[] array) {
        int temp = 0;
        int minIndex = 0;
        for (int i = 0; i < array.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }
}
