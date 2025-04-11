package bài1;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CRUDGui().setVisible(true));
    }
}