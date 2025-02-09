import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class EmployeeGUI {
    private JFrame frame;
    private JTextField cardIdField;
    private JTextField floorField;
    private JTextField roomField;
    private Main mainInstance;


    public EmployeeGUI(Main mainInstance) {
        this.mainInstance = mainInstance;

        frame = new JFrame("Employee Access Control System");

        JLabel roleLabel = new JLabel("Role: Employee");
        roleLabel.setBounds(20, 20, 200, 20);

        // Card ID Field
        JLabel cardIdLabel = new JLabel("Card ID:");
        cardIdLabel.setBounds(10, 50, 80, 25);
        frame.add(cardIdLabel);

        cardIdField = new JTextField();
        cardIdField.setBounds(100, 50, 160, 25);
        frame.add(cardIdField);

        // Floor Field
        JLabel floorLabel = new JLabel("Floor:");
        floorLabel.setBounds(10, 90, 80, 25);
        frame.add(floorLabel);

        floorField = new JTextField();
        floorField.setBounds(100, 90, 160, 25);
        frame.add(floorField);

        // Room Field
        JLabel roomLabel = new JLabel("Room:");
        roomLabel.setBounds(10, 130, 80, 25);
        frame.add(roomLabel);

        roomField = new JTextField();
        roomField.setBounds(100, 130, 160, 25);
        frame.add(roomField);

        // Check Access Button
        JButton checkButton = new JButton("Check Access");
        checkButton.setBounds(100, 170, 160, 25);
        checkButton.addActionListener(e -> checkAccess());
        frame.add(checkButton);

        // Frame Setup
        frame.setSize(300, 250);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void checkAccess() {
        String cardId = cardIdField.getText();
        String floor = floorField.getText();
        String room = roomField.getText();
        AccessUtils.checkAccess(cardId, floor, room, mainInstance.getAccessCards());
    }

}

