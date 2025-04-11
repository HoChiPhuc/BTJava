package Bài5;
import java.io.File;

public class ListFiles {
    public static void main(String[] args) {
        File folder = new File(".");
        File[] listOfFiles = folder.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                System.out.println(file.getName());
            }
        } else {
            System.out.println("Thư mục trống hoặc không tồn tại.");
        }
    }
}

