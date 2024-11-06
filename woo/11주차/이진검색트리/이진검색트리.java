import java.util.*;

public class Main {
    private static Node root;
    private static List<Integer> preOrderList;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        preOrderList = new ArrayList<>();

        // 입력이 더 이상 없을 때까지 숫자를 읽어 리스트에 추가
        while (sc.hasNextInt()) {
            preOrderList.add(sc.nextInt());
        }
        root = new Node(preOrderList.get(0));
        for (int i = 1; i < preOrderList.size(); i++) {
            insert(root, preOrderList.get(i));
        }
        postorder(root);
    }

    private static void postorder(Node root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.value);
    }

    private static Node insert(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }
        if (value < node.value) {
            node.left = insert(node.left, value);
        } else if (value > node.value) {
            node.right = insert(node.right, value);
        }
        return node;
    }

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Node(int value) {
            this.value = value;
        }
    }
}
