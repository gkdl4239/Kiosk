package Lv4Lv5;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private final List<MenuItem> itemList = new ArrayList<>();
    private final String categoryName;

    Menu(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setItem(MenuItem m) {
        this.itemList.add(m);
    }

    public void showMenuItem(){
        for(int i=0; i<itemList.size(); i++){
            MenuItem item = itemList.get(i);
            System.out.println((i+1)+". "+item.getName()+"\t | w "+item.getPrice()+" | "+item.getExp());
        }
    }

    public List<MenuItem> getMenuList(){
        return this.itemList;
    }
}
