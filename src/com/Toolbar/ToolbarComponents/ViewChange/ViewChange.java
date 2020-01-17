package com.Toolbar.ToolbarComponents.ViewChange;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.Application.Application;

import static com.Utils.Utils.scaleImage;


public class ViewChange extends JPanel {

    private void listView(Application app)
    {
        app.globalLayout = "List";
        app.refreshGallery();
    }

    private void gridView(Application app)
    {
        app.globalLayout = "Grid";
        app.refreshGallery();
    }


    public ViewChange(Application app) {
        // Setting Up Grid Layout Button
        ImageIcon gridLayout = new ImageIcon("out/src/img/resources/Grid Layout.png");
        gridLayout = scaleImage(gridLayout, 50, 50);
        JButton toggleGridLayoutButton = new JButton();
        toggleGridLayoutButton.setSize(25,25);
        toggleGridLayoutButton.setIcon(gridLayout);
        toggleGridLayoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gridView(app);
            }
        });

        // Setting up List Layout Button
        ImageIcon listLayout = new ImageIcon("out/src/img/resources/Flow Layout.png");
        listLayout = scaleImage(listLayout, 50, 50);
        JButton toggleListLayoutButton = new JButton();
        toggleListLayoutButton.setSize(25,25);
        toggleListLayoutButton.setIcon(listLayout);
        toggleListLayoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listView(app);
            }
        });

        this.add(toggleGridLayoutButton);
        this.add(toggleListLayoutButton);
        this.setLayout(new GridLayout(1,2,0, 0));

    }

}
