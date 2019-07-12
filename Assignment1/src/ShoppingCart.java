import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Admin
 *
 */


public class ShoppingCart {
	HashMap<Integer, Item> list = new HashMap<>();

	public void addItem(String itemName, String itemDesc, int itemCount,int itemKey, float itemPrice){//To add item into cart
		Item it = new Item(itemName, itemDesc, itemCount, itemKey, itemPrice);
		list.put(itemKey, it);
	}

	public void updateItem(int itemId, int itemCount){//to update item
		Integer itemID1 = new Integer(itemId);
		Item it = list.get(itemID1);
		if (itemCount == 0) {
			list.remove(itemID1);
		} else {
			it.count = itemCount;
		}

	}

	
	public void showCart(){//Function to show cart value
		for (Integer i : list.keySet()) {
			Item item = list.get(i);
			System.out.println("Item Id:" + item.getItemId());
			System.out.println("Item Name:" + item.getItemName());
			System.out.println("Item Price:" + item.getItemPrice());
			System.out.println("Item Count:" + item.getItemCount());
			System.out.println("Item Desciption:" + item.getItemDesc());
			System.out.println("_____________________________________________\n");
		}
	}

	public void generateBill(){//TO generate bill of cart
		int totalAmount = 0;
		for (Integer i : list.keySet()) {
			Item item = list.get(i);
			totalAmount += item.getItemPrice() * item.getItemCount();
		}

		System.out.println("Total Amount=" + totalAmount);
		System.out.println("_____________________________________________");

	}

	
}