import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class adminpage extends JFrame implements ActionListener {

    JTextField nameField, fatherField, motherField, mobileField, userField, otpField;
    JPasswordField passField;
    JButton submitBtn, otpBtn, verifyBtn;
    String generatedOTP = "";

    adminpage() {
        setTitle("Admin Page");
        setSize(400, 450);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(20, 20, 100, 30);
        add(nameLabel);
        nameField = new JTextField();
        nameField.setBounds(150, 20, 200, 30);
        add(nameField);

        JLabel fatherLabel = new JLabel("Father's Name:");
        fatherLabel.setBounds(20, 60, 100, 30);
        add(fatherLabel);
        fatherField = new JTextField();
        fatherField.setBounds(150, 60, 200, 30);
        add(fatherField);

        JLabel motherLabel = new JLabel("Mother's Name:");
        motherLabel.setBounds(20, 100, 120, 30);
        add(motherLabel);
        motherField = new JTextField();
        motherField.setBounds(150, 100, 200, 30);
        add(motherField);

        JLabel mobileLabel = new JLabel("Mobile No:");
        mobileLabel.setBounds(20, 140, 100, 30);
        add(mobileLabel);
        mobileField = new JTextField();
        mobileField.setBounds(150, 140, 200, 30);
        add(mobileField);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(20, 180, 100, 30);
        add(userLabel);
        userField = new JTextField();
        userField.setBounds(150, 180, 200, 30);
        add(userField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(20, 220, 100, 30);
        add(passLabel);
        passField = new JPasswordField();
        passField.setBounds(150, 220, 200, 30);
        add(passField);


        JLabel otpLabel = new JLabel("Enter OTP:");
        otpLabel.setBounds(20, 260, 100, 30);
        add(otpLabel);
        otpField = new JTextField();
        otpField.setBounds(150, 260, 200, 30);
        add(otpField);


        otpBtn = new JButton("Generate OTP");
        otpBtn.setBounds(20, 300, 150, 30);
        otpBtn.addActionListener(this);
        add(otpBtn);

        verifyBtn = new JButton("Verify OTP");
        verifyBtn.setBounds(200, 300, 150, 30);
        verifyBtn.addActionListener(this);
        add(verifyBtn);

        submitBtn = new JButton("Submit");
        submitBtn.setBounds(120, 350, 150, 30);
        submitBtn.addActionListener(this);
        add(submitBtn);

        setVisible(true);
    }


    String generateOTP() {
        Random rand = new Random();
        int otp = rand.nextInt(9000) + 1000; // 4-digit OTP
        return String.valueOf(otp);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == otpBtn) {
            generatedOTP = generateOTP();
            JOptionPane.showMessageDialog(this, "Your OTP is: " + generatedOTP);
        } else if (e.getSource() == verifyBtn) {
            String enteredOTP = otpField.getText();
            if (enteredOTP.equals(generatedOTP)) {
                JOptionPane.showMessageDialog(this, "OTP Verified Successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid OTP!");
            }
        } else if (e.getSource() == submitBtn) {

            if (nameField.getText().isEmpty() || generatedOTP.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please complete all fields and verify OTP.");
            } else {
                JOptionPane.showMessageDialog(this, "Form Submitted Successfully!");
            }
        }
    }

    public static void main(String[] args) {
        new adminpage();
    }
}
