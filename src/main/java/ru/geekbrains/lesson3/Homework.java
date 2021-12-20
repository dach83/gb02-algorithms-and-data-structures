package ru.geekbrains.lesson3;

//[1, 2 ,3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16] => 11
//[1, 2, 4, 5, 6] => 3
//[] => 1

import java.util.Arrays;

public class Homework {

    public static void main(String[] args) {
        printMissedNum(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16); // => 11
        printMissedNum(1, 2, 4, 5, 6); // => 3
        printMissedNum(); // => 1

        printMissedNum(2, 4); // => 3
        printMissedNum(2, 4, 5, 6, 8, 9, 10); // => несколько пропущенных
        printMissedNum(2, 4, 6, 8, 10, 12, 14); // => несколько пропущенных
        printMissedNum(2, 2, 2, 2, 2, 2, 2); // => несколько пропущенных
        printMissedNum(4, 5, 6, 7, 8, 9, 10); // => нет пропущенных
    }

    private static void printMissedNum(int... arr) {
        int leftInd = 0;
        int rightInd = arr.length - 1;
        int baseInd = 0;
        boolean missedInLeft;
        boolean missedInRight;

        while (rightInd - leftInd > 1) {
            baseInd = (leftInd + rightInd) / 2;
            missedInLeft = baseInd - leftInd != arr[baseInd] - arr[leftInd];
            missedInRight = rightInd - baseInd != arr[rightInd] - arr[baseInd];
            if (missedInLeft && !missedInRight) {
                rightInd = baseInd;
            } else if (!missedInLeft && missedInRight) {
                leftInd = baseInd;
            } else if (missedInLeft && missedInRight) {
                System.out.printf("В массиве %s несколько пропущенных чисел\n", Arrays.toString(arr));
                return;
            } else {
                System.out.printf("В массиве %s нет пропущенных чисел\n", Arrays.toString(arr));
                return;
            }
        }

        int missedNum = (rightInd > leftInd) ? arr[baseInd] + 1 : 1;
        System.out.printf("В массиве %s пропущено число %d\n", Arrays.toString(arr), missedNum);
    }

}
