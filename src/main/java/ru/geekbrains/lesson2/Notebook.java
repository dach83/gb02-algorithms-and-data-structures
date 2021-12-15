package ru.geekbrains.lesson2;

import java.util.Comparator;

public class Notebook implements Comparable<Notebook> {

    private static final String[] brands = {"Lenovo", "Asus", "Macbook", "Acer", "Xiaomi"};
    private static int counter = 0;

    private final int id; // поле нужно для уникальности ноутбуков, подробнее в CompareTo...
    private final int price;
    private final int memory;
    private final String brand;

    public Notebook(int price, int memory, String brand) {
        this.price = price;
        this.memory = memory;
        this.brand = brand;
        this.id = counter++;
    }

    // Генерим случайный массив ноутбуков
    public static Notebook[] randomArray(int count) {
        Notebook[] arr = new Notebook[count];
        for (int i = 0; i < count; i++) {
            int price = 500 + (int) ((2000 - 500) / 50 * Math.random()) * 50;
            int memory = 4 + (int) ((24 - 4) / 4 * Math.random()) * 4;
            String brand = brands[(int) (brands.length * Math.random())];
            arr[i] = new Notebook(price, memory, brand);
        }

        return arr;
    }

    public static void printToConsole(Notebook... notebooks) {
        for (Notebook notebook : notebooks) {
            System.out.println(notebook);
        }
    }

    @Override
    public int compareTo(Notebook o) {
        return Comparator                               // сравниваем ноутбуки
                .comparingInt(Notebook::getPrice)       // по цене
                .thenComparingInt(Notebook::getMemory)  // по памяти
                .thenComparing(Notebook::getBrand)      // по брэнду
                .thenComparingInt(Notebook::getId)      // и по id, чтобы результат сравнения был не нулевым, без этого сравнения порядок одинаковых
                .compare(this, o);                      // ноутбуков после эталонной сортировки в Arrays.sort может отличаться от SelectionSort
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "price=" + price +
                ", memory=" + memory +
                ", brand='" + brand + '\'' +
                '}';
    }

    public int getPrice() {
        return price;
    }

    public int getMemory() {
        return memory;
    }

    public String getBrand() {
        return brand;
    }

    public int getId() {
        return id;
    }
}
