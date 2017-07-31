import java.util.Scanner;


public class project_ClockHandsAngle {

	public static void main(String[] args) {
		
				System.out.println (" ");

				@SuppressWarnings("resource")
				Scanner user = new Scanner( System.in );


				double x,y,a,b,c,d;		

				System.out.print ("Hour? ");
				x = user.nextInt();

				System.out.print ("Minutes? ");
				y = user.nextInt();

				System.out.println ("");


				a = (x / 12)*360 + (y/60)*30;
				b = (y / 60)*360;

				c = a-b;
				d = b-a;

			
				if (a == b)
				{
					System.out.println ("The angle between the hands is 0.");
				}

				if (a > b)
				{
					System.out.println ("The angle between the hands is "+c+" degrees." );
				}

				if (b > a)
				{
					System.out.println ("The angle between the hands is "+d+" degrees." );
				}

			}		

	}

