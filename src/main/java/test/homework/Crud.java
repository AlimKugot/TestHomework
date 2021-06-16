package test.homework;

import model.StudentStatus;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Locale;

class Crud {

    public static void test(Class<?> clazz, StudentStatus student) {
        if (clazz.getName().toLowerCase(Locale.ROOT).equals("crud")) return;

//        clazz.setPackage
        Method[] m = clazz.getMethods();
        int i = 3;
    }
}
