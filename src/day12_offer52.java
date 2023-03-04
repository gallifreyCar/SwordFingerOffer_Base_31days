import java.awt.*;
import java.util.HashMap;

/**
 * https://leetcode.cn/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
 */
class Solution52 {
    //HashMap
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashMap<ListNode, Integer> map = new HashMap<>();
        ListNode temp = headA;
        while (temp != null) {
            map.put(temp, temp.val);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            if (map.containsKey(temp)) return temp;
            map.put(temp, temp.val);
            temp = temp.next;
        }

        return null;
    }

    //双指针
    ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode pointA = headA;
        ListNode pointB = headB;
        while (pointA != null) {
            lenA++;
            pointA = pointA.next;
        }
        while (pointB != null) {
            lenB++;
            pointB = pointB.next;
        }

        int diff = Math.abs(lenA - lenB);


        ListNode former = lenA > lenB ? headA : headB;
        ListNode latter = lenA > lenB ? headB : headA;
        while (diff != 0) {
            former = former.next;
            diff--;
        }
        while (former != null) {
            if (former == latter) return latter;
            former = former.next;
            latter = latter.next;
        }

        return null;

    }

    //双指针进一步优化
    ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        ListNode pointOne = headA;
        ListNode pointTwo = headB;
        while (pointOne != pointTwo) {
            pointOne = (pointOne == null) ? headB : pointOne.next;
            pointTwo = (pointTwo == null) ? headA : pointTwo.next;

        }

        return pointOne;
    }


}

public class day12_offer52 {
    public static void main(String[] args) {
        Solution52 solution52 = new Solution52();
        int arrA[] = {4, 1};
        int arrB[] = {5, 0, 1};
        int same[] = {8, 4, 5};

        ListNode sameList = ListBuilder.build(same);
        ListNode headA = ListBuilder.build(arrA);
        ListNode headB = ListBuilder.build(arrB);
        headA.end.next = (sameList);
        headB.end.next = (sameList);
        System.out.println(headA);
        System.out.println(headB);
        System.out.println(solution52.getIntersectionNode(headA, headB));
        System.out.println(solution52.getIntersectionNode2(headA, headB));
        System.out.println(solution52.getIntersectionNode3(headA, headB));
    }
}
