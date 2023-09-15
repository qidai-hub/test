import javafx.scene.layout.Priority;

import javax.swing.tree.TreeNode;
import java.util.*;

/**
 * 反转链表
 */
public class E01Leetcode206 {

    public String simplifyPath(String path) {
        // 以"/"作为分隔符  "/home//foo/"->"","home","","foo"
        //用栈存目录名称
        String[] names = path.split("/");
        Deque<String> queue = new LinkedList<>();
        for(String name:names){
            if("".equals(name) || ".".equals(name)){
                continue;
            }
            if("..".equals(name)){
                if(queue.size()>0){
                    queue.pollLast();
                }else{
                    continue;
                }
            }
            queue.offer(name);
        }
        // 加入分隔符"/"
        StringBuilder sb = new StringBuilder();
        if(queue.isEmpty())return "/";
        while(!queue.isEmpty()){
            sb.append("/"+queue.poll());
        }
        return sb.toString();
    }

    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {
        }
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }








    public static void main(String[] args) {
        E01Leetcode206 e01Leetcode206 = new E01Leetcode206();//
        Deque<TreeNode> deque = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        TreeNode treeNode = new TreeNode(1,new TreeNode(2,null,new TreeNode(3,null,null)),new TreeNode(2,null,new TreeNode(3,null,null)));
        TreeNode treeNode1 = new TreeNode();
        System.out.println(treeNode==treeNode1);


        e01Leetcode206.simplifyPath("/a/./b/../../c/");



    }

}
