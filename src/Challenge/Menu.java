package Challenge;

import java.util.List;
import java.util.ArrayList;

public class Menu {
    private final List<MenuItem> itemList = new ArrayList<>();
    private final String categoryName;

    Print print = new Print();

    Menu(String categoryName){
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setItem(MenuItem m){
        this.itemList.add(m);
    }

    public void showItem(){
        print.printMenuItemList(itemList,this.categoryName);
    }

    public List<MenuItem> getItemList(){
        return this.itemList;
    }

    public MenuItem getItem(int menuChoice){
        return itemList.get(menuChoice-1);
    }
}

