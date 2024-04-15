package movieticketing;

public class Booking {
    private Theater theater;
    private Movie movie;
    private Seat seat;

    public Booking(Theater theater, Movie movie, Seat seat) {
        this.theater = theater;
        this.movie = movie;
        this.seat = seat;
    }

    public void print_booking_details() {
        System.out.println("Selected theater: " + (theater != null ? theater.get_name() : "None"));
        System.out.println("Selected movie: " + (movie != null ? movie.get_title() : "None"));
        System.out.println("Movie time: " + (movie != null ? movie.get_time() : "None"));  // Print the movie time
        System.out.println("Selected seat: " + (seat != null ? ("Row: " + seat.get_row() + ", Seat: " + seat.get_number()) : "None"));
    }
}