package com.company.model;

public class Instructor extends User {
    private int instructor_ID;

    public Instructor(int instructor_ID) {
        this.instructor_ID = instructor_ID;
    }

    public Instructor(int user_Id, String first_Name, String gender, int instructor_ID) {
        super(user_Id, first_Name, gender);
        this.instructor_ID = instructor_ID;
    }

    public int get_Instructor_ID() {
        return instructor_ID;
    }

    public void set_Instructor_ID(int instructor_ID) {
        this.instructor_ID = instructor_ID;
    }

    @Override

    public String toString() {
        return "instructorID = " + instructor_ID + "\n" + " || User{" +
                "userId=" + getUserId() +
                ", firstName='" + get_Full_Name() + '\'' +
                ", gender='" + get_Gender() + '\'' +
                '}';
    }
}