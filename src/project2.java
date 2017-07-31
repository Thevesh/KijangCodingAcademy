import java.util.Scanner;

public class project2 {
	
	public static void main(String [] args){
		
		Scanner kijang = new Scanner(System.in);
		
		System.out.println("Year?");
		int year = kijang.nextInt();
		System.out.println("Month?");
		int month = kijang.nextInt();
		System.out.println("Day?");
		int day = kijang.nextInt();
		
		int year_final = year;
		
		int century = (year/100)%4;  
	
		year = year%100;
		if (year%2 == 0) year = year/2;
		else year = (year + 11)/2;
		if (year%2 == 1) year = year + 11;
		year = year%7;
		if (year == 0) year = 7;
		
		int base = (CentDays[century] + (7 - year))%7;
		
		int dayofyear = 0;
		int base_final;
		
		if (Leap(year_final)) {
			dayofyear = (LeapDays[month-1] + day)%7;
			base_final = (base +3)%7;
		}
		else {
			dayofyear = (Days[month -1] + day)%7;
			base_final = (base + 4)%7;
		}
		
		int result = (base_final + dayofyear)%7;
		if (result == 0) result = 7;
		
		System.out.println("The " + day + Suffixes[day%10] + " of " + Months[month-1] + ", " + year_final + " was a " + WeekDays[result-1]);
		
	}
	
	public static boolean Leap(int n){
		if (n%4 == 0 & n%400 == 0) return true;
		else if (n%4 == 0 & n%100 == 0) return false;
		else if (n%4 == 0) return true;
		else return false;
	}
	
	public static int [] Days = {0,31,59,90,120,151,181,212,243,273,304,334,365};
	public static int [] LeapDays = {0,31,60,91,121,152,182,213,244,274,305,335,366};
	public static int [] CentDays = {3,1,6,4};
	public static String [] WeekDays = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
	public static String [] Suffixes = {"th","st","nd","rd","th","th","th","th","th","th"};
	public static String [] Months = {"January", "February","March","April","May","June","July","August","September","October","November","December"};

}
