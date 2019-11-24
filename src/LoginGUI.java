import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.text.DefaultCaret;

public class LoginGUI extends JFrame implements ActionListener {

    JLabel nameLabel=new JLabel("NAME");
    JLabel passwordLabel=new JLabel("PASSWORD");
    JTextField nameTextField=new JTextField();
    JPasswordField passwordField=new JPasswordField();
    JButton registerButton=new JButton("NEW USER");
    JButton loginButton=new JButton("LOGIN");


    public LoginGUI (){
        createWindow();
        setLocationAndSize();
        addComponentsToFrame();

    }
    public void createWindow()
    {
        this.setTitle("Registration Form");
        this.setBounds(40,40,380,350);
        this.getContentPane().setBackground(Color.pink);
        this.getContentPane().setLayout(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
    }
    public void setLocationAndSize()
    {
        nameLabel.setBounds(20,20,40,70);;
        passwordLabel.setBounds(20,75,80,70);
        nameTextField.setBounds(180,43,140,23);
        passwordField.setBounds(180,93,140,23);
        registerButton.setBounds(70,180,100,35);
        loginButton.setBounds(200,180,100,35);
    }
    public void addComponentsToFrame()
    {
        this.add(nameLabel);
        this.add(passwordLabel);
        this.add(nameTextField);
        this.add(passwordField);
        this.add(registerButton);
        this.add(loginButton);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        PreparedStatement Pstatement = null;
        String userName = nameTextField.getText();
        String password = passwordField.getText();
       if (ae.getSource() == loginButton) {

           try {
               Class.forName("com.mysql.jdbc.Driver").newInstance();
           } catch (InstantiationException e) {
               e.printStackTrace();
           } catch (IllegalAccessException e) {
               e.printStackTrace();
           } catch (ClassNotFoundException e) {
               e.printStackTrace();
           }
           //Creating Connection Object
           Connection connection = null;
           try {
               connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDatabase?autoReconnect=true&useSSL=false", "root", "omar7712378");
           //Preapared Statement

               Pstatement = connection.prepareStatement("insert into users values(?,?)");
               Pstatement.setString(1, userName);
               Pstatement.setString(2, password);
               Pstatement.executeUpdate();
               JOptionPane.showMessageDialog(null, "Data Registered Successfully");
           } catch (SQLException e) {
               e.printStackTrace();

           }

       /**    if (!userName.isEmpty() && !password.isEmpty()) {
            message.setText(" Hello " + userName);
              productGUI = new ProductGUI();
           this.setVisible(false);

          } else {
               message.setText(" Invalid user.. ");**/

       }
}
}

