package ru.geekbrains.lesson5;

public class Homework {

    public static void main(String[] args) {
        // возведение в степень
        int num = 2;
        for (int power = -3; power < 11; power++) {
            System.out.printf("%d^%d = %f\n", num, power, MyMath.pow(2, power));
        }

    }

}
