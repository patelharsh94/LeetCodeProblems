package Mocks;

import org.junit.Test;

import java.util.HashMap;

public class Mock37 {

    public int romanToInt(String s) {

        int total = 0;
        HashMap<String, Integer> romanToInt = new HashMap<>();
        romanToInt.put("IV", 4);
        romanToInt.put("IX", 9);
        romanToInt.put("XL", 40);
        romanToInt.put("XC", 90);
        romanToInt.put("CD", 400);
        romanToInt.put("CM", 900);
        romanToInt.put("I", 1);
        romanToInt.put("V", 5);
        romanToInt.put("X", 10);
        romanToInt.put("L", 50);
        romanToInt.put("C", 100);
        romanToInt.put("D", 500);
        romanToInt.put("M", 1000);

        for (int i = 0; i < s.length(); i++) {

            if (i + 1 < s.length() && romanToInt.containsKey(s.substring(i, i+2))) {
                total += romanToInt.get(s.substring(i, i+2));
                i++;
                continue;
            } else {
                total += romanToInt.get(s.charAt(i)+"");
            }

        }

        return total;
    }

    @Test
    public void test() {
        romanToInt("IV");
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode ptr1 = l1;
        ListNode ptr2 = l2;
        ListNode ans = null;
        ListNode root = ans;

        int carry = 0;

        while (ptr1 != null || ptr2 != null) {
            ListNode currNode = null;

            if (ptr1 == null && ptr2 != null) {
                int total = (ptr2.val + carry) % 10;

                if (ptr2.val + carry >= 10) {
                    carry = 1;
                } else {
                    carry = 0;
                }
                currNode = new ListNode(total);
                ptr2 = ptr2.next;
            }

            if (ptr1 != null && ptr2 == null) {
                int total = (ptr1.val + carry) % 10;

                if (ptr1.val + carry >= 10) {
                    carry = 1;
                } else {
                    carry = 0;
                }
                currNode = new ListNode(total);
                ptr1 = ptr1.next;
            }

            if (ptr1 != null && ptr2 != null) {
                int total = (ptr1.val + ptr2.val + carry) % 10;

                if (ptr1.val + ptr2.val + carry >= 10) {
                    carry = 1;
                } else {
                    carry = 0;
                }
                currNode = new ListNode(total);
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
            }

            if (ans == null) {
                ans = currNode;
                root = ans;
            } else {
                root.next = currNode;
                root = root.next;
            }

        }


        if (root != null) {

            if (carry == 1) {
                root.next = new ListNode(1);
            }
        }

        return ans;
    }

}
