import java.io.Serializable;
import java.util.List;

public class Product implements Serializable {
    private String codePro;
    private String namePro;
    private int price;

    public Product() {
    }

    public Product(String codePro, String namePro, int price) {
        this.codePro = codePro;
        this.namePro = namePro;
        this.price = price;
    }

    public String getCodePro() {
        return codePro;
    }

    public void setCodePro(String codePro) {
        this.codePro = codePro;
    }

    public String getNamePro() {
        return namePro;
    }

    public void setNamePro(String namePro) {
        this.namePro = namePro;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "codePro='" + codePro + '\'' +
                ", namePro='" + namePro + '\'' +
                ", price=" + price +
                '}';
    }

    public String write() {
        return codePro + "," + namePro + "," + price;
    }

}
