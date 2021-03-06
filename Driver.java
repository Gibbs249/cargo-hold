package FinalProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {
	File itemsFile = new File("Items.txt");
	AndrewsList loot = new AndrewsList();
	AndrewsList cargohold = new AndrewsList();
	Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		new Driver();
	}

	public Driver() throws InputMismatchException {

		System.out.println("Welcome to the BlackStar Cargo Hold interface.");

		System.out.println("Please select a number from the options below:");

		System.out.println("");

		while (true) {
			try {

// Give the user a list of their options

				System.out.println("1: Add an item to the cargo hold.");

				System.out.println("2: Remove an item from the cargo hold.");

				System.out.println("3: Choose an attribute to sort by.");

				System.out.println("4: Search for an item.");

				System.out.println("5: Display the items in the cargo hold.");

//				System.out.println("6: Optimize loot stored in the cargohold to get the most value.");

				System.out.println("0: Exit the BlackStar Cargo Hold interface.");

// Get the user input

				int userChoice = input.nextInt();

				input.nextLine();

				switch (userChoice) {

				case 1:

					addItem();

					break;

				case 2:

					removeItem();

					break;

				case 3:

					sortItems();

					break;

				case 4:

					searchItems();

					break;

				case 5:

					displayItems();

					break;

				case 6:

					loot();

					break;

				case 0:

					System.out.println("Thank you for using the BlackStar Cargo Hold interface. See you again soon!");

					System.exit(0);
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid Input");
				return;
			}
		}
	}

	private void addItem() {
		readFromFile();
		System.out.println("Enter 1 if your item is an equipment, 2 for material, and 3 for a consumable: \n");

		int addItem = input.nextInt();

		input.nextLine();

		if (addItem > 3 || addItem < 1) {
			System.out.println("Please enter a valid input");
		}

		switch (addItem) {
		case 1:
			addEquipment();
			break;
		case 2:
			addMaterial();
			break;
		case 3:
			addConsumable();
			break;
		}
		writeToFile();
	}

	private void addEquipment() {

		try {
			Scanner fileInput = new Scanner(new File("Items.txt"));
			while (fileInput.hasNextLine()) {
				fileInput.nextLine();
			}
		} catch (FileNotFoundException e) {
		}

		String strClass = "Equipment";

		System.out.println("What is the name of the item you would like to add?");
		String strName = input.nextLine().trim().toUpperCase();

		if (strName.equals("")) {
			System.out.println("Cannot add nothing. Please enter a real item.");
			return;
		}

		System.out.println("What is the weight of the item you would like to add in pounds?");
		int intWeight = Integer.parseInt(input.nextLine());

		int total = cargohold.getTotal();
		if ((total + intWeight) > 50000) {
			System.out.println("Sorry, this item exceeds the 25 ton capacity.");
			return;
		}

		System.out.println("What is the value of the item you would like to add?");
		int intValue = Integer.parseInt(input.nextLine());

		System.out.println("What is the durability of the item you would like to add?");
		int intDurability = Integer.parseInt(input.nextLine());

		System.out.println("What is the ID of the item you would like to add?");
		int intID = Integer.parseInt(input.nextLine());

		System.out.println("What damage rating does your item have?");
		int intDamage = Integer.parseInt(input.nextLine());

		System.out.println("What defense rating does your item have?");
		int intDefense = Integer.parseInt(input.nextLine());

		System.out.println("Please specify the item's color.");
		String strColor = input.nextLine().trim();

		Item equipment = new Equipment(strClass, strName, intDurability, intWeight, intValue, intID, intDamage,
				intDefense, strColor);

		cargohold.add(equipment);
		System.out.println(strName + " is added to Cargo.");

	}

	private void addConsumable() {

		String strClass = "Consumable";

		System.out.println("What is the name of the item you would like to add?");
		String strName = input.nextLine().trim().toUpperCase();

		if (strName.equals("")) {
			System.out.println("Cannot add nothing. Please enter a real item.");
			return;
		}

		System.out.println("What is the weight of the item you would like to add in tons?");
		int intWeight = Integer.parseInt(input.nextLine());

		int total = cargohold.getTotal();
		if ((total + intWeight) > 50000) {
			System.out.println("Sorry, this item exceeds the 25 ton capacity.");
			return;
		}

		System.out.println("What is the value of the item you would like to add?");
		int intValue = Integer.parseInt(input.nextLine());

		System.out.println("What is the durability of the item you would like to add?");
		int intDurability = Integer.parseInt(input.nextLine());

		System.out.println("What is the ID of the item you would like to add?");
		int intID = Integer.parseInt(input.nextLine());

		System.out.println("Please specify the type of food (vegetable, meat, snack, none...");
		String strFoodType = input.nextLine().trim().toUpperCase();

		System.out.println("Is the item medicinal? (Yes or no)");
		String strMedicinal = input.nextLine().trim().toUpperCase();

		System.out.println("What is the expiration year?");
		int intExpireYear = Integer.parseInt(input.nextLine());

		Item consumable = new Consumable(strClass, strName, intDurability, intWeight, intValue, intID, strFoodType,
				strMedicinal, intExpireYear);
		cargohold.add(consumable);
		System.out.println(strName + " is added to Cargo.");
	}

	private void addMaterial() {

		String strClass = "Material";

		System.out.println("What is the name of the item you would like to add?");
		String strName = input.nextLine().trim().toUpperCase();

		if (strName.equals("")) {
			System.out.println("Cannot add nothing. Please enter a real item.");
			return;
		}

		System.out.println("What is the weight of the item you would like to add in pounds?");
		int intWeight = Integer.parseInt(input.nextLine());

		int total = cargohold.getTotal();
		if ((total + intWeight) > 50000) {
			System.out.println("Sorry, this item exceeds the 25 ton capacity.");
			return;
		}

		System.out.println("What is the value of the item you would like to add?");
		int intValue = Integer.parseInt(input.nextLine());

		System.out.println("What is the durability of the item you would like to add?");
		int intDurability = Integer.parseInt(input.nextLine());

		System.out.println("What is the ID of the item you would like to add?");
		int intID = Integer.parseInt(input.nextLine());

		System.out.println("Is the material made of metal? (Yes or no)");
		String strMetal = input.nextLine().trim().toUpperCase();

		System.out.println("Is the material made of plastic? (Yes or no)");
		String strPlastic = input.nextLine().trim().toUpperCase();

		System.out.println("Is the material made of Fabric? (Yes or no)");
		String strFabric = input.nextLine().trim().toUpperCase();

		Item material = new Material(strClass, strName, intDurability, intWeight, intValue, intID, strMetal, strPlastic,
				strFabric);
		cargohold.add(material);
		System.out.println(strName + " is added to Cargo.");
	}

	private void removeItem() {

		readFromFile();

		System.out.println("What would you like to remove?");
		String strName = input.nextLine().trim().toUpperCase();

		if (strName.equals("")) {
			System.out.println("Cannot remove nothing. Enter an item that is in the cargo hold.");
			return;
		}

		boolean found = cargohold.remove(strName);
		if (found) {
			System.out.println(strName + " has been removed.");
		} else {
			System.out.println("Cannot find " + strName);
		}

		writeToFile();

	}

	private void searchItems() {
		readFromFile();

		System.out.println("What is the name of the item you are searching for?");
		String strName = input.nextLine().trim().toUpperCase();

		System.out.println("What is the ID of the item you are searching for?");
		int ID = Integer.parseInt(input.nextLine());

		if (strName.equals("")) {
			System.out.println("Cannot search for nothing. Enter an item that is in the cargo hold.");
			return;
		}

		boolean found = isFound(cargohold, strName, ID);
		if (found) {
			System.out.println(strName + " is found in the cargo hold");
		} else {
			System.out.println("I don't see that in the cargo hold.");
		}
	}

//	private boolean isFound(AndrewsList cargohold, String itemName) {
//		int length = cargohold.size();
//		boolean found = false;
//		for (int i = 0; i < length; i++) {
//			if (cargohold.get(i).getStrName().equals(itemName)) {
//				found = true;
//				break;
//			}
//		}
//		return found;
//	}

	private boolean isFound(ArrayList<Item> items, String itemName) {
		int length = items.size();
		boolean found = false;
		for (int i = 0; i < length; i++) {
			if (items.get(i).getStrName().equals(itemName)) {
				found = true;
				break;
			}
		}
		return found;
	}

	private boolean isFound(AndrewsList cargohold, String strName, int ID) {
		int length = cargohold.size();
		boolean found = false;
		for (int i = 0; i < length; i++) {
			if (cargohold.get(i).getStrName().equals(strName) && cargohold.get(i).getIntID() == ID) {
				found = true;
				break;
			}
		}
		return found;
	}

	private void displayItems() {

		readFromFile();

		ArrayList<Item> items = new ArrayList<Item>();
		ArrayList<Integer> itemCounts = new ArrayList<Integer>();
		if (cargohold.size() == 0) {
			System.out.println("Cargo hold is empty. Please add an item.");
			return;
		}

		int count;
		for (int i = 0; i < cargohold.size(); i++) {
			Item item = cargohold.get(i);
			count = 1;
			for (int j = i + 1; j < cargohold.size(); j++) {
				if (item.getStrName().equals(cargohold.get(j).getStrName())) {
					count++;
				}
			}

			if (isFound(items, item.getStrName()) == false) {
				items.add(item);
				itemCounts.add(count);
			}
		}

		System.out.println("\n");

		for (int i = 0; i < items.size(); i++) {
			System.out.println("Class: " + items.get(i).getStrClass() + ", " + "Name: " + items.get(i).getStrName()
					+ ", " + "Weight: " + items.get(i).getIntWeight() + ", " + "Value: " + items.get(i).getIntValue()
					+ ", " + "Durability: " + items.get(i).getIntDurability() + ", " + "ID: " + items.get(i).getIntID()
					+ ", Total: " + itemCounts.get(i));
		}

	}

	private void sortItems() {

		readFromFile();

		System.out.println("1: Sort by item class.");

		System.out.println("2: Sort by item name.");

		System.out.println("3: Sort by item weight.");

		System.out.println("4: Sort by item value.");

		System.out.println("5: Sort by item ID.");

		System.out.println("0: Exit to main interface.");

		int userChoice = input.nextInt();

		input.nextLine();

		switch (userChoice) {

		case 1:

			sortClass();

			break;

		case 2:

			sortName();

			break;

		case 3:

			sortWeight();

			break;

		case 4:

			sortValue();

			break;

		case 5:

			sortID();

			break;

		case 0:
			System.exit(0);
		}
		writeToFile();
	}

	private void sortClass() {
		System.out.println("Your items are sorted by class.");
		Node p = cargohold.getStart();

		while (p != null) {
			Node minItem = p;
			Node possibleNewMin = p.getNext();

			while (possibleNewMin != null) {
				if (minItem.getItem().getStrClass().toUpperCase()
						.compareTo(possibleNewMin.getItem().getStrClass().toUpperCase()) > 0) {
					minItem = possibleNewMin;
				}
				possibleNewMin = possibleNewMin.getNext();
			}
			Item temp = p.getItem();
			p.setItem(minItem.getItem());
			minItem.setItem(temp);
			p = p.getNext();
		}
	}

	private void sortName() {
		System.out.println("Your items are sorted by name.");
		Node p = cargohold.getStart();

		while (p != null) {
			Node minItem = p;
			Node possibleNewMin = p.getNext();

			while (possibleNewMin != null) {
				if (minItem.getItem().getStrName().toUpperCase()
						.compareTo(possibleNewMin.getItem().getStrName().toUpperCase()) > 0) {
					minItem = possibleNewMin;
				}
				possibleNewMin = possibleNewMin.getNext();
			}
			Item temp = p.getItem();
			p.setItem(minItem.getItem());
			minItem.setItem(temp);
			p = p.getNext();
		}
	}

	private void sortWeight() {
		System.out.println("Your items are sorted by weight.");
		Node p = cargohold.getStart();

		while (p != null) {
			Node minItem = p;
			Node possibleNewMin = p.getNext();

			while (possibleNewMin != null) {
				if (minItem.getItem().getIntWeight() > possibleNewMin.getItem().getIntWeight()) {
					minItem = possibleNewMin;
				}
				possibleNewMin = possibleNewMin.getNext();
			}
			Item temp = p.getItem();
			p.setItem(minItem.getItem());
			minItem.setItem(temp);
			p = p.getNext();
		}
	}

	private void sortValue() {
		System.out.println("Your items are sorted by value.");
		Node p = cargohold.getStart();

		while (p != null) {
			Node minItem = p;
			Node possibleNewMin = p.getNext();

			while (possibleNewMin != null) {
				if (minItem.getItem().getIntValue() > possibleNewMin.getItem().getIntValue()) {
					minItem = possibleNewMin;
				}
				possibleNewMin = possibleNewMin.getNext();
			}
			Item temp = p.getItem();
			p.setItem(minItem.getItem());
			minItem.setItem(temp);
			p = p.getNext();
		}
	}

	private void sortID() {
		System.out.println("Your items are sorted by ID.");
		Node p = cargohold.getStart();

		while (p != null) {
			Node minItem = p;
			Node possibleNewMin = p.getNext();

			while (possibleNewMin != null) {
				if (minItem.getItem().getIntID() > possibleNewMin.getItem().getIntID()) {
					minItem = possibleNewMin;
				}
				possibleNewMin = possibleNewMin.getNext();
			}
			Item temp = p.getItem();
			p.setItem(minItem.getItem());
			minItem.setItem(temp);
			p = p.getNext();
		}
	}

	private void loot() {

		readLargeFile();
//
//		Collections.sort(loot, new Comparator<Item>() {
//			@Override
//			public int compare(Item o1, Item o2) {
//				return o2.getValueRatio() - o1.getValueRatio();
//			}
//		});
//
//		int maxValue = getMaxValue(25, loot, 0);
//
//		System.out.println(maxValue);
//
		writeToFile();
	}

	private void readFromFile() {
		try {
			Scanner fileInput = new Scanner(new File("Items.txt"));
			cargohold = new AndrewsList();
			while (fileInput.hasNextLine()) {
				String read = fileInput.nextLine();
				String[] split = read.split(", ");
				String Class = split[0];

				int durability = Integer.parseInt(split[2]);
				int weight = Integer.parseInt(split[3]);
				int value = Integer.parseInt(split[4]);
				int ID = Integer.parseInt(split[5]);

				if (Class.equals("Equipment")) {
					int damage = Integer.parseInt(split[6]);
					int defense = Integer.parseInt(split[7]);
					String color = split[8];
					Equipment equipment = new Equipment(split[0], split[1].toUpperCase(), durability, weight, value, ID,
							damage, defense, color);
					cargohold.add(equipment);

				} else if (Class.equals("Consumable")) {
					String foodType = split[6];
					String medicinal = split[7];
					int year = Integer.parseInt(split[8]);
					Consumable consumable = new Consumable(split[0], split[1].toUpperCase(), durability, weight, value,
							ID, foodType, medicinal, year);
					cargohold.add(consumable);

				} else if (Class.equals("Material")) {
					String metal = split[6];
					String plastic = split[7];
					String fabric = split[8];
					Material material = new Material(split[0], split[1].toUpperCase(), durability, weight, value, ID,
							metal, plastic, fabric);
					cargohold.add(material);

				}
			}

		} catch (InputMismatchException e) {
			System.out.println("File not found");
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (NumberFormatException e) {
			System.out.println("Invalid input");
		} catch (NullPointerException e) {
			System.out.println("The row does not contain all data");
		}
	}

	private void readLargeFile() {
		try {
			Scanner fileInput = new Scanner(new File("Loot.txt"));
			while (fileInput.hasNextLine()) {
				String read = fileInput.nextLine();
				String[] split = read.split(", ");
				String Class = split[0];

				int durability = Integer.parseInt(split[2]);
				int weight = Integer.parseInt(split[3]);
				int value = Integer.parseInt(split[4]);
				int ID = Integer.parseInt(split[5]);

				if (Class.equals("Equipment")) {
					int damage = Integer.parseInt(split[6]);
					int defense = Integer.parseInt(split[7]);
					String color = split[8];
					Equipment equipment = new Equipment(split[0], split[1].toUpperCase(), durability, weight, value, ID,
							damage, defense, color);
					loot.add(equipment);

				} else if (Class.equals("Consumable")) {
					String foodType = split[6];
					String medicinal = split[7];
					int year = Integer.parseInt(split[8]);
					Consumable consumable = new Consumable(split[0], split[1].toUpperCase(), durability, weight, value,
							ID, foodType, medicinal, year);
					loot.add(consumable);

				} else if (Class.equals("Material")) {
					String metal = split[6];
					String plastic = split[7];
					String fabric = split[8];
					Material material = new Material(split[0], split[1].toUpperCase(), durability, weight, value, ID,
							metal, plastic, fabric);
					loot.add(material);

				}
			}
		} catch (InputMismatchException e) {
			System.out.println("File not found");
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (NumberFormatException e) {
			System.out.println("Invalid input");
		} catch (NullPointerException e) {
			System.out.println("The row does not contain all data");
		}
	}

	private void writeToFile() {

		try {
			new PrintWriter(itemsFile).close();
			PrintWriter pw = new PrintWriter(new FileOutputStream(itemsFile, true));

			for (int i = 0; i < cargohold.size(); i++) {
				if (cargohold.get(i) != null) {
					if (cargohold.get(i).getStrClass().equals("Equipment")) {
						Equipment item = (Equipment) cargohold.get(i);
						pw.print(item.getStrClass() + ", " + item.getStrName() + ", " + item.getIntDurability() + ", "
								+ item.getIntWeight() + ", " + item.getIntValue() + ", " + item.getIntID() + ", "
								+ item.getIntDamage() + ", " + item.getIntDefense() + ", " + item.getStrColor() + "\n");

					} else if (cargohold.get(i).getStrClass().equals("Consumable")) {
						Consumable item = (Consumable) cargohold.get(i);
						pw.print(item.getStrClass() + ", " + item.getStrName() + ", " + item.getIntDurability() + ", "
								+ item.getIntWeight() + ", " + item.getIntValue() + ", " + item.getIntID() + ", "
								+ item.getStrFoodType() + ", " + item.getStrMedicinal() + ", " + item.getIntExpireYear()
								+ "\n");

					} else if (cargohold.get(i).getStrClass().equals("Material")) {
						Material item = (Material) cargohold.get(i);
						pw.print(item.getStrClass() + ", " + item.getStrName() + ", " + item.getIntDurability() + ", "
								+ item.getIntWeight() + ", " + item.getIntValue() + ", " + item.getIntID() + ", "
								+ item.getStrMetal() + ", " + item.getStrPlastic() + ", " + item.getStrFabric() + "\n");
					}
				}
			}
			pw.close();
		} catch (InputMismatchException e) {
			System.out.println("File not found");
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (NumberFormatException e) {
			System.out.println("Invalid input");
		} catch (NullPointerException e) {
			System.out.println("The row does not contain all data");
		}
	}
}