package Challenge.Domain;

import Challenge.Util.Print;

import java.util.List;
import java.util.ArrayList;

public class Menu {
    private final List<MenuItem> itemList = new ArrayList<>();
    private final String categoryName;

    Print print = new Print();

    // 카테고리 이름 주입
    Menu(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    // Setter
    public void setItem(MenuItem m) {
        this.itemList.add(m);
    }

    public void showItem() {
        print.printMenuItemList(itemList, this.categoryName);
    }

    // Getter
    public List<MenuItem> getItemList() {
        return this.itemList;
    }

    // Getter
    public MenuItem getItem(int menuChoice) {
        return itemList.get(menuChoice - 1);
    }
}

