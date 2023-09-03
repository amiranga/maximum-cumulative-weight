package com.cs.datastructures;

import java.util.Scanner;

import static com.cs.datastructures.Algorithms.iterativeMaxWeight;
import static com.cs.datastructures.Algorithms.recursiveMaxWeight;
import static com.cs.datastructures.Algorithms.optimalMaxWeight;
import static com.cs.datastructures.MessageConstants.*;

public class TestMaxWeight {
    public static void main(String[] args) {
        int[] ints = InputReader.readArray();
        if (ints == null) {
            System.out.println(DEFAULT_ERROR_MESSAGE);
            return;
        }
        System.out.printf(OUTPUT_FORMAT, "iterativeMaxWeight", iterativeMaxWeight(ints));
        System.out.printf(OUTPUT_FORMAT, "recursiveMaxWeight", recursiveMaxWeight(ints));
        System.out.printf(OUTPUT_FORMAT, "optimalMaxWeight", optimalMaxWeight(ints));
    }
}