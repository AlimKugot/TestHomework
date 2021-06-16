package test.homework;

import model.StudentStatus;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Locale;

class Crud {

    public static void test(File f, StudentStatus student) {
        if (f.getName().toLowerCase(Locale.ROOT).equals("crud")) return;
        Method[] m = f.getClass().getMethods();
        int i = 3;
    }
}
