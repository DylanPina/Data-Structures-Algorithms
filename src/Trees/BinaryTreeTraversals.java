package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node<T> {
    T data;
    Node<T> left, right;

    public Node(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public String toString() {
        return this.data.toString();
    }

}

class BinaryTree<T> {
    Node<T> root;

    public void preOrderIterative(Node<T> node) {
        if (node == null)
            return;

        Stack<Node<T>> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            Node<T> current = stack.pop();
            System.out.print(current + " ");

            if (current.right != null)
                stack.push(current.right);
            if (current.left != null)
                stack.push(current.left);
        }
    }

    public void preOrderRecursive(Node<T> node) {
        if (node == null)
            return;

        System.out.print(node + " ");
        preOrderRecursive(node.left);
        preOrderRecursive(node.right);
    }

    public void inOrderIterative(Node<T> node) {
        if (node == null)
            return;

        Stack<Node<T>> stack = new Stack<>();
        Node<T> current = node;

        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            System.out.print(current + " ");
            current = current.right;
        }
    }

    public void inOrderRecursive(Node<T> node) {
        if (node == null)
            return;

        inOrderRecursive(node.left);
        System.out.print(node + " ");
        inOrderRecursive(node.right);
    }

    public void postOrderIterative(Node<T> node) {
        if (node == null)
            return;

        Stack<Node<T>> stack1 = new Stack<>();
        Stack<Node<T>> stack2 = new Stack<>();
        stack1.push(node);

        while (!stack1.isEmpty() ) {
            Node<T> temp = stack1.pop();
            stack2.push(temp);

            if (temp.left != null)
                stack1.push(temp.left);
            if (temp.right != null)
                stack1.push(temp.right);
        }

        while (!stack2.isEmpty()) {
            Node<T> temp = stack2.pop();
            System.out.print(temp + " ");
        }

    }

    public void postOrderRecursive(Node<T> node) {
        if (node == null)
            return;

        postOrderRecursive(node.left);
        postOrderRecursive(node.right);
        System.out.print(node + " ");
    }

    public void bfs(Node<T> node) {
        if (node == null)
            return;

        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            int qLen = queue.size();

            for (int i = 0; i < qLen; i++) {
                Node<T> current = queue.poll();
                System.out.print(current + " ");
                if (current.left != null)
                    queue.add(current.left);
                if (current.right != null)
                    queue.add(current.right);
            }
        }
    }

}

class BinaryTreeTraversals {

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.root = new Node<Integer>(10);
        tree.root.left = new Node<Integer>(8);
        tree.root.right = new Node<Integer>(6);
        tree.root.left.left = new Node<Integer>(4);
        tree.root.left.right = new Node<Integer>(5);
        tree.root.right.left = new Node<Integer>(3);
        tree.root.right.right = new Node<Integer>(2);

        System.out.println("ITERATIVE: Preorder Traversal ");
        tree.preOrderIterative(tree.root);
        System.out.println("\nRECURSIVE: Preorder Traversal ");
        tree.preOrderRecursive(tree.root);

        System.out.println("\nITERATIVE: Inorder Traversal ");
        tree.inOrderIterative(tree.root);
        System.out.println("\nRECURSIVE: Inorder Traversal ");
        tree.inOrderRecursive(tree.root);

        System.out.println("\nITERATIVE: Postorder Traversal ");
        tree.postOrderIterative(tree.root);
        System.out.println("\nRECURSIVE: Postorder Traversal ");
        tree.postOrderRecursive(tree.root);

        System.out.println("\nRECURSIVE: Breadth First Search ");
        tree.bfs(tree.root);
    }

}
