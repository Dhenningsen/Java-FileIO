
public class Student implements Comparable<Student> {
	private String name;
	private int score;
	
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}

	@Override
	public int compareTo(Student arg0) {
		return this.score == arg0.score ? 0 : ( this.score > arg0.score ? 1 : -1 );
	}

	@Override
	public String toString() {
		return name + " " + score;
	}

}
