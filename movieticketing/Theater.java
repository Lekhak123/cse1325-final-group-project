package movieticketing;


import java.util.ArrayList;
public class Theater {
    private String name;
    private ArrayList < Seat > seats;
    private ArrayList < Movie > movies;

    // Constructor
    public Theater(String name) {
        this.name = name;
        this.seats = new ArrayList <> ();
        this.movies = new ArrayList <> ();
    }
    public void addMovie(Movie movie) {
        movies.add(movie);
    }
    public void addSeat(Seat seat) {
        seats.add(seat);
    }
    public boolean bookSeat(int rowNumber, int seatNumber) {
        for (Seat seat : seats) {
            if (seat.getRow() == rowNumber && seat.getNumber() == seatNumber && !seat.isBooked()) {
                seat.setBooked(true);
                return true;
            }
        }
        return false;
    }
    public void printAvailableSeats() {
        for (Seat seat : seats) {
            if (!seat.isBooked()) {
                System.out.println("Row: " + seat.getRow() + ", Seat: " + seat.getNumber());
            }
        }
    }
    // Getters
    public String getName() {
        return name;
    }

    public ArrayList < Seat > getSeats() {
        return seats;
    }

    public ArrayList < Movie > getMovies() {
        return movies;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setSeats(ArrayList < Seat > seats) {
        this.seats = seats;
    }

    public void setMovies(ArrayList < Movie > movies) {
        this.movies = movies;
    }
}