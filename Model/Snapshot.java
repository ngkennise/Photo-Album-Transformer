package Model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The type Snapshot.
 */
public class Snapshot {

  private final LocalDateTime timestamp;
  private final List<IShape> ListShapes;
  private String description;
  private String ID;

  private Snapshot(List<IShape> ListShapes, Snapshot snapshot) {
    this.ListShapes = ListShapes;
    this.timestamp = snapshot.timestamp;
    this.description = snapshot.description;
  }

  /**
   * Instantiates a new Snapshot.
   *
   * @param ListShapes  the list shapes
   * @param description the description
   */
  public Snapshot(List<IShape> ListShapes, String description) {
    this.timestamp = LocalDateTime.now();
    this.ListShapes = ListShapes;
    this.description = description;
  }

  /**
   * Gets shapes.
   *
   * @return the shapes
   */
  public List<IShape> getShapes() {
    return this.ListShapes;
  }

  /**
   * Gets id.
   *
   * @return the id
   */
  public String getID() {
    return this.timestamp.toString();
  }

  /**
   * Gets time stamp.
   *
   * @return the time stamp
   */
  public String getTimeStamp() {
    String s = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss").format(LocalDateTime.now());

    return s;
  }

  public String getDescription() {
    return this.description;
  }

  @Override
  public String toString() {
    //id, timestamp, description
    String s = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss").format(LocalDateTime.now());

    String str = "";
    for (IShape shapes : ListShapes) {
      str = str + shapes;
    }

    return "Printing Snapshots" +"\n"
            + "Snapshot ID: " + this.timestamp +"\n"
            + "Timestamp: " + s +"\n"
            + "Description: " + this.description +"\n"
            + "Shape Information: " +"\n"
            + str;
  }

  /**
   * Copy snapshot.
   *
   * @return the snapshot
   */
  public Snapshot copy() {
    List<IShape> copyList = new ArrayList<>();
    for (IShape s: ListShapes) {
      copyList.add(s.copy());
    }
    return new Snapshot(copyList, this);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Snapshot snapshot = (Snapshot) o;
    return Objects.equals(timestamp, snapshot.timestamp) && Objects.equals(ListShapes, snapshot.ListShapes) && Objects.equals(description, snapshot.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(timestamp, ListShapes, description);
  }
  // use time to get the timestamp of snap
  //hashcode, equals (see if they're the same snapshot)
}
