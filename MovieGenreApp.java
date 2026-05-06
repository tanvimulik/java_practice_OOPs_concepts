import java.util.*;

public class MovieGenreApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Step 1: Movie -> Genres
        Map<String, List<String>> movieMap = new LinkedHashMap<>();

        System.out.print("Enter number of movies: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {

            System.out.print("Enter movie name: ");
            String movie = sc.nextLine();

            System.out.print("Enter genres (comma separated): ");
            String[] genres = sc.nextLine().split(",");

            List<String> genreList = new ArrayList<>();

            for (String g : genres) {
                genreList.add(g.trim());
            }

            movieMap.put(movie, genreList);
        }

        // Step 2: Reverse mapping → Genre -> Movies
        Map<String, List<String>> genreMap = new LinkedHashMap<>();

        for (Map.Entry<String, List<String>> entry : movieMap.entrySet()) {

            String movie = entry.getKey();
            List<String> genres = entry.getValue();

            for (String genre : genres) {

                genreMap.putIfAbsent(genre, new ArrayList<>());
                genreMap.get(genre).add(movie);
            }
        }

        // Output
        System.out.println("\n--- Genre-wise Movies ---");

        for (Map.Entry<String, List<String>> entry : genreMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        sc.close();
    }
}
