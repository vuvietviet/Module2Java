import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReaderAndWriter {
    public void writeFile(List<Product> productList) {
        File file = new File("listOfProduct.csv");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(productList);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            System.err.println("Error");;
        }
    }

    public List<Product> readFile() {
        List<Product> productList = new ArrayList<>();
        File file = new File("listOfProduct.csv");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            productList = (List<Product>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (IOException e) {
            System.err.println("File not found");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return productList;
    }
}
