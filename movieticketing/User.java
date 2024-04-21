package movieticketing;
import java.util.ArrayList;

public class User {
    private String name;
    private ArrayList<Ticket> tickets;

    public User(String name) {
        this.name = name;
        this.tickets = new ArrayList<>();
    }

    public String get_name() {
        return name;
    }

    public ArrayList<Ticket> get_tickets() {
        return tickets;
    }

    public void set_name(String name) {
        this.name = name;
    }

    public void set_tickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }
    public void book_ticket(Ticket ticket) {
        tickets.add(ticket);
    }
}