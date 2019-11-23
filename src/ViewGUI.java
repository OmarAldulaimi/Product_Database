import javax.swing.*;
import java.awt.*;

public class ViewGUI extends JFrame {

        private JPanel panel;
        private JPanel panel2;
        private JLabel p_name;
        private JLabel p_price;
        private Food food;

        public ViewGUI() {
            panel = new JPanel(new GridLayout(3, 1));
            panel2 = new JPanel(new GridLayout(3, 1));
            this.setTitle("View");
            this.setSize(300,300);
            this.setVisible(true);
            this.add(panel, BorderLayout.CENTER);
            this.add(panel2, BorderLayout.SOUTH);
          panel = new JPanel();
          panel2 = new JPanel();
          food = new Food();
            p_name = new JLabel();
            p_price = new JLabel();
            panel.add(p_name);
            panel2.add(p_price);
            print();

        }

        private void print (){
            p_name.setText("Product" + food.getList());
        }


    }
