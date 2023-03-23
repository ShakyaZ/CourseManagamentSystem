package com.company.model;
import java.io.Serializable;

public class Module implements Serializable {
    private int module_ID;
    private String module_Name;
    private boolean is_Optional;

    public Module(int module_ID, String module_Name, boolean is_Optional) {
        this.module_ID = module_ID;
        this.module_Name = module_Name;
        this.is_Optional = is_Optional;
    }

    public int get_Module_ID() {
        return module_ID;
    }

    public void set_Module_ID(int module_ID) {
        this.module_ID = module_ID;
    }

    public String get_Module_Name() {
        return module_Name;
    }

    public void set_Module_Name(String module_Name) {
        this.module_Name = module_Name;
    }

    public boolean is_Optional() {
        return is_Optional;
    }

    public void setOptional(boolean optional) {
        is_Optional = optional;
    }

    @Override

    public String toString() {
        String Char;
        if (is_Optional) {
            Char = "Yes";
        } else {
            Char = "Not optional";
        }
        return "Module ID = " + module_ID + "Module Name = " + module_Name + "Optional=" + Char;
    }
}