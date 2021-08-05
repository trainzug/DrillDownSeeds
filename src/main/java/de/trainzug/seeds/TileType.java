package de.trainzug.seeds;

public enum TileType {
    Stone(0, 1, "stone", null, 128, "#FFFFFF"),
    Dirt(1, 2, "dirt", null, 192, "#BD8144"),
    Clay(2, 3, "clay", Dirt, 0, "#A1A1A1"),
    IronOre(3, 20, "iron", Stone, 6, "#27AE8C"),
    CoalOre(4, 21, "coal", Stone, 6, "#666666"),
    CopperOre(5, 22, "copper", Stone, 6, "#CB9762"),
    TinOre(6, 25, "tin", Stone, 6, "#EBE4C3"),
    CrudeOil(7, 50, "crude_oil", null, 64, "#000000");

    public final int value;
    public final TileType base;
    public final String title;
    public final int meta;
    public final int id;
    public String color;

    TileType(int id, int value, String title, TileType base, int meta, String color) {
        this.value = value;
        this.title = title;
        this.base = base;
        this.meta = meta;
        this.id = id;
        this.color = color;
    }
}