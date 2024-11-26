package Challenge;

public class InvalidMenuSelectionException extends IllegalArgumentException {
    public InvalidMenuSelectionException() {
        super("유효하지 않은 입력 입니다.");
    }
}
