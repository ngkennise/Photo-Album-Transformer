package View;

import java.io.IOException;
import java.util.List;

import Model.IShape;
import Model.IShapePhotoAlbumModel;
import Model.Snapshot;

public interface IView {

  String getViewType();
  void render(List<Snapshot> snapshots);
  //method render(start to create a web or swing) -> run the program (List<Snapshots> Snapshots)
  // create a factory for view
}
