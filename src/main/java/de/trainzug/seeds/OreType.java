package de.trainzug.seeds;

public enum OreType {
    Dirt(1, TileType.Dirt, 1.0F, 4.0F, 6, 0.5F, 0.9F, 2.0F, 0.5F, 0.8F),
    Clay(2, TileType.Clay, 2.0F, 3.0F, 5, 0.0F, 0.5F, 1.5F, 0.2F, 1.0F),
    IronOre(3, TileType.IronOre, 2.0F, 3.25F, 7, 0.0F, 1.5F, 1.5F, 0.01F, 1.0F),
    CopperOre(4, TileType.CopperOre, 2.0F, 3.25F, 8, 3.0F, 1.0F, 1.8F, 0.01F, 1.0F),
    CoalOre(5, TileType.CoalOre, 2.0F, 3.0F, 10, 0.5F, 0.6F, 1.2F, 0.25F, 1.0F),
    TinOre(6, TileType.TinOre, 2.0F, 3.7F, 6, 5.0F, 0.6F, 1.6F, 0.005F, 1.0F),
    CrudeOil(7, TileType.CrudeOil, 2.0F, 4.5F, 2, 13.0F, 0.75F, 3.0F, 1.0E-4F, 1.0F);

    public static final OreType[] values = values();
    public final TileType tile;
    public final int id;
    public final float minVeinRadius;
    public final float maxVeinRadius;
    public final float min;
    public final float max;
    public final int veins;
    public final float offset;
    public final float leftUphold;
    public final float rightUphold;

    OreType(int id, TileType tile, float minRadius, float maxRadius, int veins, float offset, float left, float right, float min, float max) {
        this.tile = tile;
        this.minVeinRadius = minRadius;
        this.maxVeinRadius = maxRadius;
        this.veins = veins;
        this.offset = offset;
        this.leftUphold = left;
        this.rightUphold = right;
        this.min = min;
        this.max = max;
        this.id = id;
    }
}
