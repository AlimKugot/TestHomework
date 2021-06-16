package google;

import java.io.File;

public class Packages {
    private static final String absolutePath = Download.getAbsolutePath();
    public static final File[] folders = new File(absolutePath).listFiles();

    /**
     * Changes folderName to package name (check naming package convention)
     *
     * @param folderName to change
     * @return normal package nome
     */
    public static String renameFolderToPackage(String folderName) {
        String packageName = folderName
                .replaceAll("[_\\s]", ".")
                .replaceAll("\\d", "");
        if (packageName.charAt(0) == '.') packageName = packageName.substring(1, packageName.length());
        return packageName;
    }


    public static void main(String[] args) {
        changePackageNamesInClasses();
    }

    public static void changePackageNamesInClasses() {
        assert folders != null;
        for (File folder : folders) {
            Package s = folder.getClass().getPackage();
            System.out.println(s);
        }
    }
}
