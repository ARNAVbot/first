package helloWorld.dto;

/**
 * Created by arnavagarwal on 15/06/16.
 */
public class CustomerDTO {

    String firstName;
    String lastName;
    String pan;

    public CustomerDTO() {
    }

    public CustomerDTO(String firstName, String lastName, String pan) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pan = pan;
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
