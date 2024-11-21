import java.util.List;
import java.util.ArrayList;
public class Menu {
    private final List<MenuItem> itemList = new ArrayList<>();
    private final String categoryName;

    InputMenu choice = new InputMenu();

    Menu(String categoryName){
        this.categoryName = categoryName;
    }


    public String getCategoryName() {
        return categoryName;
    }

    public void setItem(MenuItem m){
        this.itemList.add(m);
    }

    public int showItem(){
        System.out.println("[ "+this.categoryName.toUpperCase()+" MENU ]");
        for(int i=0; i<itemList.size(); i++){
            MenuItem m = itemList.get(i);
            System.out.println((i+1)+". "+m.getName()+"\t"+"| W "+m.getPrice()+" | "+m.getExp());
        }
        System.out.println("0. 뒤로가기");
        int num = choice.menuNumber();
        if(num==0){
            return -1;
        }
        return num;
    }

    public void getItem(int choice){
        MenuItem m = itemList.get(choice-1);
        System.out.println("선택한 메뉴: "+m.getName()+" | W "+m.getPrice()+" | "+m.getExp());
    }
}

