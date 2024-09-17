
// Importing map and hashmap
import java.util.HashMap;
import java.util.Map;
//Importing console program
import acm.program.ConsoleProgram;

public class Frendliest extends ConsoleProgram {
	// This program prints the person who has the highest number of friends
	public void run() {
		setFont("-20");
		Map<String, Integer> friendlist = new HashMap<>();
		readPairs(friendlist);
		printMostPopularPerson(friendlist);
	}

	// This method searches the most popular person in map and prints his/her name in console
	private void printMostPopularPerson(Map<String, Integer> friendlist) {
		String person = "";
		int max = 0;
		for(String key : friendlist.keySet()) {
			if(friendlist.get(key) > max) {
				max = friendlist.get(key);
				person = key;
			}
		}
		println(person + " has the highest number of friends!");
	}

	// This method reads string pairs from console and stores the number of friends for each person
	// in map. Each pair contains two people's names.
	private void readPairs(Map<String, Integer> friendlist) {
		while(true) {
			String friend = readLine("Enter the first person's name or [enter] to end: ");
			if(friend.equals("")) {
				break;
			}
			String person = readLine("Enter the second person's name or [enter] to end: ");
			if(person.equals("")) {
				break;
			}
			if(friendlist.containsKey(person)) {
				friendlist.put(person, friendlist.get(person) + 1);
			} else {
				friendlist.put(person, 1);
			}
			println(friend + " is a friend of " + person);
		}
	}
}
