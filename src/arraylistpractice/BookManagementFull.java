package arraylistpractice;

import java.util.*;



class Book {
    int id;
    String name;

    Book(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return id + " " + name;
    }

    // Required for contains(), equals()
    public boolean equals(Object o) {
        Book b = (Book) o;
        return this.id == b.id && this.name.equals(b.name);
    }
}

public class BookManagementFull {
    public static void main(String[] args) {

        ArrayList<Book> list = new ArrayList<>();
        ArrayList<Book> list2 = new ArrayList<>();

        // add()
        list.add(new Book(1, "Java"));
        list.add(new Book(2, "Python"));
        list.add(new Book(3, "C++"));

        // add(index, element)
        list.add(1, new Book(4, "DSA"));

        // addAll()
        list2.add(new Book(5, "AI"));
        list2.add(new Book(6, "ML"));
        list.addAll(list2);

        // size()
        System.out.println("Total Books: " + list.size());

        // contains()
        System.out.println("Contains Java: " + list.contains(new Book(1, "Java")));

        // containsAll()
        System.out.println("Contains All list2: " + list.containsAll(list2));

        // get()
        System.out.println("First Book: " + list.get(0));

        // set()
        list.set(0, new Book(10, "Java Updated"));

        // indexOf()
        System.out.println("Index of Python: " + list.indexOf(new Book(2, "Python")));

        // lastIndexOf()
        System.out.println("Last Index: " + list.lastIndexOf(new Book(2, "Python")));

        // remove(Object)
        list.remove(new Book(3, "C++"));

        // remove(index)
        list.remove(0);

        // removeIf()
        list.removeIf(b -> b.name.equals("AI"));

        // retainAll()
        list.retainAll(list2);

        // iterator()
        System.out.println("\nUsing Iterator:");
        Iterator<Book> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // forEach()
        System.out.println("\nUsing forEach:");
        list.forEach(b -> System.out.println(b));

        // toArray()
        Book[] arr = list.toArray(new Book[0]);
        System.out.println("\nArray:");
        for (Book o : arr) {
            System.out.println(o);
        }

        // isEmpty()
        System.out.println("\nIs Empty: " + list.isEmpty());

        // stream()
        System.out.println("\nUsing Stream:");
        list.stream().forEach(System.out::println);

        // parallelStream()
        System.out.println("\nUsing Parallel Stream:");
        list.parallelStream().forEach(System.out::println);

        // subList()
        if (list.size() > 0) {
            System.out.println("\nSubList:");
            System.out.println(list.subList(0, list.size()));
        }

        // equals()
        System.out.println("\nEquals list2: " + list.equals(list2));

        // hashCode()
        System.out.println("HashCode: " + list.hashCode());

        // clear()
        list.clear();

        System.out.println("\nAfter clear: " + list);
        System.out.println("Is Empty Now: " + list.isEmpty());
    }
}
