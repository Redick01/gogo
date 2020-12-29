package org.gogo.week05;

/**
 * @author liupenghui
 * @date 2020/12/22 12:22 上午
 */
public class Sort {

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
}
