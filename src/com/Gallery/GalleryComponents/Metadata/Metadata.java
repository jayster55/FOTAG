package com.Gallery.GalleryComponents.Metadata;

import com.Gallery.GalleryComponents.RatingButton.RatingButton;

import javax.swing.*;

public class Metadata extends JPanel {

    public Metadata(String fileName, String fileDate, int rating, int dimensions) {

        JLabel imageName = new JLabel(fileName.substring(fileName.lastIndexOf('/') + 1));
        JLabel imageDate = new JLabel(fileDate);

        RatingButton ratingButton = new RatingButton(rating, fileName);
        ratingButton.setSize(dimensions,dimensions);

        this.add(imageName);
        this.add(imageDate);
        this.add(ratingButton);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }
}
