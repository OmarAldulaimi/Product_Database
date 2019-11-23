import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ProductGUI extends JFrame {

    private JPanel panel;
    private JLabel user_label, password_label, message;
    private JTextField userName_text;
    private JTextField password_text;
    private JButton submit;
    private ViewGUI viewGUI;
    private Food food;

    public ProductGUI() {
        panel = new JPanel(new GridLayout(3, 1));
        this.setTitle("Add Products");
        this.setSize(300, 200);
        this.setVisible(true);
        this.add(panel, BorderLayout.CENTER);
        user_label = new JLabel();
        user_label.setText("User Name :");
        userName_text = new JTextField();

        // Password Label
        password_label = new JLabel();
        password_label.setText("Password :");
        password_text = new JTextField();

        // Submit
        submit = new JButton("SUBMIT");


        panel.add(user_label);
        panel.add(userName_text);
        panel.add(password_label);
        panel.add(password_text);

        message = new JLabel();
        panel.add(message);
        panel.add(submit);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Adding the listeners to components..
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                food = new Food(userName_text.getText(),password_text.getText());
                viewGUI = new ViewGUI();

            }
        });
        

    }

}