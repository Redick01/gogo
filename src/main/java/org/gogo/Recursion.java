package org.gogo;


/**
 * 递归 模版
 * @author liupenghui
 * @date 2021/7/22 1:13 下午
 */
public class Recursion {

    private static final long MAX_LEVEL = Long.MAX_VALUE;

    private void recursion(Object level, String... s) {
        // 1.   终止条件
        if ((long)level > MAX_LEVEL) {
            // 处理结果
            return;
        }
        // 2.处理当前层逻辑

        // 3.进入下一层
        recursion((long)level + 1, s);

        // 4. 清空当前层状态

    }
}
