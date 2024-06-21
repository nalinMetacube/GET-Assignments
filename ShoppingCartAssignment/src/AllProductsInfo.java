class Item {
	int itemId;
	String name;
	String description;
	int price;
	int stockAvailable;
}


public class AllProductsInfo {
	public static Item[] ProductList = new Item[5];
	
	static {
		ProductList[0] = new Item();
		ProductList[0].itemId = 1;
		ProductList[0].name = "Pen";
		ProductList[0].description = "Smooth writing ball pen";
		ProductList[0].price = 10;
		ProductList[0].stockAvailable = 15;
		
		ProductList[1] = new Item();
		ProductList[1].itemId = 2;
		ProductList[1].name = "Mug";
		ProductList[1].description = "Ceramic coffee mug";
		ProductList[1].price = 79;
		ProductList[1].stockAvailable = 11;
		
		ProductList[2] = new Item();
		ProductList[2].itemId = 3;
		ProductList[2].name = "Lamp";
		ProductList[2].description = "Compact desk lamp";
		ProductList[2].price = 149;
		ProductList[2].stockAvailable = 8;
		
		ProductList[3] = new Item();
		ProductList[3].itemId = 4;
		ProductList[3].name = "Book";
		ProductList[3].description = "Mystery novel by famous author";
		ProductList[3].price = 199;
		ProductList[3].stockAvailable = 4;
		
		ProductList[4] = new Item();
		ProductList[4].itemId = 5;
		ProductList[4].name = "Toy Car";
		ProductList[4].description = "Minitaure racing car";
		ProductList[4].price = 276;
		ProductList[4].stockAvailable = 6;
	}
}
