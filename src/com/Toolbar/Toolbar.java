package com.Toolbar;

import com.Application.Application;
import com.FileChooserComponents.FileChooser.FileChooser;
import com.Toolbar.ToolbarComponents.ClearImagesButton.ClearImagesButton;
import com.Toolbar.ToolbarComponents.RatingFilter.RatingFilter;
import com.Toolbar.ToolbarComponents.ViewChange.ViewChange;

import javax.swing.*;
import java.awt.*;

import static com.Utils.Utils.scaleImage;

public class Toolbar extends JPanel {

    public Toolbar(Application app) {
        // Setting up logo
        ImageIcon logo = new ImageIcon("out/src/img/resources/Fotag.png");
        logo = scaleImage(logo, 344, 100);
        JLabel logoLabel = new JLabel();
        logoLabel.setIcon(logo);
        JPanel logoPanel = new JPanel();
        logoPanel.add(logoLabel);

        ViewChange viewChange = new ViewChange(app);
        viewChange.setSize(10,10);

        GridBagConstraints c = new GridBagConstraints();
        this.setLayout(new GridBagLayout());

        c.fill = GridBagConstraints.VERTICAL;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.weighty = 0.5;
        c.ipady = 1;
        c.gridx = 0;
        c.gridy = 0;

        this.add(logoLabel, c);


        c.fill = GridBagConstraints.VERTICAL;
        c.anchor = GridBagConstraints.LINE_START;
        c.weighty = 0.5;
        c.ipady = 0;
        c.weightx = 10;
        c.gridx = 0;
        c.gridy = 1;


        this.add(viewChange, c);

        RatingFilter ratingFilter = new RatingFilter(app);

        c.fill = GridBagConstraints.VERTICAL;
        c.anchor = GridBagConstraints.LINE_END;
        c.weighty = 0.5;
        c.ipady = 0;
        c.weightx = 10;
        c.gridx = 2;
        c.gridy = 2;

        this.add(ratingFilter, c);

        FileChooser uploadButton = new FileChooser(app);

        c.fill = GridBagConstraints.VERTICAL;
        c.anchor = GridBagConstraints.LINE_END;
        c.weighty = 0.5;
        c.ipady = 0;
        c.weightx = 10;
        c.gridx = 2;
        c.gridy = 1;

        this.add(uploadButton, c);


        ClearImagesButton clearImages = new ClearImagesButton(app);

        c.fill = GridBagConstraints.VERTICAL;
        c.anchor = GridBagConstraints.LINE_START;
        c.weighty = 0.5;
        c.ipady = 0;
        c.weightx = 10;
        c.gridx = 0;
        c.gridy = 2;

        this.add(clearImages, c);
    }
}
