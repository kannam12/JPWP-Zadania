package com.company;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Negatyw {

    static BufferedImage image;
    static int tab[][];
    static int height;
    static int widht;

    public Negatyw() {
        String s = "C:\\Users\\P1\\Desktop\\New folder\\Podział.jpg";
        try {
            image = ImageIO.read(new File(s));
        } catch (IOException ex) {
            System.err.println(ex.getLocalizedMessage());
        }
        widht = image.getWidth()-1;
        height = image.getHeight()-1;
        System.out.println("image.getWidth()-1:  "+(image.getWidth()-1));
        System.out.println("height = image.getHeight()-1:  "+(image.getHeight()-1));
        tab = new int[image.getHeight()][image.getWidth()];
    }

    public static void main(String[] args) {
        Negatyw n = new Negatyw();
        /*
        for (int i = 1; i < image.getHeight() - 1; i++) {
            for (int j = 1; j < image.getWidth() - 1; j++) {
                tab[i][j] = image.getRGB(i, j);
            }
        }

        for (int i = 1; i < image.getHeight() - 1; i++) {
            for (int j = 1; j < image.getWidth() - 1; j++) {
                Color negatyw = new Color(255 - new Color(tab[i][j]).getRed(), 255 - new Color(tab[i][j]).getGreen(), 255 - new Color(tab[i][j]).getBlue());
                image.setRGB(i, j, negatyw.getRGB());
            }
        }
        */
        caly:
        for (int i = 1; i <widht; i++) {
            for (int j = 1; j < height; j++) {
                // System.out.println("i: " + i + "  height: " + image.getHeight());
                //System.out.println("j: " + j + "  widtt: " + image.getWidth());

                if (j >height  || i > widht  || i < 0 || j < 0) {
                    System.out.println("i: "+i+ "  width: "+widht);
                    System.out.println("j: "+j+"  height: "+height);
                    System.out.println("przerywam przerywam przerywam przerywam");
                    break caly;
                } else {
                    // tab[i][j] = image.getRGB(j, i);
                    int rgb = image.getRGB(i, j);
                    Color c = new Color(rgb);
                    if (255 < 0 || 255 - c.getRed() > 255 || 255 - c.getGreen() < 0 || 255 - c.getGreen() > 255 || 255 - c.getBlue() < 0 || 255 - c.getBlue() > 255) {
                        // System.out.println("255 - c.getRed(): " + (255 - c.getRed()));
                        // System.out.println("255 - c.getGreen(): " + (255 - c.getGreen()));
                        //System.out.println("255 - c.getBlue(): " + (255 - c.getBlue()));
                        break caly;
                    } else {
                        int red = c.getRed();
                        int green = c.getGreen();
                        int blue = c.getBlue();
                        //System.out.println("red: "+red+"red*0.5: "+(int)red/2);
                        Color negatyw = new Color(255-c.getRed(), 255-c.getGreen(), 255-c.getBlue());
                        //System.out.println("R: "+negatyw.getRed());
                        // System.out.println("G: "+negatyw.getGreen());
                        // System.out.println("B: "+negatyw.getBlue());
                        image.setRGB(i, j, negatyw.getRGB());
                    }
                }

            }
        }

        File nowy = new File("C:\\Users\\P1\\Desktop\\New folder\\PodziałBrudny.jpg");

        try {
            ImageIO.write(image, "jpg", nowy);
        } catch (IOException ex) {
            System.err.println(ex.getLocalizedMessage());
        }

    }

}
