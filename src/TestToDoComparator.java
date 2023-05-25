import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TestToDoComparator {

  @Test

  public void TestCompare() throws ParseException {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Item item1 = new Item("Задача 1", dateFormat.parse("2023-05-30"));
    Item item2 = new Item("Задача 2", dateFormat.parse("2023-05-25"));
    Item item3 = new Item("Задача 3", dateFormat.parse("2023-06-02"));
    ToDoList toDoList = new ToDoList();
    toDoList.addItem(item1);
    toDoList.addItem(item2);
    toDoList.addItem(item3);
    Assertions.assertEquals(3, toDoList.getItems().size());
    Assertions.assertEquals(item1, toDoList.getItems().get(0));
    Assertions.assertEquals(item2, toDoList.getItems().get(1));
    Assertions.assertEquals(item3, toDoList.getItems().get(2));
    toDoList.removeItemByNumber(2);

    Assertions.assertEquals(2, toDoList.getItems().size());
    Assertions.assertEquals(item2, toDoList.getItems().get(0));
    Assertions.assertEquals(item3, toDoList.getItems().get(1));
    toDoList.sortItemsByDate();

    Assertions.assertEquals(item2, toDoList.getItems().get(0));
    Assertions.assertEquals(item1, toDoList.getItems().get(1));
    Assertions.assertEquals(item3, toDoList.getItems().get(2));

    String filePath = "todo.txt";
    toDoList.saveItemsToFile(filePath);

    ToDoList loadedList = new ToDoList();
    loadedList.loadItemsFromFile(filePath);

    Assertions.assertEquals(3, loadedList.getItems().size());
    Assertions.assertEquals(item1.getDescription(), loadedList.getItems().get(0).getDescription());
    Assertions.assertEquals(item1.getDate(), loadedList.getItems().get(0).getDate());
    Assertions.assertEquals(item2.getDescription(), loadedList.getItems().get(1).getDescription());
    Assertions.assertEquals(item2.getDate(), loadedList.getItems().get(1).getDate());
    Assertions.assertEquals(item3.getDescription(), loadedList.getItems().get(2).getDescription());
    Assertions.assertEquals(item3.getDate(), loadedList.getItems().get(2).getDate());


  }
}
