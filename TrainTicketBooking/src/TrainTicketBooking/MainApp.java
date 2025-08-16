package TrainTicketBooking;

import java.io.FileNotFoundException;
import java.io.IOException;

public class MainApp {
	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException{
		BookingSystem bookingSystem=new BookingSystem(5);
		
		bookingSystem.loadTickets();
		Runnable r1 =()-> {
			try {
				bookingSystem.bookTicket("Aman");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		};
		Runnable r2 =()-> {
			try {
				bookingSystem.bookTicket("Deep");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		};
		Runnable r3 =()-> {
			try {
				bookingSystem.bookTicket("Ravi");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		};
		Runnable r4 =()-> {
			try {
				bookingSystem.bookTicket("Amar");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		};
		Runnable r5 =()-> {
			try {
				bookingSystem.bookTicket("Ram");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		};
		Runnable r6 =()-> {
			try {
				bookingSystem.bookTicket("Raj");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		};
		
		new Thread(r1).start();
		new Thread(r2).start();
		new Thread(r3).start();
		new Thread(r4).start();
		new Thread(r5).start();
		new Thread(r6).start();
		
		try {
			Thread.sleep(1000);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		bookingSystem.showAllBookings();
	}
}
