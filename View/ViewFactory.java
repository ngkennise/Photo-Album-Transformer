package View;

import java.io.OutputStream;

import Model.IShapePhotoAlbumModel;

public class ViewFactory {

  public static IView createView(String viewType, String out, Integer xMax, Integer yMax, int dimension1, int dimension2) {
    switch (viewType) {
      case "web":
        return new WebView(out, xMax, yMax);
      case "graphical":
        return new GraphicalView(dimension1, dimension2);
    }
    throw new IllegalArgumentException("Wrong argument!");
  }
}
