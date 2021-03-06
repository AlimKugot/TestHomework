package test.homework;

import google.Download;
import model.StudentStatus;
import xlsx.Excel;

import java.io.File;
import java.util.*;

/**
 * Test all in one file (it's not best practice)
 *
 * @author Alim Kugotov
 */
public class Main {
    public static Map<String, StudentStatus> studentList = new HashMap<>();

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
            StudentStatus student = new StudentStatus(name);
            for (File f : Objects.requireNonNull(folder.listFiles())) {
                switch (f.getName().toLowerCase(Locale.ROOT)) {
                    //todo: class or file?
                    case "crud.java" -> Crud.test(f.getClass(), student);
                    case "user.java" -> User.test(f, student);
                    case "gift.java" -> Gift.test(f, student);
                }
            }
            studentList.put(name, student);
        }
    }
}
