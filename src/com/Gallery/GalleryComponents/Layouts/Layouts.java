package com.Gallery.GalleryComponents.Layouts;

import com.Application.Application;
import com.Gallery.GalleryComponents.Metadata.Metadata;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static com.Utils.Utils.scaleImage;

public class Layouts {

    static Border blackline = BorderFactory.createLineBorder(Color.black, 4);

    public static class PictureFrame extends JPanel {

        static int pictureDimensions = 200;
        static int frameDimensions = 300;

        public PictureFrame(String filePath, String date, int rating, String layout, Application app) {
            // PICTURE STYLING
            JPanel picturePanel = new JPanel();
            picturePanel.setSize(pictureDimensions,pictureDimensions);
            picturePanel.setBackground(Color.DARK_GRAY);
            ImageIcon picture = new ImageIcon(filePath);
            picture = scaleImage(picture, frameDimensions, frameDimensions);

            Metadata metadata = new Metadata(filePath, date, rating, pictureDimensions);

            JPanel ratingPanel = new JPanel();

            JLabel myPicture = new JLabel();
            myPicture.setIcon(picture);
            myPicture.setBorder(blackline);

            myPicture.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    JOptionPane.showMessageDialog(
                            null,
                            ratingPanel
                    );
                    app.refreshGallery();
                }
            });

            if (layout.equals("Grid")) {
                ratingPanel.setLayout(new BoxLayout(ratingPanel, BoxLayout.Y_AXIS));
                ratingPanel.add(myPicture);
                ratingPanel.add(metadata);
            }
            else {
                ratingPanel.setLayout(new BoxLayout(ratingPanel, BoxLayout.X_AXIS));
                ratingPanel.add(Box.createHorizontalStrut(15));
                ratingPanel.add(myPicture);
                ratingPanel.add(Box.createHorizontalStrut(30));
                ratingPanel.add(metadata);
                this.setLayout(new FlowLayout(FlowLayout.LEFT));
            }

            this.add(ratingPanel);
            this.setVisible(true);
        }

    }

}