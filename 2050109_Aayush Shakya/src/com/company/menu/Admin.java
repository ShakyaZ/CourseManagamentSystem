package com.company.menu;

import com.company.Main;
import com.company.Utils.ModuleStudent;
import com.company.fileIO.*;
import com.company.model.Course;
import com.company.model.Instructor;
import com.company.model.Student;
import com.company.model.Module;


import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin{

    public static void admin_Menu(){
        admin_menus ();
        cases ();
    }

    public static void admin_menus(){
        System.out.println ("A :Manage Course");
        System.out.println ("B :Manage Module");
        System.out.println ("C :Generate Student Result");
        System.out.println ("D :Manage students and instructors");
        System.out.println ("E :Go back");
    }

    public static void cases(){
        System.out.print ("Enter from a to e:  ");
        char choice = new Scanner (System.in).next().toUpperCase ().charAt (0);
        switch (choice){
            case 'A' : course_Menu();
            case 'B' : manage_Module();
            case 'C' : print_Result();
            case 'D' : people_Manage();
            case 'E' : Main.main();
            default : 
            {
                System.out.println ("Invalid!");
                cases ();
            }
        }
    }

    public static void people_Manage(){
        System.out.println ("A :Create student");
        System.out.println ("B :Display all students.");
        System.out.println ("C :Create Instructor");
        System.out.println ("D :Display all instructors.");
        System.out.println ("E :Go back to Home menu");
        System.out.print("Enter from a to e:  ");
        char choice = new Scanner (System.in).next ().toUpperCase ().charAt (0);
        switch (choice){
            case 'A' : add_Student();
            case 'B' : { ArrayList<Student> studentArrayList = StudentfileIO.get_All_Students();
                         System.out.println("All Students.");
                for(Student student : studentArrayList)
                {
                    System.out.println(student);
                }
                people_Manage();
            }
            case 'C' : add_Instructor ();
            case 'D' : { ArrayList<Instructor> instructorArrayList = InstructorfileIO.get_All_Instructors();
                         System.out.println("All instructors list.");
                for(Instructor instructor : instructorArrayList)
                {
                    System.out.println(instructor);
                }
                people_Manage();
            }
            case 'E' : course_Menu ();
            default : {System.out.println("Invalid ! Please try again.");
                        people_Manage();
            }
        }
    }

    public static void add_Student(){
        System.out.print("Enter student's full name: ");
        String fName = new Scanner(System.in).nextLine ();
        System.out.print("Enter students gender: ");
        String gender = new Scanner(System.in).nextLine ();
        StudentfileIO.add_Student(fName,gender);
        people_Manage();
    }

    public static void add_Instructor(){
        System.out.print ("Enter full instructor name: ");
        String fName = new Scanner(System.in).nextLine ();
        System.out.print ("Enter gender: ");
        String gender = new Scanner(System.in).nextLine ();
        InstructorfileIO.addInstructor(fName,gender);
        people_Manage();
    }

    public static void course_Menu ()
    {
        System.out.println ("A :Create  a course");
        System.out.println ("B :Display the courses");
        System.out.println ("C :Add module to the course.");
        System.out.println ("D :Delete a course.");
        System.out.println ("E :Go back");
        System.out.print ("Enter from a to e:  ");
        char choice = new Scanner(System.in).next().toUpperCase().charAt(0);
        switch (choice){
            case 'A' : add_Course();
            case 'B' : { display_Courses(); course_Menu();}
            case 'C' : add_Module();
            case 'D' : delete_Course();
            case 'E' : admin_Menu();
            default : 
            {
                System.out.println ("Invalid Entry! Enter from a to e:  ");
                course_Menu();
            }
        }
    }

    private static void add_Course(){
        System.out.print ("Enter a course name:  ");
        String name = new Scanner (System.in).nextLine ();
        System.out.print ("Enter the semester year:  ");
        int semester = new Scanner (System.in).nextInt ();
        System.out.print ("Enter the level from 4 to 6:  ");
        int level = new Scanner (System.in).nextInt ();
        CoursesfileIO.add_Course (name, semester, level);
        course_Menu();
    }

    private static void add_Module(){
        display_Courses();
        display_Modules();
        System.out.print("Enter a course id:  ");
        int course_ID = new Scanner(System.in).nextInt ();
        System.out.print("Enter module id:  ");
        int module_ID = new Scanner(System.in).nextInt ();
        RelationfileIO.addModuleToCourse(course_ID, module_ID);
        course_Menu();
    }

    public static void manage_Module(){
        System.out.println("A :Create a module");
        System.out.println("B :Assign instructor to the module");
        System.out.println("C :Delete a module.");
        System.out.println("D :Go back");
        System.out.print("Enter from a to d: ");
        char choice = new Scanner(System.in).next().toUpperCase().charAt(0);
        switch (choice){
            case 'A' : register_Module();
            case 'B' : addInstructorToModule();
            case 'C' : delete_Module();
            case 'D' : course_Menu();
            default : 
            {
                System.out.println("Invalid Entry! Enter from a to d:  ");
                manage_Module();
            }
        }
    }

    private static void register_Module(){
        System.out.print("Enter module name:  ");
        String mName = new Scanner(System.in).nextLine();
        ModulefileIO.add_Module(mName);
        manage_Module();
    }

    private static void addInstructorToModule(){
        display_Modules();
        ArrayList<Instructor> instructorArrayList = InstructorfileIO.get_All_Instructors();
        System.out.println("List of available instructors");
        for(Instructor instructor : instructorArrayList)
        {
            System.out.println(instructor);
        }
        System.out.println("Add instructor to modules.");
        System.out.print("Enter instructor id:  ");
        int instructor_ID = new Scanner(System.in).nextInt();
        System.out.print("Enter module id:");
        int module_ID = new Scanner(System.in).nextInt();
        RelationfileIO.addInstructorToModule(instructor_ID, module_ID);
        manage_Module();
    }

    private static void display_Modules(){
        System.out.println("List of all modules available.");
        ArrayList<Module> moduleArrayList = ModulefileIO.get_All_Modules();
        for (Module module : moduleArrayList)
        {
            System.out.println(module);
        }
    }

    private static void display_Courses()
    {
        ArrayList<Course> courseArrayList = CoursesfileIO.get_All_Courses();
        for (Course course : courseArrayList){
            System.out.println(course);
        }
    }

    public static void print_Result()
    {
        System.out.print("Enter the student id:   ");
        int sID = new Scanner(System.in).nextInt();
        Student student = StudentfileIO.get_Student_By_ID(sID);
        Course course = RelationfileIO.getStudentCourse(sID);
        if(student != null)
        {
            StringBuilder resultString = new StringBuilder("Student ID: " + sID + "\nStudent Name: " + student.get_Full_Name () + "\n\nModule\t\tMarks\n");
            ArrayList<ModuleStudent> moduleStudentArrayList = RelationfileIO.get_Module_Student_Array_List();
            for(ModuleStudent moduleStudent: moduleStudentArrayList){
                if (moduleStudent.get_Student_ID() == sID){
                    Module module = ModulefileIO.get_Module_By_ID (moduleStudent.get_Module_ID());
                    if (module != null){
                        resultString.append(module.get_Module_Name ()).append ("\t\t").append(moduleStudent.get_Marks ()).append ("\n");
                    }
                }
            }
            if (course != null){
                resultString.append("\nCourse: " + course.get_Course_Name () + "\nLevel: " + course.get_Course_Level () + "\tSemester: " + course.get_Semester());
            }
            try{
                PrintWriter out = new PrintWriter("Marks sheet.txt");
                out.println(resultString);
                out.close();
            }
            catch(Exception e)
            {
                System.out.println(e.toString());
                System.out.println("Error");
            }

            System.out.println("Result printed to Marks sheet.txt");
        }
        else{
            System.out.println("Data not found.");
        }
        admin_Menu();
    }

    private static void delete_Module()
    {
        display_Modules();
        System.out.print("Enter module id:  ");
        int moduleID = new Scanner(System.in).nextInt();
        ModulefileIO.deleteModuleByID(moduleID);
        manage_Module();
    }

    private static void delete_Course()
    {
        display_Courses();
        System.out.print("Enter course id:  ");
        int courseID = new Scanner(System.in).nextInt();
        CoursesfileIO.delete_Module_By_ID(courseID);
        course_Menu();
    }
}
