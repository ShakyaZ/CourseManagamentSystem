package com.company.model;
import java.io.Serializable;

public class User implements Serializable {
    private int user_Id;
    private String full_Name;
    private String gender;

    public User() {
        this.user_Id = -1;
        this.full_Name = "";
        this.gender = "";
    }

    public User(int user_Id, String full_Name, String gender) {
        this.user_Id = user_Id;
        this.full_Name = full_Name;
        this.gender = gender;
    }

    public int getUserId() {
        return user_Id;
    }

    public void setUserId(int user_Id) {
        this.user_Id = user_Id;
    }

    public String get_Full_Name() {
        return full_Name;
    }

    public void set_Full_Name(String full_Name) {
        this.full_Name = full_Name;
    }

    public String get_Gender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override

    public String toString() {
        return "userId = " + user_Id + "\n" + "fullName = " + full_Name + '\'' + "\n" + "gender = " + gender + '\'';
    }
}