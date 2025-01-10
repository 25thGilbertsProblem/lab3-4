package others;

// Проверяемое исключение:
public class RopeOverextensionException extends Exception {
    private final int maxLength;

    public RopeOverextensionException(int maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public String getMessage() {
        return "длина троса превысила максимально допустимую в " + maxLength + " метров.";
    }
}
