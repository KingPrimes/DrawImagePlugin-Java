package io.github.kingprimes.image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

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

    public static BufferedImage getXiaoMeiWangRightImage() {
        return getResourcesImage("/image/XiaoMeiWang-right.png");
    }

    public static BufferedImage getXiaoMeiWangKneelingImage() {
        return getResourcesImage("/image/XiaoMeiWang-kneeling.png");
    }

    public static BufferedImage getXiaoMeiWangIllustrationImage() {
        return getResourcesImage("/image/XiaoMeiWang-illustration.png");
    }

    public static BufferedImage getResourcesImage(String path) {
        try {
            // 使用 Classloader 从 resources/image 目录加载图片
            InputStream inputStream = ImageIOUtils.class.getResourceAsStream(path);
            if (inputStream == null) {
                throw new IOException("图片文件未找到: %s".formatted(path));
            }
            // 使用 ImageIO 读取图片
            return ImageIO.read(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("无法加载图片: %s".formatted(e.getMessage()), e);
        }
    }
}