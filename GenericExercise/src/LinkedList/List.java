package LinkedList;

public class List{
    private ListElement head;
    private ListElement pointer;


    public void append(String content){
        if (content.isEmpty()) {
            throw new IllegalArgumentException("The argument 'content' cannot be empty!");
        }
        if (content == null) {
            throw new NullPointerException("The content is null");
        }
        ListElement node = new ListElement(content);
        if(head == null){
            head = node;
            return;
        }
        pointer = head;
        while(pointer.getNext() != null){
            pointer = pointer.getNext();
        }
        pointer.setNext(node);
    }

    public String remove(String string){
        if(head == null){
            return null;
        }
        if(head.getContent() == string){
            pointer = head;
            head = head.getNext();
            return pointer.getContent();
        }
        pointer = head;
        while(pointer.getNext() != null && pointer.getNext().getContent() != string){
            pointer = pointer.getNext();
        }
        if(pointer.getNext() == null){
            System.out.println("String does not exist in the list.");
            return null;
        }
        ListElement temp = pointer.getNext();
        pointer.setNext(pointer.getNext().getNext());
        return temp.getContent();
    }
}
