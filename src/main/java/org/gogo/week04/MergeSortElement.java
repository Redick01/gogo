package org.gogo.week04;

import java.util.Arrays;

/**
 * @Author Redick
 * @Date 2020/11/16 11:06 下午
 */
public class MergeSortElement {

    public static void main(String[] args) {
        int[] num1 = {1,2,3,0,0,0};
        int[] num2 = {2,3,4};
        test3(num1, 3, num2, 3);
    }

    public static void test3(int[] nums1, int m, int[] nums2, int n) {
        int[] merge = new int[m + n];
        int i = 0, j = 0;
        int element = 0;
        while (i < m || j < n) {
            if (i == m) {
                element = nums2[j++];
            } else if (j == n) {
                element = nums1[j++];
            } else if (nums1[i] == nums2[j]) {
                element = nums2[j++];
            } else if (nums1[i] < nums2[j]) {
                element = nums1[i++];
            } else if (nums1[i] > nums2[j]) {
                element = nums2[j++];
            }
            merge[i + j - 1] = element;
        }
        System.arraycopy(merge, 0, nums1, 0, merge.length);
    }

    public static void test2(int[] nums1, int m, int[] nums2, int n) {
        int[] merge = new int[m + n];
        // nums1和nums2 的指针
        int i = 0, j = 0;
        int element = 0;
        while (i < m || j < n) {
            if (i == m) {
                element = nums2[j++];
            } else if (j == n) {
                element = nums1[i++];
            } else if (nums1[i] == nums2[j]) {
                element = nums2[j++];
            } else if (nums1[i] > nums2[j]) {
                element = nums2[j++];
            } else if (nums1[i] < nums2[j]) {
                element = nums1[i++];
            }
            merge[i + j - 1] = element;
        }
        System.arraycopy(merge, 0, nums1, 0, merge.length);

    }



    /**
     * 方法一：先合并数组，然后排序
     * System.arraycopy(nums2, 0, nums1, m, n);
     * Arrays.sort(nums1);
     */
    public static void plan1(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    /**
     * 双指针法
     * 1、数组nums1和nums2是有序的
     * 2、初始化一个长度为m+n的数组merge
     * 3、将nums1和nums2的头部进行比较后放入到数组中
     * 4、最后将新数组merge元素放到nums1中
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void plan2(int[] nums1, int m, int[] nums2, int n) {
        int[] merge = new int[m + n];
        int i = 0, j = 0;
        int element;
        while (i < m || j < n) {
            if (i == m) {
                element = nums2[j++];
            } else if (j == n) {
                element = nums1[i++];
            } else if (nums1[i] < nums2[j]) {
                element = nums1[i++];
            } else {
                element = nums1[j++];
            }
            merge[i + j - 1] = element;
        }
        for (int k = 0; k < merge.length; k++) {
            nums1[k] = merge[k];
        }
    }

    /**
     * 方法二 : 双指针 / 从前往后
     * 直觉
     *
     * 一般而言，对于有序数组可以通过 双指针法 达到O(n + m)的时间复杂度。
     *
     * 最直接的算法实现是将指针p1 置为 nums1的开头， p2为 nums2的开头，在每一步将最小值放入输出数组中。
     *
     * 由于 nums1 是用于输出的数组，需要将nums1中的前m个元素放在其他地方，也就需要 O(m)O(m) 的空间复杂度。
     *
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/merge-sorted-array/solution/he-bing-liang-ge-you-xu-shu-zu-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        if (nums1.length != (m + n) || nums2.length != n) {
            return;
        }
        int[] news = new int[m];
        // 将num1 拷贝到news中
        System.arraycopy(nums1, 0, news, 0, m);
        // news的指针
        int i = 0;
        // num2的指针
        int j = 0;
        // num1的指针
        int k = 0;
        while (i < m && j < n) {
            nums1[k++] = news[i] < nums2[j] ? news[i++] : nums2[j++];
        }
        // 如果news的有剩于，将剩于的num1拷贝到nums1中
        if (i < m) {
            System.arraycopy(news, i, nums1, i + j, m + n - i - j);
        }
        // 如果num2的有剩于，将剩于的num2拷贝到nums1中
        if (j < n) {
            System.arraycopy(nums2, j, nums1, i + j, m + n - i - j);
        }
    }
}
