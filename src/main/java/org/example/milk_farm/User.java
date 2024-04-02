package org.example.milk_farm;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class User {
    private String firstName;
    private String secondName;
    private Integer personalNumber;
    private String password;

    public User(String firstName, String secondName, Integer personalNumber, String password) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.personalNumber = personalNumber;
        this.password = password;
    }

    public User() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(Integer personalNumber) {this.personalNumber = personalNumber;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
