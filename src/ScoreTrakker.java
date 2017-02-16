import java.util.*;
import java.io.*;

public class ScoreTrakker {
	private ArrayList<Student> Students = new ArrayList<Student>();
	
	private String[] files = {"scores.txt", "badscore.txt", "nofile.txt" }; 
	
	public ScoreTrakker() {
	}
	
	private void loadDataFromFile(String filename) throws FileNotFoundException {
		Students.clear();
		
		FileReader reader = new FileReader(filename);
		Scanner in = new Scanner(reader);
		String name = "";
		String line = "";
		
		while(in.hasNextLine()) {
			name = in.nextLine();
			line = in.nextLine();
			try{
				int score = Integer.parseInt(line);
				Student s = new Student(name, score);
				Students.add(s);
			}
			catch(NumberFormatException e){
				System.out.println("Incorrect format for " + name + " not a valid score : " + line + "\n");
			}
		}
	}
	
	private void printInOrder() {
		Collections.sort(Students);
		System.out.println("Student score list");
		for (Student s : Students) {
			System.out.println(s);
		}
	}
	
	public void processFiles() {
		for(String s : files){
			try {
				loadDataFromFile(s);
			} catch (FileNotFoundException e) {
				System.out.println("Cannot open file: " + s);//Prints a more user friendly message then e.printStackTrace
			}
			printInOrder();
			System.out.println("\n");
		}
	}
	
	public static void main(String [] args) {
		ScoreTrakker tracker = new ScoreTrakker();
		tracker.processFiles();
	}
}
