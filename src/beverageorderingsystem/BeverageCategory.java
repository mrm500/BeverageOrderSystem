package beverageorderingsystem;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class BeverageCategory{

    private BeverageType beverageType;
    private Map<BeverageSubtype, ArrayList<Item>> subtypesItemMap = new TreeMap<>();

    public BeverageCategory(BeverageType beverageType){
        this.beverageType = beverageType;
    }
    public BeverageCategory(BeverageType beverageType, BeverageSubtype beverageSubtype){
        this.beverageType = beverageType;
        subtypesItemMap.putIfAbsent(beverageSubtype, null);
    }

    public BeverageType getBeverageType() {
        return beverageType;
    }

    public void addBeverageSubtype(BeverageSubtype beverageSubtype) {
        subtypesItemMap.putIfAbsent(beverageSubtype, null);
    }
    public void addItemToSubtype(BeverageSubtype beverageSubtype, Item item){
        ArrayList<Item> temp = new ArrayList<>();
        temp.add(item);
        subtypesItemMap.put(beverageSubtype,temp);
    }

}
