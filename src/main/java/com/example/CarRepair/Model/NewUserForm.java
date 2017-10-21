package com.example.CarRepair.Model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * For each one form we have, for each ftl page we must have a model with the object gna use there, in creation forms
 * we need take ours field to create a user so for each input amin give we have t field here.
 */
public class NewUserForm {
    /* Privates static and finals is our regular expressions help us secure that the input of user have the pattern
     * and the size we want to, we do that using regex
     */
    private static final String PASSWORD_PATTERN = "^[a-zA-Z0-9@#$%^&]*$";

    private static final String CHARACTERS_PATTERN = "^[a-zA-Z ]*$";

    private static final String ADDRESS_PATTERN = "^[a-zA-Z0-9 ,]*$";

    private static final String MAIL_PATTERN = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{1,63}$";

    private static final String TAX_PATTERN = "\\d\\d\\d\\d\\d\\d\\d\\d\\d";

    //we also need some size to have in mind
    private static final int TAXNO_SIZE = 9;

    private static final int PASSWORD_MINSIZE = 6;

    //Each thing inside our class it has a pattern to follow and it that pattern its not correct we send validation msg
    @Pattern(regexp = CHARACTERS_PATTERN, message = "{newUser.lastname.invalid}")
    private String lastname;

    @Pattern(regexp = CHARACTERS_PATTERN, message = "{newUser.firstname.invalid}")
    private String firstname;

    //some field like tax number email and password must not be null by our database
    //size gives us the max and min size so we check the size of our input
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
    /**
     * No stress type is a string, type gonna take it's value from the radio menu Admin or User
     * and in our mapper we gona map if type is equal to admin we put 1 to isAdmin else we put 0
     */
    @Pattern(regexp = CHARACTERS_PATTERN, message = "{newUser.type.invalid}")
    private String type;

    //generate out getters and setters so we can use them in our mapper "UserConverter.buildUserObject"
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
