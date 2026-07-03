package com.monster.algorithm;

public class ContinuousSum {

    /**
     * 保存最新传入的值
     * 比如依次传入 1、3、-4，那么 latestValue 最后就是 -4
     */
    private int latestValue;

    /**
     * 当前连续子数组的和
     *
     * 它表示：以当前这个数结尾的最大连续和
     *
     * 举例：
     * 传入 1、3 时，currentSum = 1 + 3 = 4
     * 再传入 -4 时，currentSum = 4 + (-4) = 0
     */
    private int currentSum;

    /**
     * 历史出现过的最大连续和
     *
     * 比如：
     * 1, 3, -4, -2, -1, 100, -99, 100
     *
     * 最大连续和是：
     * 100 + (-99) + 100 = 101
     */
    private int maxSum;

    /**
     * 标记是否已经开始计算
     *
     * 因为第一次传入值时，不能直接用默认值 0 参与比较。
     * 如果数组全是负数，比如 -3、-2、-5，
     * 最大连续和应该是 -2，而不是 0。
     */
    private boolean initialized = false;

    /**
     * 方法一：只负责获取最新传入的值
     *
     * 注意：
     * 这个方法只保存 value，不做求和计算。
     */
    public int getValue(int value) {
        this.latestValue = value;
        return this.latestValue;
    }

    /**
     * 方法二：计算最大连续值之和
     *
     * 使用的是 Kadane 算法。
     *
     * 核心思想：
     * 对于当前值 latestValue，有两个选择：
     *
     * 1. 接着前面的连续和继续加：
     *    currentSum + latestValue
     *
     * 2. 从当前值重新开始计算：
     *    latestValue
     *
     * 谁大就选谁。
     */
    public int calculateSum() {

        // 第一次计算时，直接用最新值初始化
        if (!initialized) {
            currentSum = latestValue;
            maxSum = latestValue;
            initialized = true;
            return maxSum;
        }

        /*
         * 判断当前值是“接着前面加”更大，
         * 还是“从当前值重新开始”更大。
         *
         * 如果 currentSum + latestValue < latestValue，
         * 说明前面的连续和已经拖后腿了，应该从当前值重新开始。
         */
        currentSum = Math.max(latestValue, currentSum + latestValue);

        /*
         * 更新历史最大连续和。
         *
         * maxSum 表示目前为止出现过的最大值。
         */
        maxSum = Math.max(maxSum, currentSum);

        return maxSum;
    }

    public static void main(String[] args) {
        ContinuousSum sum = new ContinuousSum();

        int[] nums = {1, 3, -4, -2, -1, 100, -99, 100};

        int result = 0;

        for (int num : nums) {
            // 第一步：保存最新值
            sum.getValue(num);

            // 第二步：基于最新值计算最大连续和
            result = sum.calculateSum();
        }

        // 注意：这里不要再调用 calculateSum()
        // 因为 calculateSum() 是有计算动作的，重复调用会重复计算最后一个值。
        System.out.println("最大连续和：" + result); // 101
    }
}
