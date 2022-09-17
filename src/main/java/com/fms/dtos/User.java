package com.fms.dtos;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
    * This Users class is used to create user objects
    * Which contains the attributes mentioned in it.
 */

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger userId;

    @NotEmpty
    private String userName;

    @Digits(integer = 10,fraction = 0, message = "Please provide a 10 digit Phone number.")
    @Min(value = 1000000000, message = "Phone Number should not start with 0.")
    @Max(value = 9999999999L)
    private BigInteger userPhone;

    @NotEmpty
    @Email(regexp = "[a-z 0-9]+@.+\\..+", message = "Please provide a valid email address")
    private String userEmail;

    @NotEmpty
    @Size(min=5, message = "Password should be minimum of length 5.")
    private String userPassword;

    @NotEmpty
    private String userType;
 
	/**
        * Parameterized Constructor of Users
     */

    public User(String userName, BigInteger userPhone, String userEmail, String userPassword, String userType)
    {
        this.userName = userName;
        this.userPhone = userPhone;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userType = userType;
    }

    /**
        * Unparameterized Construcor of Users
     */

    public User()
    {}

    public BigInteger getUserId()
    {
        return userId;
    }

    public void setUserId(BigInteger userId)
    {
        this.userId = userId;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public BigInteger getUserPhone()
    {
        return userPhone;
    }

    public void setUserPhone(BigInteger userPhone)
    {
        this.userPhone = userPhone;
    }

    public String getUserEmail()
    {
        return userEmail;
    }

    public void setUserEmail(String userEmail)
    {
        this.userEmail = userEmail;
    }

    public String getUserPassword()
    {
        return userPassword;
    }

    public void setUserPassword(String userPassword)
    {
        this.userPassword = userPassword;
    }

    public String getUserType()
    {
        return userType;
    }

    public void setUserType(String userType)
    {
        this.userType = userType;
    }
}
