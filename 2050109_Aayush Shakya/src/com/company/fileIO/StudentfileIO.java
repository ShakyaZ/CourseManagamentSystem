package com.company.fileIO;

import com.company.model.Student;

import java.io.*;
import java.util.ArrayList;


public class StudentfileIO {
    private static ArrayList < Student > studentArrayList = new ArrayList < > ();
    public static ArrayList < Student > get_All_Students() {
        read_Student_List();
        return studentArrayList;
    }

    public static void add_Student(String fullName, String gender) {
        int userId, studentID;
        read_Student_List();
        if (studentArrayList.isEmpty()) {
            userId = 1;
            studentID = 1;
        } else {
            studentArrayList = get_All_Students();
            int size = studentArrayList.size() - 1;
            userId = studentArrayList.get(size).getUserId() + 1;
            studentID = studentArrayList.get(size).get_Student_ID() + 1;
        }
        Student student = new Student(userId, fullName, gender, studentID);
        studentArrayList.add(student);
        save_Student_List();
    }


    public static Student get_Student_By_ID(int iD)
    {
        read_Student_List();
        for (Student s: studentArrayList) {
            if (s.get_Student_ID() == iD) {
                return s;
            }
        }
        return null;
    }

    public static void save_Student_List() {
        try {
            FileOutputStream write_Data = new FileOutputStream("students.txt");
            ObjectOutputStream write_Stream = new ObjectOutputStream(write_Data);
            write_Stream.writeObject(studentArrayList);
            write_Stream.flush();
            write_Stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void read_Student_List() {
        try {
            FileInputStream read_Data = new FileInputStream("students.txt");
            ObjectInputStream read_Stream = new ObjectInputStream(read_Data);
            studentArrayList = (ArrayList < Student > ) read_Stream.readObject();
            read_Stream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}