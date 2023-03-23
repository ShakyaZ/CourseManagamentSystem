package com.company;
import com.company.menu.Admin;
import com.company.menu.InstructorMenu;
import com.company.menu.StudentMenu;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        main();
    }

    public static void main() {
        home();
        cases();
    }

    public static void home() {
        System.out.println("A :Login as Admin");
        System.out.println("B :Login as Instructor");
        System.out.println("C :Login as Student");
        System.out.println("D :Quit Program");
    }

    public static void cases() {
        System.out.print("Enter from a to d:  ");
        char choice = new Scanner(System.in).next().toUpperCase().charAt(0);
        switch (choice) {
            case 'A':
                Admin.admin_Menu();
            case 'B':
                InstructorMenu.instructor_Menu();
            case 'C':
                StudentMenu.student_Menu();
            case 'D':
                System.exit(0);
            default: {
                System.out.println("Invalid!");
                cases();
            }
        }
    }
}
