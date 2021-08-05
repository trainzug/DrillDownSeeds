package de.trainzug.seeds;

public final class Generator {
    private final RandomXS128 rng = new RandomXS128();
    private long seed;

    public Generator(long seed) {
        this.setSeed(seed);
    }

    public long getSeed() {
        return this.seed;
    }

    public void setSeed(long seed) {
        this.seed = seed;
        this.rng.setSeed(seed);
    }

    public void generate(final Layer layer) {
        for (OreType oreType : OreType.values) {
            float n2;
            if (layer.index < 40) {
                int index = layer.index;
                float n;
                if ((n = (oreType.max - oreType.min) * (float) Math.pow(2.7182817459106445, -Math.pow((index - oreType.offset) / (2.0f * ((index < oreType.offset) ? oreType.leftUphold : oreType.rightUphold)), 2.0)) + oreType.min) < 1.0E-6f) {
                    n = 0.0f;
                }
                n2 = n;
            } else {
                n2 = this.rng.nextFloat() * (1.0f + this.rng.nextFloat());
            }
            final float n3 = n2;
            final float n4 = oreType.minVeinRadius + (oreType.maxVeinRadius - oreType.minVeinRadius) * n3;
            for (int j = 0; j < oreType.veins; ++j) {
                if (n3 > this.rng.nextFloat()) {
                    this.generateVein(layer, n4, oreType.tile);
                }
            }
            if (layer.index == 0 && oreType == OreType.CopperOre) {
                for (int k = 0; k <= 15; k += this.generateVein(layer, n4, oreType.tile)) {
                }
            }
        }
    }

    private int generateVein(final Layer layer, float n, final TileType tileType) {
        layer.totalVeinCount++;
        if (tileType == TileType.Dirt) {
            layer.dirtVeinCount++;
        } else if (tileType == TileType.Clay) {
            layer.clayVeinCount++;
        } else if (tileType == TileType.IronOre) {
            layer.ironVeinCount++;
        } else if (tileType == TileType.CopperOre) {
            layer.copperVeinCount++;
        } else if (tileType == TileType.CoalOre) {
            layer.coalVeinCount++;
        } else if (tileType == TileType.TinOre) {
            layer.tinVeinCount++;
        } else if (tileType == TileType.CrudeOil) {
            layer.crudeVeinCount++;
        }
        final float n2 = this.rng.nextFloat() * layer.width;
        final float n3 = this.rng.nextFloat() * layer.height;
        n = n + this.rng.nextFloat() - 0.5f;
        int n4 = 0;
        for (int x = (int) (n2 - n - 1.0f); x < (int) (n2 + n + 1.0f); ++x) {
            for (int y = (int) (n3 - n - 1.0f); y < (int) (n3 + n + 1.0f); ++y) {
                final float n5;
                if ((n5 = (float) Math.sqrt((x - n2) * (x - n2) + (y - n3) * (y - n3))) < n) {
                    if (tileType.base != null) {
                        if (0.2f < Math.abs((float) this.rng.nextGaussian()) / 3.0f * (n5 / n)) {
                            continue;
                        }
                        layer.set(x, y, tileType.base);
                    }
                    if (0.1f >= Math.abs((float) this.rng.nextGaussian()) / 3.0f * (n5 / n)) {
                        ++n4;
                        layer.set(x, y, tileType);
                    }
                }
            }
        }
        return n4;
    }

}