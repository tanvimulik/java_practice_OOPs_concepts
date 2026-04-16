package interfacepractice;
import java.util.*;

// ===================== STUDENT CLASS =====================
class Student implements Comparable<Student> {
    int roll;
    String name;

    Student(int roll, String name) {
        this.roll = roll;
        this.name = name;
    }

    // Comparable → sort by roll (ascending)
    public int compareTo(Student s) {
        return this.roll - s.roll;
    }
}

// ===================== NAME COMPARATOR =====================
class NameComparator implements Comparator<Student> {
    // Sort by name (ascending)
    public int compare(Student s1, Student s2) {
        return s1.name.compareTo(s2.name);
    }
}

// ===================== REVERSE ROLL COMPARATOR =====================
class ReverseRollComparator implements Comparator<Student> {
    // Sort by roll (descending)
    public int compare(Student s1, Student s2) {
        return s2.roll - s1.roll;
    }
}

// ===================== RUNNABLE THREAD CLASS =====================
class MyThread implements Runnable {
    public void run() {
        System.out.println("\nThread is running...");
    }
}

// ===================== MAIN CLASS =====================
public class StudentManage {
    public static void main(String[] args) {

        // Create student list
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student(3, "Snehal"));
        list.add(new Student(1, "Amit"));
        list.add(new Student(2, "Riya"));

        // ===================== 1) Comparable =====================
        System.out.println("Sorting by Roll (Ascending using Comparable):");
        Collections.sort(list); // uses compareTo()
        for (Student s : list) {
            System.out.println(s.roll + " " + s.name);
        }

        // ===================== 2) Comparator (Name) =====================
        System.out.println("\nSorting by Name (Ascending using Comparator):");
        Collections.sort(list, new NameComparator());
        for (Student s : list) {
            System.out.println(s.roll + " " + s.name);
        }

        // ===================== 3) Comparator (Reverse Roll) =====================
        System.out.println("\nSorting by Roll (Descending using Comparator):");
        Collections.sort(list, new ReverseRollComparator());
        for (Student s : list) {
            System.out.println(s.roll + " " + s.name);
        }

        // ===================== 4) Runnable =====================
        MyThread obj = new MyThread();
        Thread t = new Thread(obj);
        t.start();
    }
}
