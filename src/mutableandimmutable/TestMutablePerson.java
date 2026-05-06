package mutableandimmutable;

class Person {
    private String firstName;
    private String lastName;

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

    void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

class TestMutablePerson {
    public static void main(String[] args) {
        Person p = new Person("Shravani", "Mulik");

        p.setFirstName("Tanvi"); // modifying object
        p.setLastName("Patil");

        System.out.println(p.getFirstName() + " " + p.getLastName());
    }
}

