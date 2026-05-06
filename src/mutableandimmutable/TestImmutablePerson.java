package mutableandimmutable;

final class Person {
    private final String firstName;
    private final String lastName;

    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    String getFirstName() {
        return firstName;
    }

    String getLastName() {
        return lastName;
    }
}

class TestImmutablePerson {
    public static void main(String[] args) {
        Person p = new Person("Shravani", "Mulik");

        System.out.println(p.getFirstName() + " " + p.getLastName());

        // p.setFirstName("Tanvi"); // Not allowed
    }
}
