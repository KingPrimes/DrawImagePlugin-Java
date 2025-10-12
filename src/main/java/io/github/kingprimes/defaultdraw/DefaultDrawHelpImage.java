package io.github.kingprimes.defaultdraw;

import io.github.kingprimes.image.ImageCombiner;
import io.github.kingprimes.image.ImageIOUtils;
import io.github.kingprimes.image.TransformUtils;
import io.github.kingprimes.utils.Fonts;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class DefaultDrawHelpImage {

    public static byte[] drawHelpImage(List<String> helpInfo) {
        final int WIDTH = 1200;
        final int MARGIN = 40;
        final int TITLE_HEIGHT = 50;
        final int HEADER_HEIGHT = 60;
        final int FONT_SIZE = Fonts.FONT_TEXT.getSize();
        final int ROW_HEIGHT = FONT_SIZE + 20;
        final int FOOTER_HEIGHT = 30;
        final int ITEMS_PER_COLUMN = 22;

        // 预计算布局参数（不变）
        int columnCount = (helpInfo.size() + ITEMS_PER_COLUMN - 1) / ITEMS_PER_COLUMN;
        int maxItemsInColumn = (helpInfo.size() + columnCount - 1) / columnCount;
        int totalHeight = MARGIN + TITLE_HEIGHT + HEADER_HEIGHT + (maxItemsInColumn * ROW_HEIGHT) + MARGIN + FOOTER_HEIGHT + 150;
        int rounderWidth = Math.multiplyExact(WIDTH, 9) / 10;
        int centerX = (WIDTH - rounderWidth) / 2;
        int columnWidth = rounderWidth / 2;  // 预计算列宽

        // 复用颜色对象（避免频繁创建）
        Color evenRowColor = new Color(0xECE9E9);
        Color textColor = Color.BLACK;
        Color headerBgColor = new Color(0x3498db);
        Color titleColor = new Color(0x2c3e50);

        ImageCombiner combiner = new ImageCombiner(WIDTH, totalHeight, ImageCombiner.OutputFormat.PNG);
        combiner.setFont(Fonts.FONT_TEXT)
                .setColor(Color.WHITE)
                .fillRect(0, 0, WIDTH, totalHeight);

        // 标题绘制（不变）
        String title = "帮助中心";
        combiner.setColor(titleColor)
                .addCenteredText(title, MARGIN + TITLE_HEIGHT / 2);

        // 表头绘制（不变）
        int y = MARGIN + TITLE_HEIGHT;
        ImageCombiner roundedCombiner = new ImageCombiner(rounderWidth, HEADER_HEIGHT, ImageCombiner.OutputFormat.PNG);
        roundedCombiner.setColor(headerBgColor)
                .fillRect(0, 0, rounderWidth, HEADER_HEIGHT)
                .combine();
        combiner.addRoundedImage(roundedCombiner.getCombinedImage(), centerX, y - 5, 25);
        combiner.setColor(Color.WHITE)
                .addCenteredText("指令", y += Fonts.FONT_TEXT.getSize() + 8);
        int imageY = y;

        // ================== 优化核心：合并循环 + 预计算坐标 ==================
        // 预计算所有行的坐标和背景信息（单次循环）
        List<RowInfo> rowInfos = new ArrayList<>(helpInfo.size());
        int currentColumn = 0;
        int currentRowInColumn = 0;

        for (int i = 0; i < helpInfo.size(); i++) {
            // 计算当前行列位置（避免循环内取模运算）
            if (i > 0 && currentRowInColumn % ITEMS_PER_COLUMN == 0) {
                currentColumn++;
                currentRowInColumn = 0;
            }

            // 预计算坐标
            int rowX = centerX + (currentColumn * columnWidth);
            int rowY = y + (currentRowInColumn * ROW_HEIGHT) + ROW_HEIGHT;  // +ROW_HEIGHT是因为初始y已包含表头高度

            // 预解析数据（避免重复分割字符串）
            String line = helpInfo.get(i);
            String[] parts = line.split("\\|");
            String command = parts.length > 0 ? parts[0] : "";

            rowInfos.add(new RowInfo(rowX, rowY, currentRowInColumn % 2 == 0, command));
            currentRowInColumn++;
        }

        // 1. 绘制所有斑马纹背景（批量操作）
        combiner.setColor(evenRowColor);
        for (RowInfo info : rowInfos) {
            if (info.isEvenRow) {
                combiner.fillRect(info.x, info.y + (ROW_HEIGHT / 2) - (FONT_SIZE / 2), WIDTH, ROW_HEIGHT);
            }
        }

        // 2. 绘制背景图片（不变）
        BufferedImage back = TransformUtils.scaleImage(ImageIOUtils.getXiaoMeiWangRightImage(), WIDTH / 2, totalHeight);
        combiner.drawImage(back, WIDTH / 2 + 40, imageY);

        // 3. 绘制所有数据行文字（批量操作）
        combiner.setColor(textColor);
        for (RowInfo info : rowInfos) {
            if (!info.command.isEmpty()) {
                combiner.addText(info.command, info.x, info.y);
            }
        }

        // 底部署名（不变）
        String footer = "Posted by: KingPrimes";
        combiner.setColor(Color.GRAY)
                .addCenteredText(footer, totalHeight - FOOTER_HEIGHT + 10);

        combiner.combine();
        try (ByteArrayOutputStream bos = combiner.getCombinedImageOutStream()) {
            return bos.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException("无法获取图像输出流: %s".formatted(e.getMessage()), e);
        }
    }

    // 内部辅助类：缓存行信息（坐标、背景状态、文字内容）
    private static class RowInfo {
        final int x;
        final int y;
        final boolean isEvenRow;
        final String command;

        RowInfo(int x, int y, boolean isEvenRow, String command) {
            this.x = x;
            this.y = y;
            this.isEvenRow = isEvenRow;
            this.command = command;
        }
    }

}
