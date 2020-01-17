package com.Gallery.GalleryComponents.RatingButton;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.Gallery.Gallery.pictures;
import static com.Utils.Utils.scaleImage;


public class RatingButton extends JButton {

    public int pictureRating;
    private ImageIcon ratingImg;
    private String picturePath;

    private String getRating(int rating) {
        switch (rating) {
            case 0:
                return "out/src/img/resources/Stars 1.png";
            case 1:
                return "out/src/img/resources/Stars 2.png";
            case 2:
                return "out/src/img/resources/Stars 3.png";
            case 3:
                return "out/src/img/resources/Stars 4.png";
            case 4:
                return "out/src/img/resources/Stars 5.png";
            case 5:
                return "out/src/img/resources/Stars 6.png";
            default:
                return "";
        }
    }

    private void changeRating() {
        if (this.pictureRating <= 4) this.pictureRating += 1;
        else this.pictureRating = 0;
        this.ratingImg = new ImageIcon(getRating(this.pictureRating));
        this.ratingImg = scaleImage(this.ratingImg, 100, 100);
        this.setIcon(this.ratingImg);
        if (!this.picturePath.equals("FILTERBUTTON")) {
            pictures.put(this.picturePath, this.pictureRating);
        }
    }

    public RatingButton(int rating, String filePath) {
        this.picturePath = filePath;
        this.pictureRating = rating;
        this.ratingImg = new ImageIcon(getRating(rating));
        this.ratingImg = scaleImage(this.ratingImg, 100, 100);
        this.setIcon(this.ratingImg);
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeRating();
            }
        });
        this.setSize(100,100);
    }
}
