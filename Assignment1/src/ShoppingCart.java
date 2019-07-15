import java.util.HashMap;
import java.util.Scanner;
public class ShoppingCart
{
    HashMap<Integer, Item> list = new HashMap<>(); 
    public void addItem(String itemName,String itemDesc, int itemCount,int itemKey,float itemPrice)//Function to add item into cart
    {
	    Item it=new Item();
	    it.itemName=itemName;
	    it.itemDesc=itemDesc;
	    it.itemCount=itemCount;
	    it.itemKey=itemKey;
	    it.itemPrice=itemPrice;
	    list.put(itemKey, it);
    }

    public void updateItem(int itemId,int itemCount)//to update the cart 
    {
	    Integer itemID1=new Integer (itemId);
	    Item it=list.get(itemID1);
	    if(itemCount==0)
	    {
		  list.remove(itemID1);
	    }
	    else
	    {
		  it.itemCount=itemCount;
	    }
	
    }

    public void showCart()//to display cart
    {
	    for(Integer i:list.keySet())
	    {
		  Item item=list.get(i);
		  System.out.println("Item Id:"+item.getItemId());
		  System.out.println("Item Name:"+item.getItemName());
		  System.out.println("Item Price:"+item.getItemPrice());
		  System.out.println("Item Count:"+item.getItemCount());
		  System.out.println("Item Desciption:"+item.getItemDesc());
		  System.out.println("_____________________________________________\n");
	    }
	 }

    public void generateBill()//to generate bill amount of cart
    {
	    int totalAmount=0;
	    for(Integer i:list.keySet())
	    {
		  Item item=list.get(i);
		  totalAmount+=item.getItemPrice()*item.getItemCount();
		}
	
	    System.out.println("Total Amount="+totalAmount);
	    System.out.println("_____________________________________________");
	
    }
public static void main( String args[])
{
    ShoppingCart cart= new ShoppingCart();//creation of object
    Scanner in = new Scanner(System.in);
    int i;
    do
    {
	    System.out.print("Enter your choice\n1.Add Item\n2.Show cart \n3.Generate Bill \n4.Update Item\n5.Exit\n");
	    i = in.nextInt();
	    switch(i)
	    {
	        case 1:System.out.println("Showing you available item \n1.Apple \n2.Ball \nSelect any of them\n");
	        int j=in.nextInt();
	        switch(j)
	        {
	           case 1:System.out.println("\nEnter number of apples?\n");
	                  int k=in.nextInt();
	        	      cart.addItem("Apple", "Its a type of fruit", k, 1, 20);
	        	      break;
	           case 2:System.out.println("Enter number of balls?");
                      int l=in.nextInt();
   	                  cart.addItem("Ball", "Its a type of fruit", l, 2, 50);
   	                  break;
   	           default:System.out.print("Wrong Input");
	         }
	                  break;
	         case 2: System.out.println("_________________________Welcome to cart___________________________\n\n");
	                 cart.showCart();
		             break;
	         case 3: cart.generateBill();
	                 break;
		 
	         case 4:System.out.println("Which item to be update?\n1.Apple\n2.Ball\n");
	                int m=in.nextInt();
	                if(m==1)
	                {
	                	System.out.print("Enter the correct quantity\n");
	                	int n=in.nextInt();
	                	cart.updateItem(1, n);
	                }
	                else if(m==2)
	                {
	                	System.out.println("Enter the correct quantity\n");
	                	int n=in.nextInt();
	                	cart.updateItem(2, n);
	                }
	                break;
	                
	         case 5:System.exit(0);
	         default:System.out.println("Wrong choice");
         }
	
    }while(true);
}
}