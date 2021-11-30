package org.gogo.week05;

/**
 * 数组的相对排序
 * 给你两个数组，arr1 和 arr2，
 * <p>
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/relative-sort-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Redick
 * @date 2021/9/17 11:40 下午
 */
public class RelativeSortArray {

    public int[] test1(int[] arr1, int[] arr2) {
        int index = 0;
        int[] hash = new int[1001];
        // 计数
        for (int n : arr1) {
            hash[n]++;
        }
        for (int n : arr2) {
            while (hash[n] > 0) {
                arr1[index++] = n;
                hash[n]--;
            }
        }
        for (int i = 0; i < hash.length; i++) {
            while (hash[i] > 0) {
                arr1[index++] = i;
                hash[i]--;
            }
        }
        return arr1;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2,1,4,3,9,6};
        new RelativeSortArray().relativeSortArray(arr1, arr2);
    }

    /**
     * 计数法
     *
     * @param arr1
     * @param arr2
     * @return
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int i = 0;
        // 1001个槽位
        int[] hash = new int[1001];
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
