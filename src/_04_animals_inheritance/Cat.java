package _04_animals_inheritance;

public class Cat extends Animal{

	Cat(String name, String furColor, Boolean isGirl) {
		super(name, furColor, isGirl);
		// TODO Auto-generated constructor stub
	}
	public void printName() {
		System.out.println("My name is "+name);
	}
	public void eat() {
		System.out.println("Eating");
	}
	
	public void sleep() {
		System.out.println("Sleeping");
	}
	
	public void play() {
		System.out.println("Playing");
	}

}
