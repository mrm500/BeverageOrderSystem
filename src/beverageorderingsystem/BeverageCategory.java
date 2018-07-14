package beverageorderingsystem;

import java.util.ArrayList;
import java.util.List;

public class BeverageCategory{

    private BeverageType beverageType;
    private List<BeverageSubCategory> beverageSubCategories = new ArrayList<>();

    public BeverageCategory(BeverageType beverageType){
        this.beverageType = beverageType;
    }

    public BeverageType getBeverageType() {
        return beverageType;
    }
    protected int getBeverageSubCategoryIndex(BeverageSubtype beverageSubtype){
        for (int i = 0; i < beverageSubCategories.size(); i++){
            if (beverageSubCategories.get(i).getBeverageSubtype() == beverageSubtype){
                return i;
            }
        }
        return -1;
    }
    protected int getBeverageSubCategoryIndex(BeverageSubCategory beverageSubCategory){
        for (int i = 0; i < beverageSubCategories.size(); i++){
            if (beverageSubCategories.get(i).getBeverageSubtype() == beverageSubCategory.getBeverageSubtype()){
                return i;
            }
        }
        return -1;
    }
    public void addBeverageSubCategory(BeverageSubCategory beverageSubCategory) {
        int index = getBeverageSubCategoryIndex(beverageSubCategory);
        if (index != -1){
            System.out.println("BeverageSubCategory already exists!");
            return;
        }
        beverageSubCategories.add(beverageSubCategory);
    }
    public void addItemToSubtype(BeverageSubtype beverageSubtype , Item item){
        int index = getBeverageSubCategoryIndex(beverageSubtype);
        if (index == -1){
            System.out.println("This beverageSubtype does not exist in any BeverageSubCategory! Add BeverageSubCategory first");
            return;
        }
        beverageSubCategories.get(index).addItem(item);
    }

    public void addItemsToSubtype(BeverageSubtype beverageSubtype, List<Item> itemList) {
        int index = getBeverageSubCategoryIndex(beverageSubtype);
        if (index == -1){
            System.out.println("This beverageSubtype does not exist in any BeverageSubCategory! Add BeverageSubCategory first");
            return;
        }
        beverageSubCategories.get(index).addItems(itemList);
    }
    public List<BeverageSubCategory> getBeverageSubCategories(){
        return beverageSubCategories;
    }
    public int size(){
        int size = 0;
        for (BeverageSubCategory beverageSubCategory : beverageSubCategories)
            size += beverageSubCategory.size();
        return size;
    }
}
