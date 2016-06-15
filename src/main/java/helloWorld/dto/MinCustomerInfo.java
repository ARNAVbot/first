package helloWorld.dto;

/**
 * Created by arnavagarwal on 15/06/16.
 */
public class MinCustomerInfo {

    private String name;

    private String pan;

    public MinCustomerInfo() {
    }

    public MinCustomerInfo(String pan, String name) {
        this.pan = pan;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }
}
