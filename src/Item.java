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
    return "=== Задача ===" +
        "\nОписание: " + description +
        "\nДата: " + ((date != null) ? date.toString() : "Не задана") +
        "\n";
  }

}
