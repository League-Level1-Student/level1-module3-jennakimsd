
public class Netflix {
	// Create your own class with a main() method that will
	// use Movie and NetflixQueue to complete the following challenges:
	public static void main(String[] args) {
		// 1. Instantiate some Movie objects (at least 5).
		Movie InfinityWar = new Movie("Infinity War", 5);
		Movie CaptainMarvel = new Movie("Captain Marvel", 4);
		Movie CaptainAmercia = new Movie("Captain America: Civil War", 5);
		Movie TheAvengers = new Movie("The Avengers", 5);
		Movie Thor = new Movie("Thor: Ragnarok", 5);
		// 2. Use the Movie class to get the ticket price of one of your movies.
		System.out.println(TheAvengers.getTicketPrice());
		// 3. Instantiate a NetflixQueue.
		NetflixQueue mine = new NetflixQueue();
		// 4. Add your movies to the Netflix queue.
		mine.addMovie(InfinityWar);
		mine.addMovie(CaptainMarvel);
		mine.addMovie(CaptainAmercia);
		mine.addMovie(TheAvengers);
		mine.addMovie(Thor);
		// 5. Print all the movies in your queue.
		mine.printMovies();
		// 6. Use your NetflixQueue object to finish the sentence "the best movie is...."
		System.out.println("The best movie is " + mine.getBestMovie());
		// 7. Use your NetflixQueue to finish the sentence "the second best movie is...."
		System.out.println("The second best movie is " + mine.getSecondBestMovie());
	}



}
