package oop3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Collections {
	public static void main(String[] args) {
		System.out.println(" List Example (ArrayList):");

		List<String> namesList = new ArrayList<>();
		namesList.add("Hari");
		namesList.add("Krish");
		namesList.add("Hk");
		namesList.add("Hk"); // Duplicates are allowed

		for (String name : namesList) {
			System.out.println(name);
		}

		System.out.println("\n Set Example (HashSet):");
		Set<String> namesSet = new HashSet<>();
		namesSet.add("hari");
		namesSet.add("Krish");
		namesSet.add("Hk");
		namesSet.add("Hk");

		Iterator<String> iterator = namesSet.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

		System.out.println("\nMap Example (HashMap):");
		Map<String, Integer> ageMap = new HashMap<>();
		ageMap.put("Hari", 25);
		ageMap.put("Krish", 26);
		ageMap.put("Hk", 27);

		for (Map.Entry<String, Integer> entry : ageMap.entrySet()) {
			System.out.println("Name: " + entry.getKey() + ", Age: " + entry.getValue());
		}
	}
}
