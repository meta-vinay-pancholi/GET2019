
public class Item // Class for the Item available in store
{
	String name;
	String desc;
	int key;
	int count = 0;
	float price = 0;
    
//	int setItemId(int id){
//		this.key=id;
//	}
//	int setItemCount(int count){
//		this.count=count;
//	}
//	float setItemPrice(float price){
//		this.price=price;
//		
//	}
//	String setItemName(String name){
//		this.name=name;
//	}
//	String setItemDesc(String desc){
//		this.desc=desc;
//	}
	/**
	 * @param name
	 * @param desc
	 * @param key
	 * @param count
	 * @param price
	 */
	Item(String name,String desc,int key,int count,float price){
		this.name=name;
		this.desc=desc;
		this.key=key;
		this.count=count;
		this.price=price;
	}
	/**
	 * @return key
	 */
	int getItemId() {
		return key;
	}

	/**
	 * @return count
	 */
	int getItemCount() {
		return count;
	}

	/**
	 * @return price
	 */
	float getItemPrice() {
		return price;
	}

	/**
	 * @return name
	 */
	String getItemName() {
		return name;
	}

	/**
	 * @return Description
	 */
	String getItemDesc() {
		return desc;
	}
}
