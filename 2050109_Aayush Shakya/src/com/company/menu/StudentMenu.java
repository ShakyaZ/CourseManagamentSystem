package com.company.menu;

import com.company.Main;
import com.company.fileIO.CoursesfileIO;
import com.company.fileIO.RelationfileIO;
import com.company.fileIO.StudentfileIO;
import com.company.model.Course;
import com.company.model.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentMenu {
    static Student student;
    ArrayList<Student> student_Array_List = StudentfileIO.get_All_Students();

    public static void student_Menu() {
        student_Submenu();
        cases1();
    }

    public static void student_Submenu() {
        System.out.println("A :Student Records");
        System.out.println("B :Go back");
    }

    public static void cases1() {
        System.out.print("Enter a or b:  ");
        char choice = new Scanner(System.in).next().toUpperCase().charAt(0);
        switch (choice) {
            case 'A':
                student_Records();
            case 'B':
                Main.main();
            default: {
                System.out.println("Invalid! ");
                cases1();
            }
        }
    }

    public static void student_Records() {
        menu_Handler();
    }

    public static void menu_Handler() {
        System.out.println();
        try {
            System.out.print("Enter your student id:  ");
            int iD = new Scanner(System.in).nextInt();

            student = StudentfileIO.get_Student_By_ID(iD);

            if(student != null) {
                student_Submenu2();
            }

            else {
                System.out.println("Error.");

                student_Submenu2();
            }

        }

        catch(Exception e) {
            System.out.println("Error. No data found");
            student_Submenu();
        }
    }

    public static void student_Submenu2() {
        System.out.println("A :Enroll into a course.");
        System.out.println("B :Quit Program");
        cases();
    }

    public static void cases() {
        System.out.print("Enter your choice:  ");
        char choice = new Scanner(System.in).next().toUpperCase().charAt(0);
        switch(choice) {
            case 'A':
                enroll_Course();
            case 'B':
                Main.main();
            default: {
                System.out.println("Invalid! Please try again");
                cases1();
            }
        }
    }

    private static void enroll_Course() {
        System.out.println("List of courses available.");
        ArrayList<Course> course_Array_List = CoursesfileIO.get_All_Courses();
        for (Course course : course_Array_List) {
            System.out.println(course);
        }
        System.out.print("Enter a course id you want to enroll into:  ");
        int course_Id = new Scanner(System.in).nextInt();
        RelationfileIO.enroll_Into_Course(student.get_Student_ID(), course_Id);
        student_Submenu2();
    }

    public static void display_Details() {
        System.out.println(student);
        RelationfileIO.print_Course_Of_Student(student.get_Student_ID());
        student_Submenu2();
    }
}
