package DataStructure;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;

public class BinaryTree<T> {


    public static void main(String[] args) {


        int[] arr = new int[]{3,9,20, 1, 0, 15,7};
        String[] str = new String[]{"A", "B", "C", "D", "E", "F", "G", null, "H"};


        BinaryTree<String> tree = new BinaryTree();

        BinaryTreeNode<String> root = tree.create(str, 0);

        tree.levelOrder(root);
        System.out.println();
//        tree.preOrder(root);
//        System.out.println();
//        tree.postOrder(root);
//        System.out.println();

    }


    public static void preOrder(BinaryTreeNode rootNode) {
        if (Objects.nonNull(rootNode.data)) {
            System.out.print(rootNode.data + " ");
        }

        if (rootNode.left != null) {
            preOrder(rootNode.left);
        }
        if (rootNode.right != null) {
            preOrder(rootNode.right);
        }
    }


    public  void inOrder(BinaryTreeNode rootNode) {
        if (rootNode.left != null) {
            inOrder(rootNode.left);
        }
        if (Objects.nonNull(rootNode.data)) {
            System.out.print(rootNode.data + " ");
        }

        if (rootNode.right != null) {
            inOrder(rootNode.right);
        }
    }

    public void postOrder(BinaryTreeNode rootNode) {
        if (rootNode.left != null) {
            postOrder(rootNode.left);
        }

        if (rootNode.right != null) {
            postOrder(rootNode.right);
        }
        if (Objects.nonNull(rootNode.data)) {
            System.out.print(rootNode.data + " ");
        }
    }

    public void levelOrder(BinaryTreeNode rootNode) {
        ArrayDeque<BinaryTreeNode> arrayDeque = new ArrayDeque<>();
        arrayDeque.add(rootNode);

        while (!arrayDeque.isEmpty()) {
            BinaryTreeNode s = arrayDeque.poll();
            if (s.data != null) {
                System.out.print(s.data + " ");
            }
            if (s.left != null) {
                arrayDeque.add(s.left);
            }
            if (s.right != null) {
                arrayDeque.add(s.right);
            }
        }

        System.out.println(1);
    }
    // 使用数组需要提前知道树节点个数
    public void levelOrder2(BinaryTreeNode rootNode) {
        LinkedList<BinaryTreeNode> arrayList = new LinkedList<>();
        arrayList.add(rootNode);
        int k = 0;
        while (arrayList.get(k) != null) {
            BinaryTreeNode s = arrayList.get(k);
            if (s.data != null) {
                System.out.print(s.data + " ");
            }
            if (s.left != null) {
                arrayList.add(s.left);
            }
            if (s.right != null) {
                arrayList.add(s.right);
            }
            k++;
        }
    }


    public  BinaryTreeNode<T> create(T[] arr, int pos) {
        if (pos < arr.length && Objects.nonNull(arr[pos])) {
            BinaryTreeNode<T> node = new BinaryTreeNode<>(arr[pos]);
            node.left  = create(arr, 2 * pos + 1);
            node.right = create(arr, 2 * pos + 2);
            return node;
        }
        return null;
    }





    static class BinaryTreeNode<T>{
        private T data;

        private BinaryTreeNode left;
        private BinaryTreeNode right;

        public BinaryTreeNode(T d, BinaryTreeNode<T> l, BinaryTreeNode<T> r) {
            this.data = d;
            this.left= l;
            this.right = r;
        }

        public BinaryTreeNode(T d ) {
            this.data = d;
        }

//        public T getData() {
//            return data;
//        }
//
//        public BinaryTreeNode<T> getLeft() {
//            return left;
//        }
//
//        public void setLeft(BinaryTreeNode<T> left) {
//            this.left = left;
//        }
//
//        public BinaryTreeNode<T> getRight() {
//            return right;
//        }
//
//        public void setRight(BinaryTreeNode<T> right) {
//            this.right = right;
//        }
    }
}
