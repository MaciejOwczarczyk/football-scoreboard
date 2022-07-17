package pl.scoreboard.worldcup.person;

public interface IPerson {

    void setFirstName(String firstName);

    void setLastName(String lastName);

    void setAge(int age);

    void setPostalCode(String postalCode);

    void setAddress(String address);

    void setCity(String city);

    String getFirstName();

    String getLastName();

    int getAge();

    String getPostalCode();

    String getAddress();

    String getCity();
}
