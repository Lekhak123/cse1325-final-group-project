package movieticketing;
import movieticketing.Theater;
import movieticketing.User;
import movieticketing.Movie;
import movieticketing.Seat;
import movieticketing.Booking;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

@SuppressWarnings("unused")
public class Main {
    private ArrayList < Theater > theaters;
    private ArrayList < User > users;
    private Theater currentTheater;
    private Movie currentMovie;
    private ArrayList<Seat> seats;  // The list of seats in the theater
    private Seat currentSeat;  // The seat that the user has selected

    public Main() {
        theaters = new ArrayList <> ();
        users = new ArrayList <> ();
        loadInitialData();
    }
    private void loadInitialData() {
        try (Scanner scanner = new Scanner(new File("movieticketing/initial_data.txt"))) {
            Theater currentTheater = null;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.trim().isEmpty()) {
                    continue;  // Skip empty lines
                }
                if (!line.contains(",")) {
                    // This line is a theater name
                    currentTheater = new Theater(line);
                    theaters.add(currentTheater);
                } else {
                    String[] parts = line.split(",");
                    if (parts.length == 5) {
                        // This line is a movie
                        String title = parts[0];
                        String genre = parts[1];
                        int duration = Integer.parseInt(parts[2]);
                        double price = Double.parseDouble(parts[3]);
                        String time = parts[4];  // Get the time
                        Movie movie = new Movie(title, genre, duration, price, time);
                        currentTheater.addMovie(movie);  // Add the movie to the current theater
                    } else if (parts.length == 3) {
                        // This line is a seat
                        int row = Integer.parseInt(parts[0]);
                        int number = Integer.parseInt(parts[1]);
                        boolean booked = Boolean.parseBoolean(parts[2]);
                        currentTheater.addSeat(new Seat(row, number, booked));
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Initial data file not found.");
        }
    }

    public void run() {
        try(Scanner scanner = new Scanner(System. in)) {
            while (true) {
                System
                    .out
                    .println("1. Select a theater");
                System
                    .out
                    .println("2. Select a movie");
                System
                    .out
                    .println("3. Book a seat");
                System
                    .out
                    .println("4. Confirm booking");
                System
                    .out
                    .println("5. Exit");
                System
                    .out
                    .print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline left-over
                switch (choice) {
                    case 1:
                        // Display all theaters and let the user select one
                        for (int i = 0; i < theaters.size(); i++) {
                            System
                                .out
                                .println((i + 1) + ". " + theaters.get(i).getName());
                        }
                        System
                            .out
                            .print("Select a theater: ");
                        int theaterChoice = scanner.nextInt() - 1;
                        currentTheater = theaters.get(theaterChoice);
                        break;
                    case 2:
                        // Display all movies in the selected theater and let the user select one
                        if (currentTheater == null) {
                            System
                                .out
                                .println("Please select a theater first.");
                            break;
                        }
                        for (int i = 0; i < currentTheater.getMovies().size(); i++) {
                            System
                                .out
                                .println((i + 1) + ". " + currentTheater.getMovies().get(i).getTitle());
                        }
                        // Select a movie...
                        int movieNumber = 0;
                        while (true) {
                            System.out.print("Select a movie: ");
                            if (scanner.hasNextInt()) {
                                movieNumber = scanner.nextInt();
                                if (movieNumber >= 1 && movieNumber <= currentTheater.getMovies().size()) {
                                    break;
                                } else {
                                    System.out.println("Invalid input. Please enter a number between 1 and " + currentTheater.getMovies().size() + ".");
                                }
                            } else {
                                System.out.println("Invalid input. Please enter an integer.");
                                scanner.next();  // Discard the invalid input
                            }
                        }
                        currentMovie = currentTheater.getMovies().get(movieNumber - 1);
                        break;
                    case 3:
                     // Book a seat
                        if (currentTheater == null) {
                            System.out.println("Please select a theater first.");
                            break;
                        }
                        // Book a seat...
                        System.out.println("Available seats:");
                        currentTheater.printAvailableSeats();
                        int rowNumber = 0;
                        int seatNumber = 0;
                        while (true) {
                            try {
                                System.out.print("Enter row number: ");
                                rowNumber = scanner.nextInt();
                                System.out.print("Enter seat number: ");
                                seatNumber = scanner.nextInt();
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input. Please enter an integer.");
                                scanner.next();  // Discard the invalid input
                            }
                        }
                        if (currentTheater.bookSeat(rowNumber, seatNumber)) {
                            System.out.println("Seat booked successfully.");
                            currentSeat = new Seat(rowNumber, seatNumber, true);  // Set the current seat to the seat that the user has booked
                        } else {
                            System.out.println("Seat is already booked or does not exist.");
                        }
                        break;
                    case 4:
                        // View selected options
                        if (currentTheater == null || currentMovie == null || currentSeat == null) {
                            System.out.println("Please complete all selections (theater, movie, seat) before viewing options.");
                            Booking booking = new Booking(currentTheater, currentMovie, currentSeat);
                            booking.printBookingDetails();
                        } else {
                            Booking booking = new Booking(currentTheater, currentMovie, currentSeat);
                            System.out.println("\nBooking details: \n");
                            booking.printBookingDetails();
                            return;
                        }
                        break;
                    case 5:
                        System
                            .out
                            .println("Thank you for using our system!");
                        return;
                    default:
                        System
                            .out
                            .println("Invalid choice. Please try again.");
                }
            }
        }
    }

    public static void main(String[]args) {
        Main main = new Main();
        main.run();
    }
}