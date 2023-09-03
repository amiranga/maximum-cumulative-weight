package com.cs.datastructures;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Algorithms {

    public static int iterativeMaxWeight(int[] array) {
        int max = 0;
        List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList());
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                List<Integer> sublist = list.subList(i, j + 1);
                int sum = sublist.stream().mapToInt(Integer::intValue).sum();
                max = Math.max(sum, max);
            }
        }
        return max;
    }


    public static int recursiveMaxWeight(int[] array) {
        return recursiveMaxWeight(array, 0, array.length - 1);
    }

    private static int recursiveMaxWeight(int[] array, int i, int j) {
        if (i == j) {
            return array[i];
        }

        int mid = (i + j) / 2;
        int sum = 0, leftMaxSum = 0;

        for (int l = mid; l >= i; l--) {
            sum += array[l];
            if (sum > leftMaxSum) {
                leftMaxSum = sum;
            }
        }

        int rightMaxSum = 0;
        sum = 0;
        for (int l = mid + 1; l <= j; l++) {
            sum += array[l];
            if (sum > rightMaxSum) {
                rightMaxSum = sum;
            }
        }

        int maxLeftRight = Math.max(recursiveMaxWeight(array, i, mid), recursiveMaxWeight(array, mid + 1, j));
        return Math.max(maxLeftRight, leftMaxSum + rightMaxSum);
    }

    public static int optimalMaxWeight(int[] nums) {
        int n = nums.length;
        int max = 0, sum = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            max = Math.max(sum, max);

            if (sum < 0) sum = 0;
        }

        return max;
    }
}
