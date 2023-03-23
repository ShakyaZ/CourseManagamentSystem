package com.company.Utils;
import java.io.Serializable;

public class ModuleInstructor implements Serializable {
    private int instructor_ID;
    private int module_ID;

    public ModuleInstructor(int module_ID, int instructor_ID) {
        this.module_ID = module_ID;
        this.instructor_ID = instructor_ID;
    }

    public int get_Module_ID() {
        return module_ID;
    }

    public void set_Module_ID(int module_ID) {
        this.module_ID = module_ID;
    }

    public int get_Instructor_ID() {
        return instructor_ID;
    }

    public void set_Instructor_ID(int instructor_ID) {
        this.instructor_ID = instructor_ID;
    }

    @Override
    public String toString() {
        return "Module ID = " + module_ID + "Instructor ID = " + instructor_ID;
    }
}