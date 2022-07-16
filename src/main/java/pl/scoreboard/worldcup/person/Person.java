package pl.scoreboard.worldcup.person;

import java.util.Objects;

public class Person implements IPerson {

    private final String firstName;
    private final String lastName;
    private int age;
    private String postalCode;
    private String address;
    private String city;


    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Person)) {
            return false;
        }

        Person other = (Person) o;
        boolean firstNameCodeEquals = (this.firstName == null && other.getFirstName() == null) || (this.firstName != null && this.firstName.equals(other.getFirstName()));
        boolean lastNameCodeEquals = (this.lastName == null && other.getLastName() == null) || (this.lastName != null && this.lastName.equals(other.getLastName()));
        boolean ageCodeEquals = this.age == other.getAge();
        boolean postalCodeCodeEquals = (this.postalCode == null && other.getPostalCode() == null) || (this.postalCode != null && this.postalCode.equals(other.getPostalCode()));
        boolean addressCodeCodeEquals = (this.address == null && other.getAddress() == null) || (this.address != null && this.address.equals(other.getAddress()));
        boolean cityCodeEquals = (this.city == null && other.getCity() == null) || (this.city != null && this.city.equals(other.getCity()));
        return ageCodeEquals && firstNameCodeEquals && lastNameCodeEquals && postalCodeCodeEquals && addressCodeCodeEquals && cityCodeEquals;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        if (Objects.nonNull(firstName)) {
            result = prime * result + firstName.hashCode();
        }
        if (Objects.nonNull(lastName)) {
            result = prime * result + lastName.hashCode();
        }
        if (Objects.nonNull(postalCode)) {
            result = prime * result + postalCode.hashCode();
        }
        if (Objects.nonNull(address)) {
            result = prime * result + address.hashCode();
        }
        if (Objects.nonNull(city)) {
            result = prime * result + city.hashCode();
        }
        result = 31 * result + age;
        return result;
    }
}
