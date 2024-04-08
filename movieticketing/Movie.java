package movieticketing;

public class Movie {
    private String title;
    private String genre;
    private int duration;
    private double price;
    private String time; // The time the movie is showing

    // Constructor
    public Movie(String title, String genre, int duration, double price, String time) {
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.price = price;
        this.time = time; // Set the time
    }
    // Getter
    public String getTime() {
        return time;
    }

    // Setter
    public void setTime(String time) {
        this.time = time;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getDuration() {
        return duration;
    }

    public double getPrice() {
        return price;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}