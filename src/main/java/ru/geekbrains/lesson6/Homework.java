package ru.geekbrains.lesson6;

import java.util.Random;

public class Homework {

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            BinaryTree<Integer> tree = randomTree(4);
            tree.display();
            System.out.println("isBalanced=" + tree.isBalancedTree());
        }

        // для проверки создаю несбалансированное дерево
        int num = 1;
        BinaryTree<Integer> tree = new BinaryTree<>(4);
        while(tree.add(num)) {
            num++;
        }
        tree.display();
        System.out.println("isBalanced=" + tree.isBalancedTree());
    }

    private static BinaryTree<Integer> randomTree(int maxDeepLevel) {
        BinaryTree<Integer> tree = new BinaryTree<>(maxDeepLevel);

        Random random = new Random();
        int value;
        do {
            value = -25 + random.nextInt(51);
        } while (tree.add(value));

        return tree;
    }
}
