package com.company.menu;
import com.company.fileIO.RelationfileIO;
import com.company.Utils.ModuleStudent;
import com.company.Main;
import java.util.Scanner;

public class InstructorMenu{
    public static void instructor_Menu(){
        instructor_SubMenu();
        cases();
    }

    public static void instructor_SubMenu(){
        System.out.println("A :Assigned Modules");
        System.out.println("B :Give marks to students");
        System.out.println("C :Go back");
    }

    public static void cases(){
        System.out.print("Enter from a to c:  ");
        char choice = new Scanner(System.in).next().toUpperCase().charAt(0);
        switch (choice){
            case 'A' : assigned_Modules();
            case 'B' : mark_Student();
            case 'C' : Main.main();
            default : {
                System.out.println("Invalid ! ");
                cases();
            }
        }
    }

    private static void mark_Student(){
        System.out.print("Enter a student id:  ");
        int sID = new Scanner(System.in).nextInt();

        System.out.print("Enter a module id:  ");
        int mID = new Scanner(System.in).nextInt();

        System.out.print("Enter marks to give to the student:  ");
        int marks = new Scanner(System.in).nextInt();

        ModuleStudent moduleStudent = new ModuleStudent(mID, sID, marks);

        RelationfileIO.markStudent(moduleStudent);

        instructor_Menu();
    }

    private static void assigned_Modules(){
        System.out.print("Enter your instructor id:  ");
        int iD = new Scanner(System.in).nextInt();
        RelationfileIO.printInstructorModules(iD);
        instructor_Menu();
    }
}