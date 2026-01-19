package ch16_스트림.ex06_최종처리;

public class Student2 {
	private String name;
	private String sex;
	private int score;

	public Student2(String name, String sex, int score) {
		this.name = name;
		this.sex = sex;
		this.score = score;
	}

	public String getName() { return name; }
	public String getSex() { return sex; }
	public int getScore() { return score; }
	
	@Override
	public String toString() {
		return "Student2 [name=" + name + ", score=" + score + "]";
	}
}