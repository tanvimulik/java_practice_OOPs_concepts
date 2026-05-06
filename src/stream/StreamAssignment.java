package stream;

import java.util.*;
import java.util.stream.*;

public class StreamAssignment {

    public static void main(String[] args) {

        // ================= VEHICLE EXAMPLE =================
        List<String> vehicles = Arrays.asList("Bus", "Bike", "Bus", "Car", "Bicycle", "Car", "Bike");

        // 1. distinct()
        List<String> distinctVehicles = vehicles.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Distinct Vehicles: " + distinctVehicles);

        // 2. count()
        long count = vehicles.stream()
                .distinct()
                .count();
        System.out.println("Count of distinct vehicles: " + count);

        // 3. limit()
        List<String> limitedVehicles = vehicles.stream()
                .distinct()
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("Limited Vehicles: " + limitedVehicles);

        // 4. anyMatch()
        boolean hasBike = vehicles.stream()
                .anyMatch(v -> v.equals("Bike"));
        System.out.println("Any Bike present: " + hasBike);

        // 5. allMatch()
        boolean allHaveLengthMoreThan2 = vehicles.stream()
                .allMatch(v -> v.length() > 2);
        System.out.println("All names length > 2: " + allHaveLengthMoreThan2);

        // 6. noneMatch()
        boolean noneIsTruck = vehicles.stream()
                .noneMatch(v -> v.equals("Truck"));
        System.out.println("No Truck present: " + noneIsTruck);

        // 7. findFirst()
        Optional<String> first = vehicles.stream().findFirst();
        System.out.println("First Element: " + first.get());

        // 8. findAny()
        Optional<String> any = vehicles.stream().findAny();
        System.out.println("Any Element: " + any.get());

        // 9. toArray()
        Object[] arr = vehicles.stream().toArray();
        System.out.println("Array Length: " + arr.length);
        System.out.println("Array Elements:");
        for (Object v : arr) {
            System.out.println(v);
        }

        // ================= NUMBER EXAMPLE =================
        List<Integer> numbers = Arrays.asList(12, 32, 11, 45, 20, 8, 69, 35, 54, 70, 24);

        // 10. min() using lambda
        Optional<Integer> min = numbers.stream()
                .min((a, b) -> a - b);
        System.out.println("Min (lambda): " + min.get());

        // 11. max() using lambda
        Optional<Integer> max = numbers.stream()
                .max((a, b) -> a - b);
        System.out.println("Max (lambda): " + max.get());

        // 12. min() using method reference
        int min2 = numbers.stream()
                .min(Integer::compare)
                .get();
        System.out.println("Min (method ref): " + min2);

        // 13. max() using method reference
        int max2 = numbers.stream()
                .max(Integer::compare)
                .get();
        System.out.println("Max (method ref): " + max2);

        // 14. filter()
        List<Integer> filtered = numbers.stream()
                .filter(n -> n > 20)
                .collect(Collectors.toList());
        System.out.println("Numbers > 20: " + filtered);

        // 15. map()
        List<Integer> multiplied = numbers.stream()
                .map(n -> n * 2)
                .collect(Collectors.toList());
        System.out.println("Numbers * 2: " + multiplied);

        // 16. sorted()
        List<Integer> sorted = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Sorted Numbers: " + sorted);

        // 17. reduce() (sum)
        int sum = numbers.stream()
                .reduce(0, (a, b) -> a + b);
        System.out.println("Sum: " + sum);

    }
}
