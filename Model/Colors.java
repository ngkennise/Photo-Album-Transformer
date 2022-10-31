package Model;

/**
 * The type Colors.
 */
public class Colors {
  private int red;
  private int green;
  private int blue;

  /**
   * Instantiates a new Colors.
   *
   * @param red   the red
   * @param green the green
   * @param blue  the blue
   */
  public Colors(int red, int green, int blue) {
    if (red < 0 || red > 255 || green < 0 || green > 255 || blue < 0 || blue > 255)
      throw new IllegalArgumentException("Colors are out of bounds!");

    this.red = red;
    this.green = green;
    this.blue = blue;
  }

  /**
   * Sets red.
   *
   * @param red the red
   */
  public void setRed(int red) {
    this.red = red;
  }

  /**
   * Sets blue.
   *
   * @param blue the blue
   */
  public void setBlue(int blue) {
    this.blue = blue;
  }

  /**
   * Sets green.
   *
   * @param green the green
   */
  public void setGreen(int green) {
    this.green = green;
  }

  /**
   * Gets blue.
   *
   * @return the blue
   */
  public int getBlue() {
    return blue;
  }

  /**
   * Gets green.
   *
   * @return the green
   */
  public int getGreen() {
    return green;
  }

  /**
   * Gets red.
   *
   * @return the red
   */
  public int getRed() {
    return red;
  }

  @Override
  public String toString() {
    return "(" + this.red + ", " + this.green + ", " + this.blue + ")";
  }
}
