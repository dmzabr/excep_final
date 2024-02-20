import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;


public class UserDataInput {

    public void inputData() throws IOException, InvalidDataLengthException, InvalidDataFormatException {
        Scanner scanner = new Scanner(System.in);
        String input;
        String[] data;

        do {
            System.out.println("Введите данные (Фамилия Имя Отчество датарождения номертелефона(без +7) пол), или введите 'exit' для выхода:");
            input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Выход из программы...");
                return; // Завершаем метод и программу
            }

            data = input.split("\\s+");

            try {
                if (data.length != 6) {
                    throw new InvalidDataLengthException("Неверное количество данных. Пожалуйста, введите все данные в требуемом формате.");
                }

                String lastName = data[0];
                String firstName = data[1];
                String middleName = data[2];
                String dob = data[3];
                String phoneNumber = data[4];
                char gender = data[5].charAt(0);

                // Проверка формата даты рождения
                if (!dob.matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
                    throw new InvalidDataFormatException("Неверный формат даты рождения. Используйте формат dd.mm.yyyy.");
                }

                // Проверка формата номера телефона
                if (!phoneNumber.matches("\\d{10}")) {
                    throw new InvalidDataFormatException("Неверный формат номера телефона. Номер должен состоять из 10 цифр.");
                }

                // Проверка пола
                if (gender != 'f' && gender != 'm') {
                    throw new InvalidDataFormatException("Неверное значение пола. Используйте 'f' для женщины и 'm' для мужчины.");
                }

                // Создание строки для записи в файл
                String userDataString = lastName + " " + firstName + " " + middleName + " " + dob + " " + phoneNumber + " " + gender + "\n";

                // Запись данных в файл
                FileWriter fileWriter = new FileWriter(lastName + ".txt", true); // добавляем в файл, если он уже существует
                fileWriter.write(userDataString);
                fileWriter.close();

                System.out.println("Данные успешно записаны в файл " + lastName + ".txt");
            } catch (InvalidDataLengthException | InvalidDataFormatException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        } while (data.length != 6);
    }
}