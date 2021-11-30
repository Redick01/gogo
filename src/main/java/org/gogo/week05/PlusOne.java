package org.gogo.week05;

/**
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *示例 1：
 *
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * 示例 2：
 *
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 * 示例 3：
 *
 * 输入：digits = [0]
 * 输出：[1]
 *  
 *
 * 提示：
 *
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author Redick
 * @Date 2020/11/24 11:07 下午
 */
public class PlusOne {

    public static int[] plusOne1(int[] digits) {
        for (int i = digits.length - 1; i >=0 ; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    /**
     * 太巧妙了
     * 因为元素就是1-9，所以+1最大是10
     * digits[i]++; 算出元素+1值
     * digits[i] = digits[i] % 10; 如果等于10 元素值是0，继续循环，如果不是0，那说明没到10，不用进1，结束计算返回数组
     * digits = new int[digits.length + 1]; 走到这里说明每一位都进行了+1，所以最终数组长度要+1，因为进位了
     * digits[0] = 1; 最后进位完第一位必然是1
     * 例如 9，9，9 返回 1，0，0，0
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        int[] digits = plusOne1(new int[]{9,9,9});
        for (int i : digits) {
            System.out.println(i);
        }
    }
}
