package de.trainzug.seeds;


import java.util.Arrays;

public final class Layer {
    final int index;
    public int width;
    public int height;
    public TileType[][] data;

    public int dirtCount = 0;
    public int clayCount = 0;
    public int ironCount = 0;
    public int copperCount = 0;
    public int coalCount = 0;
    public int tinCount = 0;
    public int crudeCount = 0;

    public int dirtVeinCount = 0;
    public int clayVeinCount = 0;
    public int ironVeinCount = 0;
    public int copperVeinCount = 0;
    public int coalVeinCount = 0;
    public int tinVeinCount = 0;
    public int crudeVeinCount = 0;

    public int dirt2by2s = 0;
    public int clay2by2s = 0;
    public int iron2by2s = 0;
    public int copper2by2s = 0;
    public int coal2by2s = 0;
    public int tin2by2s = 0;
    public int crude2by2s = 0;

    public int totalVeinCount = 0;
    public int totalOreCount = 0;
    public int total2by2s = 0;

    public Layer(int index, int width, int height) {
        this.width = width;
        this.height = height;
        this.index = index;
        this.data = new TileType[this.height][this.width];
        for (TileType[] row : data)
            Arrays.fill(row, TileType.Stone);
    }

    public void set(final int x, final int y, final TileType tileType) {
        if (x < 0 || y < 0 || x >= this.width || y >= this.height) {
            return;
        }

        if (tileType == TileType.Dirt) {
            this.dirtCount++;
        } else if (tileType == TileType.Clay) {
            this.clayCount++;
        } else if (tileType == TileType.IronOre) {
            this.ironCount++;
        } else if (tileType == TileType.CopperOre) {
            this.copperCount++;
        } else if (tileType == TileType.CoalOre) {
            this.coalCount++;
        } else if (tileType == TileType.TinOre) {
            this.tinCount++;
        } else if (tileType == TileType.CrudeOil) {
            this.crudeCount++;
        }
        this.totalOreCount++;

        data[y][x] = tileType;
    }


    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        /*for (int i = data.length - 1; i >= 0; i--) {
            for (int j = 0; j < data[i].length; j++) {
                TileType tt = data[i][j];
                if (tt == TileType.Stone) {
                    s.append(" ");
                } else {
                    s.append(tt.id);
                }
            }
            s.append('\n');
        }
        s.append('\n');*/

        s.append("Layer{" +
                "index=" + index +
                ", width=" + width +
                ", height=" + height +
                ", dirtCount=" + dirtCount +
                ", clayCount=" + clayCount +
                ", ironCount=" + ironCount +
                ", copperCount=" + copperCount +
                ", coalCount=" + coalCount +
                ", tinCount=" + tinCount +
                ", crudeCount=" + crudeCount +
                ", dirtVeinCount=" + dirtVeinCount +
                ", clayVeinCount=" + clayVeinCount +
                ", ironVeinCount=" + ironVeinCount +
                ", copperVeinCount=" + copperVeinCount +
                ", coalVeinCount=" + coalVeinCount +
                ", tinVeinCount=" + tinVeinCount +
                ", crudeVeinCount=" + crudeVeinCount +
                ", dirt2by2s=" + dirt2by2s +
                ", clay2by2s=" + clay2by2s +
                ", iron2by2s=" + iron2by2s +
                ", copper2by2s=" + copper2by2s +
                ", coal2by2s=" + coal2by2s +
                ", tin2by2s=" + tin2by2s +
                ", crude2by2s=" + crude2by2s +
                ", totalVeinCount=" + totalVeinCount +
                ", totalOreCount=" + totalOreCount +
                ", total2by2s=" + total2by2s +
                '}');

        return s.toString();
    }

    public void check2by2s() {
        for (TileType t : TileType.values()) {
            if (t == TileType.Stone) continue;
            TileType[][] pattern = new TileType[][]{{t, t}, {t, t}};

            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data[0].length; j++) {
                    if (data[i][j] == pattern[0][0]) {
                        boolean flag = true;
                        for (int k = 0; k < pattern.length; k++) {
                            for (int l = 0; l < pattern[k].length; l++) {
                                if ((i + k) >= data.length || (j + l) >= data[0].length) {
                                    flag = false;
                                    break;
                                }
                                if (data[i + k][j + l] != pattern[k][l]) {
                                    flag = false;
                                }
                            }
                        }

                        if (flag) {
                            if (t == TileType.Dirt) {
                                this.dirt2by2s++;
                            } else if (t == TileType.Clay) {
                                this.clay2by2s++;
                            } else if (t == TileType.IronOre) {
                                this.iron2by2s++;
                            } else if (t == TileType.CopperOre) {
                                this.copper2by2s++;
                            } else if (t == TileType.CoalOre) {
                                this.coal2by2s++;
                            } else if (t == TileType.TinOre) {
                                this.tin2by2s++;
                            } else if (t == TileType.CrudeOil) {
                                this.crude2by2s++;
                            }
                            this.total2by2s++;
                        }
                    }
                }
            }
        }
    }
}

