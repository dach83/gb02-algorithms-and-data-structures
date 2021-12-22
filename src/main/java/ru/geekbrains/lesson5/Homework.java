package ru.geekbrains.lesson5;

public class Homework {

    public static void main(String[] args) {
        testPow();
        testBackPack();
    }

    private static void testPow() {
        int num = 2;
        for (int power = -3; power < 11; power++) {
            System.out.printf("%d^%d = %f\n", num, power, MyMath.pow(2, power));
        }
    }

    private static void testBackPack() {
        Thing[] things = Thing.randomArray(10);
        Bag bag = BagPacker.pack(300, things);
        System.out.println(bag);
        bag.printThings();
    }

}
