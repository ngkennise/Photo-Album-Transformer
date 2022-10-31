package Model;

import java.util.List;

/**
 * The interface Shape photo album model.
 */
public interface IShapePhotoAlbumModel {

  /**
   * Add shape.
   *
   * @param name       the name
   * @param type       the type
   * @param x          the x
   * @param y          the y
   * @param xDimension the x dimension
   * @param yDimension the y dimension
   * @param red        the red
   * @param green      the green
   * @param blue       the blue
   */
  void addShape(String name, String type, double x, double y, double xDimension, double yDimension, int red, int green, int blue);

  /**
   * Gets shapes list.
   *
   * @return the shapes list
   */
//PhotoAlbumModel getModel();
  List<IShape> getShapesList();

  /**
   * Remove shape.
   *
   * @param name the name
   */
//void changeShape();
  void removeShape(String name);

  /**
   * Resize shape.
   *
   * @param name          the name
   * @param newXDimension the new x dimension
   * @param newYDimension the new y dimension
   */
  void resizeShape(String name, double newXDimension, double newYDimension);

  /**
   * Change color.
   *
   * @param name  the name
   * @param red   the red
   * @param green the green
   * @param blue  the blue
   */
  void changeColor(String name, int red, int green, int blue);

  /**
   * Change position.
   *
   * @param name the name
   * @param newX the new x
   * @param newY the new y
   */
  void changePosition(String name, double newX, double newY);

  /**
   * Gets snapshot.
   *
   * @param ID the id
   * @return the snapshot
   */
  Snapshot getSnapshot(String ID); //return snapshots, return a list of snapshots

  /**
   * Gets snapshots.
   *
   * @return the snapshots
   */
  List<Snapshot> getSnapshots();

  /**
   * Take snapshot.
   *
   * @param description the description
   */
  void takeSnapshot(String description);

  /**
   * Reset album.
   */
  void resetAlbum(); //clear

  /**
   * Gets commands.
   *
   * @return the commands
   */
  List<String> getCommands();
  // addshape, remove shape, change shape, change color, resize shape, get/take snapshot, toString method
  // dimensions means width/height, or radius.

}
