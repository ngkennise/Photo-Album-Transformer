package View;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import Model.IShape;
import Model.Snapshot;

public class WebView implements IView {
  List<Snapshot> snapshots;
  private File out;
  private String viewType;
  private Integer xMax;
  private Integer yMax;

  public WebView(String out, Integer xMax, Integer yMax) {
    this.out = new File(out);
    this.viewType = "web";

    if (xMax == null || yMax == null) {
      this.xMax = 1000;
      this.yMax = 1000;
    } else {
      this.xMax = xMax;
      this.yMax = yMax;
    }
  }

  public String getViewType() {
    return this.viewType;
  }

  private String getViewText() { //whatever gets produced here needs to be write to file
    StringBuilder builder = new StringBuilder();

    builder.append("<!DOCTYPE html>\n" +
            "<html>\n" +
            "\n" +
            "\t<head>\n" +
            "\t\t<style>\n" +
            "\t\t  .snapshot {border: 3px solid red; margin-bottom: 20px;}\n" +
            "\t\t  .snap-header {background-color: lightblue;}\n" +
            "\t\t  .snap-ID {margin-top: 0;}\n" +
            "\t\t  .shapes {background-color: lightblue;}\n" +
            "\t\t  .snap-description {margin: 0;}\n" +
            "\t\t</style>\n" +
            "\t</head>\n" +
            "\n" +
            "\t<body>" +
            "\t\t\t\n");

    for (int counter = 1; counter <= snapshots.size(); counter++) {
      Snapshot currentSnap = snapshots.get(counter - 1);

      builder.append("\t\t\t<div id=\"snap" + counter + "\"class=\"snapshot\">\n" +
              "\t\t\t\t<div class=\"snap-top\">\n" +
              "\t\t\t\t\t<h1 class=\"snap-ID\"> " + currentSnap.getID() + "</h1>\n" +
              "\t\t\t\t\t<h2 class=\"snap-description\">" + currentSnap.getDescription() + "</h2>\n" +
              "\t\t\t\t</div>\n");

      List<IShape> shapes = snapshots.get(counter - 1).getShapes();

      builder.append("\n\t\t\t\t<div class=\"shapes\">\n");
      builder.append("\t\t\t\t\t\t<svg width=\"" + xMax + "\" height=\"" + yMax + "\">\n");

      for (int shapenum = 1; shapenum <= shapes.size(); shapenum++) {
        IShape currentShape = shapes.get(shapenum - 1);

        builder.append(
                currentShape.toSVG() +
                "\n");
      }

        builder.append("\n\t\t\t\t\t\t</svg>\n");

      builder.append("\t\t\t\t</div>\n" +
                "\t\t\t</div>\n\n");
    }

    builder.append(
//            "\t\t\t</div>\n" +
            "" +
            "\t</body>\n" +
            "\n" +
            "</html>");

    return builder.toString();
  }

  private void writeToFile(String viewText) {

    try {
      FileWriter f = new FileWriter(out);
      f.write(viewText);
      f.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void render(List<Snapshot> snapshots) { // this is triggered by the controller
    this.snapshots = snapshots;
    this.writeToFile(this.getViewText());  //the view text that is produced, put it in a file
  }
}






