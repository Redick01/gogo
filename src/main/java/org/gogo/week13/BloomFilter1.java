package org.gogo.week13;

import java.util.BitSet;
import java.util.Iterator;
import java.util.Random;

/**
 * @author Redick
 * @date 2021/9/12 9:21 下午
 */
public class BloomFilter1 implements Cloneable {

    private BitSet hashes;

    private RandomInRange prng;

    /**
     * 哈希函数的数量
     */
    private int k;

    /**
     * ln(2)
     */
    private static final double LN2 = 0.6931471805599453;

    /**
     * Create a new bloom filter.
     * @param n Expected number of elements
     * @param m Desired size of the container in bits
     **/
    public BloomFilter1(int n, int m) {
        k = (int) Math.round(LN2 * m / n);
        if (k <= 0) {
            k = 1;
        }
        this.hashes = new BitSet(m);
        this.prng = new RandomInRange(m, k);
    }


    /**
     * Removes all of the elements from this filter.
     **/
    public void clear() {
        hashes.clear();
    }

    /**
     * Create a copy of the current filter
     **/
    @Override
    public BloomFilter clone() throws CloneNotSupportedException {
        return (BloomFilter) super.clone();
    }

    /**
     * Generate a unique hash representing the filter
     **/
    @Override
    public int hashCode() {
        return hashes.hashCode() ^ k;
    }

    /**
     * Test if the filters have equal bitsets.
     * WARNING: two filters may contain the same elements, but not be equal
     * (if the filters have different size for example).
     */
    public boolean equals(BloomFilter1 other) {
        return this.hashes.equals(other.hashes) && this.k == other.k;
    }

    /**
     * Merge another bloom filter into the current one.
     * After this operation, the current bloom filter contains all elements in
     * other.
     **/
    public void merge(BloomFilter1 other) {
        if (other.k != this.k || other.hashes.size() != this.hashes.size()) {
            throw new IllegalArgumentException("Incompatible bloom filters");
        }
        this.hashes.or(other.hashes);
    }

    private class RandomInRange implements Iterable<RandomInRange>, Iterator<RandomInRange> {

        private Random prng;
        /**
         * Maximum value returned + 1
         */
        private int max;
        /**
         * Number of random elements to generate
         */
        private int count;
        /**
         * Number of elements generated
         */
        private int i = 0;
        /**
         * The current value
         */
        public int value;

        RandomInRange(int maximum, int k) {
            max = maximum;
            count = k;
            prng = new Random();
        }

        public void init(Object o) {
            prng.setSeed(o.hashCode());
        }

        @Override
        public Iterator<RandomInRange> iterator() {
            i = 0;
            return this;
        }

        @Override
        public boolean hasNext() {
            return i < count;
        }

        @Override
        public RandomInRange next() {
            i++;
            value = prng.nextInt() % max;
            if (value < 0) {
                value = -value;
            }
            return this;
        }
    }
}
