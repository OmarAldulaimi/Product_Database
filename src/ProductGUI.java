import javax.swing.*;
import java.awt.*;

public class ProductGUI extends JFrame {
    private JPanel panel = new JPanel();
    private JLabel userName_text;

    public ProductGUI() {
        userName_text = new JLabel();
        this.setTitle("Please Login Here !");
        this.setSize(300,300);
        panel = new JPanel(new GridLayout(3, 1));
        add(panel, BorderLayout.CENTER);
        panel.add(userName_text);

    }

    public void name (String s){
        userName_text.setText(s);
    }






}
