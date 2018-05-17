package leetcode;

/**
 * see https://leetcode.com/problems/merge-two-sorted-lists/description/
 */
public class MergeTwoSortedLists {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode r = res;
        ListNode p1 = l1;
        ListNode p2 = l2;
        while(null != p1 && null != p2){
            if(p1.val <= p2.val){
                r.next = p1;
                r = r.next;
                p1 = p1.next;
            }else{
                r.next = p2;
                r = r.next;
                p2 = p2.next;
            }
        }
        while(null != p1){
            r.next = p1;
            r = r.next;
            p1 = p1.next;
        }
        while(null != p2){
            r.next = p2;
            r = r.next;
            p2 = p2.next;
        }
        return res.next;
    }
    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode l11 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l21 = new ListNode(4);
        l1.next = l11;
        l11.next = null;
        l2.next = l21;
        l21.next = null;
        ListNode res = mergeTwoLists(l1,l2);
        ListNode p = res;
        while(null != p){
            System.out.println(p.val);
            p = p.next;
        }
    }
}