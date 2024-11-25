import java.util.List;
import java.util.ArrayList;
import java.util.stream.IntStream;

public class Menu {
    private final List<MenuItem> itemList = new ArrayList<>();
    private final String categoryName;

    InputMenu choice = new InputMenu();
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

    public int showItem(){
        System.out.println();
        System.out.println("[ "+this.categoryName.toUpperCase()+" MENU ]");

        IntStream.range(0,itemList.size())
                .forEach(i->{
                    MenuItem m = itemList.get(i);
                    String formatName = String.format("%-20s",m.getName());
                    System.out.println((i+1)+". "+formatName+"| W "+m.getPrice()+" | "+m.getExp());
                });

        System.out.println("0. 뒤로가기");
        int num = choice.menuNumber();
        if(num==0){
            return -1;
        }
        return num;
    }

    public MenuItem getItem(int menuChoice){
        MenuItem selected = itemList.get(menuChoice-1);
        print.printWannaAdd(selected);

        int wannaAdd = choice.menuNumber();

        if(wannaAdd==1){
            System.out.println(selected.getName()+" 이 장바구니에 추가되었습니다.");
            return selected;
        }

        else if(wannaAdd==2){
            System.out.println("취소되었습니다.");
            return null;
        }

        else{
            System.out.println("유효한 번호를 다시 선택해주세요");
            return getItem(menuChoice);
        }

    }
}

