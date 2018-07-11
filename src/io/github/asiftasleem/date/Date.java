package io.github.asiftasleem.date;
/**
 * Date and basic methods on Date without suing Java Util class
 * @author mtasleem
 *
 */
public class Date {
	private int day;
	private int month;
	private int year;

	public Date(int year, int month, int day) throws IllegalArgumentException {
		if (month < 1 || month > 12) {
			throw new IllegalArgumentException("Invalid Month Value");
		}
		if (day < 1 || day > numberOfDaysInMonth(year, month)) {
			throw new IllegalArgumentException("Invalid Day Value");
		}

		if (year > 9999) {
			throw new IllegalArgumentException("Invalid Year Value");
		}
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public Date() {
		this.day = 01;
		this.month = 01;
		this.year = 1970;
	}

	public static int daysTo(Date one, Date two) {
		return one.daysTo(two);
	}

	public String longDate() {
		int a = Integer.parseInt("1011011", 2);
		int b = Integer.parseInt("01010001", 2);
		if (this.month == 01 || this.month == 1) {
			return "January " + this.day + ", " + this.year;
		} else if (this.month == 02 || this.month == 2) {
			return "February " + this.day + ", " + this.year;
		} else if (this.month == 03 || this.month == 3) {
			return "March " + this.day + ", " + this.year;
		} else if (this.month == 04 || this.month == 4) {
			return "April " + this.day + ", " + this.year;
		} else if (this.month == 035 || this.month == 5) {
			return "May " + this.day + ", " + this.year;
		} else if (this.month == 06 || this.month == 6) {
			return "June " + this.day + ", " + this.year;
		} else if (this.month == 07 || this.month == 7) {
			return "July " + this.day + ", " + this.year;
		} else if (this.month == b || this.month == 8) {
			return "August " + this.day + ", " + this.year;
		} else if (this.month == a || this.month == 9) {
			return "September " + this.day + ", " + this.year;
		} else if (this.month == 10) {
			return "October " + this.day + ", " + this.year;
		} else if (this.month == 11) {
			return "November " + this.day + ", " + this.year;
		} else if (this.month == 11) {
			return "December " + this.day + ", " + this.year;
		} else {
			throw new IllegalArgumentException("Invalid date");
		}
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		if (day < 1 || day > numberOfDaysInMonth(this.year, this.month)) {
			throw new IllegalArgumentException("Invalid day value");
		}
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		if (month < 1 || month > 12) {
			throw new IllegalArgumentException("Invalid month value");
		}
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		if (year > 9999) {
			throw new IllegalArgumentException("Invalid year value");
		}
		this.year = year;
	}

	public boolean isLeapYear() {
		return isLeapYear(this.year);

	}

	public boolean isLeapYear(int year) {
		if (year % 400 == 0) {
			return true;
		} else if (year % 100 == 0) {
			return false;
		} else if (year % 4 == 0) {
			return true;
		} else {
			return false;
		}
	}

	public void addDays(int days) {
		int numberOfDays = 30;
		if (days > 0) {
			while (days > 0) {
				this.day++;
				numberOfDays = numberOfDaysInMonth(this.year, this.month);
				if (this.day / numberOfDays == 1 && this.day % numberOfDays == 1) {
					this.day = 1;
					this.month++;

					if (this.month == 13) {
						this.month = 1;
						this.year++;
					}
				}
				days--;
			}
		} else {
			while (days < 0) {
				this.day--;
				numberOfDays = numberOfDaysInMonth(this.year, this.month);
				if (this.day == 0) {
					this.month--;
					if (this.month == 0) {
						this.month = 12;
						this.year--;
					} else {
						this.day = numberOfDaysInMonth(this.year, this.month);
					}
				}
				days++;
			}

		}
	}

	public void addWeeks(int weeks) {
		this.addDays(7 * weeks);
	}

	public int daysTo(Date other) {

		Date start = null;
		Date end = null;
		int multiplier = 1;

		// first find smaller date to start with
		if (this.year < other.year) {
			start = this;
			end = other;
		} else if (this.year > other.year) {
			start = other;
			end = this;
			multiplier = -1;
		} else if (this.year == other.year) {
			if (this.month < other.month) {
				start = this;
				end = other;
			} else if (this.month > other.month) {
				start = other;
				end = this;
				multiplier = -1;
			} else if (this.month == other.month) {
				if (this.day < other.day) {
					start = this;
					end = other;
				} else if (this.day > other.day) {
					start = other;
					end = this;
					multiplier = -1;
				} else if (this.day == other.day) {
					return 0; //which means both dates are actually equal
				}
			}
		}
		
		int calcDay = start.day;
		int calcMonth = start.month;
		int calcYear = start.year;
		int totalDays = 0;
		int numberOfDays = 30; //a good default value
		do {
			totalDays++;
			
			calcDay++;
			numberOfDays = numberOfDaysInMonth(calcYear, calcMonth);
			if (calcDay / numberOfDays == 1 && calcDay % numberOfDays == 1) {
				calcDay = 1;
				calcMonth++;

				if (calcMonth == 13) {
					calcMonth = 1;
					calcYear++;
				}
			}
			if(calcDay == end.day && calcMonth == end.month && calcYear == end.year)
				break;
		}while(true);
		
		
		return totalDays * multiplier;
	}

	private int numberOfDaysInMonth(int year, int month) {
		if (month < 1 || month > 12)
			throw new IllegalArgumentException("Invalid Date");

		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
			return 31;
		else if (month == 4 || month == 6 || month == 9 || month == 11)
			return 30;
		else {
			if (isLeapYear(year))
				return 29;
			else
				return 28;
		}

	}

	@Override
	public String toString() {
		return this.year + "/" + this.month + "/" + this.day;
	}

}
