import java.util.Comparator;
import java.util.Date;

public class ToDoComparator implements Comparator<Item> {

  @Override
  public int compare(Item item1, Item item2) {
    Date date1 = item1.getDate();
    Date date2 = item2.getDate();
    if (date1 == null && date2 == null) {
      return 0;
    } else if (date1 == null) {
      return 1;
    } else if (date2 == null) {
      return -1;
    }
    return date1.compareTo(date2);
  }

}