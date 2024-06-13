import javafx.beans.binding.NumberBinding;

public class BinarTree {
    int[] a = {1, 2, 3, 4, 5, 7, 10, 12, 0};

    private Node root = new Node();

    public boolean addNode(Node current, Node node) {
        boolean added = true;
        System.out.println(current.value);
        System.out.println(current.setted);
        if(current==null || current.setted==false){
            current = new Node(node.value, null, null);
            current.setted=true;
            return true;
        }

        if(current.left==null) {
            added = this.addNode(current.left, node);
        }
        if(added==false && current.right==null) {
            added = this.addNode(current.right, node);
        }
        return added;
    }

    public void initBT() {
        for(int x : this.a) {
            System.out.println(x);
            this.addNode(this.root, new Node(x, null, null));
        }
    }

    public void display(Node node) {
        if(node==null) {
            return ;
        }else {
            System.out.print(node.value);
            if(node.left!=null) {
                display(node.left);
            }
            if(node.right!=null) {
                display(node.right);
            }
            System.out.println();
            return ;
        }
    }

    public static void main(String args[]) {
        BinarTree bt = new BinarTree();
        bt.initBT();
        bt.display(bt.root);
        System.out.print(bt.root.value);

    }

}



class Node{
    public int value;
    public Node left = null;
    public Node right = null;
    public boolean setted = false;
    public Node() {
    }

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
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
