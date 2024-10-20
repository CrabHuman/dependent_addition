package edu.gmu.cs321;
import java.util.Date;

public class Immigrant extends Person{
    private Date dateOfBirth;
    private String address;
    private long phoneNumber;
    private String email;

    public Immigrant(){
        super();
        dateOfBirth = null;
        address = null;
        phoneNumber = -1;
        email = null;
    }

    public Immigrant(String firstName, String lastName, int personID){
        super(firstName, lastName, personID);
        dateOfBirth = null;
        address = null;
        phoneNumber = -1;
        email = null;
    }

    public Immigrant(String firstName, String lastName, int personID, Date dateOfBirth, String address, long phoneNumber, String email){
        super(firstName, lastName, personID);
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Date getDateOfBirth(){
        return dateOfBirth;
    }
    public String getAddress(){
        return address;
    }
    public long getPhoneNumber(){
        return phoneNumber;
    }
    public String getEmail(){
        return email;
    }

    public void setDateOfBirth(Date dateOfBirth){
        this.dateOfBirth = dateOfBirth;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public void setPhoneNumber(long phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    public void setEmail(String email){
        this.email = email;
    }

}
