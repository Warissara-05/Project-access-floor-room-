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
            new AccessCard("Card1-JohnDoe", Arrays.asList("Low Floor", "Medium Floor"), Arrays.asList("Room 101", "Room 102")),
            new AccessCard("Card2-Alice123", Arrays.asList("Medium Floor"), Arrays.asList("Meeting Room", "Room 201")),
            new AccessCard("Card3-BobXYZ", Arrays.asList("High Floor"), Arrays.asList("Room 301", "Room 302"))
    };

    public Main() {
        frame = new JFrame("Access Control System");

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

        // If card is found, check the access
        if (selectedCard != null) {
            AccessControl accessControl = new FloorAccess();  // Example: Check access to floor
            accessControl.setAccessCard(selectedCard);
            boolean accessGranted = accessControl.checkAccess(floor, room);

            String result = "Access " + (accessGranted ? "Granted" : "Denied");
            String dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

            JOptionPane.showMessageDialog(frame, "Date and Time: " + dateTime + "\n" + result);
        } else {
            JOptionPane.showMessageDialog(frame, "Card ID not found!");
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}
