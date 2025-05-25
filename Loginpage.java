import javax.swing.*;

public class Loginpage{
    public static void main(String[] args) {

        JFrame frame = new JFrame("Login Page");
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);


        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(20, 20, 80, 25);
        frame.add(userLabel);


        JTextField userText = new JTextField();
        userText.setBounds(100, 20, 200, 25);
        frame.add(userText);


        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(20, 60, 80, 25);
        frame.add(passLabel);


        JPasswordField passText = new JPasswordField();
        passText.setBounds(100, 60, 200, 25);
        frame.add(passText);


        JButton loginButton = new JButton("Login");
        loginButton.setBounds(120, 100, 100, 30);
        frame.add(loginButton);



        loginButton.addActionListener(_ -> {
            String username = userText.getText();
            String password = new String(passText.getPassword());

            if (username.equals("admin") && password.equals("12345")) {
                JOptionPane.showMessageDialog(frame, "Login Successful!");
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid username or password!");
            }
        });

        frame.setVisible(true);
    }
}
