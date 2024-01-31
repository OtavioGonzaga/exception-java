package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
	private int roomNumber;
	private Date checkinDate;
	private Date checkoutDate;

	public Reservation() {}

	public Reservation(int roomNumber, Date checkinDate, Date checkoutDate) {
		this.roomNumber = roomNumber;
		this.checkinDate = checkinDate;
		this.checkoutDate = checkoutDate;
	}

	public long duration() {
		return TimeUnit.DAYS.convert(checkoutDate.getTime() - checkinDate.getTime(), TimeUnit.MILLISECONDS);
	}

	public void updateDates(Date checkin, Date checkout) {
		this.checkinDate = checkin;
		this.checkoutDate = checkout;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("Reservation: Room: ").append(roomNumber);
		sb.append(", Check-in: ").append(DATE_FORMAT.format(checkinDate));
		sb.append(", Checkout: ").append(DATE_FORMAT.format(checkoutDate));
		sb.append(", ").append(duration()).append(" nights.");

		return sb.toString();
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckinDate() {
		return checkinDate;
	}

	public Date getCheckoutDate() {
		return checkoutDate;
	}
}
