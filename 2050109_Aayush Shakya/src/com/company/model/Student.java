package com.company.model;

public class Student extends User {
    private int student_ID;

    public Student(int student_ID) {
        this.student_ID = student_ID;
    }

    public Student(int user_Id, String first_Name, String gender, int student_ID) {
        super(user_Id, first_Name, gender);
        this.student_ID = student_ID;
    }

    public int get_Student_ID() {
        return student_ID;
    }

    public void setStudentID(int student_ID) {
        this.student_ID = student_ID;
    }

    @Override

    public String toString() {
        return "studentID = " + student_ID + "\nUser:" +
                "userId = " + getUserId() + "\n" +
                "First Name = " + get_Full_Name() + "\n" +
                "gender = " + get_Gender();
    }
}