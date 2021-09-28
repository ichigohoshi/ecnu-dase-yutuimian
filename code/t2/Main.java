import java.util.*;

public class Main {

    private static class Node {
        int val;
        Node left, right;
        public Node() {}
        public Node(int val) {
            this.val = val;
        }
    }

    private static StringBuilder result = new StringBuilder();

    private static void build(List<Integer> preList, List<Integer> inList, Node root) {
        if (preList.isEmpty()) {
            return;
        }
        int val = root.val;
        int index = inList.indexOf(val);
        if (index > 0) {
            List<Integer> leftPreList = preList.subList(1, index+1);
            List<Integer> leftInList = inList.subList(0, index);
            Node left = new Node(leftPreList.get(0));
            root.left = left;
            build(leftPreList, leftInList, left);
        }
        int size = preList.size();
        if (index < size-1) {
            List<Integer> rightPreList = preList.subList(index+1, size);
            List<Integer> rightInList = inList.subList(index+1, size);
            Node right = new Node(rightPreList.get(0));
            root.right = right;
            build(rightPreList, rightInList, right);
        }
    }

    private static void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        result.append(root.val).append(' ');
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> preList = new ArrayList<>();
        List<Integer> inList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            preList.add(sc.nextInt());
        }
        for (int i = 0; i < n; i++) {
           inList.add(sc.nextInt());
        }
        sc.close();
        Node root = new Node(preList.get(0));
        build(preList, inList, root);
        postOrder(root);
        System.out.println(result.toString().trim());
    }

}
