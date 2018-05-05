package algorithm;

/**
 * 二叉有序树 转换成 双向有序链表
 */
public class TreeConvert {

    public static void main(String[] args){
        TreeNode tree = initTree();

        TreeNode lastNode = null;
        TreeNode last = convert(tree,lastNode);
        TreeNode head = null;
        while(null != last && last.getLeft()!=null){
            head = last.getLeft();
            last = last.getLeft();
        }
        while(null != head){
            System.out.println(head.getVal());
            head = head.getRight();
        }
    }

    public static TreeNode initTree(){
        TreeNode root = new TreeNode(10);
        TreeNode l1 = new TreeNode(6);
        TreeNode l2 = new TreeNode(4);
        TreeNode l3 = new TreeNode(8);

        TreeNode r1 = new TreeNode(14);
        TreeNode r2 = new TreeNode(12);
        TreeNode r3 = new TreeNode(16);

        root.setLeft(l1);
        root.setRight(r1);
        l1.setLeft(l2);
        l1.setRight(l3);

        l2.setRight(null);
        l2.setLeft(null);

        l3.setRight(null);
        l3.setLeft(null);

        r1.setLeft(r2);
        r1.setRight(r3);
        r2.setRight(null);
        r2.setLeft(null);
        r3.setRight(null);
        r3.setLeft(null);
        return root;
    }


    public static TreeNode convert(TreeNode tree, TreeNode lastNode){
        if(null == tree){
            return null;
        }
        TreeNode cur = tree;
        if(null != cur.getLeft()){
            lastNode = convert(cur.getLeft(), lastNode);
        }
        //root和lastNode衔接起来
        cur.setLeft(lastNode);
        if(null != lastNode){
            lastNode.setRight(cur);
        }
        lastNode = cur;
        if(null != cur.getRight()){
            lastNode = convert(cur.getRight(),lastNode);
        }
        return lastNode;
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(){

    }

    public TreeNode(int val){
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}