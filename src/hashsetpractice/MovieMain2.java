package hashsetpractice;

import java.util.*;

// ===============================
// Movie class (Comparable by NAME)
// ===============================
class Movie implements Comparable<Movie> {
    String name;
    double rating;

    Movie(String name, double rating) {
        this.name = name;
        this.rating = rating;
    }

    public String toString() {
        return name + " (" + rating + ")";
    }

    // HashSet uniqueness
    public int hashCode() {
        return Objects.hash(name);
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Movie)) return false;
        Movie m = (Movie) obj;
        return this.name.equals(m.name);
    }

    // Comparable → SORT BY NAME
    @Override
    public int compareTo(Movie m) {
        return this.name.compareTo(m.name);
    }
    
    /* 
    @Override
     public int compareTo(Movie m) {
    return Double.compare(this.rating, m.rating);
      }
    */
    
}

// ===============================
// Comparator → SORT BY RATING
// ===============================
class RatingComparator implements Comparator<Movie> {
    public int compare(Movie m1, Movie m2) {
        return Double.compare(m2.rating, m1.rating); // Descending
    }
}

// ===============================
// Comparator → SORT BY NAME (EXTRA)
// ===============================
class NameComparator implements Comparator<Movie> {
    public int compare(Movie m1, Movie m2) {
        return m1.name.compareTo(m2.name);
    }
}

// ===============================
// MAIN CLASS
// ===============================
public class MovieMain2 {
    public static void main(String[] args) {

        // ===============================
        // HASHSET (Original)
        // ===============================
        HashSet<Movie> movies = new HashSet<>();

        movies.add(new Movie("Inception", 8.8));
        movies.add(new Movie("Avatar", 7.9));
        movies.add(new Movie("Titanic", 7.8));
        movies.add(new Movie("Interstellar", 8.6));
        movies.add(new Movie("Inception", 8.8)); // duplicate

        System.out.println("HashSet: " + movies);


        // ===============================
// EXTRA HASHSET METHODS (ADDED)
// ===============================

// contains()
System.out.println("\nContains 'Avatar': " + 
    movies.contains(new Movie("Avatar", 7.9)));

// size()
System.out.println("Size: " + movies.size());

// isEmpty()
System.out.println("Is Empty: " + movies.isEmpty());

// remove()
movies.remove(new Movie("Titanic", 7.8));
System.out.println("\nAfter remove Titanic:");
movies.forEach(System.out::println);

// addAll()
HashSet<Movie> newMovies = new HashSet<>();
newMovies.add(new Movie("Joker", 8.5));
newMovies.add(new Movie("Avengers", 8.0));

movies.addAll(newMovies);
System.out.println("\nAfter addAll:");
movies.forEach(System.out::println);

// containsAll()
System.out.println("\nContainsAll newMovies: " + movies.containsAll(newMovies));

// removeAll()
movies.removeAll(newMovies);
System.out.println("\nAfter removeAll (removed newMovies):");
movies.forEach(System.out::println);

// retainAll()
HashSet<Movie> retainSet = new HashSet<>();
retainSet.add(new Movie("Inception", 8.8));

movies.retainAll(retainSet);
System.out.println("\nAfter retainAll (only Inception kept):");
movies.forEach(System.out::println);

// clone()
HashSet<Movie> clonedSet = (HashSet<Movie>) movies.clone();
System.out.println("\nCloned Set:");
clonedSet.forEach(System.out::println);

// toArray()
Object[] arr = movies.toArray();
System.out.println("\nConverted to Array:");
for (Object o : arr) {
    System.out.println(o);
}

// removeIf() (Java 8)
movies.removeIf(m -> m.rating < 9.0);
System.out.println("\nAfter removeIf (rating < 9):");
movies.forEach(System.out::println);

// clear()
movies.clear();
System.out.println("\nAfter clear(): " + movies);

        // ===============================
        // LINKEDHASHSET (Maintains Order)
        // ===============================
        LinkedHashSet<Movie> linkedSet = new LinkedHashSet<>(movies);

        System.out.println("\nLinkedHashSet (Insertion Order):");
        for (Movie m : linkedSet) {
            System.out.println(m);
        }

        // ===============================
        // TREESET USING COMPARABLE
        // ===============================
        TreeSet<Movie> treeByName = new TreeSet<>(movies);

        System.out.println("\nTreeSet (Sorted by Name - Comparable):");
        for (Movie m : treeByName) {
            System.out.println(m);
        }

        // ===============================
        // TREESET USING COMPARATOR (Rating)
        // ===============================
        TreeSet<Movie> treeByRating = new TreeSet<>(new RatingComparator());
        treeByRating.addAll(movies);

        System.out.println("\nTreeSet (Sorted by Rating - Comparator):");
        for (Movie m : treeByRating) {
            System.out.println(m);
        }

        // ===============================
        // TREESET USING COMPARATOR (Name)
        // ===============================
        TreeSet<Movie> treeByNameComparator = new TreeSet<>(new NameComparator());
        treeByNameComparator.addAll(movies);

        System.out.println("\nTreeSet (Sorted by Name - Comparator):");
        for (Movie m : treeByNameComparator) {
            System.out.println(m);
        }

        // ===============================
        // ITERATOR
        // ===============================
        System.out.println("\nIterator:");
        Iterator<Movie> itr = movies.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        // ===============================
        // LIST + LISTITERATOR
        // ===============================
        List<Movie> list = new ArrayList<>(movies);

        System.out.println("\nListIterator Forward:");
        ListIterator<Movie> listItr = list.listIterator();
        while (listItr.hasNext()) {
            System.out.println(listItr.next());
        }

        System.out.println("\nListIterator Backward:");
        while (listItr.hasPrevious()) {
            System.out.println(listItr.previous());
        }

        // ===============================
        // SORT USING COLLECTIONS (Comparator)
        // ===============================

        // Sort by Name
        Collections.sort(list, new NameComparator());
        System.out.println("\nSorted List by Name:");
        list.forEach(System.out::println);

        // Sort by Rating
        Collections.sort(list, new RatingComparator());
        System.out.println("\nSorted List by Rating:");
        list.forEach(System.out::println);


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



/* 
🔴 ✅ IMPORTANT HashSet METHODS (WRITE IN EXAM)

👉 These are the most commonly used + expected ones

🔥 What to write in exam (perfect answer)

If question is:
👉 “Write methods of HashSet”

Write:

✔ Basic:
add()
remove()
contains()
size()
isEmpty()
clear()


✔ Traversal:
iterator()



✔ Bulk:
addAll()
removeAll()
retainAll()
containsAll()
✔ Utility:

clone()
toArray()
*/