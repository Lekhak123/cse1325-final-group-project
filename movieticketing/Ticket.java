package movieticketing;

// No changes needed for the import statements
public class Ticket {
    private Movie movie;
    private Seat seat;
    private User user;

    // Constructor
    public Ticket(Movie movie, Seat seat, User user) {
        this.movie = movie;
        this.seat = seat;
        this.user = user;
    }

    // Getters
    public Movie getMovie() {
        return movie;
    }

    public Seat getSeat() {
        return seat;
    }

    public User getUser() {
        return user;
    }

    // Setters
    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public void setUser(User user) {
        this.user = user;
    }
}