package minijavaproject;

import java.util.ArrayList;
import java.util.Scanner;

public class OnlineShoppingStore {

    ArrayList<Item> items;
    ArrayList<Item> cart;
   
    public OnlineShoppingStore() {
        cart = new ArrayList<>();
        items = new ArrayList<>();
        items.add(new ClockItem(1, 40));
        items.add(new ChairItem(2, 40));
        items.add(new CalculatorItem(3, 20));
    }

    public void askCustomerToBuy() {
        System.out.println("What would you like to buy");
    }

    public void getInputFromCustomer() {
        String input;
        do {
            askCustomerToBuy();
            Scanner sc = new Scanner(System.in);
            input = sc.nextLine();
            for (Item item : items) {
                if (Integer.valueOf(input) == item.id) {
                    System.out.println("What amount of " + item.name + "?");
                    input = sc.nextLine();
                    int amount = Integer.valueOf(input);
                    item.setQty(amount);
                    cart.add(item);
                    break;
                }
            }
            System.out.println("do you want to continue shopping (y/N)?");
            input = sc.nextLine();
            
        } while (input.equalsIgnoreCase("y"));
        
        double total =0;
        if (cart.size() > 0) {
            System.out.println("Thank you for shopping you have " + cart.size());
            for (Item item : cart) {
                System.out.println(item.id +" : "+ item.name +" :  amount = " + item.qty);
                total=total+(item.qty * item.price);
            }
            System.out.println("Total Amount = " + total);
        }
    }

    public void showItem() {

        for (Item item : items) {
            System.out.println(item.id + ":" + item.name + "(" + item.price + ")");
        }
    }
    
    public void testGitHub(){
        
    }

}
