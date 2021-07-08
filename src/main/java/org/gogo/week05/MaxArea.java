package org.gogo.week05;

/**
 * @author liupenghui
 * @date 2021/7/8 11:10 下午
 */
public class MaxArea {


    public static void main(String[] args) {
        int [] height = {1,8,6,2,5,4,8,3,7};
        MaxArea maxArea = new MaxArea();
        System.out.println(maxArea.plan_1(height));
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
     */
    public int plan_2(int[] height) {
        int maxArea = 0;
        if (height.length < 2) {
            return maxArea;
        }
        for (int i = 0; j < height.length - 1; i < j;) {
            int maxHigh = 
        }
    }
}
