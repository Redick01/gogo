package org.gogo.week07;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * 数字n代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
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

    public List<String> test13(int n) {
        List<String> list = new ArrayList<>();

        return list;
    }

    public void ge1(int left, int right, int n, List<String> list, String str) {
        if (left == n && right == n) {
            list.add(str);
            return;
        }
        if (left < n) {
            ge1(left + 1, right, n, list, str + "(");
        }
        if (left < right) {
            ge1(left, right + 1, n, list, str + ")");
        }
    }

    public List<String> test12(int n) {
        List<String> list = new ArrayList<>();
        ge(0, 0, n, list, "");
        return list;
    }
    public void ge(int left, int right, int n, List<String> list, String str) {
        if (left == n && right == n) {
            list.add(str);
            return;
        }
        if (left > n) {
            ge(left + 1, right, n, list, str +"(");
        }
        if (right > left) {
            ge(left, right + 1, n, list, str + ")");
        }
    }


    private List<String> test11(int n) {
        List<String> res = new ArrayList<>();
        recursion(0, 0, n, res, "");
        return res;
    }

    public void recursion1(int left, int right, int n, List<String> res, String s) {
        // 终止条件
        if (left == 0 && right == 0) {
            res.add(s);
            return;
        }
        if (left > 0) {
            recursion1(left - 1, right, n - 1, res, s + "(");
        }
        if (right > left) {
            recursion1(left, right - 1, n - 1, res, s + ")");
        }
    }

    public void recursion(int left, int right, int n, List<String> res, String s) {
        // 终止条件
        if (left == n && right == n) {
            res.add(s);
            return;
        }
        if (left < n) {
            recursion(left + 1, right, n, res, "(");
        }
        if (left < right) {
            recursion(left, right + 1, n, res, ")");
        }
    }

    public static void main(String[] args) {
        new GenerateParenthesis().test2(3);
    }

    public List<String> test2(int n) {
        List<String> res = new ArrayList<>();
        dfs(0, 0, n, res, "");
        return res;
    }

    private void dfs(int left, int right, int n, List<String> res, String str) {
        if (left == n && right == n) {
            res.add(str);
            return;
        }
        if (left < n) {
            dfs(left + 1, right, n, res, str + "(");
        }
        if (right < left) {
            dfs(left, right + 1, n, res, str + ")");
        }
    }


    public List<String> test1(int n) {
        List<String> res = new ArrayList<>();
        gen(0, 0, n, "", res);
        return res;
    }

    private void gen(int left, int right, int n, String s, List<String> res) {
        // 终止条件
        if (left == n && right == n) {
            res.add(s);
            return;
        }
        // 当前层处理逻辑
        // 左括号处理
        if (left < n) {
            // 进入下一层
            gen(left + 1, right, n, s + "(", res);
        }
        // 右括号处理
        if (left > right) {
            gen(left, right + 1, n, s + ")", res);
        }
    }

    /**
     * 递归
     * @param n
     * @return
     */
    public List<String> test3(int n) {
        List<String> res = new ArrayList<>();
        dfs3(0, 0, n, "", res);
        return res;
    }

    private static void dfs3(int left, int right, int n, String str, List<String> res) {
        // 递归终止条件
        if (left == n && right == n) {
            res.add(str);
            return;
        }
        // 进入下一层，处理左右括号
        if (left < n) {
            dfs3(left + 1, right, n, str + "(", res);
        }
        if (left > right) {
            dfs3(left, right + 1, n, str + ")", res);
        }
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
