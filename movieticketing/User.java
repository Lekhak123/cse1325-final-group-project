package movieticketing;


import java.util.ArrayList;
public class User {
    private String name;
    private ArrayList<Ticket> tickets;

    // Constructor
    public User(String name) {
        this.name = name;
        this.tickets = new ArrayList<>();
    }

    // Getters
    public String getName() {
        return name;
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }
    public void bookTicket(Ticket ticket) {
        tickets.add(ticket);
    }
}