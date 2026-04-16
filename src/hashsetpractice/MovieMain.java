package hashsetpractice;

import java.util.*;
// Movie class
class Movie {
    String name;
    double rating;

    Movie(String name, double rating) {
        this.name = name;
        this.rating = rating;
    }

    // For printing
    public String toString() {
        return name + " (" + rating + ")";
    }

    // For HashSet uniqueness
    public int hashCode() {
        return name.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Movie)) return false;
        Movie m = (Movie) obj;
        return this.name.equals(m.name);
    }
}

// Main class
public class MovieMain {
    public static void main(String[] args) {

        // ===============================
        // 1. CREATE HASHSET
        // ===============================
        HashSet<Movie> movies = new HashSet<>();

        // ===============================
        // 2. add()
        // ===============================
        movies.add(new Movie("Inception", 8.8));
        movies.add(new Movie("Avatar", 7.9));
        movies.add(new Movie("Titanic", 7.8));
        movies.add(new Movie("Interstellar", 8.6));

        // Duplicate (will not be added)
        movies.add(new Movie("Inception", 8.8));

        System.out.println("Initial Movies: " + movies);

        // ===============================
        // 3. size() and isEmpty()
        // ===============================
        System.out.println("Size: " + movies.size());
        System.out.println("Is Empty: " + movies.isEmpty());

        // ===============================
        // 4. contains()
        // ===============================
        System.out.println("Contains Titanic? " +
                movies.contains(new Movie("Titanic", 7.8)));

        // ===============================
        // 5. remove()
        // ===============================
        movies.remove(new Movie("Avatar", 7.9));
        System.out.println("After removing Avatar: " + movies);

        // ===============================
        // 6. iterator()
        // ===============================
        System.out.println("\nIterating using Iterator:");
        Iterator<Movie> itr = movies.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        // ===============================
        // 7. addAll()
        // ===============================
        HashSet<Movie> moreMovies = new HashSet<>();
        moreMovies.add(new Movie("Joker", 8.5));
        moreMovies.add(new Movie("Avengers", 8.0));

        movies.addAll(moreMovies);
        System.out.println("\nAfter addAll: " + movies);

        // ===============================
        // 8. containsAll()
        // ===============================
        System.out.println("Contains all moreMovies? " +
                movies.containsAll(moreMovies));

        // ===============================
        // 9. removeAll()
        // ===============================
        movies.removeAll(moreMovies);
        System.out.println("After removeAll: " + movies);

        // ===============================
        // 10. retainAll()
        // ===============================
        HashSet<Movie> temp = new HashSet<>();
        temp.add(new Movie("Inception", 8.8));

        movies.retainAll(temp);
        System.out.println("After retainAll: " + movies);

        // ===============================
        // 11. clone()
        // ===============================
        HashSet<Movie> cloned =
                (HashSet<Movie>) movies.clone();
        System.out.println("Cloned Set: " + cloned);

        // ===============================
        // 12. toArray()
        // ===============================
        Object[] arr = movies.toArray();
        System.out.println("Array:");
        for (Object o : arr) {
            System.out.println(o);
        }

        // ===============================
        // 13. spliterator()
        // ===============================
        System.out.println("\nUsing Spliterator:");
        Spliterator<Movie> sp = movies.spliterator();
        sp.forEachRemaining(System.out::println);

        // ===============================
        // 14. CLEAR
        // ===============================
        moreMovies.clear();
        System.out.println("After clearing moreMovies: " + moreMovies);

        // ===============================
        // 15. SORTING (IMPORTANT)
        // ===============================

        // Re-add data
        movies.add(new Movie("Titanic", 7.8));
        movies.add(new Movie("Avatar", 7.9));
        movies.add(new Movie("Interstellar", 8.6));

        List<Movie> list = new ArrayList<>(movies);

        // Sort by Name (Ascending)
        Collections.sort(list, (a, b) -> a.name.compareTo(b.name));
        System.out.println("\nSorted by Name:");
        for (Movie m : list) {
            System.out.println(m);
        }

        // Sort by Rating (Descending)
        Collections.sort(list, (a, b) -> Double.compare(b.rating, a.rating));
        System.out.println("\nSorted by Rating (Descending):");
        for (Movie m : list) {
            System.out.println(m);
        }
    }
}
