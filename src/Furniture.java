import java.util.ArrayList;

public class Furniture implements Products {
    private String name;
    private String price;
    private ArrayList<String> products = new ArrayList<String>();


    @Override
    public void setName(String s) {
        products.add(s);


    }

    @Override
    public String getName() {
        name = products.toString();
        return name;
    }

    @Override
    public void setPrice(String i) {

    }

    @Override
    public String getPrice() {
        return null;
    }
}
