package de.trainzug.seeds;

import java.util.Random;

public class Seed {

    public static void main(String[] arg) {
        System.out.println("Start...");
        Layer l;
        double tries = 0;
        Generator g;
        do {
            tries++;
            l = new Layer(0, 64, 64);
            g = new Generator(hash(randomString()));
            g.generate(l);
        } while (!(l.tinVeinCount >= 1 && l.tinCount >= 4));
        System.out.println(l);
        System.out.println("seed found: " + g.getSeed() + " after " + tries + " tries");
    }

    public static long hash(String str) {
        long j = 1125899906842597L;
        int length = str.length();
        for (int i = 0; i < length; i++) {
            j = (j * 31) + ((long) str.charAt(i));
        }
        return j;
    }

    public static String randomString() {
        Random rand = new Random();
        StringBuilder ok = new StringBuilder();
        for (int i = 0; i < 19; i++) {
            ok.append(rand.nextInt((9) + 1));
        }
        return ok.toString();
    }

}
