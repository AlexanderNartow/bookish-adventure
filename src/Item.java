import java.text.SimpleDateFormat;
import java.util.Date;

class Item {

  private Date date;
  private String description;

  public Item(String description, Date date) {
    this.description = description;
    this.date = date;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  @Override
  public String toString() {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String dateString = (date != null) ? dateFormat.format(date) : "Не задана";
    return "Задача: " + description + " | Дата: " + dateString;
  }
}