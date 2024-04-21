package movieticketing;
import java.util.ArrayList;

public class Theater {
    private String name;
    private ArrayList < Seat > seats;
    private ArrayList < Movie > movies;

    public Theater(String name) {
        this.name = name;
        this.seats = new ArrayList <> ();
        this.movies = new ArrayList <> ();
    }
    public void add_movie(Movie movie) {
        movies.add(movie);
    }
    public void add_seat(Seat seat) {
        for (Seat existingSeat : seats) {
            if (existingSeat.get_row() == seat.get_row() && existingSeat.get_number() == seat.get_number()) {
                // This seat already exists, so we don't add it again
                return;
            }
        }
        seats.add(seat);
    }
    public boolean book_seat(int rowNumber, int seatNumber) {
        for (Seat seat : seats) {
            if (seat.get_row() == rowNumber && seat.get_number() == seatNumber && !seat.isBooked()) {
                seat.set_booked(true);
                return true;
            }
        }
        return false;
    }
    public void print_available_seats() {
        for (Seat seat : seats) {
            if (!seat.isBooked()) {
                System.out.println("Row: " + seat.get_row() + ", Seat: " + seat.get_number());
            }
        }
    }
    public String get_name() {
        return name;
    }
    public boolean seat_exists(int rowNumber, int seatNumber) {
        for (Seat seat : seats) {
            if (seat.get_row() == rowNumber && seat.get_number() == seatNumber) {
                return true;
            }
        }
        return false;
    }

    public ArrayList < Seat > get_sears() {
        return seats;
    }

    public ArrayList < Movie > get_movies() {
        return movies;
    }

    public void set_name(String name) {
        this.name = name;
    }

    public void set_seats(ArrayList < Seat > seats) {
        this.seats = seats;
    }

    public void set_movies(ArrayList < Movie > movies) {
        this.movies = movies;
    }
}