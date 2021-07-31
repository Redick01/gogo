package org.gogo.week09;

import java.util.*;

/**
 * 单词接龙 I
 * @author Redick
 * @date 2021/7/31 4:13 下午
 */
public class LadderLength {

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");
        System.out.println(new LadderLength().test1(beginWord, endWord, list));
    }

    // 单词数目
    int cnt = 1;
    // 用于标记是否达到，这里 false代表到达了
    boolean failed = true;

    public int test1(String beginWord, String endWord, List<String> wordList) {
        // 字典中就不存在endWord，无法转换
        if (!wordList.contains(endWord)) {
            return 0;
        }
        // 定义一个布尔数组，字典单词是否入过队列并全部初始化为false
        boolean[] marked = new boolean[wordList.size()];
        Arrays.fill(marked, false);
        // 初始化一个队列
        Deque<String> deque = new ArrayDeque<>();
        for (int i = 0; i < wordList.size(); i++) {
            if (!marked[i] && rule(wordList.get(i), beginWord)) {
                deque.add(wordList.get(i));
                marked[i] = true;
            }
        }
        cnt++;
        if (deque.contains(endWord)) {
            failed = false;
            return cnt;
        }
        while (!deque.isEmpty()) {
            // 当前层级
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                String str = deque.poll();
                for (int j = 0; j < wordList.size(); j++) {
                    if (!marked[j] && rule(wordList.get(j), str)) {
                        deque.add(wordList.get(j));
                        marked[i] = true;
                    }
                }
            }
            //以层为单位进行有批次的遍历, 使得我们能够很好统计最短路径的长度
            cnt++;
            if (deque.contains(endWord)) {
                failed = false;
                return cnt;
            }
        }
        return failed ? 0 : cnt;
    }

    public boolean rule(String word1, String word2) {
        int sameCount = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                sameCount += 1;
            }
        }
        return sameCount <= 1;
    }

    public int plan2(String beginWord, String endWord, List<String> wordList) {
        //如果endWord不在字典里，无法进行转换, 返回0
        if(!wordList.contains(endWord)) return 0;

        //定义marked数组, 并全部初始化为false
        boolean[] marked = new boolean[wordList.size()];
        Arrays.fill(marked,false);

        //初始化队列
        List<String> queue = new ArrayList<>();
        for(int i=0;i<wordList.size();++i){
            if(!marked[i]&&comparable(wordList.get(i),beginWord)){
                queue.add(wordList.get(i));
                marked[i] = true;
            }
        }
        cnt++;
        //可能在初始化的时候就已经找到endWord了
        if(queue.contains(endWord)){
            failed = false;
            return cnt;
        }

        //BFS分层遍历
        while(!queue.isEmpty()){
            int sz = queue.size();
            //循环sz次, 将当前队列中的数据处理完
            for(int j=0;j<sz;++j){
                //对于每次循环, 取队首元素
                String s = queue.get(0);
                //遍历wordList, 将满足条件的元素加入队列并标记
                for(int i=0;i<wordList.size();++i){
                    if(!marked[i]&&comparable(wordList.get(i),s)){
                        queue.add(wordList.get(i));
                        marked[i] = true;
                    }
                }
                //在循环末尾, 去除该元素, 这证明该数据已经处理完了
                queue.remove(0);
            }
            //以层为单位进行有批次的遍历, 使得我们能够很好统计最短路径的长度
            cnt++;
            //到达该数据, 标记成功, 返回cnt(层级数)
            if(queue.contains(endWord)){
                failed = false;
                return cnt;
            }
        }
        //到达该数据, 标记成功, 返回cnt(层级数), 否则失败, 返回0
        if(failed) return 0;
        else return cnt;
    }

    private boolean comparable(String s1, String s2){
        int cnt = 0;
        for(int i=0;i<s1.length();++i){
            if(s1.charAt(i)!=s2.charAt(i)) cnt++;
        }
        return cnt<=1;
    }





    Map<String, Integer> wordId = new HashMap<>();

    List<List<Integer>> list = new ArrayList<>();

    int nums = 0;

    /**
     * 广度优先搜索
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int plan1(String beginWord, String endWord, List<String> wordList) {
        // 先构建一个图，基于这个图做广度优先搜索
        for (String word : wordList) {
            putWordId(word);
        }
        putWordId(beginWord);
        if (!wordId.containsKey(endWord)) {
            return 0;
        }
        int[] dis = new int[nums];
        Arrays.fill(dis, Integer.MAX_VALUE);
        int beginId = wordId.get(beginWord);
        int endId = wordId.get(endWord);
        dis[beginId] = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(beginId);
        while (!deque.isEmpty()) {
            int id = deque.poll();
            if (id == endId) {
                return dis[endId] / 2 + 1;
            }
            for (int i : list.get(id)) {
                if (dis[i] == Integer.MAX_VALUE) {
                    dis[i] = dis[id] + 1;
                    deque.add(i);
                }
            }
        }
        return 0;
    }

    private void putWordId(String word) {
        if (!wordId.containsKey(word)) {
            wordId.put(word, nums++);
            list.add(new ArrayList<>());
        }
        int id = wordId.get(word);
        char[] chars = word.toCharArray();
        int len = chars.length;
        for (int i = 0; i < len; i++) {
            char temp = chars[i];
            chars[i] = '*';
            String newWord = new String(chars);
            if (!wordId.containsKey(newWord)) {
                wordId.put(newWord, nums++);
                list.add(new ArrayList<>());
            }
            int id1 = wordId.get(newWord);
            list.get(id).add(id1);
            list.get(id1).add(id);
            chars[i] = temp;
        }
    }
}
