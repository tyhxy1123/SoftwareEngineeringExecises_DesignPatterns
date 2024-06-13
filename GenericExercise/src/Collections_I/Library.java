package Collections_I;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

class Library{
    private List<Book> stock;
    public Library(){
        stock = new LinkedList<Book>();
    }

    public void sortedInsertion(Book newBook){
        stock.add(newBook);
        Collections.sort(stock, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.compareTo(o2);
            }
        });
    }

    public Book searchForIsbn(String isbn){
        int index = Collections.binarySearch(stock, new Book(isbn), new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.compareTo(o2);
            }
        });
        if(index < 0){
            return null;
        }
        return stock.get(index);
    }

    public List<Book> searchForAuthor(String author){
        List<Book> foundBooks = new LinkedList<Book>();
        int i = 0;
        while(i < stock.size()){
            if(stock.get(i).getAuthor().equals(author)){
                foundBooks.add(stock.get(i));
            }
            i++;
        }
        return foundBooks;
    }

    public static void main(String[] args) {
        Library lib = new Library();
        String isbn = "3";
        lib.sortedInsertion(new Book("1", "a1", "Whatever"));
        lib.sortedInsertion(new Book("6", "a2", "Anyway"));
        lib.sortedInsertion(new Book("4", "a4", "okey"));
        lib.sortedInsertion(new Book("3", "a3", "Dockey"));
        lib.sortedInsertion(new Book("2", "a3", "Double"));
        for(int i = 0; i < lib.stock.size(); i++){
            System.out.println(lib.stock.get(i));
        }
        System.out.println(lib.searchForIsbn(isbn).toString());
    }
}

class Book implements Comparable<Book>{

    private String isbn;
    private String author;
    private String title;

    protected Book (String isbn, String author, String title){
        if(isbn == null || author == null || title == null){
            throw new NullPointerException();
        }
        if(isbn.isEmpty() || author.isEmpty() || title.isEmpty()){
            throw new NullPointerException();
        }
        this.isbn = isbn;
        this.author = author;
        this.title = title;
    }

    protected Book(String isbn){
        this.isbn = isbn;
        this.author = "";
        this.title = "";
    }
    protected String getIsbn(){
        return isbn;
    }
    protected String getAuthor(){
        return author;
    }
    protected String getTitle(){
        return title;
    }

    @Override
    public String toString(){
        return "ISBN: " + getIsbn() + ", Author: "
                + getAuthor() + ", Title: "
                + getTitle();
    }

    public int compareTo(Book b){
        return Integer.parseInt(this.getIsbn())
                - Integer.parseInt(b.getIsbn());
    }
}