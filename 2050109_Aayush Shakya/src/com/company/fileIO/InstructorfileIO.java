package com.company.fileIO;

import com.company.model.Instructor;

import java.io.*;
import java.util.ArrayList;

public class InstructorfileIO {

    private static ArrayList < Instructor > instructor_Array_List = new ArrayList < > ();

    public static ArrayList < Instructor > get_All_Instructors() {
        read_Instructor_List();
        return instructor_Array_List;
    }

    public static void addInstructor(String first_Name, String gender) {
        int user_Id, instructor_ID;
        read_Instructor_List();
        if (instructor_Array_List.isEmpty()) {
            user_Id = 1;
            instructor_ID = 1;
        } else {
            instructor_Array_List = get_All_Instructors();
            int size = instructor_Array_List.size() - 1;
            user_Id = instructor_Array_List.get(size).getUserId() + 1;
            instructor_ID = instructor_Array_List.get(size).get_Instructor_ID() + 1;
        }
        Instructor instructor = new Instructor(user_Id, first_Name, gender, instructor_ID);

        instructor_Array_List.add(instructor);

        save_Instructor_List(); // save array

        System.out.println("Instructor add successful.");
    }

    public static Instructor get_Student_By_ID(int iD) {
        read_Instructor_List();

        for (Instructor instructor: instructor_Array_List) {
            if (instructor.get_Instructor_ID() == iD) {
                return instructor;
            }
        }
        return null;
    }

    public static void save_Instructor_List() {
        try {
            FileOutputStream write_Data = new FileOutputStream("instructors.txt");
            ObjectOutputStream write_Stream = new ObjectOutputStream(write_Data);
            write_Stream.writeObject(instructor_Array_List);
            write_Stream.flush();
            write_Stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void read_Instructor_List() {
        try {
            FileInputStream read_Data = new FileInputStream("instructors.txt");
            ObjectInputStream read_Stream = new ObjectInputStream(read_Data);
            instructor_Array_List = (ArrayList < Instructor > ) read_Stream.readObject();
            read_Stream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}