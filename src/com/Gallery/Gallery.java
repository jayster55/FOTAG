package com.Gallery;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import com.Application.Application;
import com.Gallery.GalleryComponents.Layouts.Layouts;
import com.Gallery.GalleryComponents.ModifiedFlowLayout.ModifiedFlowLayout;

public class Gallery extends JPanel {

    private static boolean firstLoad = true;

    public static HashMap<String, Integer> pictures = new HashMap<>();

    private static void writePictures() throws IOException {

        File fout = new File("out/src/picturePaths.txt");
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(fout);
        } catch (Exception e) {
            System.out.println("Couldn't Find picturePaths.txt");
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        for (String picturePath : pictures.keySet()) {


            int rating = pictures.get(picturePath);

            bw.write(picturePath + "," + rating);
            bw.newLine();

        }
        bw.close();

    }

    private static void getPictures() {
        BufferedReader reader;
        String picturePath;
        int pictureRating;
        String[] tokens;

        try {
            reader = new BufferedReader(new FileReader(
                    "out/src/picturePaths.txt"));
            String line = reader.readLine();

            while (line != null) {
                tokens = line.split(",");
                picturePath = tokens[0];
                pictureRating = Integer.parseInt(tokens[1]);
                pictures.put(picturePath, pictureRating);

//                System.out.println(line);
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void onExit() throws IOException {
        writePictures();
        System.out.println("Exiting Application, Writing Pictures to File");
        System.exit(0);
    }

    public Gallery(String layout, int filterValue, Application app) {

       if (firstLoad) {
            getPictures();
            firstLoad = false;
        }

        for(String picturePath : pictures.keySet()) {
            int rating = pictures.get(picturePath);

            File file = new File( picturePath );

            String date = "NULL";

            BasicFileAttributes attrs;
            try {
                attrs = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
                FileTime time = attrs.creationTime();

                String pattern = "yyyy-MM-dd";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

                date = simpleDateFormat.format( new Date( time.toMillis() ) );

            } catch (IOException e) {
                e.printStackTrace();
            }

            if (filterValue == -1) {
                JPanel picture = new Layouts.PictureFrame(picturePath, date, rating, layout, app);
                picture.setAlignmentX(Component.LEFT_ALIGNMENT);
                this.add(picture);
            } else {
                if (rating >= filterValue) {
                    JPanel picture = new Layouts.PictureFrame(picturePath, date, rating, layout, app);
                    this.add(picture);
                }
            }
        }

        if (layout.equals("Grid")) {
            this.setLayout(new ModifiedFlowLayout());
        } else {
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        }

        this.setVisible(true);
    }
}
