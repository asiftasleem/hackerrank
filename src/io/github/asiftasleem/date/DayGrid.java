package io.github.asiftasleem.date;


import java.util.Calendar;
import java.util.GregorianCalendar;

public class DayGrid {

	public static void main(String[] args) {
		int month = 2;
		int year = 2017;
		showGrid(year, month);
	}

	private static void showGrid(int year, int month) {
		if (!(month >= 1 && month <= 12)) {
			System.out.println("Month value should be from 1 to 12");
			return;
		}

		if (!(year >= 1900 && year <= 2100)) {
			System.out.println("Year value should be from 1900 to 2100");
			return;
		}

		GregorianCalendar cal = new GregorianCalendar(year, month - 1, 1);
		//first day of the month
		int firstDay = cal.get(Calendar.DAY_OF_WEEK);
		//Total number of days in the given month
		int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		//find how many row to print
		int numberOfRows = (int) Math.ceil(((firstDay - 1) + daysInMonth) / 7.0);
		
		// print header
		System.out.print(String.format("%5s   ", "Sun"));
		System.out.print(String.format("%5s   ", "Mon"));
		System.out.print(String.format("%5s   ", "Tue"));
		System.out.print(String.format("%5s   ", "Wed"));
		System.out.print(String.format("%5s   ", "Thu"));
		System.out.print(String.format("%5s   ", "Fri"));
		System.out.print(String.format("%5s   ", "Sat"));
		
		//start new line
		System.out.println();
		
		//print upper boarder
		System.out.print("+");
		for (int i = 1; i <= 7; i++)
			System.out.print("-------+");

		int days = 1;
		for (int j = 1; j <= numberOfRows; j++) {
			//Take output to the next line
			System.out.println();

			if (j == 1) {// if it is the first row of the grid
				// print starting padded cells
				System.out.print("|");
				int k = 1;
				while (k < firstDay) {
					System.out.print("       |");
					k++;
				}
				for (int l = k; l <= 7; l++) {
					System.out.print(String.format("%5d  |", days));
					days++;
				}
			} else if (j == numberOfRows) { /// if it is the last row of the grid
				System.out.print("|");
				int l = 1;
				while (l <= 7 && days <= daysInMonth) {
					System.out.print(String.format("%5d  |", days));
					days++;
					l++;
				}
				//print ending padded cells
				int m = l-1;
				while (m < 7) {
					System.out.print("       |");
					m++;
				}

			} else { //for rest of the rows
				System.out.print("|");
				for (int l = 1; l <= 7; l++) {
					if (days <= daysInMonth) {
						System.out.print(String.format("%5d  |", days));
						days++;
					}
				}
			}

		}
		//start a new line
		System.out.println();
		
		//print lower boarder
		System.out.print("+");
		for (int i = 1; i <= 7; i++)
			System.out.print("-------+");

	}

}
