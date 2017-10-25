package com.example.CarRepair.Model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class NewUserForm {

    private static final String PASSWORD_PATTERN = "^[a-zA-Z0-9@#$%^&]*$";

    private static final String CHARACTERS_PATTERN = "^[a-zA-Z ]*$";

    private static final String ADDRESS_PATTERN = "^[a-zA-Z0-9 ,]*$";

    private static final String MAIL_PATTERN = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{1,63}$";

    private static final String TAX_PATTERN = "\\d\\d\\d\\d\\d\\d\\d\\d\\d";


    private static final int TAXNO_SIZE = 9;

    private static final int PASSWORD_MINSIZE = 6;


    @Pattern(regexp = CHARACTERS_PATTERN, message = "{newUser.lastname.invalid}")
    private String lastname;

    @Pattern(regexp = CHARACTERS_PATTERN, message = "{newUser.firstname.invalid}")
    private String firstname;

    @NotNull(message = "{newUser.taxno.null}")
    @Pattern(regexp = TAX_PATTERN, message = "{newUser.taxno.invalid}")
    @Size(min=TAXNO_SIZE, max=TAXNO_SIZE, message = "{newUser.taxno.size}")
    private String taxNumber;

    //@Pattern(regexp = ADDRESS_PATTERN, message = "{newUser.address.invalid}")
    private String address;

    @NotNull(message = "{newUser.mail.null}")
    @Pattern(regexp = MAIL_PATTERN, message = "{newUser.mail.invalid}")
    private String mail;

    @NotNull(message = "{newUser.password.null}")
    @Pattern(regexp = PASSWORD_PATTERN, message = "{newUser.password.invalid}")
    @Size(min = PASSWORD_MINSIZE, message = "{newUser.password.size}")
    private String password;

    @Pattern(regexp = CHARACTERS_PATTERN, message = "{newUser.type.invalid}")
    private String type;

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
