import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ProductGUI extends JFrame {

    private JPanel panel,panel2;
    private JLabel p_name;
    private JTextField txt_name;
    private JButton add_btn;
    private DefaultListModel<String> dlm = new DefaultListModel<String>();
    private DefaultListModel<String> dlm2 = new DefaultListModel<String>();
    private DefaultListModel<String> dlm3 = new DefaultListModel<String>();
    private DefaultListModel<String> dlm4 = new DefaultListModel<String>();
    private JList list = new JList(dlm);
    private JList list2 = new JList(dlm2);
    private JList list3 = new JList(dlm3);
    private JList list4 = new JList(dlm4);
    private Food food;
    private Furniture furniture;
    private Clothes clothes;
    private Other other;
    private String[] choices = { "Food","Clothes", "Furniture", "Other"};
    private JComboBox<String> cb;
    private String choice;



    public ProductGUI() {
        food = new Food();
        furniture = new Furniture();
        clothes = new Clothes();
        other = new Other();
        panel = new JPanel(new GridLayout(3, 3));
        panel2 = new JPanel(new GridLayout(2, 1));
        this.setTitle("Add Products");
        this.setSize(600, 800);
        this.setVisible(true);
        this.add(panel, BorderLayout.CENTER);
        this.add(panel2, BorderLayout.NORTH);
        p_name = new JLabel();
        p_name.setText("Product Name :");
        txt_name = new JTextField();

        //list
        cb = new JComboBox<String>(choices);
        cb.setVisible(true);


        // Submit
        add_btn = new JButton("Add");
        add_btn.setBounds(50,100,80,30);

     
        panel.add(list);
        panel.add(list2);
        panel.add(list3);
        panel.add(list4);

        list.setBackground(Color.pink);
        list2.setBackground(Color.LIGHT_GRAY);
        list3.setBackground(Color.yellow);
        list4.setBackground(Color.red);

        panel2.add(p_name);
        panel2.add(txt_name);
        panel2.add(add_btn);
        panel2.add(cb);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Adding the listeners to components..
        add_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choice = (String) cb.getSelectedItem();
               if (choice.matches("Food"))    {
                    food.setName(txt_name.getText());
                    dlm.addElement(food.getName());

               }else if (choice.matches("Clothes")){
                   clothes.setName(txt_name.getText());
                   dlm2.addElement(clothes.getName());
               }else if (choice.matches("Furniture")){
                   furniture.setName(txt_name.getText());
                   dlm3.addElement(furniture.getName());

               }else if (choice.matches("Other")) {
                     other.setName(txt_name.getText());
                     dlm4.addElement(other.getName());

               }

            }
        });


    }

}