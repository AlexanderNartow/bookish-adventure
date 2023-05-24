import java.util.Date;

public class Item {

  private Date date;
  private String description;

  public Item(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
