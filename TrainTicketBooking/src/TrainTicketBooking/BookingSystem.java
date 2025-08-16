package TrainTicketBooking;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class BookingSystem {
	private boolean[] seats;
	private List<Ticket> bookedTickets;

	public BookingSystem(int totalSeats) {
		seats = new boolean[totalSeats];
		bookedTickets = new ArrayList<Ticket>();
	}

	public synchronized boolean bookTicket(String passengerName) throws FileNotFoundException, IOException {
		int freeSeatIndex = IntStream.range(0, seats.length).filter(i -> !seats[i]).findFirst().orElse(-1);
		if (freeSeatIndex == -1) {
			System.out.println("No Seats Left for : " + passengerName);
			return false;
		}
		seats[freeSeatIndex] = true;
		Ticket ticket = new Ticket(freeSeatIndex + 1, passengerName);
		bookedTickets.add(ticket);
		System.out.println(ticket);
		saveTickets();
		return true;
	}

	private void saveTickets() throws FileNotFoundException, IOException {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("tickets.ser"))) {
			oos.writeObject(bookedTickets);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void loadTickets() throws FileNotFoundException, IOException, ClassNotFoundException {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("tickets.ser"))) {
			bookedTickets = (List<Ticket>) ois.readObject();
			bookedTickets.forEach(t -> seats[t.getSeatNumber() - 1] = true);
		} catch (FileNotFoundException e) {

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void showAllBookings() {
		bookedTickets.stream().forEach(System.out::println);
	}
}
