package Challenge.Util;

import java.util.Scanner;

public class InputMenu {

    public int menuNumber() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        // 정수형 외 자료형 입력시 예외
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
