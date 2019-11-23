import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.DefaultCaret;

public class LoginGUI extends JFrame implements ActionListener {

    private JPanel panel;
    private JLabel user_label, password_label, message;
    private JTextField userName_text;
    private JPasswordField password_text;
    private JButton submit;
    private ProductGUI productGUI;

    public LoginGUI() {

        // Username Label
        user_label = new JLabel();
        user_label.setText("User Name :");
        userName_text = new JTextField();

        // Password Label
        password_label = new JLabel();
        password_label.setText("Password :");
        password_text = new JPasswordField();

        // Submit
        submit = new JButton("SUBMIT");

        panel = new JPanel(new GridLayout(3, 1));
        panel.add(user_label);
        panel.add(userName_text);
        panel.add(password_label);
        panel.add(password_text);

        message = new JLabel();
        panel.add(message);
        panel.add(submit);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Adding the listeners to components..
        submit.addActionListener(this);
        add(panel, BorderLayout.CENTER);
        setTitle("Please Login Here !");
        setSize(300,200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String userName = userName_text.getText();
        String password = password_text.getText();
        if (!userName.isEmpty() && !password.isEmpty()) {
            message.setText(" Hello " + userName);
            productGUI = new ProductGUI();
          //  this.setVisible(false);

        } else {
            message.setText(" Invalid user.. ");
        }
    }
}
