package de.trainzug.seeds;

import java.util.Random;

public class RandomXS128 extends Random {

    private static final double NORM_DOUBLE = 1.0 / (1L << 53);
    private static final double NORM_FLOAT = 1.0 / (1L << 24);
    private long seed0;
    private long seed1;

    public RandomXS128() {
        setSeed(new Random().nextLong());
    }

    private static long murmurHash3(long x) {
        x ^= x >>> 33;
        x *= 0xff51afd7ed558ccdL;
        x ^= x >>> 33;
        x *= 0xc4ceb9fe1a85ec53L;
        x ^= x >>> 33;

        return x;
    }

    @Override
    public long nextLong() {
        long s1 = this.seed0;
        final long s0 = this.seed1;
        this.seed0 = s0;
        s1 ^= s1 << 23;
        return (this.seed1 = (s1 ^ s0 ^ (s1 >>> 17) ^ (s0 >>> 26))) + s0;
    }

    @Override
    protected final int next(int bits) {
        return (int) (nextLong() & ((1L << bits) - 1));
    }

    @Override
    public int nextInt() {
        return (int) nextLong();
    }

    @Override
    public int nextInt(final int n) {
        return (int) nextLong(n);
    }

    public long nextLong(final long n) {
        if (n <= 0) throw new IllegalArgumentException("n must be positive");
        for (; ; ) {
            final long bits = nextLong() >>> 1;
            final long value = bits % n;
            if (bits - value + (n - 1) >= 0) return value;
        }
    }

    @Override
    public double nextDouble() {
        return (nextLong() >>> 11) * NORM_DOUBLE;
    }

    @Override
    public float nextFloat() {
        return (float) ((nextLong() >>> 40) * NORM_FLOAT);
    }

    @Override
    public boolean nextBoolean() {
        return (nextLong() & 1) != 0;
    }

    @Override
    public void nextBytes(final byte[] bytes) {
        int n;
        int i = bytes.length;
        while (i != 0) {
            n = Math.min(i, 8); // min(i, 8);
            for (long bits = nextLong(); n-- != 0; bits >>= 8)
                bytes[--i] = (byte) bits;
        }
    }

    @Override
    public void setSeed(final long seed) {
        long seed0 = murmurHash3(seed == 0 ? Long.MIN_VALUE : seed);
        setState(seed0, murmurHash3(seed0));
    }

    public void setState(final long seed0, final long seed1) {
        this.seed0 = seed0;
        this.seed1 = seed1;
    }
}
