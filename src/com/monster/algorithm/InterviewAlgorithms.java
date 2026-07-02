package com.monster.algorithm;

import java.util.HashMap;
import java.util.Stack;

public class InterviewAlgorithms {

    public static void main(String[] args) {
        // int[] ints = twoSum(new int[]{2, 7, 11, 15}, 26);
        // for (int i : ints) {
        // System.out.println(i);
        // }
//        int binaried = binarySearch(new int[]{2, 7, 11, 15, 17, 30, 39, 40, 50, 56, 89, 90}, 39);
//        System.out.printf("%d", binaried);

        String s = "{}[]()";
        boolean valid = isValid(s);
        System.out.printf("%s", valid);
    }

    /**
     * 两数之和
     *
     * @param nums   数组
     * @param target 目标
     * @return 结果
     */
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            if (map.containsKey(need)) {
                return new int[]{map.get(need), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, 1};
    }

    /**
     * 二分法查找
     *
     * @param nums   有序数组
     * @param target 目标值
     * @return 正确值下标
     */
    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 判断括号是否合法
     *
     * @param s 字符串
     * @return 是否合法
     */
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                // 获取栈内最顶的元素
                Character top = stack.pop();
                if (c == ')' && top != '(') {
                    return false;
                }
                if (c == ']' && top != '[') {
                    return false;
                }
                if (c == '}' && top != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
