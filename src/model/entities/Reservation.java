package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {
	public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
	private int roomNumber;
	private Date checkinDate;
	private Date checkoutDate;

	public Reservation() {}

	public Reservation(int roomNumber, Date checkinDate, Date checkoutDate) {
		if (!checkoutDate.after(checkinDate)) throw new DomainException("Error in reservation: The check-out date must be after the check-in date");
		if (checkinDate.before(new Date())) throw new DomainException("Error in reservation: The check-in date must be a future date");
		this.roomNumber = roomNumber;
		this.checkinDate = checkinDate;
		this.checkoutDate = checkoutDate;
	}

	public long duration() {
		return TimeUnit.DAYS.convert(checkoutDate.getTime() - checkinDate.getTime(), TimeUnit.MILLISECONDS);
	}

	public void updateDates(Date checkinDate, Date checkoutDate) {
		if (!checkoutDate.after(checkinDate)) throw new DomainException("Error in reservation: The check-out date must be after the check-in date");
		if (checkinDate.before(new Date())) throw new DomainException("Error in reservation: The check-in date must be a future date");
		if (checkinDate.before(this.checkinDate)) throw new DomainException("Error in reservation: The new check-in date must be after or equal the old check-in date");
		this.checkinDate = checkinDate;
		this.checkoutDate = checkoutDate;
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
