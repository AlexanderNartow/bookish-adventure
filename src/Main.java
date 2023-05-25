import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

  public static final String FILE_PATH = "res/tasks.txt";

  public static void main(String[] args) throws InputMismatchException {
    Scanner scanner = new Scanner(System.in);
    ToDoList todoList = new ToDoList();
    while (true) {
      try {
        System.out.println("1. Добавить задачу");
        System.out.println("2. Удалить задачу");
        System.out.println("3. Вывести список задач");
        System.out.println("4. Сохранить список задач в файл");
        System.out.println("5. Вывести список задач из файла");
        System.out.println("6. Выйти");
        System.out.print("Выберите действие: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == 1) {
          System.out.print("Введите описание задачи: ");
          String description = scanner.nextLine();
          System.out.print("Введите дату задачи (yyyy-MM-dd): ");
          String dateString = scanner.nextLine();
          Date date = null;
          try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            date = dateFormat.parse(dateString);
          } catch (ParseException e) {
            System.out.println("Некорректный формат даты. Используйте формат yyyy-MM-dd.");
          }
          Item item = new Item(description, date);
          todoList.addItem(item);
        } else if (choice == 2) {
          System.out.print("Введите номер задачи для удаления: ");
          int itemNumber = scanner.nextInt();
          scanner.nextLine();
          todoList.removeItemByNumber(itemNumber);
        } else if (choice == 3) {
          todoList.sortItemsByDate();

          todoList.printItems();
        } else if (choice == 4) {
          todoList.saveItemsToFile(FILE_PATH);
        } else if (choice == 5) {
          todoList.loadItemsFromFile(FILE_PATH);
          todoList.sortItemsByDate();
          todoList.printItems();

        } else if (choice == 6) {
          break;
        } else {
          System.out.println("Некорректный выбор.");
        }
      } catch (InputMismatchException e) {
        System.out.println("Некорректный ввод. Введите число от 1 до 6.");
        scanner.nextLine(); // Пропустить некорректный ввод
      }
    }
  }
}