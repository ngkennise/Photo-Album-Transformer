package Model;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * The type Photo album model.
 */
public class PhotoAlbumModel implements IShapePhotoAlbumModel {

  //private final PhotoAlbumModel INSTANCE = new PhotoAlbumModel();
  private final LinkedHashMap<String, IShape> shapesList = new LinkedHashMap<>();
  //private final List<Snapshot> snapshots = new ArrayList<>();
  private final Map<String, Snapshot> listOfSnaps = new HashMap<>();
  private final List<String> commands =  new ArrayList<>();

  /**
   * Instantiates a new Photo album model.
   */
  public PhotoAlbumModel() {

  }

//  public PhotoAlbumModel getModel() {
//    return this;
//  }

  public List<IShape> getShapesList() {
    return new ArrayList<>(shapesList.values());
  }

  @Override
  public void addShape(String name, String type, double x, double y, double xDimension, double yDimension, int red, int green, int blue) {
    if (shapesList.containsKey(name)) {
      throw new IllegalArgumentException("Name already exist!");
    }
    Colors colors = new Colors(red, green, blue);
    IShape shape = FactoryShape.createShape(name, type, x, y, xDimension, yDimension, colors);
    shapesList.put(name, shape);

    if (type.equalsIgnoreCase("Oval")) {
      commands.add("Create " + type.toLowerCase() + " " + name + " with center at (" + x + "," + y + ")"
              + "," + " radius " + xDimension + " and " + yDimension + "\n");
    }

    if (type.equalsIgnoreCase("Rectangle")) {
      commands.add("Create " + type.toLowerCase() + " " + name + " with corner at (" + x + "," + y + ")"
              + "," + " width " + xDimension + " and" + " height " + yDimension + "\n");
    }
  }

  public List<String> getCommands() {
    return commands.stream().collect(Collectors.toUnmodifiableList());
    }

  @Override
  public void removeShape(String name) {
    if (!shapesList.containsKey(name)) {
      throw new IllegalArgumentException("Shape does not exist in the list!");
    }
    shapesList.remove(name);
    commands.add(name + " has been removed!");
  }

  @Override
  public void resizeShape(String name, double newXDimension, double newYDimension) {
    if (!shapesList.containsKey(name)) {
      throw new IllegalArgumentException("Shape does not exist in the list!");
    }
    commands.add(name + " changes x dimension from " + shapesList.get(name).getWidth() + " to " + newXDimension);
    commands.add(name + " changes y dimension from " + shapesList.get(name).getHeight() + " to " + newYDimension);
    shapesList.get(name).resize(newXDimension, newYDimension);
  }

  @Override
  public void changeColor(String name, int red, int green, int blue) {
    Colors newColor = new Colors(red, green, blue);
    if (!shapesList.containsKey(name)) {
      throw new IllegalArgumentException("Shape does not exist in the list!");
    }
    commands.add(name + " change color from " + shapesList.get(name).getColor() + " to " + newColor);
    shapesList.get(name).changeColor(newColor);
  }

  @Override
  public void changePosition(String name, double newX, double newY) {
    if (!shapesList.containsKey(name)) {
      throw new IllegalArgumentException("Shape does not exist in the list!");
    }
    commands.add(name + "change position from" + shapesList.get(name).getPosition() + " to (" + newX + "," + newY + ")");
    shapesList.get(name).move(new Point2D(newX, newY));
  }

  @Override
  public Snapshot getSnapshot(String ID) {
    if (!listOfSnaps.containsKey(ID)) {
      throw new IllegalArgumentException("Snapshot does not exist!");
    }
    return listOfSnaps.get(ID).copy();

//    for (Snapshot s : snapshots) {
//      if (s.getID() == ID) {
//        return s.copy();
//      }
//    }
//    return null;
// iterate snapshot list (for , snapshot.get id , return a copy)
  }

  public List<Snapshot> getSnapshots() {

    List<Snapshot> copyList = new ArrayList<>();
    //List<Snapshot> mapValue = new ArrayList<>(listOfSnaps.values());
    for (Snapshot s : listOfSnaps.values()) {
      copyList.add(s.copy());
      copyList.sort((Snapshot s1, Snapshot s2) -> s1.getID().compareTo(s2.getID()));
    }
    return copyList;
  }
      //create copy of the list, return the copy list
      //return snapshots;

  @Override
  public void takeSnapshot(String description) {
    //create a snapshot, and add to snapshots list
    List<IShape> copyShapes = new ArrayList<>();
    for (IShape s : shapesList.values()) {
      copyShapes.add(s.copy());
    //  copyShapes.sort((IShape s1, IShape s2) -> s1.get.compareTo(s2.getType()));
    }
    commands.add("Take a snapshot");

    Snapshot a = new Snapshot(copyShapes, description);
    listOfSnaps.put(a.getID(), a);
  }

  @Override
  public void resetAlbum() {
    commands.add("Album and Snapshots have been reset!");

    shapesList.clear();
    listOfSnaps.clear();
  }

//
// setters , getters, (shapes, color, position, snapshot, commands)

//ICommand interface move, remove, resize, change color
//move class
//remove class, all need their own individual class!
// have a new Command package

// not overlapping - visual of the shapes
}