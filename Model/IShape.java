package Model;

/**
 * The interface Shape.
 */
public interface IShape {

  /**
   * Gets type.
   *
   * @return the type
   */
  String getType();

  /**
   * Gets name.
   *
   * @return the name
   */
  String getName();

  /**
   * Gets color.
   *
   * @return the color
   */
  Colors getColor();

  /**
   * Change color.
   *
   * @param color the color
   */
  void changeColor(Colors color);

  /**
   * Move.
   *
   * @param newPosition the new position
   */
  void move(Point2D newPosition);

  /**
   * Resize.
   *
   * @param size1 the size 1
   * @param size2 the size 2
   */
  void resize(double size1, double size2);

  double getWidth();
  double getHeight();

  /**
   * Gets position.
   *
   * @return the position
   */
  Point2D getPosition();

  /**
   * Copy shape.
   *
   * @return the shape
   */
  IShape copy();

  String toSVG();
}
