package Challenge.Exception;

public class InvalidMenuSelectionException extends IllegalArgumentException {

    // 유효하지 않은 번호 예외 처리
    public InvalidMenuSelectionException() {
        super("유효하지 않은 입력 입니다.");
    }
}
