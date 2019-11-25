import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.text.DefaultCaret;

public class LoginGUI extends JFrame {

   private JLabel nameLabel=new JLabel("NAME");
   private JLabel passwordLabel=new JLabel("PASSWORD");
   private JTextField nameTextField=new JTextField();
   private JPasswordField passwordField=new JPasswordField();
   private JButton registerButton=new JButton("NEW USER");
   private JButton loginButton=new JButton("LOGIN");
   private ProductGUI productGUI;


    public LoginGUI (){
        createWindow();
        setLocationAndSize();
        addComponentsToFrame();

    }
    public void createWindow()
    {
        this.setTitle("Registration Form");
        this.setBounds(40,40,380,350);
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
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
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ProductGUI();
                setVisible(false);
            }
        });
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                PreparedStatement Pstatement = null;
                String userName = nameTextField.getText();
                String password = passwordField.getText();

                    try {
                        Class.forName("com.mysql.jdbc.Driver").newInstance();
                    } catch (InstantiationException e1) {
                        e1.printStackTrace();
                    } catch (IllegalAccessException e2) {
                        e2.printStackTrace();
                    } catch (ClassNotFoundException e3) {
                        e3.printStackTrace();
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
                    } catch (SQLException e4) {
                        e4.printStackTrace();

                    }

            }
        });

    }

    }



