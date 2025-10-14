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

    /**
     * 读取指定路径的图片文件并返回BufferedImage对象
     *
     * @param path 图片文件的路径
     * @return 读取到的BufferedImage对象
     * @throws IOException 当文件不存在或读取失败时抛出此异常
     */
    public static BufferedImage readImage(String path) throws IOException {
        return ImageIO.read(new File(path));
    }

    /**
     * 将BufferedImage对象写入到指定路径的文件中
     *
     * @param image  要写入的BufferedImage对象
     * @param format 图像格式，如"jpg"、"png"等
     * @param path   文件保存路径
     * @throws IOException 当文件写入失败时抛出此异常
     */
    public static void writeImage(BufferedImage image, String format, String path) throws IOException {
        ImageIO.write(image, format, new File(path));
    }

    /**
     * 创建一个指定尺寸和背景色的空图像
     *
     * @param width   图像宽度
     * @param height  图像高度
     * @param bgColor 背景颜色，如果为null则不绘制背景
     * @return 创建的BufferedImage对象
     */
    public static BufferedImage createEmptyImage(int width, int height, Color bgColor) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = image.createGraphics();
        if (bgColor != null) {
            g2.setColor(bgColor);
            g2.fillRect(0, 0, width, height);
        }
        return image;
    }

    /**
     * 获取小美王角色向右方向的图像
     *
     * @return BufferedImage 返回小美王向右方向的图像对象
     */
    public static BufferedImage getXiaoMeiWangRightImage() {
        return getResourcesImage("/image/XiaoMeiWang-right.png");
    }

    /**
     * 获取小美王跪姿图片
     *
     * @return BufferedImage 返回小美王跪姿图片对象
     */
    public static BufferedImage getXiaoMeiWangKneelingImage() {
        return getResourcesImage("/image/XiaoMeiWang-kneeling.png");
    }

    /**
     * 获取小美王插图图片
     *
     * @return BufferedImage 返回小美王插图的BufferedImage对象
     */
    public static BufferedImage getXiaoMeiWangIllustrationImage() {
        return getResourcesImage("/image/XiaoMeiWang-illustration.png");
    }

    /**
     * 随机获取 {@link #getXiaoMeiWangRightImage}、{@link #getXiaoMeiWangKneelingImage}、{@link #getXiaoMeiWangIllustrationImage} 这三张图片中的一张图片返回
     *
     * @return 随机返回的小美王图片
     */
    public static BufferedImage getRandomXiaoMeiWangImage() {
        return switch ((int) (Math.random() * 3)) {
            case 1 -> getXiaoMeiWangKneelingImage();
            case 2 -> getXiaoMeiWangIllustrationImage();
            default -> getXiaoMeiWangRightImage();
        };
    }

    /**
     * 从resources目录加载图片资源
     *
     * @param path 图片文件的路径
     * @return 加载成功的BufferedImage对象
     * @throws RuntimeException 当图片加载失败或文件未找到时抛出运行时异常
     */
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