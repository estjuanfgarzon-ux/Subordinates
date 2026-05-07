import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

// Node structure for tree
class Node {

    long data;
    List<Node> children;

    Node(long x) {

        data = x;
        children = new ArrayList<>();
    }

    Node get(long p) {

        if (p == data)
            return this;

        for (Node node : children)
            return node.get(p);

        return null;
    }
}

public class Subordinates {

    static List<Integer>[] tree;
    static int[] subordinates;

    // Function to add a child to a node
    static void addChild(Node parent, Node child) {

        if (parent == null)
            return;

        parent.children.add(child);
    }

    static void dfs(int node) {

        subordinates[node] = 0;

        for (int child : tree[node]) {

            dfs(child);

            subordinates[node] += 1 + subordinates[child];
        }
    }

    // Function to print parents of each node
    static void printParents(Node node, Node parent) {

        if (parent == null)
            System.out.println(node.data + " -> NULL");
        else
            System.out.println(node.data + " -> " + parent.data);

        for (Node child : node.children)
            printParents(child, node);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        tree = new ArrayList[n + 1];
        subordinates = new int[n + 1];

        for (int i = 1; i <= n; i++)
            tree[i] = new ArrayList<>();

        Node root = new Node(1);

        for (int i = 2; i <= n; i++) {

            Node node = new Node(i);

            int boss = sc.nextInt();

            addChild(root.get(boss), node);

            tree[boss].add(i);
        }

        System.out.println("Parents of each node:");

        printParents(root, null);

        dfs(1);

        for (int i = 1; i <= n; i++)
            System.out.print(subordinates[i] + " ");
    }
}