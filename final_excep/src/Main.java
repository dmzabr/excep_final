import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        start();
    }

    public static void start() {
        try {
            UserDataInput userDataInput = new UserDataInput();
            userDataInput.inputData();
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода: " + e.getMessage());
        } catch (InvalidDataLengthException | InvalidDataFormatException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

}
