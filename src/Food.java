import java.util.ArrayList;

public class Food implements Products {

  //  private HashMap<String, String> product = new HashMap<String, String>();
    private String name;
    private String price;
    private ArrayList<String> products = new ArrayList<String>();


    public Food() {

    }

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
        this.price = i;
    }



    @Override
    public String getPrice() {
        return price;
    }


}

