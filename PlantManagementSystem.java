import java.util.*;

// ===============================
// Plant Class
// ===============================
class Plant {
    int plantId;
    String plantName;
    int quantity;
    double price;
    String type;
    String owner;

    Plant(int plantId, String plantName, int quantity, double price, String type, String owner) {
        this.plantId = plantId;
        this.plantName = plantName;
        this.quantity = quantity;
        this.price = price;
        this.type = type;
        this.owner = owner;
    }

    public String toString() {
        return plantId + " | " + plantName + " | Qty: " + quantity +
                " | Price: " + price + " | Type: " + type + " | Owner: " + owner;
    }
}

// ===============================
// MAIN CLASS
// ===============================
public class PlantManagementSystem {

    public static void main(String[] args) {

        ArrayList<Plant> plants = new ArrayList<>();

        // 1. ADD
        plants.add(new Plant(1, "Rose", 10, 50, "Flower", "Amit"));
        plants.add(new Plant(2, "Tulip", 3, 70, "Flower", "Riya"));
        plants.add(new Plant(3, "Aloe Vera", 8, 40, "Medicinal", "Rahul"));
        plants.add(new Plant(4, "Bamboo", 2, 100, "Decor", "Sneha"));
        plants.add(new Plant(5, "Neem", 15, 60, "Medicinal", "Vikas"));

        System.out.println("All Plants:");
        plants.forEach(System.out::println);

        // 2. UPDATE
        for (Plant p : plants) {
            if (p.plantId == 2) {
                p.quantity = 6;
            }
        }

        // Out of stock
        System.out.println("\nOut of Stock (qty < 5):");
        for (Plant p : plants) {
            if (p.quantity < 5) {
                System.out.println(p);
            }
        }

        // 3. STOCK VALUE
        System.out.println("\nStock Value:");
        for (Plant p : plants) {
            double value = p.quantity * p.price;
            System.out.println(p.plantName + " | Qty: " + p.quantity + " | Value: " + value);
        }

        // 4. SEARCH BY TYPE
        System.out.println("\nMedicinal Plants:");
        for (Plant p : plants) {
            if (p.type.equalsIgnoreCase("Medicinal")) {
                System.out.println(p);
            }
        }

        // 5. REMOVE OUT OF STOCK
        plants.removeIf(p -> p.quantity < 5);

        System.out.println("\nAfter Removing Out of Stock:");
        plants.forEach(System.out::println);

        // 6. REPORT
        if (!plants.isEmpty()) {

            // ===============================
            // METHOD 1: MANUAL LOOP (USED)
            // ===============================
            Plant maxQty = plants.get(0);
            Plant minQty = plants.get(0);
            Plant maxPrice = plants.get(0);
            Plant minPrice = plants.get(0);

            for (Plant p : plants) {
                if (p.quantity > maxQty.quantity) maxQty = p;
                if (p.quantity < minQty.quantity) minQty = p;

                if (p.price > maxPrice.price) maxPrice = p;
                if (p.price < minPrice.price) minPrice = p;
            }

            System.out.println("\n--- REPORT (Manual Loop) ---");
            System.out.println("Highest Quantity: " + maxQty);
            System.out.println("Lowest Quantity: " + minQty);
            System.out.println("Highest Price: " + maxPrice);
            System.out.println("Lowest Price: " + minPrice);

            // ===============================
            // METHOD 2: SORTING (ALTERNATIVE)
            // ===============================
            ArrayList<Plant> temp = new ArrayList<>(plants);

            // Sort by quantity
            temp.sort((a, b) -> a.quantity - b.quantity);
            System.out.println("\n(Sort Method)");
            System.out.println("Min Qty: " + temp.get(0));
            System.out.println("Max Qty: " + temp.get(temp.size() - 1));

            // Sort by price
            temp.sort((a, b) -> Double.compare(a.price, b.price));
            System.out.println("Min Price: " + temp.get(0));
            System.out.println("Max Price: " + temp.get(temp.size() - 1));

            // ===============================
            // GROUP BY TYPE
            // ===============================
            System.out.println("\nGrouped by Type:");

            Map<String, List<Plant>> map = new HashMap<>();

            for (Plant p : plants) {
                map.putIfAbsent(p.type, new ArrayList<>());
                map.get(p.type).add(p);
            }

            for (String type : map.keySet()) {
                System.out.println("\nType: " + type);
                for (Plant p : map.get(type)) {
                    System.out.println(p);
                }
            }
        }
    }
}