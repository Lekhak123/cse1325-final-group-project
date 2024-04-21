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
    private Theater current_theater;
    private Movie currentMovie;
    // The list of seats in the theater
    private ArrayList<Seat> seats;
    // The seat that the user has selected
    private Seat currentSeat;

    public Main() {
        theaters = new ArrayList <> ();
        users = new ArrayList <> ();
        load_initial_data();
    }
    private void load_initial_data() {
        try (Scanner scanner = new Scanner(new File("movieticketing/initial_data.txt"))) {
            Theater current_theater = null;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.trim().isEmpty()) {
                    // Skip empty lines
                    continue;
                }
                if (!line.contains(",")) {
                    // This line is a theater name. Note: we are using the token "," to differentiate between a theater, seat, and a movie
                    current_theater = new Theater(line);
                    theaters.add(current_theater);
                } else {
                    String[] parts = line.split(",");
                    if (parts.length == 5) {
                        // This line is a movie
                        String title = parts[0];
                        String genre = parts[1];
                        int duration = Integer.parseInt(parts[2]);
                        double price = Double.parseDouble(parts[3]);
                        String time = parts[4];
                        Movie movie = new Movie(title, genre, duration, price, time);
                        current_theater.add_movie(movie);
                    } else if (parts.length == 3) {
                        // This line is a seat
                        int row = Integer.parseInt(parts[0]);
                        int number = Integer.parseInt(parts[1]);
                        boolean booked = Boolean.parseBoolean(parts[2]);
                        current_theater.add_seat(new Seat(row, number, booked));
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
                    .println("1. Select a theater:");
                System
                    .out
                    .println("2. Select a movie:");
                System
                    .out
                    .println("3. Book a seat:");
                System
                    .out
                    .println("4. Confirm booking:");
                System
                    .out
                    .println("5. Exit:");
                System
                    .out
                    .print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        // Display all theaters and let the user select one of them
                        for (int i = 0; i < theaters.size(); i++) {
                            System.out.println((i + 1) + ". " + theaters.get(i).get_name());
                        }
                        int theater_choice = -1;
                        while (theater_choice < 0 || theater_choice >= theaters.size()) {
                            System.out.print("Select a theater: ");
                            theater_choice = scanner.nextInt() - 1;
                            if (theater_choice < 0 || theater_choice >= theaters.size()) {
                                System.out.println("Invalid choice. Please select a valid theater.");
                            }
                        }
                        current_theater = theaters.get(theater_choice);
                        break;
                    case 2:
                        // Display all movies in the selected theater and let the user select one of them
                        if (current_theater == null) {
                            System
                                .out
                                .println("Please select a theater first!");
                            break;
                        }
                        for (int i = 0; i < current_theater.get_movies().size(); i++) {
                            System
                                .out
                                .println((i + 1) + ". " + current_theater.get_movies().get(i).get_title());
                        }
                        int movieNumber = 0;
                        while (true) {
                            System.out.print("Select a movie: ");
                            if (scanner.hasNextInt()) {
                                movieNumber = scanner.nextInt();
                                if (movieNumber >= 1 && movieNumber <= current_theater.get_movies().size()) {
                                    break;
                                } else {
                                    System.out.println("Invalid input! Please enter a number between 1 and " + current_theater.get_movies().size() + ".");
                                }
                            } else {
                                System.out.println("Invalid input! Please enter an integer.");
                                scanner.next();
                            }
                        }
                        currentMovie = current_theater.get_movies().get(movieNumber - 1);
                        break;
                    case 3:
                        // Book a seat
                        if (current_theater == null) {
                            System.out.println("Please select a theater first!");
                            break;
                        }
                        System.out.println("Available seats:");
                        current_theater.print_available_seats();
                        int rowNumber = 0;
                        int seatNumber = 0;
                        while (true) {
                            try {
                                System.out.print("Enter row number: ");
                                rowNumber = scanner.nextInt();
                                System.out.print("Enter seat number: ");
                                seatNumber = scanner.nextInt();

                                if (current_theater.seat_exists(rowNumber, seatNumber)) {
                                    break;
                                } else {
                                    System.out.println("Seat does not exist! Please enter a valid row and seat number.");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input! Please enter an integer.");
                                scanner.next();
                            }
                        }
                        if (current_theater.book_seat(rowNumber, seatNumber)) {
                            System.out.println("Seat booked successfully.");
                            // Set the current seat to the seat that the user has booked
                            currentSeat = new Seat(rowNumber, seatNumber, true);
                        } else {
                            System.out.println("Seat is already booked or does not exist!");
                        }
                        break;
                    case 4:
                        // View selected options
                        if (current_theater == null || currentMovie == null || currentSeat == null) {
                            System.out.println("Please complete all selections (theater, movie, seat) before viewing options.");
                            Booking booking = new Booking(current_theater, currentMovie, currentSeat);
                            booking.print_booking_details();
                        } else {
                            Booking booking = new Booking(current_theater, currentMovie, currentSeat);
                            System.out.println("\nBooking details: \n");
                            booking.print_booking_details();
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
                            .println("Invalid choice! Please try again.");
                }
            }
        }
    }

    public static void main(String[]args) {
        Main main = new Main();
        main.run();
    }
}