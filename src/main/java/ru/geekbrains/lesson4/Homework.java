package ru.geekbrains.lesson4;


import java.util.Iterator;

public class Homework {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        list.display();
        System.out.println("getFirst: " + list.getFirst());
        System.out.println("getLast: " + list.getLast());

        list.insertFirst(1);
        list.insertFirst(2);
        list.insertFirst(3);
        list.display();

        list.insertLast(6);
        list.insertLast(7);
        list.insertLast(8);
        list.display();

        System.out.println("RemoveFirst: " + list.removeFirst());
        list.display();

        System.out.println("RemoveLast: " + list.removeLast());
        list.display();

        System.out.println("getFirst: " + list.getFirst());
        System.out.println("getLast: " + list.getLast());
        list.display();

        System.out.println("contains(6): " + list.contains(6));
        System.out.println("contains(3): " + list.contains(3));
        list.display();

        System.out.println("get(-1): " + list.get(-1));
        System.out.println("get(0): " + list.get(0));
        System.out.println("get(1): " + list.get(1));
        System.out.println("get(2): " + list.get(2));
        System.out.println("get(3): " + list.get(3));
        System.out.println("get(4): " + list.get(4));
        list.display();

        System.out.println("remove(6): " + list.remove(6));
        System.out.println("remove(8): " + list.remove(8));
        list.display();

        list.insert(9, 3);
        list.display();
        list.insert(0, 0);
        list.display();
        list.insert(3, 1);
        list.display();
        list.insert(4, 3);
        list.display();
        list.insert(5, 3);
        list.display();
        list.insert(6, 4);
        list.display();

        System.out.println("Проверить методы итератора");
        Iterator<Integer> listIterator = list.iterator();
        while(listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }

    }

}
