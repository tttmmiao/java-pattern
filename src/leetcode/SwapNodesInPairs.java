package leetcode;

/**
 * see https://leetcode.com/problems/swap-nodes-in-pairs/description/
 *
 */
public class SwapNodesInPairs {
    public static ListNode swapPairs(ListNode head) {
        int cnt = 0;
        ListNode pre = new ListNode(-1);
        ListNode res = pre;
        ListNode p = head;
        ListNode next = null;
        ListNode cur = null;
        while(null != p){
            if(cnt % 2 != 1){
                next = p;
                p = p.next;
            }else{
                cur = p;
                p = p.next;
                pre.next = cur;
                cur.next = next;
                next.next = null;
                pre = next;
            }
            cnt++;
        }
        if(cnt == 1){
            return head;
        }
        //是奇数，把最后一个节点的值加进来
        if(cnt%2 == 1){
            pre.next = next;
        }
        return res.next;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode l11 = new ListNode(4);
        ListNode l12 = new ListNode(5);
        ListNode l13 = new ListNode(6);
        l1.next = l11;
        l11.next = l12;
        l12.next = l13;
        l13.next = null;

        ListNode res = swapPairs(null);
        while(res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }
}
