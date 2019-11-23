import java.util.HashMap;
import java.util.Iterator;

public class Food implements Products {

    private HashMap<String, String> product = new HashMap<String, String>();
    private String name;
    private String price;

    public Food(String name, String price) {
        this.name = name;
        this.price = price;
        product.put(name, price);
    }

    public Food() {

    }

    @Override
    public void setName(String s) {
        this.name = s;

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setPrice(String i) {
        this.price = i;
    }



    @Override
    public String getPrice() {
        return price;
    }

    public String getList() {
        Iterator<String> keySetIterator = product.keySet().iterator();


            String key = keySetIterator.next();
            return key + product.get(key);

    }
}

