package com.example.CarRepair.Domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
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

    @OneToMany(mappedBy = "user",targetEntity=Repair.class, cascade = CascadeType.REMOVE, orphanRemoval=true)
    private List<Repair> repairs;

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
