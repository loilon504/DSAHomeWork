import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

	/*

    class Node
    	int data;
    	Node left;
    	Node right;
	*/

    public static Node[] a = new Node[505];
    public static void levelOrder(Node root) {
        int l = 1, r = 0;
        a[++r] = root;
        while (l <= r) {
            int save = r;
            for (int i = l; i <= save; i++) {
                System.out.print(a[i].data + " ");
                if (a[i].left != null) a[++r] = a[i].left;
                if (a[i].right != null) a[++r] = a[i].right;
            }
            l = save + 1;
        }
    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        levelOrder(root);
    }
}