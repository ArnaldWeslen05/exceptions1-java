package model.entites;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Resevation {

	private Integer roomNuber;
	private Date checkIn;
	private Date checkOut;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Resevation() {

	}

	public Resevation(Integer roomNuber, Date checkIn, Date checkOut) {
		this.roomNuber = roomNuber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNuber() {
		return roomNuber;
	}

	public void setRoomNuber(Integer roomNuber) {
		this.roomNuber = roomNuber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public String updateDate(Date checkIn, Date checkOut) {
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			return "Resevation dates for updates must be future dates.";
		}
		if (checkOut.after(checkIn)) {
			return "Erro in  Resevation : Check-out date must be after check-in date";
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null;
	}

	@Override
	public String toString() {
		return "Room : " + roomNuber + " , chaeck-in: " + sdf.format(checkIn) + ", check-out: " + sdf.format(checkOut)
				+ " , " + duration() + " nights";
	}

}
