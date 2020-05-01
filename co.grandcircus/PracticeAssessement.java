import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

//TO HELP WITH ASSESSMENT 2
//1. sets cannot be called with regular for loop.
//sets and hashmaps must use enhanced for loop
//2. HashMap uses put and get
//Lists use add and get
//Sets and maps can only have one instance of each element or key
//Sets order things their own way
public class PracticeAssessement {

	//For testing the methods
	public static void main(String[] args) {
		
		//1.MAP - HASHMAP TEST
		HashMap<Integer, String> spanish = espanol(); //just to note how to create map from method
		System.out.println(espanol()); //two ways to print
		System.out.println(spanish);
		
		//2. LIST TEST
		//Declaring, adding elements
		//gets size of list, also converts it to uppercase but doesn't return that
		List<String>randList = new ArrayList<>();
		randList.add("Hi");
		randList.add("there");
		randList.add("you");
		randList.add("trees");
		randList.add("birds");
		randList.add("coffee");
		randList.add("headaches");
		randList.add("sleepiness");
		System.out.println(lift(randList));
		
		//3. MAP - HASHMAP TEST
		//loops through hashmap elements, removes elements
		HashMap<String, String> stringMap = new HashMap<>();
		stringMap.put("Hi", "there");
		stringMap.put("what's", "up");
		stringMap.put("pretty", "flowers");
		stringMap.put("why", "not");
		boolean isThere = takeItAway(stringMap, "why");
		System.out.println(isThere);
		System.out.println(stringMap);
		//***Apparently the changes made to a map in a method keep it that way
		//after returning to the main method***
		
		//4.SETS - HASHSET TEST
		//Stores list elements into a hashset
		HashSet<String> someSet = listToSet(randList);
		System.out.println(someSet);
		
		//5.THROW EXCEPTIONS -  EXCEPTIONS AND LIST INDEXES
		int id = howFarApart(randList, "TREES", "YOU");
		System.out.println(id);
		
		//6. ARRAY INDEXES - AND EXCEPTIONS
		//int intArray[];    //declaring array
		//intArray = new int[20];  // allocating memory to array
		//int[] intArray = { 1,2,3,4,5,6,7,8,9,10 };
		double[] doubles = {3.2, 5.4, 7, -5.1, 7.8, 9.8, -2.3};
		double num = makeADifference(doubles, 0 , 4);
		System.out.println(num);
		
		//7. CREATE SET BASED ON ELEMENTS IN ARRAY
		int[] integers = {3, -4, -29, 45, 23, -23, 0, 12, -5, 8};
		HashSet <Integer> positives = neverTellMeTheOdds(integers);
		System.out.println(positives);
		
		//8. MODIFY ARRAY
		for (int i = 0; i < integers.length; i++) { //shows array before method
			System.out.print(integers[i] + " ");
		}
		int pos = fleeZero(integers);
		System.out.println("\n" + pos);
		for (int i = 0; i < integers.length; i++) { //array after method
			System.out.print(integers[i] + " ");
		}
		
	}
	
	
	/*//////////////METHODS////////////////*/
	
	
	
	
	//1. HASHMAPS
	public static HashMap<Integer, String> espanol() {
		//
		HashMap<Integer, String> spanish = new HashMap<>();
		spanish.put(1, "Uno");
		spanish.put(2, "Dos");
		spanish.put(3, "Tres");
		//
		return spanish;
	}
	
	//2. EDITING A LIST AND RETURNING ITS SIZE
	public static int lift(List<String> caps) {
		System.out.println(caps); //test
		//REPLACE ELEMENTS IN LIST
		for (String cap: caps) { //loop through a list or arraylist
			caps.set(caps.indexOf(cap), cap.toUpperCase());
		}
		//ANOTHER WAY TO REPLACE
		for (int i = 0; i < caps.size(); i++) { //index by number
			caps.set(i, caps.get(i).toUpperCase());
		}
		System.out.println(caps); //test
		return caps.size(); //Getting the NUMBER OF ELEMENTS in a list
	}
	
	//3. EDIT HASHMAP - REMOVE ELEMENTS THAT MATCH A GIVEN STRING
	public static boolean takeItAway(HashMap<String, String> elements, String string) {
		for (String element: elements.keySet()) { //Looping through HashMap
			if (element.equals(string)) {
				//elements.get(element) <-- calls the value by the key
				return elements.remove(element, elements.get(element)); //overloaded method remove
			}
		}
		return false; //if it doesn't find anything, it returns false;
	}
	
	//4. SETS - HASHSETS
	//converts a list into a set
	public static HashSet<String> listToSet(List<String> list) {
		HashSet<String> set = new HashSet<>();
		for (int i = 0; i < list.size(); i++) { //using regular for loop
			//(Elements in a set can't be called with a regular for loop though.)
			set.add(list.get(i)); //use "add" with sets
		}
		return set;
	}
	
	//5. EXCEPTIONS AND LIST INDEXES
	//Compares strings in a list, finds out how far apart the indexes are
	//If the given strings are not in the list, it catches the error and tells the user
	public static int howFarApart(List<String> list, String first, String second) {
		try {
			int a = list.indexOf(first);
			int b = list.indexOf(second);
			if (a == -1 || b == -1) {
				throw new IllegalArgumentException();
			}
			return a - b;
		} catch (IllegalArgumentException e) {
			System.out.println("String not found");
			return -123;
		}
	}
	
	//6. ARRAY INDEXES - AND EXCEPTIONS
	public static double makeADifference(double[] nums, int a, int b) {
		try {
			double subtract = Math.abs(nums[a] - nums[b]);
			return subtract;
		} catch (IndexOutOfBoundsException e) {
			return 0;
		}
		
	}
	
	//7. CREATE SET BASED ON ELEMENTS IN ARRAY
	public static HashSet<Integer> neverTellMeTheOdds(int[] numbers) {
		HashSet<Integer> positives = new HashSet<>(); //Sets use .add
		for (int i = 0; i < numbers.length; i++ ) {
			if (numbers[i] >= 0) {
				positives.add(numbers[i]);
			}
		}
		return positives;
	}
	
	//8. MODIFY ARRAY
	public static int fleeZero (int[] numbers) {
		int a = 0;
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] > 0) {
				numbers[i] += 1;
				a++;
			} else if (numbers[i] < 0) {
				numbers[i] -= 1;
			}
		}
		return a;
	}
	

}
