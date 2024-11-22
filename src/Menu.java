import java.util.List;
import java.util.ArrayList;
import java.util.stream.IntStream;

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
        MenuItem m = itemList.get(menuChoice-1);
        System.out.println("선택한 메뉴: "+m.getName()+" | W "+m.getPrice()+" | "+m.getExp());
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인\t 2. 취소");
        int wannaAdd = choice.menuNumber();

        if(wannaAdd==1){
            System.out.println(m.getName()+" 이 장바구니에 추가되었습니다.");
            return m;
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

