package Model;

/**
 * The type Rectangle.
 */
public class Rectangle extends AbstractShape{

  //left corner bottom
  //point2D(width, double height);

  private Point2D leftCorner;
  private double width;
  private double height;

  /**
   * Instantiates a new Rectangle.
   *
   * @param color      the color
   * @param name       the name
   * @param leftCorner the left corner
   * @param width      the width
   * @param height     the height
   */
  public Rectangle(Colors color, String name, Point2D leftCorner, double width, double height) {
    super(color, name);
    if (name == null || name == "") {
      throw new IllegalArgumentException("Name cannot be null or empty");
    }
    if (width < 0 || height < 0) {
      throw new IllegalArgumentException("Width and Height cannot be null");
    }

    this.leftCorner = leftCorner;
    this.width = width;
    this.height = height;
  }

  @Override
  public String getType() {
    return "Rectangle";
  }

  @Override
  public void changeColor(Colors color) {
    this.setColor(color);
  }

  @Override
  public void move(Point2D newPosition) {
    this.leftCorner = newPosition;

  }

  @Override
  public void resize(double size1, double size2) {
    this.width = size1;
    this.height = size2;
  }

  public double getWidth() {
    return this.width;
  }

  public double getHeight() {
    return this.height;
  }

  @Override
  public Point2D getPosition() {
    return leftCorner;
  }

  @Override
  public String toString() {
    return "Name: " + this.name +"\n"
            + "Type: " + this.getType().toLowerCase() +"\n"
            + "Min corner: " + this.leftCorner + ", Width: " + this.width + ", Height: " + this.height
            + ", Color: " + this.color + "\n";
  }

  @Override
  public IShape copy() {
    return new Rectangle(this.color, this.name, this.leftCorner, this.width, this.height);
  }

  @Override
  public String toSVG() {

    String str = String.format("<rect id=\"%s\" x=\"%d\" y=\"%d\" width=\"%d\" height=\"%d\" "
            ,name, (int) leftCorner.getX(), (int) leftCorner.getY(), (int) width, (int) height);
    str = str + String.format("fill=\"rgb(%d,%d,%d)\" visibility=\"visible\"/>",
            color.getRed(), color.getGreen(), color.getBlue());
    return str;
  }
}
