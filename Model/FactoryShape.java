package Model;

/**
 * The class type Factory shape.
 */
public class FactoryShape {

  /**
   * Create shape.
   *
   * @param name       the name
   * @param type       the type
   * @param x          the x
   * @param y          the y
   * @param xDimension the x dimension
   * @param yDimension the y dimension
   * @param colors     the colors
   * @return the shape
   */
  public static IShape createShape(String name, String type, double x, double y, double xDimension, double yDimension, Colors colors) {
    Point2D center = new Point2D(x, y);
    if (type.equalsIgnoreCase("Oval")) {
      return new Oval(colors, name, center, xDimension, yDimension);
    }
    if (type.equalsIgnoreCase("Rectangle")) {
      return new Rectangle(colors, name, new Point2D(x,y), xDimension, yDimension);
    }
    return null;
  }
}

    //if rectangle
    //if neither, return null
    //ignoreequals case


