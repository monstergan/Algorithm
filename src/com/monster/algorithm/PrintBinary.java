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
        int test = 1;
        //00000000000000000000000000000001
        printBinary(test);
        //左移一位 00000000000000000000000000000010
        printBinary(test << 1);
        //左移八位 00000000000000000000000100000000
        printBinary(test << 8);
    }
}
