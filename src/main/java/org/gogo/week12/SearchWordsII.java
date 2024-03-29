package org.gogo.week12;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 单词搜索 II
 *
 *
 * @author Redick
 * @date 2021/8/25 11:31 下午
 */
public class SearchWordsII {

    /**
     * 字典树+DFS
     * @param board
     * @param words
     * @return
     */
    public List<String> findWords(char[][] board, String[] words) {
        // 构建字典树
        Trie trie = new Trie();
        TrieNode trieNode = trie.root;
        for (String word : words) {
            trie.insert(word);
        }

        //使用set防止重复
        Set<String> result = new HashSet<>();
        int m = board.length;
        int n = board[0].length;
        boolean [][] visited = new boolean[m][n];
        //遍历整个二维数组
        for(int i=0;i<board.length; i++){
            for (int j = 0; j < board [0].length; j++){
                find(board,visited,i,j,m,n,result,trieNode);
            }
        }
        System.out.print(result);
        return new LinkedList<>(result);
    }

    private void find(char [] [] board, boolean [][]visited,int i,int j,int m,int n,Set<String> result,TrieNode cur){
        //边界以及是否已经访问判断
        if(i<0||i>=m||j<0||j>=n||visited[i][j]) {
            return;
        }
        cur = cur.trieNode[board[i][j]-'a'];
        visited[i][j] = true;
        if(cur == null) {
            //如果单词不匹配，回退
            visited[i][j]=false;
            return;
        }
        //找到单词加入
        if(cur.end) {
            result.add(cur.val);
        }
        find(board,visited,i+1,j,m,n,result,cur);
        find(board,visited,i,j+1,m,n,result,cur);
        find(board,visited,i,j-1,m,n,result,cur);
        find(board,visited,i-1,j,m,n,result,cur);
        //最后要回退，因为下一个起点可能会用到上一个起点的字符
        visited[i][j] = false;
    }


    class TrieNode {
        int count;
        int prefix;
        // 是否到节点末尾
        boolean end;
        // 字母
        public String val;
        // 初始化26个字母节点
        TrieNode[] trieNode = new TrieNode[26];

        public TrieNode() {
            this.count = 0;
            this.prefix = 0;
        }
    }

    class Trie {
        TrieNode root;

        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode p = root;
            for (int i = 0; i < word.length(); i++) {
                // 计算在TrieNode中的位置
                int u = word.charAt(i) - 'a';
                if (p.trieNode[u] == null) {
                    p.trieNode[u] = new TrieNode();
                }
                p = p.trieNode[u];
            }
            p.end = true;
            p.val = word;
        }

        public void insert(TrieNode root, String str){
            if(root == null || str.length() == 0){
                return;
            }
            char[] c = str.toCharArray();
            for(int i = 0;i<str.length();i++){
                //如果该分支不存在，创建一个新节点
                if(root.trieNode[c[i] - 'a'] == null){
                    root.trieNode[c[i] - 'a'] = new TrieNode();
                }
                root = root.trieNode[c[i] - 'a'];
                root.prefix++;//注意，应该加在后面
            }
            //以该节点结尾的单词数+1
            root.count++;
        }

        public int search(TrieNode trieNode, String str) {
            if (trieNode == null || null == str || str.length() == 0) {
                return -1;
            }
            char[] c = str.toCharArray();
            for (int i = 0; i < c.length; i++) {
                // 如果不存在，创建一个新的节点
                if (trieNode.trieNode[c[i] - 'a'] == null) {
                    return -1;
                }
                // 如果存在，则继续向下遍历
                trieNode = trieNode.trieNode[c[i] - 'a'];
            }
            //如果到结尾,也说明该单词不存在
            if (trieNode.count == 0) {
                return -1;
            }
            return trieNode.count;
        }

        //查询以str为前缀的单词数量
        public int searchPrefix(TrieNode root,String str){
            if(root==null||str.length()==0){
                return -1;
            }
            char[] c=str.toCharArray();
            for(int i=0;i<str.length();i++){
                //如果该分支不存在，表名该单词不存在
                if(root.trieNode[c[i]-'a']==null){
                    return -1;
                }
                //如果存在，则继续向下遍历
                root = root.trieNode[c[i]-'a'];
            }
            return root.prefix;
        }
    }

    public static void main(String[] args) {
        String[] strings = {"tea", "teacher", "oda", "red", "black", "blue", "to", "two", "redick"};
        new SearchWordsII().insert(strings);
    }

    public void insert(String[] strings) {
        Trie trie = new Trie();
        TrieNode trieNode = new TrieNode();
        for (String s : strings) {
            trie.insert(trieNode, s);
        }
        System.out.println(trie.searchPrefix(trieNode, "t"));
    }
}
