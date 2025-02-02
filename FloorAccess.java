class FloorAccess extends AccessControl {
    @Override
    public boolean checkAccess(String floor, String room) {
        // Check if the floor is in the accessible list
        if (getAccessCard().getAccessibleFloors().contains(floor)) {
            logAccessAttempt(floor, room, true);
            return true;
        }
        logAccessAttempt(floor, room, false);
        return false;
    }
}

class RoomAccess extends AccessControl {
    @Override
    public boolean checkAccess(String floor, String room) {
        // Check if the room is in the accessible list
        if (getAccessCard().getAccessibleRooms().contains(room)) {
            logAccessAttempt(floor, room, true);
            return true;
        }
        logAccessAttempt(floor, room, false);
        return false;
    }
}
