import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.Scanner;

public class CopyFile {
    String str = "";
    public void readFileSource(String filePathSource) {
        try {
            File file = new File(filePathSource);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            int c = -1;
            int count = 0;
            while ((c = br.read()) != -1) {
                count++;
                str += (char) c;
            }
            br.close();
            System.out.println("The number of characters in the file: " + count);
        } catch (Exception e) {
            System.err.println("File not found or error content");
        }
    }

    public void writeFileDestination(String filePathDestination) {
        try {
            File file = new File(filePathDestination);
            if (file.exists()) {
                throw new FileAlreadyExistsException(filePathDestination);
            }

            BufferedWriter bw = new BufferedWriter(new FileWriter(filePathDestination));
            for (int i = 0; i < str.length(); i++) {
                bw.write(str.charAt(i));
            }
            System.out.println("Writing successful");
            bw.close();
        } catch (Exception e) {
            System.err.println("File exists");
        }
    }

    public static void main(String[] args) {
        CopyFile copyFile = new CopyFile();
        copyFile.readFileSource("F:/java.io.file/module2Unit17CopyFile.txt");
        copyFile.writeFileDestination("F:/java.io.file/module2Unit17PasteFile.txt");
    }
}
