import java.util.*;
import java.io.*;

public class ScoreTrakker {
	private ArrayList<Student> Students = new ArrayList<Student>();
	
	public ScoreTrakker() {
	}
	
	private void loadDataFromFile(String filename) throws FileNotFoundException {
		FileReader reader = new FileReader(filename);
		Scanner in = new Scanner(reader);
		while(in.hasNextLine()) {
			String name = in.nextLine();
			int score = Integer.parseInt(in.nextLine());
			Student s = new Student(name, score);
			Students.add(s);
		}
	}
	
	private void printInOrder() {
		Collections.sort(Students);
		for (Student s : Students) {
			System.out.println(s);
		}
	}
	
	public void processFiles() {
		try {
			loadDataFromFile("scores.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		printInOrder();
	}
	
	public static void main(String [] args) {
		ScoreTrakker tracker = new ScoreTrakker();
		tracker.processFiles();
	}
}
