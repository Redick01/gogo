package org.gogo.week02;

public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] nums = {1,1,2,2,3,3,4,5};
        System.out.println(removeDuplicates(nums));
        System.out.println(getRabbitNum(6));
    }

    /**
     * 删除排序数组中的重复项
     * 给定数组 nums = [1,1,2],

     函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。

     你不需要考虑数组中超出新长度后面的元素。

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // 慢指针
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            /*
            当两个两个位置元素不相等时，将慢指针前移，并将i指针处元素赋值给快指针count处，然后快指针继续，去重数组的元素数就等于指针count+1
            因为count起始是0，去重的元素就分布在0到count指针处元素，其余位置存的是没有被覆盖的重复值
             */
            if (nums[count] != nums[i]) {
                count++;
                nums[count] = nums[i];
            }
        }
        return count + 1;
    }

    /**
     * 兔子生孩子问题
     * 有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，问每个月的兔子总数为多少？
     *
     * 斐波那契数列，当大于2月时，求出兔子的对数为 f(n) = f(n - 1) + f(n - 2)
     * @param n
     * @return
     */
    public static long getRabbitNum(int n) {
        if (1 == n || 2 == n) {
            return 1;
        }
        return getRabbitNum(n - 1) + getRabbitNum(n - 2);
    }
    private static int fibo2(int a) {
        if(a<=0)
            return 0;
        if(a == 1)
            return 1;

        int f1 = 1;
        int f2 = 1;
        int result = 0;
        int i = 2;
        while(i++ <= a) {
            result = f1 + f2;
            f1 = f2;
            f2 =result;
        }
        return result;
    }
}
