package others;

// Непроверяемое исключение:
public class MachineNotAttachedException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Машина не привязана к тросу!";
    }
}
