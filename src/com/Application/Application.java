package com.Application;

import com.Gallery.Gallery;
import com.Toolbar.Toolbar;


import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class Application extends JFrame {


    private JPanel mainPanel;
    private Toolbar toolbar;
    public Gallery gallery;
    private JScrollPane scrollPane;

    public static boolean firstLoad = false;

    public String globalLayout = "Grid";
    public Boolean filtering = false;
    public int filterValue = -1;


    public void refreshGallery() {

        this.gallery.setVisible(false);
        if (filtering) {
            this.gallery = new Gallery(this.globalLayout, this.filterValue, this);
        } else {
            this.gallery = new Gallery(this.globalLayout, -1, this);
        }


        scrollPane.setViewportView(gallery);


        mainPanel.removeAll();
        mainPanel.add(toolbar);
        mainPanel.add(scrollPane);

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        this.add(mainPanel);



//        this.gallery.revalidate();
        this.revalidate();
        this.repaint();

    }

    public Application() {

        mainPanel = new JPanel();

        toolbar = new Toolbar(this);
        toolbar.setSize(1000,100);

        gallery = new Gallery(globalLayout, filterValue, this);

        scrollPane = new JScrollPane();


        scrollPane.setViewportView(gallery);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getVerticalScrollBar().setUnitIncrement(10);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVisible(true);
        scrollPane.setPreferredSize(new Dimension(1000, 1000));
        gallery.setSize(1000,1000);

        mainPanel.add(toolbar);
        mainPanel.add(scrollPane);

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        this.add(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                try {
                    Gallery.onExit();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        this.setMinimumSize(new Dimension(500, 500));
        this.setMaximumSize(new Dimension(screenSize.width, screenSize.height));

        this.setSize(1000, 1000);// 400 width and 500 height
        this.setVisible(true);// making the frame visible

    }
}
