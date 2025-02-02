import java.util.List;

class AccessCard {
    private String cardId;
    private List<String> accessibleFloors;
    private List<String> accessibleRooms;

    // Constructor
    public AccessCard(String cardId, List<String> accessibleFloors, List<String> accessibleRooms) {
        this.cardId = cardId;
        this.accessibleFloors = accessibleFloors;
        this.accessibleRooms = accessibleRooms;
    }

    // Getters
    public String getCardId() {
        return cardId;
    }

    public List<String> getAccessibleFloors() {
        return accessibleFloors;
    }

    public List<String> getAccessibleRooms() {
        return accessibleRooms;
    }

    // Setters (if needed)
    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public void setAccessibleFloors(List<String> accessibleFloors) {
        this.accessibleFloors = accessibleFloors;
    }

    public void setAccessibleRooms(List<String> accessibleRooms) {
        this.accessibleRooms = accessibleRooms;
    }
}
