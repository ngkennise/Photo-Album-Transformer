package PhotoAlbumMain;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


import Controller.ReadingFile;
import Controller.ViewController;
import Model.IShapePhotoAlbumModel;
import Model.PhotoAlbumModel;
import View.IView;
import View.ViewFactory;

public class PhotoAlbumMain {
  private final static Integer  XMAX = 1000;
  private final static Integer  YMAX = 1000;
  private final static Integer  DIMENSION1 = 1000;
  private final static Integer  DIMENSION2 = 1000;

  public static void main(String[] args) throws IOException {
    IShapePhotoAlbumModel model = new PhotoAlbumModel();
    IView view;
    String in = ""; //file name
    String viewType = ""; //svg, swing
    String out = ""; // the out file

    //read the input file , info about shapes
    for (int i = 0; i < args.length; i++) {
      if (args[i].equalsIgnoreCase("-in")) {
        in = args[i + 1];

        String CurrDir = System.getProperty("user.dir"); //current directory
        CurrDir += "/src/" + in;

        InputStream inputStream = new FileInputStream(CurrDir);
        model = ReadingFile.readFile(new InputStreamReader(inputStream), model);

      } else if (args[i].equalsIgnoreCase("-view") || args[i].equalsIgnoreCase("-v")) {
        viewType = args[i + 1];
      }

      // reads output file path
      else if (args[i].equalsIgnoreCase("-out")) {
        out = args[i + 1];
      }
    }
    // if file name or view not be specified
    if (in.equals("")) {
      throw new IllegalArgumentException("in cannot be empty!");
    }

    if (viewType.equals("")) {
      throw new IllegalArgumentException("viewType cannot be empty!");
    }

    view = ViewFactory.createView(viewType, out, XMAX, YMAX, DIMENSION1, DIMENSION2); //ask factory to make a view according to the view type
    ViewController controller = new ViewController(model, view); //calling controller to link model and view
    controller.start();
  }
}






