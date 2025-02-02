import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Main {
    private JFrame frame;
    private JTextField cardIdField;
    private JTextField floorField;
    private JTextField roomField;

    // Create some sample access cards with unique cardIds
    private AccessCard[] accessCards = {
            new AccessCard("MG001", Arrays.asList("Low", "Medium", "High"), Arrays.asList("Room101", "Room102", "Room201", "Room202", "Room301", "Room302")),  // Manager card
            new AccessCard("EP001", Arrays.asList("Low", "Medium"), Arrays.asList("Room101", "Room102", "Room201", "Room202")),  // Employee card
            new AccessCard("VS001", Arrays.asList("Low"), Arrays.asList("Meeting Room" , "Room101"))  // Visitor card
    };

    public Main() {
        JFrame frame = new JFrame("Login with");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JLabel titleLabel = new JLabel("Login with:", SwingConstants.CENTER);
        titleLabel.setBounds(100, 5, 100, 20);
        frame.add(titleLabel);

        // Create buttons for Manager, Employee, Visitors
        JButton managerButton = new JButton("Manager");
        JButton employeeButton = new JButton("Employee");
        JButton visitorsButton = new JButton("Visitors");

        // Set positions and sizes of buttons
        managerButton.setBounds(100, 30, 100, 30);
        employeeButton.setBounds(100, 70, 100, 30);
        visitorsButton.setBounds(100, 110, 100, 30);

        // Add ActionListener for each button
        managerButton.addActionListener(e -> openAccessWindow("Manager"));
        employeeButton.addActionListener(e -> openAccessWindow("Employee"));
        visitorsButton.addActionListener(e -> openAccessWindow("Visitors"));

        // Add buttons to the frame
        frame.setLayout(null);
        frame.add(managerButton);
        frame.add(employeeButton);
        frame.add(visitorsButton);

        // Display the frame
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void openAccessWindow(String role) {
        frame = new JFrame("Access Control System");

        JLabel roleLabel = new JLabel("Role: " + role);
        roleLabel.setBounds(20, 20, 200, 20);

        JLabel cardIdLabel = new JLabel("Card ID:");
        cardIdLabel.setBounds(10, 10, 80, 25);
        frame.add(cardIdLabel);

        cardIdField = new JTextField();
        cardIdField.setBounds(100, 10, 160, 25);
        frame.add(cardIdField);

        JLabel floorLabel = new JLabel("Floor:");
        floorLabel.setBounds(10, 50, 80, 25);
        frame.add(floorLabel);

        floorField = new JTextField();
        floorField.setBounds(100, 50, 160, 25);
        frame.add(floorField);

        JLabel roomLabel = new JLabel("Room:");
        roomLabel.setBounds(10, 90, 80, 25);
        frame.add(roomLabel);

        roomField = new JTextField();
        roomField.setBounds(100, 90, 160, 25);
        frame.add(roomField);

        JButton checkButton = new JButton("Check Access");
        checkButton.setBounds(100, 130, 160, 25);
        checkButton.addActionListener(e -> checkAccess());
        frame.add(checkButton);

        frame.setSize(300, 200);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void checkAccess() {
        String cardId = cardIdField.getText();
        String floor = floorField.getText();
        String room = roomField.getText();

        // Find the card with the provided cardId
        AccessCard selectedCard = null;
        for (AccessCard card : accessCards) {
            if (card.getCardId().equals(cardId)) {
                selectedCard = card;
                break;
            }
        }

        if (selectedCard != null) {
            AccessControl accessControl = new FloorAccess();  // Example: Check access to floor
            accessControl.setAccessCard(selectedCard);
            boolean accessGranted = accessControl.checkAccess(floor, room);

            String result = "Access " + (accessGranted ? "Granted" : "Denied");
            String dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

            JOptionPane.showMessageDialog(frame, "Date and Time: " + dateTime + "\n" + result);
        } else {
            JOptionPane.showMessageDialog(frame, "Card ID not found.!");
        }
    }

    public static void main(String[] args) {
        new Main();
    }

}
