package pl.scoreboard.worldcup.person;

import java.util.Objects;

public class Person implements IPerson {

    private String firstName;
    private String lastName;
    private int age;
    private String postalCode;
    private String address;
    private String city;


    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public String getPostalCode() {
        return postalCode;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
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
