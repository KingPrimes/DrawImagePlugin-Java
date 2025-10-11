package io.github.kingprimes.image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@SuppressWarnings("unused")
public final class ImageIOUtils {
    private ImageIOUtils() {
    }

    public static BufferedImage readImage(String path) throws IOException {
        return ImageIO.read(new File(path));
    }

    public static void writeImage(BufferedImage image, String format, String path) throws IOException {
        ImageIO.write(image, format, new File(path));
    }

    public static BufferedImage createEmptyImage(int width, int height, Color bgColor) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = image.createGraphics();
        if (bgColor != null) {
            g2.setColor(bgColor);
            g2.fillRect(0, 0, width, height);
        }
        return image;
    }
}