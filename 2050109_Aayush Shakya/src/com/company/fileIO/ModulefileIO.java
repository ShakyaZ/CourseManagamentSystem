package com.company.fileIO;

import java.io.*;
import java.util.ArrayList;
import com.company.model.Module;


public class ModulefileIO {
    private static ArrayList < Module > module_Array_List = new ArrayList < > ();
    public static ArrayList < Module > get_All_Modules() {
        read_Module_List();
        return module_Array_List;
    }

    public static Module get_Module_By_ID(int module_Id) {
        read_Module_List();
        for (Module module: module_Array_List) {
            if (module.get_Module_ID() == module_Id) {
                return module;
            }
        }
        return null;
    }

    public static void save_Module_List() {
        try {
            FileOutputStream write_Data = new FileOutputStream("modules.txt");
            ObjectOutputStream write_Stream = new ObjectOutputStream(write_Data);
            write_Stream.writeObject(module_Array_List);
            write_Stream.flush();
            write_Stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void read_Module_List() {
        try {
            FileInputStream read_Data = new FileInputStream("modules.txt");
            ObjectInputStream read_Stream = new ObjectInputStream(read_Data);
            module_Array_List = (ArrayList < Module > ) read_Stream.readObject();
            read_Stream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void add_Module(String name) {
        int module_Id;
        read_Module_List();
        if (module_Array_List.isEmpty()) {
            module_Id = 1;
        } else {
            module_Array_List = get_All_Modules();
            int size = module_Array_List.size() - 1;
            module_Id = module_Array_List.get(size).get_Module_ID() + 1;
        }
        Module module = new Module(module_Id, name, false);
        module_Array_List.add(module);
        save_Module_List();
        System.out.println("Module creation successful.");
    }

    public static void deleteModuleByID(int module_Id) {
        read_Module_List();
        ArrayList < Module > module_Array_List2 = new ArrayList < > ();
        for (Module module: module_Array_List) {
            if (module.get_Module_ID() != module_Id) {
                module_Array_List2.add(module);
            }
        }
        module_Array_List.clear();
        module_Array_List.addAll(module_Array_List2);
        save_Module_List();
        System.out.println("Module delete successful.");
    }
}