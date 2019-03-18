
public class Athlete {
	static int nextBibNumber = 1;
	static String raceLocation = "New York";
	static String raceStartTime = "9.00am";

	String name;
	int speed;
	int bibNumber;

	Athlete(String name, int speed) {
		this.name = name;
		this.speed = speed;
		bibNumber = nextBibNumber;
		nextBibNumber++;
	}
}
