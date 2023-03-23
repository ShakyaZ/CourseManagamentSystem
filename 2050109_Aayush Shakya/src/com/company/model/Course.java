package com.company.model;
import java.io.Serializable;

public class Course implements Serializable {
    private int course_ID;
    private String course_Name;
    private int semester;
    private int course_Level;
    private boolean is_Canceled;

    public Course(int course_ID, String course_Name, int semester, int course_Level, boolean is_Canceled) {
        this.course_ID = course_ID;
        this.course_Name = course_Name;
        this.semester = semester;
        this.course_Level = course_Level;
        this.is_Canceled = is_Canceled;
    }

    public int get_Course_ID() {
        return course_ID;
    }

    public void setCourseID(int course_ID) {
        this.course_ID = course_ID;
    }

    public String get_Course_Name() {
        return course_Name;
    }

    public void set_Course_Name(String course_Name) {
        this.course_Name = course_Name;
    }

    public int get_Semester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int get_Course_Level() {
        return course_Level;
    }

    public void setCourseLevel(int course_Level) {
        this.course_Level = course_Level;
    }

    public boolean is_Canceled() {
        return is_Canceled;
    }

    public void set_Canceled(boolean canceled) {
        is_Canceled = canceled;
    }

    @Override
    public String toString() {
        String Char;
        if (is_Canceled) {
            Char = "Yes";
        } else {
            Char = "No";
        }
        return "ID = " + course_ID + "\n" + "Name = " + course_Name + "\n" + "Semester = " + semester + "\n" + "Level = " + course_Level + "\n" + "Canceled = " + Char + "\n";
    }
}