package Library;

import java.util.ArrayList;

public class Library {
    private final int MAXBOOKS = 10;
    ArrayList<Book>  myBooks = new ArrayList<>();

    public Library() {
        System.out.println("Hello, I am a library, which can store up to 10 books!");
    }

    public void add(Book book){
        if(myBooks.size() < 10){
            myBooks.add(book);
            System.out.println("I added the book " + book.toString() + "!");
        }
        else System.out.println("The library is full!");
    }

    public Book search(String title){

        for (Book book : myBooks) {
            if(book.toString() == title){
                System.out.println("The book with the title " + title +" exists in the library!");
                return book;
            }
        }
        System.out.println("The book with the title " + title +" does not exist in the library!");
        return null;
    }
}
