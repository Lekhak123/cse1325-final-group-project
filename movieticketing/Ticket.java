package movieticketing;

public class Ticket {
    private Movie movie;
    private Seat seat;
    private User user;

    public Ticket(Movie movie, Seat seat, User user) {
        this.movie = movie;
        this.seat = seat;
        this.user = user;
    }

    public Movie get_movie() {
        return movie;
    }

    public Seat get_sear() {
        return seat;
    }

    public User get_user() {
        return user;
    }

    public void set_movie(Movie movie) {
        this.movie = movie;
    }

    public void set_seat(Seat seat) {
        this.seat = seat;
    }

    public void set_user(User user) {
        this.user = user;
    }
}