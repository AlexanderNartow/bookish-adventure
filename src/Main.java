import java.util.Scanner;


public class Main {

  public static void Main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    ToDoList todoList = new ToDoList();
    while (true) {
      System.out.println("1. Добавить задачу");
      System.out.println("2. Удалить задачу");
      System.out.println("3. Вывести список задач");
      System.out.println("4. Сохранить список задач в файл");
      System.out.println("5. Выйти");
      System.out.print("Выберите действие: ");
      int choice = scanner.nextInt();
      scanner.nextLine();
      if (choice == 1) {
        System.out.print("Введите описание задачи: ");
        String description = scanner.nextLine();
        Task task = new Task(description); //TODO
        todoList.addTask(task);
      } else if (choice == 2) {
        System.out.print("Введите номер задачи для удаления: ");
        int taskNumber = scanner.nextInt();
        scanner.nextLine();
        todoList.removeTaskByNumber(taskNumber);
      } else if (choice == 3) {
        todoList.printTasks();
      } else if (choice == 4) {
        System.out.print("Введите имя файла для сохранения списка задач: ");
        String filename = scanner.nextLine();
        todoList.saveTasksToFile(filename);
      } else if (choice == 5) {
        break;
      } else {
        System.out.println("Некорректный выбор.");
      }
    }
  }
}