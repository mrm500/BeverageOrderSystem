package beverageorderingsystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cafe {
    String cafeName;
    List<BeverageCategory> beverages = new ArrayList<>();

    public Cafe(String cafeName){
        this.cafeName = cafeName;
    }
    public String getName(){
        return this.cafeName;
    }
    public void addBeverages(BeverageCategory beverageCategory){
        beverages.add(beverageCategory);
    }

    private int getBeverageCategoryIndex(BeverageType beverageType){
        int index = 0;
        for (BeverageCategory beverageCategory : beverages){
            if (beverageCategory.getBeverageType() == beverageType){
                return index;
            }
            index++;
        }
        return -1;
    }

    public void addBeverageSubtype(BeverageType beverageType, BeverageSubCategory beverageSubCategory){
        int index = getBeverageCategoryIndex(beverageType);
        if (index == -1){
            System.out.println("BeverageType does not exist in cafe! Add BeverageType first.");
            return;
        }
        if (beverages.get(index).getBeverageSubCategoryIndex(beverageSubCategory) == -1) {
            beverages.get(index).addBeverageSubCategory(beverageSubCategory);
            //System.out.println(beverageSubCategory.getBeverageSubtype().name() + " subcategory added.!");
        }
    }
    public void addItemToBeverageSubtype(BeverageType beverageType,BeverageSubtype beverageSubtype,Item item){
        int index = getBeverageCategoryIndex(beverageType);
        System.out.println("\tCafe Racer\n");
        if (index == -1){
            System.out.println("BeverageType does not exist in Cafe! Add BeverageType first.");
            return;
        }
        int beverageSubCategoryIndex = beverages.get(index).getBeverageSubCategoryIndex(beverageSubtype);
        if (beverageSubCategoryIndex == -1){
            System.out.println("BeverageSubtype does not exist in BeverageCategory! Add BeverageSubCategory first.");
            return;
        }
        beverages.get(index).addItemToSubtype(beverageSubtype,item);
    }
    public void addItemsToBeverageSubtype(BeverageType beverageType,BeverageSubtype beverageSubtype,List<Item> itemList){

        // this method does not work.!

        int index = getBeverageCategoryIndex(beverageType);
        if (index == -1){
            System.out.println("BeverageType does not exist in Cafe! Add BeverageType first.");
            return;
        }
        int beverageSubCategoryIndex = beverages.get(index).getBeverageSubCategoryIndex(beverageSubtype);
        if (beverageSubCategoryIndex == -1){
            System.out.println("BeverageSubtype does not exist in BeverageCategory! Add BeverageSubCategory first.");
            return;
        }
        beverages.get(index).addItemsToSubtype(beverageSubtype,itemList);
    }
    public void printMenu(){
        int number = 1;
        System.out.println("\n\t\t" + cafeName + "\n");
        for (BeverageCategory beverageCategory : beverages){
            for (BeverageSubCategory beverageSubCategory : beverageCategory.getBeverageSubCategories()){
                for (Item item: beverageSubCategory.getItems()){
                    System.out.println(number++ + ". " + beverageCategory.getBeverageType().name() + "."+ beverageSubCategory.getBeverageSubtype().name() + "." + item.getInfo());
                }
            }
        }
    }

    public List<BeverageCategory> getBeverages() {
        return beverages;
    }
}
