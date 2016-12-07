package arg.dao;

import java.util.Random;

public class Generator {

    public static int GenNb(int min, int max) {
        Random rn = new Random();
        int num = rn.nextInt(max - min + 1) + min;
        return num;

    }

    public static double GenNbDouble(double rangeMin, double rangeMax) {
        Random rn = new Random();
        double num = rangeMin + (rangeMax - rangeMin) * rn.nextDouble();
        return num;
    }

}
