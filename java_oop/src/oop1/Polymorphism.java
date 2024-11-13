package oop1;

class Animal {
	public void sound() {
		System.out.println("Animal makes a sound");
	}

	public void move(int distance) {
		System.out.println("Animal moved " + distance + " meters.");
	}

	public void move(int distance, String direction) {
		System.out.println("Animal moved " + distance + " meters to the " + direction);
	}
}

class Dog extends Animal {
	@Override
	public void sound() {
		System.out.println("Dog barks");
	}

	public void eat() {
		System.out.println("Dog is eating pedigree");
	}
}

class Cat extends Animal {
	@Override
	public void sound() {
		System.out.println("Cat meows");
	}

	public void drink() {
		System.out.println("Cat is drinking milk");
	}
}

public class Polymorphism {
	public static void main(String[] args) {
		System.out.println("Compile time Polymorphism Example (Method Overloading):");
		Animal animal = new Animal();
		animal.move(10);
		animal.move(15, "north");

		System.out.println("\n Runtime Polymorphism Example (Method Overriding):");
		Animal myDog = new Dog();
		Animal myCat = new Cat();
		myDog.sound();
		myCat.sound();

		if (myDog instanceof Dog) {
			Dog dog = (Dog) myDog;
			dog.eat();
		}

		if (myCat instanceof Cat) {
			Cat cat = (Cat) myCat;
			cat.drink();
		}
	}
}
