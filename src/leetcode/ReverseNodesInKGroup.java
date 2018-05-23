package leetcode;

/**
 * see https://leetcode.com/problems/reverse-nodes-in-k-group/description/
 * 思路：关键是将各个group连接起来
 * pre_left, left, right
 *
 * 取余为0的位置 left = cur
 * 取余为k-1的位置 right = cur， pre_left.next = right, pre_left = left 剩余数量 <k,直接拼接返回ß
 *
 * 注意边界case：k<=1 和k>size
 */
public class ReverseNodesInKGroup {
    public static ListNode reverseKGroup(ListNode head, int k) {
        if(k <= 1){
            return head;
        }
        ListNode res = new ListNode(-1);
        int size = 0;
        //计算列表的长度
        ListNode tmp = head;
        while(null != tmp){
            size++;
            tmp = tmp.next;
        }
        if(k > size){
            return head;
        }
        //前一个group的末尾
        ListNode former_left = res;
        //当前group的最左和最右
        ListNode left = null;
        ListNode right = null;
        //两个指针逐个遍历
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;
        int cnt = 0;
        while(cnt < size){
            if(cnt % k == 0){
                left = cur;
            }
            //反转
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            if(cnt % k == k-1){
                right = pre;
                former_left.next = right;
                former_left = left;
                //剩余的数量不足以构成一个group
                if((size-cnt) <= k){
                    former_left.next = cur;
                    break;
                }
            }
            cnt++;
        }
        return res.next;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode l11 = new ListNode(2);
        ListNode l12 = new ListNode(3);
        ListNode l13 = new ListNode(4);
        ListNode l14 = new ListNode(5);
        l1.next = l11;
        l11.next = l12;
        l12.next = l13;
        l13.next = null;

        ListNode res = reverseKGroup(l1,2);
        while(res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }

}
