package org.gogo.week13;

import java.util.BitSet;

/**
 * @author Redick
 * @date 2021/9/12 5:48 下午
 */
public class BloomFilter {

    /**
     * 使用加法hash算法，所以定义了一个8个元素的质数数组
     */
    private static final int[] PRIMES = new int[]{2, 3, 5, 7, 11, 13, 17, 19};
    /**
     * 用八个不同的质数，相当于构建8个不同算法
     */
    private final Hash[] hashList = new Hash[PRIMES.length];
    /**
     * 创建一个长度为10亿的比特位
     */
    private final BitSet bits = new BitSet(256 << 22);

    public BloomFilter() {
        for (int i = 0; i < PRIMES.length; i++) {
            // 使用8个质数，创建八种算法
            hashList[i] = new Hash(PRIMES[i]);
        }
    }

    /**
     * 添加元素
     */
    public void add(String value) {
        for (Hash hash : hashList) {
            bits.set(hash.hash(value), true);
        }
    }

    public boolean contains(String value) {
        if (null == value) {
            return false;
        }
        boolean res = true;
        for (Hash hash :hashList) {
            res = res && bits.get(hash.hash(value));
        }
        return res;
    }

    /**
     * 加法hash算法
     */
    public static class Hash {

        private final int prime;

        public Hash(int prime) {
            this.prime = prime;
        }

        public int hash(String key) {
            int hash, i;
            for (hash = key.length(), i = 0; i < key.length(); i++) {
                hash += key.charAt(i);
            }
            // 保证不会哈希越界
            return (hash % prime);
        }
    }


    public static void main(String[] args) {
        BloomFilter filter = new BloomFilter();
        System.out.println(filter.contains("ssfsd"));
        filter.add("ssfsd");
        filter.add("devwe");
        System.out.println(filter.contains("ssfsd"));
    }
}
