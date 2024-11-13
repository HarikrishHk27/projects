package oop3;

public class GenericMethodExample {

	public static <T> void printArray(T[] array) {
		for (T element : array) {
			System.out.print(element + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {

		Integer[] intArray = { 1, 2, 3, 4, 5 };
		System.out.print("Integer Array: ");
		printArray(intArray);

		String[] strArray = { "Hari", "Krish", "Hk" };
		System.out.print("\n String Array: ");
		printArray(strArray);

		Double[] doubleArray = { 1.1, 2.2, 3.3 };
		System.out.print("\n Double Array: ");
		printArray(doubleArray);
	}
}
