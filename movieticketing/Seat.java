package movieticketing;

public class Seat {
    private int row;
    private int number;
    private boolean isBooked;

    // Constructor
    public Seat(int number, int row, boolean booked) {
        this.number = number;
        this.row = row;
        this.isBooked = booked;
    }
    // Getters
    public int getRow() {
        return row;
    }

    public int getNumber() {
        return number;
    }

    public boolean isBooked() {
        return isBooked;
    }

    // Setters
    public void setRow(int row) {
        this.row = row;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setBooked(boolean isBooked) {
        this.isBooked = isBooked;
    }
}