package Model;

/**
 * The type Oval.
 */
public class Oval extends AbstractShape {
  private Point2D center;
  private double xRadius;
  private double yRadius;

  /**
   * Instantiates a new Oval.
   *
   * @param color   the color
   * @param name    the name
   * @param center  the center
   * @param xRadius the x radius
   * @param yRadius the y radius
   */
  public Oval(Colors color, String name, Point2D center, double xRadius, double yRadius) {
    super(color, name);

    if (name == null || name == "") {
      throw new IllegalArgumentException("Name cannot be null or empty");
    }

    if (color == null) {
      throw new IllegalArgumentException("Color cannot be null");
    }

    if (xRadius < 0 || yRadius < 0) {
      throw new IllegalArgumentException("xRadius or yRadius cannot be negative");
    }

    this.center = center;
    this.xRadius = xRadius;
    this.yRadius = yRadius;
  }

  @Override
  public String getType() {
    return "OVAL";
  }

  @Override
  public void changeColor(Colors color) {
    this.setColor(color);

  }

  @Override
  public void move(Point2D newPosition) {
    this.center = newPosition;
  }

  @Override
  public void resize(double newX, double newY) {
    this.xRadius = newX;
    this.yRadius = newY;

  }

  @Override
  public double getWidth() {
    return xRadius;
  }

  @Override
  public double getHeight() {
    return yRadius;
  }

  @Override
  public Point2D getPosition() {
    return center;
  }

  @Override
  public String toString() {
    return "Name: " + this.name +"\n"
            + "Type: " + this.getType().toLowerCase() +"\n"
            + "Center: " + this.center + ", X Radius: " + xRadius + ", Y Radius: " + yRadius
            +", Color: " + this.color + "\n";
  }

  @Override
  public IShape copy() {
    return new Oval(this.color, this.name, this.center, this.xRadius, this.yRadius);
  }

  @Override
  public String toSVG() {
    String str = String.format("<ellipse id=\"%s\" cx=\"%d\" cy=\"%d\" rx=\"%d\" ry=\"%d\" ",
            name, (int) center.getX(), (int) center.getY(), (int) xRadius, (int) yRadius);
    str = str + String.format("fill=\"rgb(%d,%d,%d)\" visibility=\"visible\"/>",
            color.getRed(), color.getGreen(), color.getBlue());
    return str;
  }

}
