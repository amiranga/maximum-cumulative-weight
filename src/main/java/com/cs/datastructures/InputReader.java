package com.cs.datastructures;

import java.util.Scanner;

import static com.cs.datastructures.MessageConstants.*;

public class InputReader {
    public static int[] readArray() {
        int[] ints = null;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println(ENTER_ARRAY_SIZE);
            int arraySize = Integer.parseInt(scanner.nextLine());
            ints = new int[arraySize];
            System.out.println(ENTER_ARRAY_ELEMENTS);
            for (int i = 0; i < arraySize; i++) {
                ints[i] = Integer.parseInt(scanner.nextLine());
            }
        } catch (Exception e) {
            System.out.println(DEFAULT_ERROR_MESSAGE);
        }
        return ints;
    }
}
