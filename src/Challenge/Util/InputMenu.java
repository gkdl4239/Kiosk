package Challenge.Util;

import java.util.Scanner;

public class InputMenu {

    public int menuNumber() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
