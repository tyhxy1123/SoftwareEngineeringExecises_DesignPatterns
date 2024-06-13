package LinkedList;

public class ListElement {
    private String content;
    private ListElement next;

    public ListElement(String content) {
        if(content.isEmpty()){
            throw new IllegalArgumentException("illegal argument.");
        }
        if(content == null){
            throw new NullPointerException("content can not be null");
        }
        this.content = content;
        this.next = null;
    }

    public void setContent(String content) {
        if(content.isEmpty()){
            throw new IllegalArgumentException("illegal argument.");
        }
        if(content == null){
            throw new NullPointerException("content can not be null");
        }
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public ListElement getNext() {
        return next;
    }

    public void setNext(ListElement next) {
        this.next = next;
    }
}
