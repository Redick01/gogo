package org.gogo.week05;

/**
 * @author liupenghui
 * @date 2021/7/11 3:01 下午
 */
public class AddOne {

    public static void main(String[] args) {
        int[] digits = {1,2,3};
        test2(digits);
    }

    public static int[] test2(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >=0; i--) {
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








    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >=0; i--) {
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
}
