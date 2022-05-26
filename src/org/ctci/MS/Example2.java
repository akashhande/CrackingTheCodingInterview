package org.ctci.MS;

import static java.time.temporal.ChronoUnit.MINUTES;
import static org.junit.Assert.assertEquals;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import org.junit.Test;

public class Example2 {

	public int solution(String S) {
		int sleepTime = 0;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");

		String[] days = S.split("\\R");
		ArrayList<DailySchedule> dailySchedule = new ArrayList<DailySchedule>();
		LocalTime dayStartTime = LocalTime.parse("00:00");
		LocalTime dayEndTime = LocalTime.parse("23:59", dtf);

		for (int i = 0; i < days.length; i++) {
			String day = days[i].split("\\s+")[0];
			String timeFrame = days[i].split("\\s+")[1];
			String timeSlot1 = timeFrame.split("-")[0];
			String timeSlot2 = timeFrame.split("-")[1];
			LocalTime localTimeFrom = LocalTime.parse(timeSlot1);
			LocalTime localTimeTo;
			if(!isEndOfDay(timeSlot2))
				localTimeTo = LocalTime.parse(timeSlot2);
			else
				localTimeTo = dayEndTime;

			DailySchedule temp = new DailySchedule(day, localTimeFrom, localTimeTo);
			dailySchedule.add(temp);
		}

		for (int i = 0; i < dailySchedule.size(); i++) {
			DailySchedule day = dailySchedule.get(i);
			long diffMorning = dayStartTime.until(day.getLocalTimeFrom(), MINUTES);
			long diffEvening = day.getLocalTimeTo().until(dayEndTime, MINUTES);
			long maxTimeSlot = Math.max(diffMorning, diffEvening+1);
			if (sleepTime < maxTimeSlot)
				sleepTime = (int) maxTimeSlot;
		}

		return sleepTime;
	}
	
	public boolean isEndOfDay(String timeSlot) {
		boolean result = false;
		if(timeSlot.equals("24:00"))
			result = true;
		
		return result;
	}

	public class DailySchedule {
		String day;
		LocalTime localTimeFrom;
		LocalTime localTimeTo;

		public DailySchedule(String day, LocalTime localTimeFrom, LocalTime localTimeTo) {
			this.day = day;
			this.localTimeFrom = localTimeFrom;
			this.localTimeTo = localTimeTo;
		}

		public String getDay() {
			return day;
		}

		public void setDay(String day) {
			this.day = day;
		}

		public LocalTime getLocalTimeFrom() {
			return localTimeFrom;
		}

		public void setLocalTimeFrom(LocalTime localTimeFrom) {
			this.localTimeFrom = localTimeFrom;
		}

		public LocalTime getLocalTimeTo() {
			return localTimeTo;
		}

		public void setLocalTimeTo(LocalTime localTimeTo) {
			this.localTimeTo = localTimeTo;
		}

	}

	@Test
	public void test() {
		String meetings = "Mon 01:00-23:00\n" + "Tue 01:00-23:00\n" + "Wed 01:00-23:00\n" + "Thu 01:00-23:00\n"
				+ "Fri 01:00-23:00\n" + "Sat 01:00-23:00\n" + "Sun 01:00-21:00\n";
		
		
		String meetings2 = "Sun 10:00-20:00\nFri 05:00-10:00\nFri 16:30-23:50\nSat 10:00-24:00\nSun 01:00-04:00\n"
				+ "Sat 02:00-06:00\nTue 03:30-18:15\nTue 19:00-20:00\nWed 04:25-15:14\nWed 15:14-22:40\nThu 00:00-23:59\n"
				+ "Mon 05:00-13:00\nMon 15:00-21:00";

		assertEquals(180, solution(meetings));
		//assertEquals(179, solution(meetings2));
	}
}
