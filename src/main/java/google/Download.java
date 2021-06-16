package google;

import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;


public class Download {
    /**
     * Path to save all downloaded files
     */
    private static String absolutePath = "/home/alim/IdeaProjects/CheckHomework/" +
            "CheckHomework/src/main/java/homework/";

    /**
     * ID of file from Google drive
     */
    private static String folderID;
    private static String propertiesPath = "/home/alim/IdeaProjects/CheckHomework/" +
            "CheckHomework/src/main/resources/folder_id.properties";


    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(propertiesPath));
            folderID = properties.getProperty("PARA4");
        } catch (IOException e) {
            //nothing to do because you can set folderID via setter method
            //it's not best practice
        }
    }

    @SuppressWarnings("unused")
    public static String getAbsolutePath() {
        return absolutePath;
    }

    @SuppressWarnings("unused")
    public static void setAbsolutePath(String absolutePath) {
        Download.absolutePath = absolutePath;
    }

    @SuppressWarnings("unused")
    public static String getFolderID() {
        return folderID;
    }

    @SuppressWarnings("unused")
    public static void setFolderID(String folderID) {
        Download.folderID = folderID;
    }

    @SuppressWarnings("unused")
    public static String getPropertiesPath() {
        return propertiesPath;
    }

    @SuppressWarnings("unused")
    public static void setPropertiesPath(String propertiesPath) {
        Download.propertiesPath = propertiesPath;
    }

    /**
     * Download all files and folder from folderID
     *
     * @param service part of google drive auth
     * @throws IOException if folderID is incorrect
     */
    protected static void downloadFolder(Drive service) throws IOException {
        String pageToken = null;
        do {
            FileList result = service.files().list()
                    .setQ("'" + folderID + "' in parents")
                    .setSpaces("drive")
                    .setFields("nextPageToken, files(id, name)")
                    .setPageToken(pageToken)
                    .execute();
            for (File folder : result.getFiles()) {
                System.out.printf("Found folder: %s (%s)\n", folder.getName(), folder.getId());
                downloadFilesInFolder(service, folder);
            }
            pageToken = result.getNextPageToken();
        } while (pageToken != null);
    }

    /**
     * Helper for downloadFolder
     *
     * @param service part of google drive auth
     * @param folder to download files from it
     * @throws IOException if service or folder is incorrect
     */
    private static void downloadFilesInFolder(Drive service, File folder) throws IOException {
        folder.setName(Packages.renameFolderToPackage(folder.getName()));
        final String folderPath = absolutePath + folder.getName() + "/";
        java.io.File direct = new java.io.File(folderPath);
        if (!direct.exists()) direct.mkdirs();

        FileList result;
        String pageToken = null;

        do {
            result = service.files().list()
                    .setQ("'" + folder.getId() + "' in parents")
                    .setSpaces("drive")
                    .setFields("nextPageToken, files(id, name)")
                    .setPageToken(pageToken)
                    .execute();
            for (File file : result.getFiles()) {
                try (OutputStream os = new FileOutputStream(folderPath + file.getName())) {
                    service.files()
                            .get(file.getId())
                            .executeMediaAndDownloadTo(os);
                }
            }
            pageToken = result.getNextPageToken();
        } while (pageToken != null);
    }
}