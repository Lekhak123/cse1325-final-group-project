package movieticketing;

public class Seat {
    private int row;
    private int number;
    private boolean isBooked;

    public Seat(int row, int number, boolean booked) {
        this.number = number;
        this.row = row;
        this.isBooked = booked;
    }
    public int get_row() {
        return row;
    }

    public int get_number() {
        return number;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void set_row(int row) {
        this.row = row;
    }

    public void set_number(int number) {
        this.number = number;
    }

    public void set_booked(boolean isBooked) {
        this.isBooked = isBooked;
    }
}