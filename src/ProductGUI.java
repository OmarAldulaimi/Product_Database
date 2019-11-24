import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ProductGUI extends JFrame {

    private JPanel panel,panel2,panel3;
    private JLabel p_name, message;
    private JTextField userName_text;
    private JButton add_btn;
    private JList list;
    private Food food;
    private String[] choices = { "Food","Clothes", "Furniture"};
    private JComboBox<String> cb;
    private String choice;


    public ProductGUI() {
        food = new Food();
        panel = new JPanel(new GridLayout(1, 2));
        panel2 = new JPanel(new GridLayout(1, 1));
        panel3 = new JPanel(new GridLayout(1, 1));
        this.setTitle("Add Products");
        this.setSize(600, 800);
        this.setVisible(true);
        this.add(panel, BorderLayout.CENTER);
        this.add(panel2, BorderLayout.NORTH);
        this.add(panel3, BorderLayout.SOUTH);



        
        p_name = new JLabel();
        p_name.setText("User Name :");
        userName_text = new JTextField();

        //list
        cb = new JComboBox<String>(choices);
        cb.setVisible(true);
        panel.add(cb);

        // Submit
        add_btn = new JButton("SUBMIT");
        add_btn.setBounds(50,100,80,30);
        list = new JList();
        panel3.add(list);


        panel.add(p_name);
        panel.add(userName_text);

        panel2.add(p_name);
        panel2.add(userName_text);

        message = new JLabel();
        panel2.add(message);
        panel2.add(add_btn);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Adding the listeners to components..
        add_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if (choices.toString().matches("food"))    {
                    food.setName(userName_text.getText());         
                    message.setText(food.getName());               
               }else if (choices.equals("Clothes")){
                   food.setName(userName_text.getText());
                   message.setText(food.getName());
               }else if (choices.equals("Furniture")){

               }else{
                   message.setText("Please choose one");

               }

            }
        });


    }

}