package bài1;
import javax.swing.*;
import java.awt.*;

public class CRUDGui extends JFrame {
    private JTextArea textArea;
    private XMLHandler xmlHandler;

    public CRUDGui() {
        setTitle("XML CRUD Application");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        xmlHandler = new XMLHandler("data.xml");
        textArea = new JTextArea();
        JButton btnLoad = new JButton("Load XML");
        JButton btnAdd = new JButton("Add Element");

        btnLoad.addActionListener(e -> textArea.setText(xmlHandler.readXML()));
        btnAdd.addActionListener(e -> {
            String name = JOptionPane.showInputDialog("Enter element name:");
            if (name != null && !name.isEmpty()) {
                xmlHandler.addElement(name);
                textArea.setText(xmlHandler.readXML());
            }
        });

        JPanel panel = new JPanel();
        panel.add(btnLoad);
        panel.add(btnAdd);

        add(new JScrollPane(textArea), BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);
    }
}