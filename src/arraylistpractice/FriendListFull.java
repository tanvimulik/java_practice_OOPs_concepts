package arraylistpractice;

import java.util.*;

public class FriendListFull {
    public static void main(String[] args) {

        // Create list
        ArrayList<String> friends = new ArrayList<>();

        // add()
        friends.add("Snehal");
        friends.add("Ankita");
        friends.add("Tanvi");
        friends.add("Shweta");
        friends.add("Riya");

        System.out.println("Original List: " + friends);

        // contains()  ✅ (IMPORTANT PART)
        System.out.println("Is Tanvi present? " + friends.contains("Tanvi"));

        // add(index, element)
        friends.add(2, "Pooja");

        // remove(Object) ✅ (IMPORTANT PART)
        friends.remove("Shweta");

        // add()
        friends.add("Neha");

        System.out.println("After Add/Remove: " + friends);

        // size()
        System.out.println("Size: " + friends.size());

        // get()
        System.out.println("Friend at index 1: " + friends.get(1));

        // set()
        friends.set(1, "Aarti");
        System.out.println("After set(): " + friends);

        // indexOf()
        System.out.println("Index of Tanvi: " + friends.indexOf("Tanvi"));

        // lastIndexOf()
        friends.add("Tanvi");
        System.out.println("Last index of Tanvi: " + friends.lastIndexOf("Tanvi"));

        // addAll()
        ArrayList<String> newFriends = new ArrayList<>();
        newFriends.add("Komal");
        newFriends.add("Priya");

        friends.addAll(newFriends);

        // addAll(index, collection)
        friends.addAll(1, newFriends);

        System.out.println("After addAll: " + friends);

        // containsAll()
        System.out.println("Contains all newFriends? " + friends.containsAll(newFriends));

        // removeIf()
        friends.removeIf(name -> name.equals("Priya"));

        System.out.println("After removeIf: " + friends);

        // retainAll()
        friends.retainAll(newFriends);
        System.out.println("After retainAll (only common): " + friends);

        // iterator()
        System.out.println("\nUsing Iterator:");
        Iterator<String> it = friends.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // forEach()
        System.out.println("\nUsing forEach:");
        friends.forEach(name -> System.out.println(name));

        // toArray()
        String[] arr = friends.toArray(new String[0]);
        System.out.println("\nArray:");
        for (String s : arr) {
            System.out.println(s);
        }

        // isEmpty()
        System.out.println("\nIs Empty: " + friends.isEmpty());

        // subList()
        if (friends.size() > 0) {
            System.out.println("SubList: " + friends.subList(0, friends.size()));
        }

        // equals()
        ArrayList<String> copy = new ArrayList<>(friends);
        System.out.println("Equals copy? " + friends.equals(copy));

        // hashCode()
        System.out.println("HashCode: " + friends.hashCode());

        // clear()
        friends.clear();

        System.out.println("\nAfter clear: " + friends);
        System.out.println("Is Empty Now: " + friends.isEmpty());
    }
}
