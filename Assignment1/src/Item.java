public class Item //Class for the Item available in store
{
   String itemName="";
   String itemDesc="";
   int itemKey;
   int itemCount=0;
   float itemPrice=0;

   int getItemId()
   {
	  return itemKey;
   }
   int getItemCount()
   {
	  return itemCount;
   }
   float getItemPrice()
   {
	  return itemPrice;
   }
   String getItemName()
   {
	  return itemName;
   }
   String getItemDesc()
   {
	return itemDesc;
   }
}
