package treeset;

import java.util.*;


class Movie implements Comparable<Movie> {
    int id;
    String name;
    double rating;

    Movie(int id, String name, double rating) {
        this.id = id;
        this.name = name;
        this.rating = rating;
    }

    // Sorting based on rating
    public int compareTo(Movie m) {
        return Double.compare(this.rating, m.rating);
    }

    public String toString() {
        return name + "(" + rating + ")";
    }
}

public class MovieManager {
    public static void main(String[] args) {

        TreeSet<Movie> movies = new TreeSet<>();

        // 🔹 Adding elements
        movies.add(new Movie(1, "Inception", 8.8));
        movies.add(new Movie(2, "Avatar", 7.9));
        movies.add(new Movie(3, "Interstellar", 8.6));
        movies.add(new Movie(4, "Joker", 8.5));
        movies.add(new Movie(5, "Titanic", 7.8));

        System.out.println("All Movies (Sorted): " + movies);

        // 🔴 SortedSet methods
        System.out.println("\n--- SortedSet Methods ---");

        System.out.println("First (Lowest): " + movies.first());
        System.out.println("Last (Highest): " + movies.last());

        System.out.println("HeadSet (<8.5): " +
                movies.headSet(new Movie(0, "", 8.5)));

        System.out.println("TailSet (>=8.5): " +
                movies.tailSet(new Movie(0, "", 8.5)));

        System.out.println("SubSet (8.0 to 8.8): " +
                movies.subSet(new Movie(0, "", 8.0),
                              new Movie(0, "", 8.8)));

        // 🔴 NavigableSet methods
        System.out.println("\n--- NavigableSet Methods ---");

        System.out.println("Ceiling (>=8.4): " +
                movies.ceiling(new Movie(0, "", 8.4)));

        System.out.println("Floor (<=8.4): " +
                movies.floor(new Movie(0, "", 8.4)));

        System.out.println("Higher (>8.5): " +
                movies.higher(new Movie(0, "", 8.5)));

        System.out.println("Lower (<8.5): " +
                movies.lower(new Movie(0, "", 8.5)));

        // 🔴 Removal methods
        System.out.println("\n--- Removal Methods ---");

        System.out.println("Poll First (remove lowest): " +
                movies.pollFirst());

        System.out.println("Poll Last (remove highest): " +
                movies.pollLast());

        System.out.println("After Removal: " + movies);

        // 🔴 Reverse operations
        System.out.println("\n--- Reverse Operations ---");

        System.out.println("Descending Set: " +
                movies.descendingSet());

        System.out.print("Descending Iterator: ");
        Iterator<Movie> it = movies.descendingIterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        // 🔴 Advanced Range (inclusive/exclusive)
        System.out.println("\n--- Advanced Range ---");

        System.out.println("SubSet inclusive/exclusive: " +
                movies.subSet(new Movie(0,"",7.9), true,
                              new Movie(0,"",8.8), false));

        System.out.println("HeadSet inclusive: " +
                movies.headSet(new Movie(0,"",8.5), true));

        System.out.println("TailSet exclusive: " +
                movies.tailSet(new Movie(0,"",8.5), false));
    }
}
