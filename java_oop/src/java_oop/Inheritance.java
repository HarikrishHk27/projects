package java_oop;

class Animal {
	public void eat() {
     System.out.println("Animal is eating");
     }
	}

class Dog extends Animal {
	public void bark() {
		System.out.println("Dog is barking");
		}
	}

class Puppy extends Dog {
	public void sleep() {
		System.out.println("Puppy is sleeping");
		}
	}

class Cat extends Animal {
	public void meow() {
     System.out.println("Cat is meowing");
     }
	}

interface Swimmer {
 void swim();
}

interface Runner {
 void run();
}

class Dolphin implements Swimmer, Runner {
 
	@Override
	public void swim() {
		System.out.println("Dolphin is swimming");
 }
	
	@Override
	public void run() {
		System.out.println("Dolphin is swimming fast, like running in water!");
 }
}

class SuperDolphin extends Dolphin {
	public void superSwim() {
		System.out.println("Dolphin is swimming super fast!");
		}
	}

public class Inheritance {
	public static void main(String[] args) {
		
     System.out.println("Single Inheritance Example:");
     Dog dog = new Dog();
     dog.eat();
     dog.bark();
     
     System.out.println("\n Multilevel Inheritance Example:");
     Puppy puppy = new Puppy();
     puppy.eat();
     puppy.bark();
     puppy.sleep();

     System.out.println("\n Hierarchical Inheritance Example:");
     Cat cat = new Cat();
     cat.eat();
     cat.meow();
     
     System.out.println("\n Multiple Inheritance Example Using Interfaces:");
     Dolphin dolphin = new Dolphin();
     dolphin.swim();
     dolphin.run();
     
     System.out.println("\n Hybrid Inheritance Example:");
     SuperDolphin superDolphin = new SuperDolphin();
     superDolphin.swim();
     superDolphin.run();
     superDolphin.superSwim();
	}
}
