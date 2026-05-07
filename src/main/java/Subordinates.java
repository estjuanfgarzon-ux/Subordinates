import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

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

    // Function to add a child to a node
    static void addChild(Node parent, Node child) {

        if (parent == null)
            return;

        parent.children.add(child);
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

        // The first input line has an integer n
        long n = sc.nextLong();

        // Relacionado padre - hijo
        Node root = new Node(1);

        for (long i = 2; i <= n; i++) {

            Node node = new Node(i);

            long idParent = sc.nextLong();

            addChild(root.get(idParent), node);
        }

        System.out.println("Parents of each node:");

        printParents(root, null);
    }
}