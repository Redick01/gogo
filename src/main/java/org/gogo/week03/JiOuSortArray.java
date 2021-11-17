package org.gogo.week03;

/**
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 *
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 *
 * 你可以返回任何满足上述条件的数组作为答案。
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-array-by-parity-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class JiOuSortArray {


    public static void main(String[] args) {
        int[] A = {4,2,5,7};
        int[] B = sortArrayByParityII(A);
        for (int b : B) {
            System.out.println(b);
        }
    }

    public static int[] sortJO(int[] arrays) {
        int[] result = new int[arrays.length];
        // 偶数
        int index = 0;
        for (int a : arrays) {
            if (a % 2 == 0) {
                result[index] = a;
                index += 2;
            }
        }
        // 奇数
        index = 1;
        for (int a : arrays) {
            if (a % 2 == 1) {
                result[index] = a;
                index += 2;
            }
        }
        return result;
    }

    public static int[] sortArrayByParityII(int[] A) {

        int[] result = new int[A.length];
        // 偶数
        int index = 0;
        for (int a : A) {
            if (a % 2 == 0) {
                result[index] = a;
                index += 2;
            }
        }
        // 奇数
        index = 1;
        for (int a : A) {
            if (a % 2 == 1) {
                result[index] = a;
                index += 2;
            }
        }
        return result;
    }
}
