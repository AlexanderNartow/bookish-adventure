import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.junit.jupiter.api.Test;

class TestToDoComparator {

  @Test

  public void TestCompare() throws ParseException {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Item item1 = new Item("Задача 1", dateFormat.parse("2023-05-30"));
    Item item2 = new Item("Задача 2", dateFormat.parse("2023-05-25"));
    Item item3 = new Item("Задача 3", dateFormat.parse("2023-06-02"));

  }
}
