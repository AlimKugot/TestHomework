package test.homework;

import google.Download;
import model.Student;
import xlsx.Excel;

import java.io.File;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Test all in one file (it's not best practice)
 *
 * @author Alim Kugotov
 */
public class Structure {
    public static Map<String, Student> studentList = new HashMap<>();

    /**
     * Where we saved downloaded files
     */
    public static final String absolutePath = Download.getAbsolutePath();

    /**
     * Folders with student's name
     */
    public static final File[] folders = new File(absolutePath).listFiles();

    /**
     * Excel file with result of our tests
     */
    Excel excel = new Excel();


    /**
     * Checks download folder and init map with students
     */
    public static void main(String[] args) {
        assert folders != null;
        for (File folder : folders) {
            String name = folder.getName();
            Student student = new Student(name);
            for (File f : Objects.requireNonNull(folder.listFiles())) {
                switch (f.getName().toLowerCase(Locale.ROOT)) {
                    case "crud.java" -> Crud.check(f, student);
                    case "user.java" -> User.check(f, student);
                    case "gift.java" -> Gift.check(f, student);
                }
            }
            studentList.put(name, student);
        }
    }

    static class Crud {
        static void check(File f, Student student) {
            if (f.getName().toLowerCase(Locale.ROOT).equals("crud")) return;
            Method[] m = f.getClass().getMethods();
            int i = 3;
        }

//        private static methodName
    }

    static class User {
        static void check(File f, Student student) {}
//        static boolean userFile(File f) {
//
//        }
    }

    static class Gift {
        static void check(File f, Student student) {}
    }
}
