import beverageorderingsystem.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Cafe cafe = new Cafe("Cafe Racer");

        cafe.addBeverages(new BeverageCategory(BeverageType.HOT));
        cafe.addBeverages(new BeverageCategory(BeverageType.COLD));

        ArrayList<Item> coffeeItems = new ArrayList<>();
        coffeeItems.add(new Item("Latte", 40));
        coffeeItems.add(new Item("Cappuccino",50));
        coffeeItems.add(new Item("Expresso",30));
        cafe.addBeverageSubtype(BeverageType.HOT, new BeverageSubCategory(BeverageSubtype.COFFEE,18));
        cafe.addItemsToBeverageSubtype(BeverageType.HOT,BeverageSubtype.COFFEE,coffeeItems);


        ArrayList<Item> teaItems = new ArrayList<>();
        teaItems.add(new Item("Masala",15));
        teaItems.add(new Item("Black",10));
        cafe.addBeverageSubtype(BeverageType.HOT,new BeverageSubCategory(BeverageSubtype.TEA,5,teaItems));

        ArrayList<Item> coldCoffeeItems = new ArrayList<>();
        coldCoffeeItems.add(new Item("Oreo",110));
        coldCoffeeItems.add(new Item("Frape",125));

        cafe.addBeverageSubtype(BeverageType.COLD,new BeverageSubCategory(BeverageSubtype.COLDDRINK,21,coldCoffeeItems));

        cafe.printMenu();

        Invoice invoice = new Invoice();
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\nSelect Item(s) from catalog : ");
        invoice.placeOrder(cafe,"1,3,3");
        invoice.printBill();
    }
}
