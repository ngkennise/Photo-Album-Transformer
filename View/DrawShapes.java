package View;

import java.awt.*;
import java.util.List;

import javax.swing.*;

import Model.IShape;

public class DrawShapes extends JPanel {

  private List<IShape> shapes = null;

  public DrawShapes() {
    super();
  }

  @Override
  public void paintComponent(Graphics graphics) throws NullPointerException {
    if (graphics == null) {
      throw new NullPointerException("Graphics cannot be null!");
    }

    super.paintComponent(graphics);

    if (this.shapes != null) {

      Graphics2D graphics2D = (Graphics2D) graphics;
      for (IShape shape : this.shapes) {
//        System.out.println(shapes);
        graphics2D.setColor(new Color(shape.getColor().getRed(),
                shape.getColor().getGreen(), shape.getColor().getBlue()));

        if (shape.getType().equalsIgnoreCase("oval")) {
          graphics2D.fillOval((int) shape.getPosition().getX(), (int) shape.getPosition().getY()
                  , (int) shape.getWidth(), (int) shape.getHeight());

        } else if (shape.getType().equalsIgnoreCase("rectangle")) {
          graphics2D.fillRect((int) shape.getPosition().getX(), (int) shape.getPosition().getY()
                  , (int) shape.getWidth(), (int) shape.getHeight());
        }
      }
    }
  }

  public void draw(List<IShape> shapes) {
    this.shapes = shapes;
    this.repaint();
  }
}
