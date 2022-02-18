package com.monster.algorithm;

/**
 * @className: PrintBinary
 * @description: TODO 打印二进制
 * @author: monster_gan
 * @date: 2022/2/18 15:54
 **/
public class PrintBinary {

    /**
     * 打印整型二进制
     * <p>
     * * << :向左移位 （不带符号）
     * * >> : 向右移位 （存在带符号）
     *
     * @param: num
     * @return: void
     * @author: monster_gan
     * @date: 2022/2/18 15:55
     */
    private static void printBinary(int num) {
        for (int i = 31; i >= 0; i--) {
            String result = (num & (1 << i)) == 0 ? "0" : "1";
            System.out.print(result);
        }
        System.out.println();
    }

    public static void main(String[] args) {
//        int num = 3;
//        printBinary(num);


        //移位
//        int test = 1;
        //00000000000000000000000000000001
//        printBinary(test);
        //左移一位 00000000000000000000000000000010
//        printBinary(test << 1);
        //左移八位 00000000000000000000000100000000
//        printBinary(test << 8);

        //打印整型最大值
//        int max = Integer.MAX_VALUE;
//        printBinary(max);

        //打印整型最小值
//        int min = Integer.MIN_VALUE;
//        printBinary(min);

        /**
         * 位运算概述：
         *  & ： 与  两个位都为 1 时，结果才为 1；
         *  | ： 或  两个位都为 0 时。结果才为 0；
         *  ^ ： 异或 两个位相同是为 0，相异为 1；
         *  ~ ： 取反  0 变 1, 1 变 0；
         *  << : 左移 各二进制全部左移若干位，高位丢弃，低位补 0
         *  >> ： 右移 各二进位全部右移若干位，对无符号数，高位补0，有符号数，各编译器处理方法不一样，有的补符号位（算术右移），有的补0（逻辑右移）
         */
        int a = 12358742;
        int b = 5485244;
        printBinary(a);
        printBinary(~a);
        printBinary(b);
        System.out.println("====================");
        printBinary(a | b);
        printBinary(a & b);
        printBinary(a ^ b);


    }
}
