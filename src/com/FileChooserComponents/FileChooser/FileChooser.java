

package com.FileChooserComponents.FileChooser;

import com.Application.Application;
import com.FileChooserComponents.ImageFileView.ImageFileView;
import com.FileChooserComponents.ImageFilter.ImageFilter;
import com.FileChooserComponents.ImagePreview.ImagePreview;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import static com.Gallery.Gallery.pictures;

public class FileChooser extends JButton
        implements ActionListener {
    static private String newline = "\n";
    private JTextArea log;
    private JFileChooser fc;
    private Application application;

    public FileChooser(Application app) {

        application = app;
        this.setText("Upload");
        this.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        //Set up the file chooser.
        if (fc == null) {
            fc = new JFileChooser();

            //Add a custom file filter and disable the default
            //(Accept All) file filter.
            fc.addChoosableFileFilter(new ImageFilter());
            fc.setAcceptAllFileFilterUsed(false);

            //Add custom icons for file types.
            fc.setFileView(new ImageFileView());

            //Add the preview pane.
            fc.setAccessory(new ImagePreview(fc));
        }

        //Show it.
        int returnVal = fc.showDialog(FileChooser.this,
                "Choose");

        //Process the results.
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();

            pictures.put(file.getAbsolutePath(), 0);
            application.refreshGallery();

        } else {
            log.append("Attachment cancelled by user." + newline);
        }
        log.setCaretPosition(log.getDocument().getLength());

        //Reset the file chooser for the next time it's shown.
        fc.setSelectedFile(null);
    }
}
