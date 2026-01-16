package ch16_스트림.ex05_중간처리;

public class Student2 implements Comparable<Student2> {
	private String name;
	private int score;

	public Student2(String name, int score) {
		this.name = name;
		this.score = score;
	}

	public String getName() { return name; }
	public int getScore() { return score; }

	@Override
	public int compareTo(Student2 o) {
		return Integer.compare(score, o.score);
	}
}