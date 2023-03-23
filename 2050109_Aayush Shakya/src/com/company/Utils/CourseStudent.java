package com.company.Utils;
import java.io.Serializable;

public class CourseStudent implements Serializable {
    private int Student_ID;
    private int course_ID;

    public CourseStudent(int courseID, int student_ID) {
        this.course_ID = course_ID;
        Student_ID = student_ID;
    }

    public int get_Course_ID() {
        return course_ID;
    }

    public void set_Course_ID(int course_ID) {
        this.course_ID = course_ID;
    }

    public int get_Student_ID() {
        return Student_ID;
    }

    public void set_Student_ID(int student_ID) {
        Student_ID = student_ID;
    }

    @Override
    public String toString() {
        return "Course ID = " + course_ID + "Student ID = " + Student_ID;
    }


}