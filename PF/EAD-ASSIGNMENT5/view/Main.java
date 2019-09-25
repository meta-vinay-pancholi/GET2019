package com.metacube.get2019.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.metacube.get2019.dao.InMemoryDao;
import com.metacube.get2019.enums.Status;
import com.metacube.get2019.facade.CartFacade;
import com.metacube.get2019.factory.BaseFactory;
import com.metacube.get2019.model.ProductModel;

/**
 * Main class
 * @author Vinay
 */
public class Main {
	
	/**
	 * Main method
	 * @param args unused
	 */
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		boolean isExit = false;
		try {
			InMemoryDao memoryDao = BaseFactory.createInMemoryDao();
			CartFacade cart = BaseFactory.createCartFacade();
			do {
				
				System.out.println("-----------------------------");
				
				System.out.println("1. Add product into shop");
				System.out.println("2. Update a product in shop");
				System.out.println("3. Delete a product from shop");
				System.out.println("4. Get all products of shop");
				System.out.println("5. Add a product into cart");
				System.out.println("6. Update a product in cart");
				System.out.println("7. Delete a product from cart");
				System.out.println("8. Get all products of cart");
				System.out.println("9. Exit");
				System.out.println("-----------------------------");
				System.out.print("Enter your choice : ");
				int choice = sc.nextInt();
				System.out.println("-----------------------------");
				switch(choice) {
				case 1:
					System.out.print("Enter the id of product : ");
					int id = sc.nextInt();
					sc.nextLine();
					System.out.print("Enter the name of product : ");
					String pName = sc.nextLine();
					System.out.print("Enter the price of product : ");
					double price = sc.nextDouble();
					sc.nextLine();
					System.out.print("Enter the category of product : ");
					String pCategory = sc.nextLine();
					System.out.print("Enter the quantity of product : ");
					int quantity = sc.nextInt();
					System.out.println("-----------------------------");
					Status status = memoryDao.createProduct(id, pName, price, pCategory, quantity);
					System.out.println("Product is added : "+status);
					System.out.println("-----------------------------");
					break;
				case 2:
					System.out.print("Enter the id of product to be updated : ");
					id = sc.nextInt();
					System.out.print("Enter the quantity to which to update : ");
					quantity = sc.nextInt();
					System.out.println("-----------------------------");
					status = memoryDao.updateProduct(id, quantity);
					System.out.println("Product is updated : "+status);
					System.out.println("-----------------------------");
					break;
				case 3:
					System.out.print("Enter the id of product to be deleted : ");
					id = sc.nextInt();
					System.out.println("-----------------------------");
					status = memoryDao.deleteProduct(id);
					System.out.print("Product is deleted : "+status);
					System.out.println("-----------------------------");
					break;
				case 4:
					Map<ProductModel, Integer> productsAvaiable = new HashMap<ProductModel, Integer>();
					productsAvaiable = memoryDao.getAll();
					System.out.println("-----------------------------");
					for(Map.Entry<ProductModel, Integer> entry : productsAvaiable.entrySet()) {
						System.out.println(entry.getKey().getId() + "\t\t" + entry.getKey().getpName() + "\t\t" + entry.getKey().getPrice()
								+ "\t\t" + entry.getKey().getpCategory() + "\t\t" + entry.getValue());
					}
					System.out.println("-----------------------------");
					break;
				case 5:
					System.out.print("Enter the id of product to be added into cart : ");
					id = sc.nextInt();
					System.out.println("Enter the quantity of product to be added : ");
					quantity = sc.nextInt();
					System.out.println("-----------------------------");
					status = cart.addProductToCart(id, quantity, memoryDao);
					System.out.println("Product is added : "+status);
					System.out.println("-----------------------------");
					break;
				case 6:
					System.out.print("Enter the id of product to be updated : ");
					id = sc.nextInt();
					System.out.print("Enter the quantity of product : ");
					quantity = sc.nextInt();
					System.out.println("-----------------------------");
					status = cart.updateProductToCart(id, quantity);
					System.out.println("Product is updated in cart  : "+status);
					System.out.println("-----------------------------");
					break;
				case 7:
					System.out.print("Enter the id of product to be deleted from cart : ");
					id = sc.nextInt();
					System.out.println("-----------------------------");
					status = cart.removeProductToCart(id);
					System.out.println("Product is removed from cart : "+status);
					System.out.println("-----------------------------");
					break;
				case 8:
					Map<ProductModel, Integer> productsInCart = new HashMap<ProductModel, Integer>();
					productsInCart = cart.getCartProducts();
					System.out.println("-----------------------------");
					for(Map.Entry<ProductModel, Integer> entry : productsInCart.entrySet()) {
						System.out.println(entry.getKey().getId() + "\t\t" + entry.getKey().getpName() + "\t\t" + entry.getKey().getPrice()
								+ "\t\t" + entry.getKey().getpCategory() + "\t\t" + entry.getValue());
					}
					System.out.println("-----------------------------");
					break;
				case 9:
					isExit = true;
					System.out.println("-----------------------------");
					System.out.println("Successfully exit");
					System.out.println("-----------------------------");
					break;
				default :
					System.out.println("-----------------------------");
					System.out.println("Enter a valid choice");
					System.out.println("-----------------------------");
				}
			} while(!isExit);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			sc.close();
		}
	}

}
