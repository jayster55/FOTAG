package com.Toolbar.ToolbarComponents.ClearImagesButton;

import javax.swing.*;

import com.Application.Application;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.Gallery.Gallery.pictures;

public class ClearImagesButton extends JButton {

    public ClearImagesButton(Application app) {
        this.setText("Clear All Images");
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pictures.clear();
                app.refreshGallery();
            }
        });
    }
}
