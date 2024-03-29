package org.gogo.week05;

/** 盛最多水的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liupenghui
 * @date 2021/7/8 11:10 下午
 */
public class MaxArea {

    public int twoPointerTest(int[] height) {
        int maxAre = 0;
        for (int i = 0, j = height.length - 1; i < j;) {
            int maxHeight = height[i] < height[j] ? height[i++] : height[j--];
            int width = j - i + 1;
            maxAre = Math.max(maxAre, maxHeight * width);
        }
        return maxAre;
    }


    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        MaxArea maxArea = new MaxArea();
        System.out.println(maxArea.twoPointerTest(height));
    }

    public int test1(int[] height) {
        int maxArea = 0;
        for (int i = 0, j = height.length - 1; i < j;) {
            int minHeight = height[i] < height[j] ? height[i++] : height[j--];
            maxArea = Math.max(maxArea, minHeight * (j - i + 1));
        }
        return maxArea;
    }


    public int times_2(int[] height) {
        // 夹逼法
        int maxArea = 0;
        for (int i = 0, j = height.length - 1; i < j;) {
            // 求较矮的棒子高度
            int minHigh = height[i] < height[j] ? height[i++] : height[j--];
            maxArea = Math.max(maxArea, (j - i + 1) * minHigh);
        }
        return maxArea;
    }

    /**
     * 方案1 双指针
     * @param height
     * @return
     */
    public int plan_1(int[] height) {
        int maxArea = 0;
        if (height.length < 2) {
            return maxArea;
        }
        int high = 0;
        for (int i = 0; i < height.length - 1; ++i) {
            for (int j = i + 1; j < height.length; ++j) {
                high = Math.min(height[i], height[j]);
                int area = high * (j - i);
                maxArea = Math.max(area, maxArea);
            }
        }
        return maxArea;
    }

    /**
     * 双指针夹逼法，时间复杂度O(n)
     * 指针i头指针 指针j尾指针，从头尾往中间走，当i和相遇时就能求出最大面积
     *
     */
    public int plan_2(int[] height) {
        int maxArea = 0;
        if (height.length < 2) {
            return maxArea;
        }
        for (int i = 0, j = height.length - 1; i < j;) {
            int minHigh = height[i] < height[j] ? height[i++] : height[j--];
            // i+1的目的时q去掉坐标的第一个
            maxArea = Math.max(maxArea, (j - i + 1) * minHigh);
        }
        return maxArea;
    }
}
