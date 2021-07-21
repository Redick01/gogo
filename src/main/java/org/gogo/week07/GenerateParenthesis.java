package org.gogo.week07;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Redick
 * @date 2021/7/21 11:23 下午
 */
public class GenerateParenthesis {

    public static void main(String[] args) {
        new GenerateParenthesis().generateParenthesis(3);
    }

    /**
     * 递归法
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generate(0, 0, n, "", res);
        return res;
    }

    /**
     * 递归函数
     * @param left 左括号
     * @param right 右括号
     * @param n 括号个数
     * @param parenthesis 生成的字符串
     * @param res 结果
     */
    private void generate(int left, int right, int n, String parenthesis, List<String> res) {
        // 终止条件， 如果左右括号都处理完了就终止了
        if (left == n && right == n) {
            res.add(parenthesis);
            return;
        }
        // 当前层处理逻辑并进入下一层
        if (left < n) {
            generate(left + 1, right, n, parenthesis + "(", res);
        }
        if (left > right) {
            generate(left, right + 1, n, parenthesis + ")", res);
        }
    }
}
