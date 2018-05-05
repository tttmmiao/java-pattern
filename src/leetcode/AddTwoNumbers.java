package leetcode;

/**
 * see https://leetcode.com/problems/add-two-numbers/description/
 */
public class AddTwoNumbers {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode h1 = l1;
        ListNode h2 = l2;
        int total = l1.val + l2.val;
        int add = total / 10;
        int cur = total % 10;
        ListNode sum = new ListNode(cur);
        ListNode hs = sum;
        while(h1!=null && h2!=null){
            total = h1.val + h2.val + add;
            cur = total % 10;
            add = total / 10;
            hs.next = new ListNode(cur);
            h1 = h1.next;
            h2 = h2.next;
            hs = hs.next;
        }
        while(h1!=null){
            total = h1.val + add;
            cur = total % 10;
            add = total / 10;
            hs.next = new ListNode(cur);
            h1 = h1.next;
            hs = hs.next;
        }
        while(h2 != null){
            total = h2.val + add;
            cur = total % 10;
            add = total / 10;
            hs.next = new ListNode(cur);
            h2 = h2.next;
            hs = hs.next;
        }
        while(add != 0){
            cur = add % 10;
            add = add /10;
            hs.next = new ListNode(cur);
            hs = hs.next;
        }
        return sum;
    }

    public static void main(String[] args){
        AddTwoNumbers demo = new AddTwoNumbers();
        ListNode l1 =  demo.new ListNode(0);
        ListNode l11 =  demo.new ListNode(0);
        ListNode l12 =  demo.new ListNode(5);
        l1.next = l11;
        l11.next = l12;
        l12.next = null;
        ListNode l2 =  demo.new ListNode(0);
        ListNode l21 =  demo.new ListNode(0);
        ListNode l22 =  demo.new ListNode(5);
        l2.next = l21;
        l21.next = l22;
        l22.next = null;
        ListNode res = demo.addTwoNumbers(l1,l2);
        ListNode head = res;
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
