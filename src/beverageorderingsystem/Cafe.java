package beverageorderingsystem;

import java.util.ArrayList;
import java.util.List;

public class Cafe {
    List<BeverageCategory> beverages;

    public Cafe(){
        beverages = new ArrayList<>();
    }

    public boolean checkIfBeverageExists(BeverageType beverageType){
        //TODO
        return false;
    }
    public void addBeverages(BeverageCategory beverageCategory){
        beverages.add(beverageCategory);
    }
    public void addBeverages(BeverageType beverageType, BeverageSubtype beverageSubtype){
        BeverageCategory beverageCategory = getBeverageCategory(beverageType);
        if (beverageCategory.getBeverageType() == BeverageType.NULL){
            System.out.println("Beverage Type not present! first add BeverageCategory");
            return;
        }
        beverageCategory.addBeverageSubtype(beverageSubtype);
    }
    BeverageCategory getBeverageCategory(BeverageType beverageType){
        for (BeverageCategory beverageCategory : beverages){
            if (beverageCategory.getBeverageType() == beverageType){
                return beverageCategory;
            }
        }
        return new BeverageCategory(BeverageType.NULL);
    }
    /*
    public void setTaxOfBeverageSubtype(BeverageType beverageType,String subtype, double tax){
        for (BeverageCategory beverageCategory : beverages){
            if (beverageCategory.getBeverageType() == beverageType){
                beverageCategory.setTax(tax);
                break;
            }
        }
    }
    */
    public void addBeverageSubtype(BeverageType beverageType, BeverageSubtype subtype){
        BeverageCategory beverageCategory = getBeverageCategory(beverageType);
        if (beverageCategory.getBeverageType() != BeverageType.NULL)
            beverageCategory.addBeverageSubtype(subtype);
    }
    public void addItemToBeverageSubtype(BeverageType beverageType,String subtype,Item item){
        for (BeverageCategory beverageCategory : beverages){
            if (beverageCategory.getBeverageType() == beverageType){
                beverageCategory.addItemToSubtype(subtype,item);
            }
        }
    }
}
