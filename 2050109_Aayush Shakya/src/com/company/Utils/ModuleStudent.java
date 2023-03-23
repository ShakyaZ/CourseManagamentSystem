package com.company.Utils;
import java.io.Serializable;

public class ModuleStudent implements Serializable {
    private int marks;
    private int module_ID;
    private int student_ID;

    public ModuleStudent(int module_ID, int student_ID, int marks) {
        this.module_ID = module_ID;
        this.student_ID = student_ID;
        this.marks = marks;
    }

    public int get_Module_ID() {
        return module_ID;
    }

    public void setModuleID(int module_ID) {
        this.module_ID = module_ID;
    }

    public int get_Student_ID() {
        return student_ID;
    }

    public void set_Student_ID(int student_ID) {
        this.student_ID = student_ID;
    }

    public int get_Marks() {
        return marks;
    }

    public void set_Marks(int marks) {
        this.marks = marks;
    }

    @Override

    public String toString() {
        return "Module ID = " + module_ID + "Student ID = " + student_ID + "Marks Obtained = " + marks;
    }
}