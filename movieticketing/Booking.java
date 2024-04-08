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

    public void printBookingDetails() {
        System.out.println("Selected theater: " + (theater != null ? theater.getName() : "None"));
        System.out.println("Selected movie: " + (movie != null ? movie.getTitle() : "None"));
        System.out.println("Movie time: " + (movie != null ? movie.getTime() : "None"));  // Print the movie time
        System.out.println("Selected seat: " + (seat != null ? ("Row: " + seat.getRow() + ", Seat: " + seat.getNumber()) : "None"));
    }
}