package com.monster.algorithm;

public class LinkedList {

    public static void main(String[] args) {
        // 1. 准备测试数据
//        int[] data = {1, 2, 3, 4, 5, 9};
//        ListNode head = createList(data);
//
//        System.out.print("反转前: ");
//        printList(head);
//
//        // 2. 执行测试
//        ListNode reversedHead = reverseList(head);
//
//        // 3. 验证结果
//        System.out.print("反转后: ");
//        printList(reversedHead);

        // ---- 用例 1：测试常规无环链表 1 -> 2 -> 3 ----
//        ListNode noCycleHead = new ListNode(1);
//        noCycleHead.next = new ListNode(2);
//        noCycleHead.next.next = new ListNode(3);
//        System.out.println("无环链表测试结果: " + hasCycle(noCycleHead)); // 预期输出: false

        // ---- 用例 2：测试有环链表 1 -> 2 -> 3 -> 4 -> 2 ----
        ListNode cycleHead = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);

        cycleHead.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2; // 尾巴连回 2，形成环
        System.out.println("有环链表测试结果: " + hasCycle(cycleHead)); // 预期输出: true
    }

    /**
     * 反转链表
     */
    static class ListNode {

        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 判断链表是否有环
     * <p>
     * 快慢指针，如果有环一定会相遇。
     *
     * @param head 节点
     * @return 是否有环
     */
    public static boolean hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    /**
     * 反转链表
     *
     * @param head 节点
     * @return 反转之后的节点
     */
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            //  临时保存当前节点的下一个节点，防止断链。
            ListNode next = curr.next;
            //  将当前节点的指针指向前驱节点（实现反转）
            curr.next = prev;
            // 将 prev 向后移动一步，准备处理下一个节点。
            prev = curr;
            // 将 curr 向后移动一步，继续循环。
            curr = next;
        }
        return prev;
    }

    public static ListNode createList(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }
        return head;
    }

    // 辅助方法：打印链表
    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }
}
