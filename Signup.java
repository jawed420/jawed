import javax.swing.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.regex.Pattern;

public class Signup{

    static HashMap<String, String> users = new HashMap<>();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Adminpage");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);


        JLabel nameLabel = new JLabel("Full Name:");
        nameLabel.setBounds(30, 30, 100, 25);
        frame.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(150, 30, 200, 25);
        frame.add(nameField);


        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(30, 70, 100, 25);
        frame.add(emailLabel);

        JTextField emailField = new JTextField();
        emailField.setBounds(150, 70, 200, 25);
        frame.add(emailField);


        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(30, 110, 100, 25);
        frame.add(userLabel);

        JTextField userField = new JTextField();
        userField.setBounds(150, 110, 200, 25);

        frame.add(userField);


        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(30, 150, 100, 25);
        frame.add(passLabel);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(150, 150, 200, 25);
        frame.add(passField);


        JLabel confirmLabel = new JLabel("Confirm Password:");
        confirmLabel.setBounds(30, 190, 120, 25);
        frame.add(confirmLabel);

        JPasswordField confirmField = new JPasswordField();
        confirmField.setBounds(150, 190, 200, 25);
        frame.add(confirmField);


        JButton signupButton = new JButton("Submit");
        signupButton.setBounds(150, 240, 100, 30);
        frame.add(signupButton);
        signupButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String fullName = nameField.getText();
                String email = emailField.getText();
                String username = userField.getText();
                String password = new String(passField.getPassword());
                String confirmPassword = new String(confirmField.getPassword());


                if (fullName.isEmpty() || email.isEmpty() || username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "All fields are required!");
                } else if (!isValidEmail(email)) {
                    JOptionPane.showMessageDialog(frame, "Invalid email format!");
                } else if (!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(frame, "Passwords do not match!");
                } else if (users.containsKey(username)) {
                    JOptionPane.showMessageDialog(frame, "Username already exists!");
                } else {

                    users.put(username, password);
                    JOptionPane.showMessageDialog(frame, "Signup successful for: " + fullName);

                    nameField.setText("");
                    emailField.setText("");
                    userField.setText("");
                    passField.setText("");
                    confirmField.setText("");
                }
            }
        });

        frame.setVisible(true);
    }


    private static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+@[a-zA-Z0-9.-]+\\.[a-z]{2,7}$";
        return Pattern.matches(emailRegex, email);
    }
}
