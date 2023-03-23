package com.company.fileIO;

import com.company.model.Course;

import java.io.*;
import java.util.ArrayList;

public class CoursesfileIO {
    private static ArrayList<Course> course_Array_List = new ArrayList<>();
    public static ArrayList<Course> get_All_Courses (){
        read_Course_List ();
        return course_Array_List;
    }

    public static Course get_Course_By_ID(int id){
        read_Course_List ();
        for (Course course: course_Array_List){
            if (course.get_Course_ID() == id){
                return course;
            }
        }
        return null;
    }

    public static void save_Course_List (){
        try{
            FileOutputStream write_Data = new FileOutputStream ("courses.txt");
            ObjectOutputStream write_Stream = new ObjectOutputStream (write_Data);
            write_Stream.writeObject (course_Array_List);
            write_Stream.flush ();
            write_Stream.close ();
        }

        catch (IOException e)
        {
            e.printStackTrace ();
        }
    }

    public static void read_Course_List () {
        try {
            FileInputStream read_Data = new FileInputStream ("courses.txt");
            ObjectInputStream read_Stream = new ObjectInputStream (read_Data);
            course_Array_List = (ArrayList<Course>) read_Stream.readObject ();
            read_Stream.close ();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void add_Course(String name, int semester, int level) {
        int course_Id;
        read_Course_List();
        if(course_Array_List.isEmpty()){
            course_Id = 1;
        }
        else{
            course_Array_List = get_All_Courses();
            int size = course_Array_List.size() - 1 ;
            course_Id = course_Array_List.get (size).get_Course_ID() + 1;
        }
        Course course = new Course(course_Id,name,semester,level,false);
        course_Array_List.add(course);
        save_Course_List();
        System.out.println ("Successfully created course.");
    }

    public static void delete_Module_By_ID (int course_ID) {
        read_Course_List();
        ArrayList<Course> course_Array_List2 = new ArrayList<>();
        for(Course course: course_Array_List)
        {
            if (course.get_Course_ID() != course_ID)
            {
                course_Array_List2.add (course);
            }
        }
        course_Array_List.clear();
        course_Array_List.addAll(course_Array_List2);
        save_Course_List();
        System.out.println("Successfully deleted course.");
    }
}
