import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

class ToDoList {

  private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
  private final List<Item> items;

  public ToDoList() {
    items = new ArrayList<>();
  }

  public void addItem(Item item) {
    items.add(item);
  }

  public List<Item> getItems() {
    return items;
  }

  public void removeItem(Item item) {
    items.remove(item);
  }

  public void printItems() {
    System.out.println("Список дел:");
    for (int i = 0; i < items.size(); i++) {
      Item item = items.get(i);
      System.out.println((i + 1) + ". " + item);
    }
  }

  public void saveItemsToFile(String filePath) {
    try (FileWriter writer = new FileWriter(filePath)) {
      for (Item item : items) {
        writer.write(item.getDescription() + "|" + dateFormat.format(item.getDate()) + "\n");
      }
      writer.close();
      System.out.println("Список задач сохранен в файл: " + Main.FILE_PATH);
    } catch (IOException e) {
      System.out.println("Ошибка при сохранении списка в файл.");
    }
  }

  public void loadItemsFromFile(String filePath) {
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      String line;
      items.clear();

      while ((line = reader.readLine()) != null) {
        String[] parts = line.split("\\|");
        if (parts.length == 2) {
          String description = parts[0];
          Date date = null;
          try {
            date = dateFormat.parse(parts[1]);
          } catch (ParseException e) {
            System.out.println("Некоректный формат даты в файле");
          }
          Item item = new Item(description, date);
          items.add(item);

        }
      }
      System.out.println("Список задач загружен из файла: " + Main.FILE_PATH);
      printItems();
    } catch (IOException e) {
      System.out.println("Ошибка при загрузке списка из файла.");
    }
  }

  public void removeItemByNumber(int itemNumber) {
    if (itemNumber >= 1 && itemNumber <= items.size()) {
      Item item = items.get(itemNumber - 1);
      items.remove(item);
      System.out.println("Задача удалена.");
    } else {
      System.out.println("Некорректный номер задачи.");
    }

  }

  public void sortItemsByDate() {
    Collections.sort(items, new ToDoComparator());
    {

    }

  }
}