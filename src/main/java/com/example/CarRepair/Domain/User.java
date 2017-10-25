package com.example.CarRepair.Domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
//Users is the name of my table in Database
@Table(name = "users")
public class User implements Serializable {
    @Id //signifies the primary key
    /*name is the name of column it reference, nullable is true by default if we want a field
     *be always filled we put nullable false, with length we choose the size of out field it must be same with
     *Database by default size is 255
     */
    @Column(name = "userid", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userID;
    @Column(name = "taxno", nullable = false , length = 30, unique = true)
    private Integer taxNumber;
    @Column(name = "lastname", length = 30)
    private String lastName;
    @Column(name = "firstname",length = 30)
    private String firstName;
    @Column(name = "address")
    private String address;
    @Column(name = "email", nullable = false,length = 30, unique=true)
    private String email;
    @Column(name = "userpassword", nullable = false,length = 30)
    private String userpassword;
    @Column(name = "isadmin")
    private boolean isAdmin;
    /**
     * Because I want OneToMany I want a List, for ManyToOne you just need a simple User not a collection
     * Also i mappedBy user that mean your field with annotation ManyToOne you name it user
     * and the Repair is the call I am connected so be the name of your class
     */
//    @OneToMany(mappedBy="user",targetEntity=Repair.class)
    @OneToMany(mappedBy = "user",targetEntity=Repair.class, cascade = CascadeType.REMOVE, orphanRemoval=true)
    private List<Repair> repairs;
    /****** I USE GENERIC TO MAKE THE CONSTRICTORS, GETTERS, SETTERS AND TO STRING ******/
    public User() {
    }

    public User(Long userID, Integer taxNumber, String email, String password) {
        this.userID = userID;
        this.taxNumber = taxNumber;
        this.email = email;
        this.userpassword = password;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public int getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(int taxNumber) {
        this.taxNumber = taxNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return userpassword;
    }

    public void setPassword(String password) {
        this.userpassword = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public List<Repair> getRepairs() {
        return repairs;
    }

    public void setRepairs(List<Repair> repairs) {
        this.repairs = repairs;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", taxNumber=" + taxNumber +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +

                ", password='" + userpassword + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
