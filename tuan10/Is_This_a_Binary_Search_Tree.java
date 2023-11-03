/* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.

The Node class is defined as follows:
    class Node {
        int data;
        Node left;
        Node right;
     }
*/
public static ArrayList<Integer> a = new ArrayList<>();
public static void DFS(Node root) {
        if (root.left != null) DFS(root.left);
        a.add(root.data);
        if (root.right != null) DFS(root.right);
        }

        boolean checkBST(Node root) {
        DFS(root);
        for (int i = 0; i < a.size() - 1; i++) if (a.get(i) >= a.get(i + 1)) return false;
        return true;
        }