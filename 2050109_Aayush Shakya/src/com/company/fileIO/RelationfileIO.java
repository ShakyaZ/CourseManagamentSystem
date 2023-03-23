package com.company.fileIO;

import com.company.Main;
import com.company.Utils.CourseModule;
import com.company.Utils.CourseStudent;
import com.company.Utils.ModuleInstructor;
import com.company.Utils.ModuleStudent;
import com.company.model.Course;
import com.company.model.Module;


import java.io.*;
import java.util.ArrayList;


public class RelationfileIO {
    private static ArrayList < CourseModule > course_Module_Array_List = new ArrayList < > ();
    private static ArrayList < CourseStudent > course_Student_Array_List = new ArrayList < > ();
    private static ArrayList < ModuleInstructor > module_Instructor_Array_List = new ArrayList < > ();
    private static ArrayList < ModuleStudent > module_Student_Array_List = new ArrayList < > ();

    public static void read_Course_Module() {
        try {
            FileInputStream read_Data = new FileInputStream("coursemodule.txt");
            ObjectInputStream read_Stream = new ObjectInputStream(read_Data);
            course_Module_Array_List = (ArrayList < CourseModule > ) read_Stream.readObject();
            read_Stream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void save_Course_Module() {
        try {
            FileOutputStream write_Data = new FileOutputStream("coursemodule.txt");
            ObjectOutputStream write_Stream = new ObjectOutputStream(write_Data);
            write_Stream.writeObject(course_Module_Array_List);
            write_Stream.flush();
            write_Stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void read_Course_Student() {
        try {
            FileInputStream read_Data = new FileInputStream("coursestudent.txt");
            ObjectInputStream read_Stream = new ObjectInputStream(read_Data);
            course_Student_Array_List = (ArrayList < CourseStudent > ) read_Stream.readObject();
            read_Stream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void save_Course_Student() {
        try {
            FileOutputStream write_Data = new FileOutputStream("coursestudent.txt");
            ObjectOutputStream write_Stream = new ObjectOutputStream(write_Data);
            write_Stream.writeObject(course_Student_Array_List);
            write_Stream.flush();
            write_Stream.close();
        } catch (IOException e) {
            System.out.println("Not enrolled.");
        }
    }

    public static void read_Module_Instructor() {
        try {
            FileInputStream read_Data = new FileInputStream("moduleinstructor.txt");
            ObjectInputStream read_Stream = new ObjectInputStream(read_Data);
            module_Instructor_Array_List = (ArrayList < ModuleInstructor > ) read_Stream.readObject();
            read_Stream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void save_Module_Instructor() {
        try {
            FileOutputStream write_Data = new FileOutputStream("moduleinstructor.txt");
            ObjectOutputStream write_Stream = new ObjectOutputStream(write_Data);
            write_Stream.writeObject(module_Instructor_Array_List);
            write_Stream.flush();
            write_Stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void read_Module_Student() {
        try {
            FileInputStream read_Data = new FileInputStream("modulestudent.txt");
            ObjectInputStream read_Stream = new ObjectInputStream(read_Data);
            module_Student_Array_List = (ArrayList < ModuleStudent > ) read_Stream.readObject();
            read_Stream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void save_Module_Student() {
        try {
            FileOutputStream write_Data = new FileOutputStream("modulestudent.txt");
            ObjectOutputStream write_Stream = new ObjectOutputStream(write_Data);
            write_Stream.writeObject(module_Student_Array_List);
            write_Stream.flush();
            write_Stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void enroll_Into_Course(int student_ID, int course_ID) {
        try {
            read_Course_Student();
            CourseStudent course_Student = new CourseStudent(course_ID, student_ID);
            course_Student_Array_List.add(course_Student);
            save_Course_Student();
            System.out.println("Enrollment successful.");
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("Error.");
            Main.main();
        }
    }

    public static void print_Course_Of_Student(int student_ID) {
        try {
            read_Course_Student();
            CourseStudent course_Student;
            for (CourseStudent course_Student2: course_Student_Array_List) {
                if (course_Student2.get_Student_ID() == student_ID) {
                    course_Student = course_Student2;
                    Course course = CoursesfileIO.get_Course_By_ID(course_Student.get_Course_ID());
                    System.out.println(course);
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("Error.");
            Main.main();
        }
    }

    public static void addModuleToCourse(int course_ID, int module_ID) {
        try {
            read_Course_Module();
            CourseModule courseModule = new CourseModule(course_ID, module_ID);
            course_Module_Array_List.add(courseModule);
            save_Course_Module();
            System.out.println("Module added successfully.");
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("Error.");
            Main.main();
        }
    }

    public static void addInstructorToModule(int instructor_ID, int module_ID) {
        try {
            read_Module_Instructor();
            ModuleInstructor moduleInstructor = new ModuleInstructor(module_ID, instructor_ID);
            module_Instructor_Array_List.add(moduleInstructor);
            save_Module_Instructor();
            System.out.println("Instructor assigned to module.");
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("Error.");
            Main.main();
        }
    }

    public static void printInstructorModules(int instructor_ID) {
        try {
            read_Module_Instructor();
            for (ModuleInstructor module_Instructor: module_Instructor_Array_List) {
                if (module_Instructor.get_Instructor_ID() == instructor_ID) {
                    Module module = ModulefileIO.get_Module_By_ID(module_Instructor.get_Module_ID());
                    System.out.println(module);
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("Error.");
            Main.main();
        }
    }

    public static void markStudent(ModuleStudent module_Student) {
        try {
            read_Module_Student();
            module_Student_Array_List.add(module_Student);
            save_Module_Student();
            System.out.println("Successfully marked student.");
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("Error.");
            Main.main();
        }
    }

    public static ArrayList < ModuleStudent > get_Module_Student_Array_List() {
        read_Module_Student();
        return module_Student_Array_List;
    }

    public static Course getStudentCourse(int studentID) {
        Course course;
        read_Course_Student();
        CourseStudent course_Student;
        for (CourseStudent course_Student2: course_Student_Array_List) {
            if (course_Student2.get_Student_ID() == studentID) {
                course_Student = course_Student2;
                course = CoursesfileIO.get_Course_By_ID(course_Student.get_Course_ID());
                return course;
            }
        }
        return null;
    }
}