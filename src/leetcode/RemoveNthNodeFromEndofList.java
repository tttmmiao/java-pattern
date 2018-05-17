package leetcode;

/**
 * see https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 * 基本想法：
 * step1，计算链表的长度
 * step2, 找到len-n的位置，修改链表
 */
public class RemoveNthNodeFromEndofList {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode res = head;
        ListNode cur = head;
        int len = 0;
        while(null != cur){
            len++;
            cur = cur.next;
        }
        cur = head;
        ListNode pre = null;
        ListNode next = cur.next;
        int cnt = 0;
        while(cnt < len - n){
            cnt++;
            pre = cur;
            cur = next;
            next = next.next;
        }
        //删除第一个节点
        if(pre == null){
            head = cur.next;
            res = head;
        }else{
            //需要删除的位置
            pre.next = next;
            cur = null;
        }
        return res;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        ListNode e1 = new ListNode(2);
        ListNode e2 = new ListNode(3);
        ListNode e3 = new ListNode(4);
        ListNode e4 = new ListNode(5);
        head.next = null;
       /* e1.next = null;
        e2.next = e3;
        e3.next = e4;
        e4.next = null;*/
        int n = 1;
        ListNode res = removeNthFromEnd(head,n);
        ListNode p = res;
        while(null != p){
            System.out.println(p.val);
            p = p.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}