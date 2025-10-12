package io.github.kingprimes.defaultdraw;

import io.github.kingprimes.image.ImageCombiner;
import io.github.kingprimes.utils.Fonts;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.List;

public class DefaultDrawHelpImage {

    public static byte[] drawHelpImage(List<String> helpInfo) {
        final int WIDTH = 800;
        final int MARGIN = 40;
        final int TITLE_HEIGHT = 50;
        final int HEADER_HEIGHT = 60;
        final int FONT_SIZE = Fonts.FONT_TEXT.getSize();
        final int ROW_HEIGHT = FONT_SIZE + 20;
        final int FOOTER_HEIGHT = 30;

        // 计算总高度
        int totalHeight = MARGIN + TITLE_HEIGHT + HEADER_HEIGHT + (helpInfo.size() * ROW_HEIGHT) + MARGIN + FOOTER_HEIGHT;
        BufferedImage image = new BufferedImage(WIDTH, totalHeight, BufferedImage.TYPE_INT_ARGB_PRE);
        ImageCombiner combiner = new ImageCombiner(image, ImageCombiner.OutputFormat.PNG);

        // 设置高质量渲染
        combiner.setFont(Fonts.FONT_TEXT)
                .setColor(Color.WHITE)
                .fillRect(0, 0, WIDTH, totalHeight); // 白色背景

        // ================== 标题绘制 ==================
        String title = "帮助中心";
        combiner.setFont(Fonts.FONT_TEXT)
                .setColor(new Color(0x2c3e50))
                .addCenteredText(title, MARGIN + TITLE_HEIGHT / 2);

        // ================== 表头绘制 ==================
        int y = MARGIN + TITLE_HEIGHT;
        int rounderWidth = Math.multiplyExact(WIDTH, 9) / 10;
        ImageCombiner roundedCombiner = new ImageCombiner(rounderWidth, HEADER_HEIGHT, ImageCombiner.OutputFormat.PNG);
        roundedCombiner.setColor(new Color(0x3498db))
                .fillRect(0, 0, rounderWidth, HEADER_HEIGHT)
                .combine();
        int centerX = (WIDTH - rounderWidth) / 2;
        combiner.addRoundedImage(roundedCombiner.getCombinedImage(), centerX, y - 5, 25);

        // 绘制表头文字（居中）
        combiner.setColor(Color.WHITE)
                .setFont(Fonts.FONT_TEXT)
                .addCenteredText("指令", y += Fonts.FONT_TEXT.getSize() + 8);

        // ================== 数据行绘制 ==================
        for (int i = 0; i < helpInfo.size(); i++) {
            String line = helpInfo.get(i);
            String[] parts = line.split("\\|");
            if (parts.length == 0) continue;

            String command = parts[0]; // 仅取第一部分（指令）

            y += ROW_HEIGHT;
            boolean isEvenRow = i % 2 == 0;

            // 斑马纹背景
            if (isEvenRow) {
                combiner.setColor(new Color(0xECE9E9)).fillRect(0, y + (ROW_HEIGHT / 2) - (FONT_SIZE / 2), WIDTH, ROW_HEIGHT);
            }

            // 绘制命令列（居中）
            combiner.setColor(Color.BLACK)
                    .addCenteredText(command, y);
        }

        // ================== 底部署名 ==================
        y += ROW_HEIGHT;
        String footer = "Posted by: KingPrimes";
        combiner.setFont(Fonts.FONT_TEXT)
                .setColor(Color.GRAY)
                .addCenteredText(footer, y + 10);

        // 合并图像
        combiner.combine();
        try (ByteArrayOutputStream bos = combiner.getCombinedImageOutStream()) {
            return bos.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException("无法获取图像输出流: %s".formatted(e.getMessage()), e);
        }
    }

}
