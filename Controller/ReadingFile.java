package Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import Model.IShapePhotoAlbumModel;
import Model.PhotoAlbumModel;
import Model.Snapshot;

public class ReadingFile {

  public static IShapePhotoAlbumModel readFile(Readable readable, IShapePhotoAlbumModel model) {

    List<Snapshot> snapshots = new ArrayList<>();
    Scanner s = new Scanner(readable);
    // Split at new line, ignoring the # comment lines
    s.useDelimiter(Pattern.compile("(\\n+|#.*)+"));
    while (s.hasNext()) {
      String line = s.next();
//      Scanner wordScanner = new Scanner(line);
//      String word = wordScanner.next();

      // word stores the first word
      //
      String[] strArray = line.split("\\p{Space}");
      List<String> list = Arrays.stream(strArray).filter(element -> !element.isEmpty()).collect(Collectors.toUnmodifiableList());

      if (list.get(0).equalsIgnoreCase("shape")) {
        double x = Double.parseDouble(list.get(3));
        double y = Double.parseDouble(list.get(4));
        double xDimension = Double.parseDouble(list.get(5));
        double yDimension = Double.parseDouble(list.get(6));
        int red = Integer.parseInt(list.get(7));
        int green = Integer.parseInt(list.get(8));
        int blue = Integer.parseInt(list.get(9));

        //snapshots.add(model.takeSnapshot());
        model.addShape(list.get(1), list.get(2), x, y, xDimension, yDimension, red, green, blue);

      } else if (list.get(0).equalsIgnoreCase("remove")) {
        model.removeShape(list.get(1));

      } else if (list.get(0).equalsIgnoreCase("resize")) {
        double xDimension = Double.parseDouble(list.get(2));
        double yDimension = Double.parseDouble(list.get(3));

        model.resizeShape(list.get(1), xDimension, yDimension);

      } else if (list.get(0).equalsIgnoreCase("color")) {
        int red = Integer.parseInt(list.get(2));
        int green = Integer.parseInt(list.get(3));
        int blue = Integer.parseInt(list.get(4));
        model.changeColor(list.get(1), red, green, blue);

      } else if (list.get(0).equalsIgnoreCase("move")) {
        Double x = Double.parseDouble(list.get(2));
        Double y = Double.parseDouble(list.get(3));

        model.changePosition(list.get(1), x, y);

      } else if (list.get(0).equalsIgnoreCase("snapShot")) {
        String str = "";
        for (int i = 1; i < list.size(); i++) {
          str += list.get(i) + " ";
        }
        model.takeSnapshot(str);
      }
      //word.split("\n", 1);
      //word.split(); // put string into array, index
      //split word into array, if first word == shape, create shape, pass in the model into this file
      //model.create shape
    }
    return model;
  }
}
