package mutableandimmutable;

class Address {
    private String city;
    private String pincode;

    Address(String city, String pincode) {
        this.city = city;
        this.pincode = pincode;
    }

    String getCity() {
        return city;
    }

    String getPincode() {
        return pincode;
    }

    void setCity(String city) {
        this.city = city;
    }

    void setPincode(String pincode) {
        this.pincode = pincode;
    }
}

final class Person{
    private final String firstName;
    private final String lastName;
    private final Address address1;

    Person(String firstName, String lastName, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address1 = new Address(address.getCity(), address.getPincode());
    }

    Address getAddress() {
        return new Address(address1.getCity(), address1.getPincode());
    }
}

class TestPersonWithAddressImmutable {
    public static void main(String[] args) {
        Address ad = new Address("Nagpur", "413102");
        Person p = new Person("Shravani", "Mulik", ad);

        ad.setCity("Pune"); // trying to modify

        System.out.println(p.getAddress().getCity());
    }
}
