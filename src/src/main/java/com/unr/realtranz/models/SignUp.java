package com.unr.realtranz.models;

/***
 **@Author:Nagaraju Ukkalam
 @Version:1.0
 @Date:17-06-2022 22:57
 **/
public class SignUp {
    private String firstName;
    private String lastName;
    private String email_id;
    private String username;
    private String phone1;
    private String password;

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

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Users{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email_id='" + email_id + '\'' +
                ", username='" + username + '\'' +
                ", phone1='" + phone1 + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
