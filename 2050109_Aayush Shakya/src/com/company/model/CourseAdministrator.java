package com.company.model;

public class CourseAdministrator extends User {
    private String admin_ID;

    public CourseAdministrator(String admin_ID) {
        this.admin_ID = admin_ID;
    }

    public CourseAdministrator(int user_Id, String first_Name, String gender, String admin_ID) {
        super(user_Id, first_Name, gender);
        this.admin_ID = admin_ID;
    }


    public String get_Administrator_ID() {
        return admin_ID;
    }

    public void setAdministratorID(String admin_ID) {
        this.admin_ID = admin_ID;
    }
}