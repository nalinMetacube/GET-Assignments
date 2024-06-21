import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;


public class Main {

	private static Item[] ProductList;
	private static HashMap<Integer, Integer> cart = new HashMap<>();
	
	public static void displayProducts() {
		for(Item item : ProductList) {
			System.out.println(item.itemId + " for " + item.name);
			System.out.println("Description : " + item.description);
			System.out.println("Price : " + item.price);
			System.out.println("Quantity Available : " + item.stockAvailable);
			System.out.println("................");
		}
	}
	
	public static void showMenu() {
		System.out.println(".....Enter the option for the corresponding opertions........");
		System.out.println("1 : Add an item to the cart");
		System.out.println("2 : Show quantity of a item in the cart");
		System.out.println("3 : Update quantity of added item");
		System.out.println("4 : Delete Item from cart");
		System.out.println("5 : Display cart total value");
		System.out.println("6 : EXIT");
	}
	
	public static void displayCart() {
		System.out.println(".......Items available in cart.........");
		for(Map.Entry<Integer, Integer> item : cart.entrySet()) {
			System.out.println("ItemId : " + item.getKey());
			System.out.println("Name : " + ProductList[item.getKey() - 1].name);
			System.out.println("Description : " + ProductList[item.getKey() - 1].description);
			System.out.println("Price : " + ProductList[item.getKey() - 1].price);
			System.out.println("Quantity : " + item.getValue());
			System.out.println("................");
		}
	}
	
	public static boolean checkAvailability(int itemId, int quantity) {
		return ProductList[itemId - 1].stockAvailable >= quantity;
	}

	public static void main(String[] args) {
		ProductList = AllProductsInfo.ProductList;
		Scanner sc = new Scanner(System.in);
		int option, itemId, quantity;
		do {
			showMenu();
			option = sc.nextInt();
			switch(option) {
				case 1:
				{
					displayProducts();
					System.out.println("Enter the item id to be added");
					itemId = sc.nextInt();
					System.out.println("Enter the quantity to be added");
					quantity = sc.nextInt();
					if(!checkAvailability(itemId, quantity)) {
						System.out.println("Sorry! Currently this much quantity of stock is not available for the item chosen");
						break;
					}
					addToCart(itemId, quantity);
					break;
				}
				case 2:
				{
					displayProducts();
					System.out.println("Enter the item id");
					itemId = sc.nextInt();
					showQuantity(itemId);
					break;
				}
				case 3:
				{
					if(cart.isEmpty()) {
						System.out.println("Cart is empty");
						break;
					}
					displayCart();
					System.out.println("Enter the item id");
					itemId = sc.nextInt();
					System.out.println("Enter the quantity");
					quantity = sc.nextInt();
					updateQuantity(itemId, quantity);
					break;
				}
				case 4:
				{
					if(cart.isEmpty()) {
						System.out.println("Cart is empty");
						break;
					}
					displayCart();
					System.out.println("Enter the item id to be deleted");
					itemId = sc.nextInt();
					deleteItem(itemId);
					break;
				}
				case 5:
				{
					System.out.println("Total value of cart : " + totalBill());
					break;
				}
			}
		}while(option != 6);
	}
	
	public static void addToCart(int itemId, int quantity) {
		if(cart.containsKey(itemId)) 
			cart.put(itemId, cart.get(itemId) + quantity);
		else 
			cart.put(itemId, quantity);
		ProductList[itemId - 1].stockAvailable -= quantity;
	}
	
	public static void showQuantity(int itemId) {
		if(cart.containsKey(itemId)) System.out.println(cart.get(itemId));
		else System.out.println("Sorry! This item doesn't exist in the cart");
	}
	
	public static void updateQuantity(int itemId, int quantity) {
		if(quantity - cart.get(itemId) > ProductList[itemId - 1].stockAvailable) System.out.println("Sorry! This much stock is not available for the chosen item");
		else cart.put(itemId, quantity);
	}
	
	public static void deleteItem(int itemId) {
		cart.remove(itemId);
	}
	
	public static int totalBill() {
		int amount = 0;
		for(Map.Entry<Integer, Integer> item : cart.entrySet()) {
			amount += (ProductList[item.getKey() - 1].price * item.getValue());
		}
		return amount;
	}

}
