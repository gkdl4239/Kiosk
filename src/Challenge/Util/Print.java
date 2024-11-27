package Challenge.Util;

import Challenge.Exception.InvalidMenuSelectionException;
import Challenge.Domain.Menu;
import Challenge.Domain.MenuItem;
import Challenge.Domain.OrderList;

import java.util.List;
import java.util.stream.IntStream;

public class Print {
    public void printMainMenu(List<Menu> menuList) {
        System.out.println();
        System.out.println("[ MAIN MENU ]");
        for (int i = 1; i < menuList.size() + 1; i++) {
            System.out.println(i + ". " + menuList.get(i - 1).getCategoryName());
        }
        System.out.println("0. 종료");
    }

    // 카테고리 메뉴 출력
    public void printMenuItemList(List<MenuItem> itemList, String categoryName) {
        System.out.println();
        System.out.println("[ " + categoryName.toUpperCase() + " MENU ]");

        IntStream.range(0, itemList.size())
                .forEach(i -> {
                    MenuItem m = itemList.get(i);
                    String formatName = String.format("%-20s", m.getName());
                    System.out.println((i + 1) + ". " + formatName + "| W " + m.getPrice() + " | " + m.getExp());
                });

        System.out.println("0. 뒤로가기");
    }

    // ORDER 메뉴 출력
    public void printOrderMenu(int orderNumber) {
        System.out.println();
        System.out.println("[ ORDER MENU ]");
        System.out.println(orderNumber + ". Orders");
        System.out.println((orderNumber + 1) + ". Cancel");
    }

    // 주문 확인 출력
    public void printTotalOrder(OrderList orderList) {
        System.out.println("아래와 같이 주문 하시겠습니까?");
        System.out.println();
        System.out.println("[ Orders ]");

        // 장바구니가 들어있는 리스트에서 차례대로 정보 출력
        IntStream.range(0, orderList.getOrderList().size())
                .forEach(i -> {
                    MenuItem orders = orderList.getOrderList().get(i);
                    String formatName = String.format("%-20s", orders.getName());
                    System.out.println((i + 1) + ". " + formatName + "| W " + orders.getPrice() + " | " + orders.getExp());
                });

        System.out.println();
        System.out.println("[ Total ]");
        System.out.println("W " + orderList.getTotalPrice());

        System.out.println();
        System.out.println("1. 주문  2. 메뉴 추가  3. 메뉴 빼기");
    }

    // 할인 선택
    public void printDiscountChoice() {
        System.out.println();
        System.out.println("할인 정보를 입력해주세요.");
        System.out.println("1. 국가유공자 \t: 20%");
        System.out.println("2. 군인 \t\t\t: 10%");
        System.out.println("3. 학생 \t\t\t: 5%");
        System.out.println("4. 일반 \t\t\t: 0%");
    }

    // 주문 완료 안내
    public void printOrderCompleted(double discountedPrice) {
        System.out.println();
        System.out.println("주문이 완료되었습니다. 금액은 W " + discountedPrice + " 입니다.");
    }

    // 주문 추가 확인
    public void printWannaAdd(MenuItem selected) {
        System.out.println();
        System.out.println("선택한 메뉴: " + selected.getName() + " | W " + selected.getPrice() + " | " + selected.getExp());
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인\t 2. 취소");
    }

    // 메뉴 담기 완료 안내
    public void printAddComplete(MenuItem selectedItem) {
        System.out.println(selectedItem.getName() + " 이 장바구니에 추가되었습니다.");
    }

    // 삭제할 메뉴 번호 요청
    public void printRemoveNumber() {
        System.out.println();
        System.out.println("장바구니에서 삭제할 메뉴의 번호를 입력해주세요(다른 번호의 같은 메뉴도 삭제)");
    }

    // 취소 완료 안내
    public void printCanceled() {
        System.out.println("취소되었습니다.");
    }

    // 장바구니 초기화 안내
    public void printResetOrder() {
        System.out.println("장바구니를 비웠습니다");
    }

    // 예외 안내
    public void printError(InvalidMenuSelectionException e) {
        System.out.println(e.getMessage());
        System.out.println("처음부터 다시 시작해주세요.");
    }

    // 메뉴 추가 확인 안내
    public void printSelectAddition() {
        System.out.println("메뉴 추가를 선택하셨습니다.");
    }
}
