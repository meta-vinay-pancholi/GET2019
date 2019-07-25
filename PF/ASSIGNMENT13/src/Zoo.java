import java.util.ArrayList;
import java.util.Scanner;
/**
 * This class contains functions like
 * @fun addZone()
 * @fun addCage()
 * @fun add animal()
 * @author Vinay Pancholi
 */
public class Zoo {
	static int id = 0;
	static ArrayList<Zone> ZoneArea = new ArrayList<Zone>();//array list for handling various zones
	static ArrayList<Cage> CageArea = new ArrayList<Cage>();//array list for handling cages
	static ArrayList<Animal> AnimalArea = new ArrayList<Animal>();//array list for handling animal

	public static void main(String[] args) {
		int exit = 0;
		Scanner sc = new Scanner(System.in);

		while (exit != -1) {
			System.out.println("1-Ädd Zone");
			System.out.println("2-Add Cage");
			System.out.println("3-Add Animal");
			System.out.println("4-Remove Animal");
			System.out.println("5-Show Animal");
			System.out.println("6-Exit");
			int userInput = sc.nextInt();

			switch (userInput) {
			case 1: {
				if (ZoneArea.size() < 3) {
					System.out.println("Enter Catergory of Zone");
					sc.nextLine();
					String Category = sc.nextLine();
					System.out.println("Enter Cage Capacity of Zone");
					int cageCapacity = sc.nextInt();

					switch (Category) {
					case "Mammal": {
						Zone Z1 = addZone("Mammal", cageCapacity);
						ZoneArea.add(Z1);//adding zone of type mammal
						break;
					}

					case "Reptile": {
						Zone Z1 = addZone("Reptile", cageCapacity);
						ZoneArea.add(Z1);//adding zone of type Reptile
						break;
					}

					case "Bird": {
						Zone Z1 = addZone("Bird", cageCapacity);
						ZoneArea.add(Z1);//adding zone of type Bird
						break;
					}

					}
				} else {
					System.out.println("Zone Full");
				}
				break;
			}

			case 2: {
				if (ZoneArea.size() == 0) {
					System.out.println("No zone exist please create on first\n");
				    } else {
					System.out.println("Enter Type of Cage Eg. Lion , Crocodile , Peacock");
					sc.nextLine();
					String cageType = sc.nextLine();
					System.out.println("Enter Animal Capacity of cage");
					int animalCapacity = sc.nextInt();
					
					if ("Lion".equals(cageType)) {
						String zoneType = Lion.class.getSuperclass().getSimpleName();
						insertIntoTheCage(zoneType, animalCapacity, cageType);//inserting of cage type Lion into zone
						
					} else if ("Crocodile".equals(cageType)) {
						String zoneType = Crocodile.class.getSuperclass().getSimpleName();
						insertIntoTheCage(zoneType, animalCapacity, cageType);//inserting of cage type Crocodile into zone

					} else if ("Peacock".equals(cageType)) {
						String zoneType = Peacock.class.getSuperclass().getSimpleName();
						insertIntoTheCage(zoneType, animalCapacity, cageType);//inserting of cage type Crocodile into zone

					} else {
						System.out.println("Enter correct choice \n");
					}

				}
				break;
			}

			case 3:
				if (ZoneArea.size() == 0) {
					System.out.println("Please Create Zone");
				} else if (CageArea.size() == 0) {
					System.out.println("Please Create Cage");
				} else {
					System.out.println("Enter type of animal");
					sc.nextLine();
					String animalType = sc.nextLine();
					System.out.println("Enter name of animal");
					String animalName = sc.nextLine();
					System.out.println("Enter age of animal");
					int age = sc.nextInt();
					System.out.println("Enter weight of animal");
					int weight = sc.nextInt();
					for (int i = 0; i < CageArea.size(); i++) {
						System.out.println("c");
						Cage CageObj = CageArea.get(i);
						if (animalType.equals(CageObj.cageType)) {
							if (CageObj.Aniamlcapacity > 0) {
								CageObj.Aniamlcapacity = CageObj.Aniamlcapacity - 1;
								Animal A1 = addAnimal(id++, animalName,animalType,age,weight);
								AnimalArea.add(A1);
							} else {
								System.out.println("Capacity full");
							}
						}
					}
				}
				break;
			case 4:
				sc.nextLine();
				System.out.println("Enter Name of Animal");
				String animalName = sc.nextLine();
				for (int i = 0; i < AnimalArea.size(); i++) {
					Animal A1 = AnimalArea.get(i);
					if (animalName.equals(A1.name)) {
						AnimalArea.remove(i);
					}
				}
				break;

			case 5:
				sc.nextLine();
				System.out.println("Enter Name of Animal");
				String animalName1 = sc.nextLine();
				for (int i = 0; i < AnimalArea.size(); i++) {
					Animal A1 = AnimalArea.get(i);
					if (animalName1.equals(A1)) {
						System.out.println("Name of Animal->" + A1.name);
						System.out.println("Id of Animal->" + A1.id);
						System.out.println("Sound Of Animal->" + A1.getSound());
					} else {
						System.out.println("Animal Not Found");
					}
				}
				break;
			case 6:
				System.out.println("Thanks For Comming");
				System.exit(0);

			}
		}
	}

	/**
	 * @param zoneType
	 * @param animalCapacity
	 * @param cageType
	 * function for adding animal into cage , this function also checking capacity of cage 
	 */
	private static void insertIntoTheCage(String zoneType, int animalCapacity,String cageType) {
		
		for (int i = 0; i < ZoneArea.size(); i++) {
			Zone ZoneAreaObj = ZoneArea.get(i);
			if (zoneType.equals(ZoneAreaObj.category)) {
				if (ZoneAreaObj.cageCapity > 0) {
					ZoneAreaObj.cageCapity = ZoneAreaObj.cageCapity - 1;
					Cage c1 = addCage(cageType, animalCapacity);
					CageArea.add(c1);

				 } else {
					System.out.println("Cage Size Full");
				}
				break;
			}
		}
	}

	/**
	 * @param zoneType
	 * @param Cagecapacity
	 * function for adding a zone 
	 */
	public static Zone addZone(String zoneType, int Cagecapacity) {
		return new Zone(zoneType, Cagecapacity);
	}

	/**
	 * @param CageType
	 * @param Acapacity
	 * function for adding cage
	 */
	public static Cage addCage(String CageType, int Acapacity) { 
		return new Cage(CageType, Acapacity);
	}

	/**
	 * @param Id
	 * @param Name
	 * @param Type
	 * function for adding animal
	 */
	public static Animal addAnimal(int Id, String Name, String Type ,int age ,int weight) {
		if ("Lion".equals(Type)) {
			return new Lion(Id, Name , age ,weight);
		} 
		else if ("Crocodile".equals(Type)) {
			return new Crocodile(Id, Name,  age ,weight);
		} 
		else if ("Peacock".equals(Type)) {
			return new Peacock(Id, Name , age ,weight);
		} else {
			System.out.println("No Animal Found");
			return null;
		}
	}

}
