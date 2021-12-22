package ru.geekbrains.lesson5;

public class MyMath {

    public static double pow(double num, int power) {
        if (power < 0)
            return pow(1/num, -power);

        if (power == 0)
            return 1;

        if (power % 2 == 0) {
            double res = pow(num, power / 2);
            return res * res;
        } else {
            return num * pow(num, power - 1);
        }
    }

}
