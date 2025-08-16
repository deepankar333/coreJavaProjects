package TrainTicketBooking;

import java.io.Serializable;

public class Ticket implements Serializable {
	private static final long serialVersionUID = 1L;
	private int seatNumber;
	private String passengerName;

	public Ticket() {
	}

	public Ticket(int seatNumber, String passengerName) {
		super();
		this.seatNumber = seatNumber;
		this.passengerName = passengerName;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public String getPassengerName() {
		return passengerName;
	}

	@Override
	public String toString() {
		return "Ticket [Seat Number=" + seatNumber + ", Booked by =" + passengerName + "]";
	}
}
