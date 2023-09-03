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


    public static int recursiveMaxWeight(int[] nums) {
        return recursiveMaxWeight(nums, 0, nums.length - 1);
    }

    private static int recursiveMaxWeight(int[] nums, int i, int j) {
        if (i == j) {
            return nums[i];
        }

        int mid = (i + j) / 2;
        int sum = 0, leftMaxSUM = 0;

        for (int l = mid; l >= i; l--) {
            sum += nums[l];
            if (sum > leftMaxSUM) {
                leftMaxSUM = sum;
            }
        }

        int rightMaxSUM = 0;
        sum = 0;
        for (int l = mid + 1; l <= j; l++) {
            sum += nums[l];
            if (sum > rightMaxSUM) {
                rightMaxSUM = sum;
            }
        }

        int maxLeftRight = Math.max(recursiveMaxWeight(nums, i, mid), recursiveMaxWeight(nums, mid + 1, j));
        return Math.max(maxLeftRight, leftMaxSUM + rightMaxSUM);
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
