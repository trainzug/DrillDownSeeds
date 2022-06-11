package de.trainzug.seeds;

public class Generator {
    public static final Generator G = new Generator();
    private final RandomXS128 rng = new RandomXS128();
    private long seed;

    private Generator() {
    }

    public long getSeed() {
        return this.seed;
    }

    public void setSeed(long seed) {
        this.seed = seed;
        this.rng.setSeed(seed);
    }

    public void generate(Layer layer) {
        for (OreType type : OreType.values) {
            this.generateVeins(layer, type);
        }
    }

    private void generateVeins(Layer layer, OreType type) {
        float probability = layer.index < 40 ? type.getProbability(layer.index) : this.rng.nextFloat() * (1.0F + this.rng.nextFloat());
        float radius = type.minVeinRadius + (type.maxVeinRadius - type.minVeinRadius) * probability;

        int i;
        for(i = 0; i < type.veins; ++i) {
            float f = this.rng.nextFloat();
            if (probability > f) {

                this.generateVein(layer, radius, type.tile);
            }
        }

        if (layer.index == 0 && type == OreType.CopperOre) {
            for(i = 0; i <= 15; i += this.generateVein(layer, radius, type.tile));
        }
    }

    private int generateVein(Layer layer, float rad, TileType type) {
        float x = this.rng.nextFloat() * (float)layer.width;
        float y = this.rng.nextFloat() * (float)layer.height;
        float radius = rad + this.rng.nextFloat() - 0.5F;
        int produced = 0;

        for(int j = (int)(x - radius - 1.0F); j < (int)(x + radius + 1.0F); ++j) {
            for(int k = (int)(y - radius - 1.0F); k < (int)(y + radius + 1.0F); ++k) {
                float dist = (float)Math.sqrt(((float)j - x) * ((float)j - x) + ((float)k - y) * ((float)k - y));
                if (dist < radius) {
                    float dst;
                    float gs;
                    float rnd;
                    if (type.base != null) {
                        dst = dist / radius;
                        gs = (float)Math.abs(this.rng.nextGaussian());
                        rnd = gs / 3.0F * dst;
                        if (0.2F < rnd) {
                            continue;
                        }

                        layer.set(j, k, type.base);
                    }

                    dst = dist / radius;
                    gs = (float)Math.abs(this.rng.nextGaussian());
                    rnd = gs / 3.0F * dst;
                    if (0.1F >= rnd) {
                        ++produced;
                        layer.set(j, k, type);
                    }
                }
            }
        }

        return produced;
    }
}