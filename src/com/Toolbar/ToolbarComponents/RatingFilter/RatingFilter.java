package com.Toolbar.ToolbarComponents.RatingFilter;

import com.Application.Application;
import com.Gallery.GalleryComponents.RatingButton.RatingButton;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class RatingFilter extends JPanel {

    private void updateRatingFilter(int filterNumber, Application app, RatingButton ratingButton) {
        if (filterNumber == -1) {
            app.filterValue = 1;
            app.filtering = true;
        }
        else if (filterNumber == 6) {
            app.filtering = false;
            app.filterValue = -1;
            ratingButton.setText("Filtering: Off");
        } else {

            app.filtering = true;
            app.filterValue = filterNumber;
            ratingButton.setText("Filtering: On");
        }
        app.refreshGallery();
    }

    public RatingFilter(Application app) {

        RatingButton filterButton = new RatingButton(0, "FILTERBUTTON");
        filterButton.setText("Filtering: Off");
        filterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateRatingFilter(filterButton.pictureRating + 1, app, filterButton);
            }
        });

        this.add(filterButton);
    }
}
