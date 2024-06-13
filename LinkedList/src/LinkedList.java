public class LinkedList {

    private Node root = new Node(null, null, null);

    public void addNode(Node nodeToAdd, int value){
        nodeToAdd.setValue(value);
    }

    public Node findNullSpotInTheTree(Node root){
        Node currentNode = root;

        while(true){

            if(currentNode.getLeft() == null){
                Node newLeftNode = new Node(currentNode, null, null);
                currentNode.setLeft(newLeftNode);
                return currentNode.getLeft();
            }
            else if(currentNode.getRight() == null){
                Node newRightNode = new Node(currentNode, null, null);
                currentNode.setRight(newRightNode);
                return currentNode.getRight();
            }
        }
        if()






    }

    public static void main(String[] args){
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};




    }
}
