
public class RunningRace {

	public static void main(String[] args) {
		// create two athlete
		Athlete sami = new Athlete("Sami", 5000);
		Athlete nick = new Athlete("Nick", 4999);
		// print their names, bibNumbers, and the location of their race.
		System.out.println(sami.name);
		System.out.println(sami.bibNumber);
		System.out.println(sami.raceLocation);
		System.out.println(nick.name);
		System.out.println(nick.bibNumber);
		System.out.println(nick.raceLocation);
	}

}
