package bai1;

import javax.swing.*;
import java.awt.event.*;
import java.security.*;

public class LoginUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Login");
        JTextField userField = new JTextField(15);
        JPasswordField passField = new JPasswordField(15);
        JButton loginBtn = new JButton("Login");

        
        JPanel panel = new JPanel();
        panel.add(new JLabel("Username:"));
        panel.add(userField);
        panel.add(new JLabel("Password:"));
        panel.add(passField);
        panel.add(loginBtn);
        frame.add(panel);

        loginBtn.addActionListener(e -> {
            String user = userField.getText();
            String pass = new String(passField.getPassword());
            String hashedPass = hashPassword(pass); 

            
            if (user.equals("admin") && hashedPass.equals(hashPassword("123456"))) {
                JOptionPane.showMessageDialog(frame, "Login success!");
            } else {
                JOptionPane.showMessageDialog(frame, "Login failed!");
            }
        });

        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5"); 
            byte[] hash = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) sb.append(String.format("%02x", b));
            return sb.toString();
        } catch (Exception e) {
            return null;
        }
    }
}
