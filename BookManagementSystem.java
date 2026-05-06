package arraylistpractice;

import java.util.*;

// Book class
class Book implements Comparable<Book> {
    int id;
    String name;
    String author;

    // Constructor
    Book(int id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }

    // toString() → for printing
    public String toString() {
        return id + " " + name + " " + author;
    }

    // equals() → for contains(), remove()
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;

        Book b = (Book) o;
        return this.id == b.id && this.name.equals(b.name) && this.author.equals(b.author);
    }

    // hashCode() → must with equals()
    public int hashCode() {
        return Objects.hash(id, name, author);
    }

    // Comparable → default sorting (by name)
    public int compareTo(Book b) {
        return this.name.compareTo(b.name);
    }
}

// Comparator → sort by id
class IdComparator implements Comparator<Book> {
    public int compare(Book a, Book b) {
        return a.id - b.id;
    }
}

class IdComparator2 implements Comparator<Book> {
    public int compare(Book a, Book b) {
        return Integer.compare(a.id,b.id);
    }
}


// Comparator → sort by author
class AuthorComparator implements Comparator<Book> {
    public int compare(Book a, Book b) {
        return a.author.compareTo(b.author);
    }
}

public class BookManagementSystem {
    public static void main(String[] args) {

        ArrayList<Book> books = new ArrayList<>();

        // add()
        books.add(new Book(3, "Java", "James"));
        books.add(new Book(1, "Python", "Guido"));
        books.add(new Book(2, "C++", "Bjarne"));

        System.out.println("Original List:");
        books.forEach(System.out::println);

        // contains()
        System.out.println("\nContains Java book: " +
                books.contains(new Book(3, "Java", "James")));

        // remove()
        books.remove(new Book(2, "C++", "Bjarne"));

        // add(index)
        books.add(1, new Book(4, "DSA", "CLRS"));

        // get()
        System.out.println("\nFirst Book: " + books.get(0));

        // set()
        books.set(0, new Book(10, "Java Updated", "James"));

        // size()
        System.out.println("Total Books: " + books.size());

        // indexOf()
        System.out.println("Index of Python: " +
                books.indexOf(new Book(1, "Python", "Guido")));

        // iterator()
        System.out.println("\nUsing Iterator:");
        Iterator<Book> it = books.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // toArray()
        Book[] arr = books.toArray(new Book[0]);
        System.out.println("\nArray:");
        for (Book b : arr) {
            System.out.println(b);
        }

        // ================= SORTING =================


        Collections.sort(books, (a, b) -> a.id - b.id);


        Collections.sort(books, (a, b) -> Integer.compare(a.id, b.id));

        Collections.sort(books, (a, b) -> a.author.compareTo(b.author));

        books.sort((a, b) -> Integer.compare(a.id, b.id));

        // 1. Comparable (by name)
        Collections.sort(books);
        System.out.println("\nSorted by Name (Comparable):");
        books.forEach(System.out::println);

        // 2. Comparator (by id)
        Collections.sort(books, new IdComparator());
        System.out.println("\nSorted by ID (Comparator):");
        books.forEach(System.out::println);

        // 3. Comparator (by author)
        Collections.sort(books, new AuthorComparator());
        System.out.println("\nSorted by Author (Comparator):");
        books.forEach(System.out::println);

        // ================= STREAM =================
        System.out.println("\nUsing Stream:");
        books.stream().forEach(System.out::println);

        // ================= CLEAR =================
        books.clear();
        System.out.println("\nAfter clear: " + books);
    }
}
