package oop3;

class MemoryManagementExample {
    
    static class Person {
        String name;

        public Person(String name) {
            this.name = name;
        }

        public void display() {
            System.out.println("Person's Name: " + name);
        }
        protected void finalize() {
            System.out.println(name + " is being garbage collected.");
        }
    }

    public static void main(String[] args) {

        Person person1 = new Person("Hari");
        Person person2 = new Person("Krishna");
        person1.display();
        person2.display();
        person1 = null;
        person2 = null;

        System.gc();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main method has finished executing.");
    }
}

