package hashmappractice;

import java.util.*;

// Subscriber class
class Subscriber {
    private Integer id;
    private String name;

    Subscriber(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return "Subscriber{id=" + id + ", name='" + name + "'}";
    }
}

public class SubMain {

    public static void main(String[] args) {

        // Create subscribers
        Subscriber s1 = new Subscriber(1,"ABC");
        Subscriber s2 = new Subscriber(2,"DEF");
        Subscriber s3 = new Subscriber(3,"GHI");

        // Device -> Subscriber map
        Map<Integer, Subscriber> deviceMap = new HashMap<>();

        // put()
        deviceMap.put(101, s1);
        deviceMap.put(102, s2);
        deviceMap.put(103, s1);
        deviceMap.put(104, s3);

        System.out.println("Original Map:");
        System.out.println(deviceMap);

        // containsKey()
        System.out.println("\nContains key 101: " + deviceMap.containsKey(101));

        // get()
        System.out.println("Get device 102: " + deviceMap.get(102));

        // remove()
        deviceMap.remove(104);
        System.out.println("After removing 104: " + deviceMap);

        // putIfAbsent()
        deviceMap.putIfAbsent(101, s3); // won't replace
        System.out.println("After putIfAbsent: " + deviceMap);

        // keySet()
        System.out.println("\nAll Keys: " + deviceMap.keySet());

        // values()
        System.out.println("All Values: " + deviceMap.values());

        // entrySet()
        System.out.println("\nUsing entrySet:");
        for (Map.Entry<Integer, Subscriber> e : deviceMap.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }

        // size()
        System.out.println("\nSize: " + deviceMap.size());

        // isEmpty()
        System.out.println("Is Empty: " + deviceMap.isEmpty());

        // -------------------------------
        // REVERSE MAP (EASY VERSION)
        // -------------------------------

        Map<Subscriber, List<Integer>> subscriberMap = new HashMap<>();

        for (Integer deviceId : deviceMap.keySet()) {

            Subscriber sub = deviceMap.get(deviceId);

            // SIMPLE LOGIC (no computeIfAbsent)
            if (!subscriberMap.containsKey(sub)) {
                subscriberMap.put(sub, new ArrayList<Integer>());
            }

            subscriberMap.get(sub).add(deviceId);
        }

        System.out.println("\nReversed Map:");
        for (Subscriber s : subscriberMap.keySet()) {
            System.out.println(s + " -> " + subscriberMap.get(s));
        }

        // List of device IDs
        List<Integer> deviceList = new ArrayList<>(deviceMap.keySet());
        System.out.println("\nList of Device IDs:");
        System.out.println(deviceList);

        // clear()
        deviceMap.clear();
        System.out.println("\nAfter clear(): " + deviceMap);
    }
}




package hashmappractice;

import java.util.*;

// Subscriber class
class Subscriber implements Comparable<Subscriber> {
    private int id;
    private String name;

    // Constructor
    Subscriber(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    // toString()
    public String toString() {
        return "Subscriber{id=" + id + ", name='" + name + "'}";
    }

    // equals()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subscriber)) return false;

        Subscriber s = (Subscriber) o;
        return id == s.id && name.equals(s.name);
    }

    // hashCode()
    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    // Comparable → sort by id
    @Override
    public int compareTo(Subscriber s) {
        return Integer.compare(this.id, s.id);
    }
}

// Comparator → sort by name
class SubscriberNameComparator implements Comparator<Subscriber> {
    public int compare(Subscriber a, Subscriber b) {
        return a.getName().compareTo(b.getName());
    }
}

public class SubMain {

    public static void main(String[] args) {

        // Create subscribers
        Subscriber s1 = new Subscriber(1, "ABC");
        Subscriber s2 = new Subscriber(2, "DEF");
        Subscriber s3 = new Subscriber(3, "GHI");

        // Device -> Subscriber map
        Map<Integer, Subscriber> deviceMap = new HashMap<>();

        deviceMap.put(101, s1);
        deviceMap.put(102, s2);
        deviceMap.put(103, s1);
        deviceMap.put(104, s3);

        System.out.println("Original Map:");
        System.out.println(deviceMap);

        // Reverse Map using HashMap
        Map<Subscriber, List<Integer>> subscriberMap = new HashMap<>();

        for (Integer deviceId : deviceMap.keySet()) {
            Subscriber sub = deviceMap.get(deviceId);

            if (!subscriberMap.containsKey(sub)) {
                subscriberMap.put(sub, new ArrayList<>());
            }

            subscriberMap.get(sub).add(deviceId);
        }

        System.out.println("\nReversed Map (HashMap):");
        subscriberMap.forEach((k, v) -> System.out.println(k + " -> " + v));

        // -------------------------------
        // TREE MAP (SORTED BY ID)
        // -------------------------------
        Map<Subscriber, List<Integer>> treeMapById = new TreeMap<>();
        treeMapById.putAll(subscriberMap);

        System.out.println("\nTreeMap Sorted by ID:");
        treeMapById.forEach((k, v) -> System.out.println(k + " -> " + v));

        // -------------------------------
        // TREE MAP (SORTED BY NAME)
        // -------------------------------
        Map<Subscriber, List<Integer>> treeMapByName =
                new TreeMap<>(new SubscriberNameComparator());

        treeMapByName.putAll(subscriberMap);

        System.out.println("\nTreeMap Sorted by Name:");
        treeMapByName.forEach((k, v) -> System.out.println(k + " -> " + v));

        // List of device IDs
        List<Integer> deviceList = new ArrayList<>(deviceMap.keySet());
        System.out.println("\nDevice List: " + deviceList);

        // clear()
        deviceMap.clear();
        System.out.println("\nAfter clear(): " + deviceMap);
    }
}