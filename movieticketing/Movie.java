package movieticketing;

public class Movie {
    private String title;
    private String genre;
    private int duration;
    private double price;
    private String time;

    public Movie(String title, String genre, int duration, double price, String time) {
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.price = price;
        this.time = time;
    }
    public String get_time() {
        return time;
    }

    public void set_time(String time) {
        this.time = time;
    }

    public String get_title() {
        return title;
    }

    public String get_genre() {
        return genre;
    }

    public int get_duration() {
        return duration;
    }

    public double get_price() {
        return price;
    }

    public void set_title(String title) {
        this.title = title;
    }

    public void set_genre(String genre) {
        this.genre = genre;
    }

    public void set_duration(int duration) {
        this.duration = duration;
    }

    public void set_price(double price) {
        this.price = price;
    }
}