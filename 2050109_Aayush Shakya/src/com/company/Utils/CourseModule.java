package com.company.Utils;
import java.io.Serializable;

public class CourseModule implements Serializable {
    private int course_ID;
    private int module_ID;

    public CourseModule(int course_ID, int module_ID) {
        this.course_ID = course_ID;
        this.module_ID = module_ID;
    }

    public int get_Course_ID() {
        return course_ID;
    }

    public void setCourseID(int course_ID) {
        this.course_ID = course_ID;
    }

    public int get_Module_ID() {
        return module_ID;
    }

    public void set_Module_ID(int module_ID) {
        this.module_ID = module_ID;
    }

    @Override
    public String toString() {
        return "Course ID = " + course_ID + "Module ID = " + module_ID;
    }
}