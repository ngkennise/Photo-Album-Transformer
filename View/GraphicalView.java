package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

import Model.IShapePhotoAlbumModel;
import Model.Snapshot;

public class GraphicalView extends JFrame implements IView, ActionListener {

  private int dimension1;
  private int dimension2;
  private String viewType;
  private JPanel topPanel;
  private JPanel bottomPanel;
  private DrawShapes middlepanel;
  private JButton previous;
  private JButton forward;
  private JButton select;
  private JButton quit;
  private static final int defaultSize = 1000;
  private List<Snapshot> snapshotsList;
  private int currentPosition = 0;
  JLabel getID;
  JLabel getDescription;

  public GraphicalView(Integer dimension1, Integer dimension2) {

    this.viewType = "graphical";
    if (dimension1 == null && dimension2 == null) {
      this.dimension1 = defaultSize;
      this.dimension2 = defaultSize;
    }
    this.dimension1 = dimension1;
    this.dimension2 = dimension2;
  }

  public void create() {
//    JFrame frame = new JFrame();
    this.setTitle("cs5004 Shapes Photo Album Viewer");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    this.setPreferredSize(new Dimension(this.dimension1, this.dimension2));
    this.setSize(this.dimension1, this.dimension2);
    this.setLayout(new BorderLayout());

    this.getContentPane().setBackground(new Color(255, 255, 255));

    topPanel = new JPanel();
    topPanel.setBackground(new Color(220, 203, 220));
    //  topPanel.setBounds(0, 0, 100, 100);

    //the middle part to draw shapes
    middlepanel = new DrawShapes();
    //middlepanel.setPreferredSize(new Dimension(600, 600));
    middlepanel.setBackground(new Color(130, 191, 222));

    bottomPanel = new JPanel();
    bottomPanel.setBackground(new Color(149, 131, 224));

    previous = new JButton("<< Previous <<");
    forward = new JButton(">> Forward >>");
    select = new JButton("^^ Select ^^");
    quit = new JButton("xx Quit xx");

    bottomPanel.add(previous);
    bottomPanel.add(forward);
    bottomPanel.add(select);
    bottomPanel.add(quit);

    previous.addActionListener(this);
    forward.addActionListener(this);
    select.addActionListener(this);
    quit.addActionListener(this);


    this.add(topPanel, BorderLayout.NORTH);
    this.add(bottomPanel, BorderLayout.SOUTH);
    this.add(middlepanel, BorderLayout.CENTER);

    this.setVisible(true);
  }

  @Override
  public String getViewType() {
    return this.viewType;
  }

  public void repaintLabel() {
    String snapID = snapshotsList.get(currentPosition).getID();
    String description = snapshotsList.get(currentPosition).getDescription();

    getID.setText(snapID);
    getDescription.setText(description);

    topPanel.repaint();
    repaint();

  }

  public void render(List<Snapshot> snapshots) {
    create();
    snapshotsList = snapshots;

    String snapID = snapshotsList.get(currentPosition).getID();
    String description = snapshotsList.get(currentPosition).getDescription();

    getID = new JLabel(snapID);
    getDescription = new JLabel(description);

    topPanel.add(getID);
    topPanel.add(getDescription);

    middlepanel.draw((snapshotsList.get(currentPosition).getShapes()));
    this.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == previous) {
      if (currentPosition <= 0) {
        JOptionPane.showMessageDialog(this,
                "There is no previous snapshot!");
      } else {
        currentPosition--;

        repaintLabel();
        middlepanel.draw((snapshotsList.get(currentPosition).getShapes()));

      }
    }

    if (e.getSource() == forward) {
      if (currentPosition >= snapshotsList.size() - 1) {
        JOptionPane.showMessageDialog(this,
                "There is no more snapshots!");
      } else {
        currentPosition++;
        repaintLabel();
        middlepanel.draw((snapshotsList.get(currentPosition).getShapes()));

      }
    }

    if (e.getSource() == select) {

      String[] uniqueID = new String[snapshotsList.size()];
      for (int i = 0; i < snapshotsList.size(); i++) {
        uniqueID[i] = snapshotsList.get(i).getID();
      }

      String s = (String) JOptionPane.showInputDialog(
              this,
              "Select a snapshot that you would like to see: \n" + "",
              "Menu Bar",
              JOptionPane.PLAIN_MESSAGE,
              null,
              uniqueID,
              uniqueID[currentPosition]); // s = unique id, find the specific id in the unique id, and match them


//      int element = Integer.parseInt(uniqueID[currentPosition]);

      for (int i = 0; i < uniqueID.length; i++) {
        if (uniqueID[i].equals(s)) {
          currentPosition = i;
        }
      }

      if ((s != null) && (s.length() > 0)) {

        repaintLabel();
        middlepanel.draw(snapshotsList.get(currentPosition).getShapes());
      }
    }

    if (e.getSource() == quit) {
      JOptionPane.showMessageDialog(this,
              "Are you sure you want to quit?");
      System.exit(1);
    }
  }
}

