import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ToDoList {

  private List<Item> items;

  public ToDoList() {
    items = new ArrayList<>();
  }

  public void addItem(Item item) {
    items.add(item);
  }

  public void removeItem(Item item) {
    items.remove(item);
  }


  public void printItems() {
    System.out.println("Список дел:");
    for (int i = 0; i < items.size(); i++) {
      Item item = items.get(i);
      System.out.println((i + 1) + ". " + item.getDescription());
    }
  }

  public void saveItemToFile(String filename) {
    try (FileWriter writer = new FileWriter(filename)) {
      for (Item item : items) {
        writer.write(item.getDescription() + "\n");

      }
      System.out.println("список задач сохранен с в списке задач: " + filename);
    } catch (IOException e) {
      System.out.println("ощибка в сохранении списка в файл");
    }
  }

  public void removeItemByNumber(int itemNumber) {
    if (itemNumber >= 1 && itemNumber <= items.size()) {
      Item item = items.get(itemNumber - 1);
      items.remove(item);
      System.out.println("Задача удалена");
    } else {
      System.out.println("Не корректный ввод");
    }
  }
}
