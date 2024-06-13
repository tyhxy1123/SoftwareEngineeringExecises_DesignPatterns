public class Node {
    public Node() {
    }

    public Node(Node fatherNode, Node left, Node right) {
        this.fatherNode = fatherNode;
        this.left = left;
        this.right = right;
    }

    private Node fatherNode = new Node();
    private Node left = new Node();
    private Node right = new Node();
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getFatherNode() {
        return fatherNode;
    }

    public void setFatherNode(Node fatherNode) {
        this.fatherNode = fatherNode;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }


}


