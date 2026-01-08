package ch11_base모듈.sec01_Object.ex04_record;

public class RecordExample {
	public static void main(String[] args) {
		Member m = new Member("winter", "눈송이", 25);
		System.out.println(m.getId());
		System.out.println(m.getName());
		System.out.println(m.getAge());
		System.out.println(m.toString());
		System.out.println();
		
		Member m1 = new Member("winter", "눈송이", 25);
		Member m2 = new Member("winter", "눈송이", 25);
		System.out.println("m1.hashCode(): " + m1.hashCode());
		System.out.println("m2.hashCode(): " + m2.hashCode());
		System.out.println("m1.equals(m2): " + m1.equals(m2) );
	}
}