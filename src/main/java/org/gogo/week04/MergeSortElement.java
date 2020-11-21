package org.gogo.week04;

/**
 * @Author Redick
 * @Date 2020/11/16 11:06 下午
 */
public class MergeSortElement {

    public static void main(String[] args) {
        int[] num1 = {1,2,3,0,0,0};
        int[] num2 = {2,3,4};
        merge(num1, 3, num2, 3);
    }



    /**
     * 方法一：先合并数组，然后排序
     * System.arraycopy(nums2, 0, nums1, m, n);
     * Arrays.sort(nums1);
     *
     * 方法二 : 双指针 / 从前往后
     * 直觉
     *
     * 一般而言，对于有序数组可以通过 双指针法 达到O(n + m)O(n+m)的时间复杂度。
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
