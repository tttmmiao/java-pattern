package leetcode;


/**
 * see https://leetcode.com/problems/merge-k-sorted-lists/description/
 * 自己的思路：将节点放在数组中比较
 * 考虑性能的思路：二分的方式，一半一半合并
 */
public class MergeKSortedLists {
    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode res = new ListNode(-1);
        ListNode p = res.next;
        int len = lists.length;
        merge(0,len-1,lists);
        return res.next;
    }

    public static ListNode merge(int start, int end, ListNode[] lists){
        if(end < start){
            return null;
        }
        if(start == end){
            return lists[start];
        }
        int mid = (start + end) / 2;
        ListNode left = merge(start,mid,lists);
        ListNode right = merge(mid+1, end, lists);

        //todo
        return left;

    }

    /**
     * 空间复杂度为O(N),时间复杂度为O(N2)
     */
    public static ListNode mergeKListsV1(ListNode[] lists) {
        ListNode res = new ListNode(-1);
        ListNode head = res;
        int len = lists.length;
        ListNode[] pL = new ListNode[len];
        for(int i = 0;i < len;i++){
            ListNode cur = lists[i];
            if(cur != null ){
                pL[i] = cur;
            }
        }
        int minVal = 0;
        int pos = 0;
        while(pos != -1){
            minVal = Integer.MAX_VALUE;
            pos = -1;
            for(int i = 0;i < len;i++){
                if(pL[i] != null && pL[i].val <= minVal){
                    minVal = pL[i].val;
                    pos = i;
                }
            }
            if(pos != -1){
                head.next = pL[pos];
                pL[pos] = pL[pos].next;
                head = head.next;
            }else{
                break;
            }
        }
        return res.next;
    }

    public static void main(String[] args){
        ListNode[] lists = new ListNode[3];
        ListNode l1 = new ListNode(1);
        ListNode l11 = new ListNode(4);
        ListNode l12 = new ListNode(5);
        l1.next = l11;
        l11.next = l12;
        l12.next = null;

        lists[0] = l1;
        ListNode l2 = new ListNode(1);
        ListNode l21 = new ListNode(3);
        ListNode l22 = new ListNode(4);
        l2.next = l21;
        l21.next = l22;
        l22.next = null;
        lists[1] = l2;

        ListNode l3 = new ListNode(2);
        ListNode l31 = new ListNode(6);
        l3.next = l31;
        l31.next = null;
        lists[2] = l3;

        ListNode res = mergeKLists(lists);
        while(res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }
}
