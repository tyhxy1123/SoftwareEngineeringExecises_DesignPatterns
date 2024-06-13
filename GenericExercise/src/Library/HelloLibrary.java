package Library;

public class HelloLibrary {
    public static void main(String[] args){
        new HelloLibrary().run();
    }

    public void run(){
        Library lib = new Library();
        Book book1 = new Book("Java for dummy!");
        Book book2 = new Book("Test book 2");
        lib.add(book1);
        Book foundBook = lib.search("Java for dummy!");


    }
}
