package Model;

/**
 * The type Abstract shape.
 */
public abstract class AbstractShape implements IShape {

  Colors color;
  String name;

  /**
   * Instantiates a new Abstract shape.
   *
   * @param color the color
   * @param name  the name
   */
  public AbstractShape(Colors color, String name) {
    if (name == null || name == "") {
      throw new IllegalArgumentException("Name cannot be null or empty");
    }
    if (color == null) {
      throw new IllegalArgumentException("Color cannot be null");
    }
    this.color = color;
    this.name = name;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public Colors getColor() {
    return this.color;
  }

  /**
   * Sets color.
   *
   * @param color the color
   */
  protected void setColor(Colors color) {
    this.color = color;
  }
}