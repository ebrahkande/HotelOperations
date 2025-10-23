public class Room {

    private int numberOfBeds;
    private double getPrice;
    private boolean isOccupied;
    private boolean isDirty;

    // Constructor
    public Room(int numberOfBeds, double price, boolean isOccupied, boolean isDirty) {
        this.numberOfBeds = numberOfBeds;
        this.getPrice = getPrice;
        this.isOccupied = isOccupied;
        this.isDirty = isDirty;
    }

    // Getters and Setters
    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public double getGetPrice() {
        return getPrice;
    }

    public void setGetPrice(double getPrice) {
        this.getPrice = getPrice;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public boolean isDirty() {
        return isDirty;
    }

    public void setDirty(boolean dirty) {
        isDirty = dirty;
    }

    public boolean isAvailable() {
        // Available if NOT occupied AND NOT dirty
        return !isOccupied && !isDirty;
    }

    // Operational methods
    public boolean checkIn() {
        if(!this.isDirty() && !this.isOccupied()) {
            return true;
        }

        return false;
    }

    public void checkOut() {
        // the room is now free, but still needs to be cleaned
        this.isOccupied = false;
        System.out.println("Room checked out. Now free, but still dirty.");
    }

    public void cleanRoom() {
        // the room is no longer dirty, making it available for check-in
        this.isDirty = false;
        System.out.println("Room cleaned. Ready for the next guest.");
    }
}