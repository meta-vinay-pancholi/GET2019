import java.util.Scanner;



public class Main {
	/**
	 * @param args
	 */
	
	
	public static void main(String args[]) {
		ShoppingCart cart = new ShoppingCart();// creation of object
		Scanner in = new Scanner(System.in);
		int i;
		do {
			System.out
					.print("Enter your choice\n1.Add Item\n2.Show cart \n3.Generate Bill \n4.Update Item\n5.Exit\n");
			i = in.nextInt();
			switch (i) {
			case 1:
				System.out
						.println("Showing you available item \n1.Apple \n2.Ball \nSelect any of them\n");
				int j = in.nextInt();
				switch (j) {
				case 1:
					System.out.println("\nEnter number of apples?\n");
					int k = in.nextInt();
					cart.addItem("Apple", "Its a type of fruit", k, 1, 20);
					break;
				case 2:
					System.out.println("Enter number of balls?");
					int l = in.nextInt();
					cart.addItem("Ball", "Its a type of fruit", l, 2, 50);
					break;
				default:
					System.out.print("Wrong Input");
				}
				break;
			case 2:
				System.out
						.println("_________________________Welcome to cart___________________________\n\n");
				cart.showCart();
				break;
			case 3:
				cart.generateBill();
				break;

			case 4:
				System.out
						.println("Which item to be update?\n1.Apple\n2.Ball\n");
				int m = in.nextInt();
				if (m == 1) {
					System.out.print("Enter the correct quantity\n");
					int n = in.nextInt();
					cart.updateItem(1, n);
				} else if (m == 2) {
					System.out.println("Enter the correct quantity\n");
					int n = in.nextInt();
					cart.updateItem(2, n);
				}
				break;

			case 5:
				System.exit(0);
			default:
				System.out.println("Wrong choice");
			}

		} while (true);
	}
}
