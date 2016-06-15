package helloWorld.domain;

import org.springframework.data.annotation.Id;

/**
 * Created by arnavagarwal on 14/06/16.
 */
public class Customer {
    @Id
    private String id;

    private String firstName;
    private String lastName;
    private String pan;

    public Customer() {
    }

    public Customer(String firstName, String lastName, String pan) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pan = pan;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }
}
