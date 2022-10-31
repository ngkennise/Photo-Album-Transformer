package Model;

/**
 * The type Point 2 d.
 */
public class Point2D {

  private double x;
  private double y;

  /**
   * Instantiates a new Point 2 d.
   *
   * @param x the x
   * @param y the y
   */
  public Point2D(double x, double y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Gets x.
   *
   * @return the x
   */
  public double getX() {
    return this.x;
  }

  /**
   * Gets y.
   *
   * @return the y
   */
  public double getY() {
    return this.y;
  }

  @Override
  public String toString() {
    return "(" + this.x + ", " + this.y + ")";

  }
}
