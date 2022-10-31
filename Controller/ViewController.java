package Controller;

import Model.IShapePhotoAlbumModel;
import Model.PhotoAlbumModel;
import View.IView;

public class ViewController {
  IShapePhotoAlbumModel model = new PhotoAlbumModel();
  IView view;

  public ViewController(IShapePhotoAlbumModel model, IView view) {
    this.model = model;
    this.view = view;
  }

  public void start() {
    String viewType = this.view.getViewType();

    if (viewType.equalsIgnoreCase("web")) {
      view.render(model.getSnapshots());
    }

    if (viewType.equalsIgnoreCase("graphical")) {
      view.render(model.getSnapshots());
    }


  }
}
