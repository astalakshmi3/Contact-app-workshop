package astalakshmi.example.exception;

public class ExceptionHandler {
    private ExceptionHandler() {
    }
    public static String handleException(Exception e) {
        return  e.getMessage();
    }
}
