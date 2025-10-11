package io.github.kingprimes.image;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 文字处理工具类（静态工具方法，无状态）
 */
@SuppressWarnings("unused")
public final class TextUtils {

    // 私有构造，防止实例化
    private TextUtils() {}

    // ---------------------- 居中坐标计算 ----------------------
    /**
     * 计算单行文本在指定宽度画布上的水平居中X坐标
     * <p>计算逻辑：通过画布宽度减去文本宽度的差值除以2，得到文本左边缘的起始X坐标，使文本在水平方向居中</p>
     * <p>特殊处理：若{@code metrics}或{@code text}为null，直接返回0以避免空指针异常</p>
     *
     * @param metrics 字体度量对象，用于获取文本宽度（通过{@link FontMetrics#stringWidth(String)}）
     * @param text 待居中的单行文本内容（文本宽度将用于居中计算）
     * @param canvasWidth 画布/容器的宽度（像素），即文本居中的参考宽度
     * @return 文本水平居中时的左边缘X坐标（像素）；若输入参数无效（metrics或text为null）则返回0
     */
    public static int calculateCenterX(FontMetrics metrics, String text, int canvasWidth) {
        if (metrics == null || text == null) return 0;
        return (canvasWidth - metrics.stringWidth(text)) / 2;
    }

    /**
     * 计算单行文字水平居中的X坐标（带偏移量）
     */
    public static int calculateCenterX(FontMetrics metrics, String text, int canvasWidth, int xOffset) {
        return calculateCenterX(metrics, text, canvasWidth) + xOffset;
    }

    /**
     * 计算单行文字完全居中（X、Y轴）的坐标
     */
    public static Point calculateCenterXY(FontMetrics metrics, String text, int canvasWidth, int canvasHeight) {
        if (metrics == null || text == null) return new Point(0, 0);
        int x = calculateCenterX(metrics, text, canvasWidth);
        // Y轴居中需考虑文字基线（ascent），避免文字偏上
        int y = (canvasHeight + metrics.getAscent() - metrics.getDescent()) / 2;
        return new Point(x, y);
    }

    /**
     * 计算单行文字完全居中（X、Y轴）的坐标（带偏移量）
     */
    public static Point calculateCenterXY(FontMetrics metrics, String text, int canvasWidth, int canvasHeight, int xOffset, int yOffset) {
        Point center = calculateCenterXY(metrics, text, canvasWidth, canvasHeight);
        return new Point(center.x + xOffset, center.y + yOffset);
    }

    // ---------------------- 自动换行 ----------------------
    /**
     * 根据最大宽度自动拆分文本（按空格分割）
     */
    public static String[] wrapText(FontMetrics metrics, String text, int maxWidth) {
        List<String> lines = new ArrayList<>();
        if (metrics == null || text == null || maxWidth <= 0) {
            lines.add(text == null ? "" : text);
            return lines.toArray(new String[0]);
        }

        StringBuilder currentLine = new StringBuilder();
        String[] words = text.split(" ");

        for (String word : words) {
            // 测试当前行加单词是否超过最大宽度
            String testLine = currentLine + word + " ";
            if (metrics.stringWidth(testLine) <= maxWidth) {
                currentLine.append(word).append(" ");
            } else {
                // 单个单词超过最大宽度，直接单独成行
                if (currentLine.isEmpty()) {
                    lines.add(word);
                } else {
                    lines.add(currentLine.toString().trim());
                    currentLine = new StringBuilder(word + " ");
                }
            }
        }
        // 添加最后一行
        if (!currentLine.isEmpty()) {
            lines.add(currentLine.toString().trim());
        }
        return lines.toArray(new String[0]);
    }

    // ---------------------- 文本高度计算 ----------------------
    /**
     * 计算多行文本总高度（含行间距）
     */
    public static int calculateMultilineHeight(FontMetrics metrics, String[] lines, int spacing) {
        if (metrics == null || lines == null || lines.length == 0) return 0;
        // 总高度 = 每行高度之和 + 行间距之和（行数-1）
        return lines.length * metrics.getHeight() + (lines.length - 1) * spacing;
    }

    // ---------------------- 基础文本绘制 ----------------------
    /**
     * 绘制带背景框的单行文本
     */
    public static void drawTextWithBackground(Graphics2D g2, Font font, Color textColor,
                                              String text, int x, int y,
                                              Color bgColor, Color borderColor,
                                              int cornerRadius, int padding) {
        if (g2 == null || text == null) return;

        FontMetrics metrics = g2.getFontMetrics(font != null ? font : g2.getFont());
        int textWidth = metrics.stringWidth(text);
        int textHeight = metrics.getHeight();

        // 1. 绘制背景（圆角矩形）
        if (bgColor != null) {
            g2.setColor(bgColor);
            g2.fillRoundRect(
                    x - padding,                      // 背景X（左移内边距）
                    y - metrics.getAscent() - padding, // 背景Y（上移内边距+文字上半部分）
                    textWidth + 2 * padding,          // 背景宽（文字宽+2倍内边距）
                    textHeight,                       // 背景高（文字高度）
                    cornerRadius, cornerRadius
            );
        }

        // 2. 绘制边框
        if (borderColor != null) {
            g2.setColor(borderColor);
            g2.drawRoundRect(
                    x - padding,
                    y - metrics.getAscent() - padding,
                    textWidth + 2 * padding,
                    textHeight,
                    cornerRadius, cornerRadius
            );
        }

        // 3. 绘制文字（恢复文字颜色和字体）
        g2.setColor(textColor != null ? textColor : Color.BLACK);
        if (font != null) g2.setFont(font);
        g2.drawString(text, x, y);
    }

    /**
     * 绘制带背景框的多行文本
     */
    public static void drawMultilineTextWithBackground(Graphics2D g2, Font font, Color textColor,
                                                       String text, int x, int y,
                                                       Color bgColor, Color borderColor,
                                                       int cornerRadius, int padding) {
        if (g2 == null || text == null) return;

        FontMetrics metrics = g2.getFontMetrics(font != null ? font : g2.getFont());
        String[] lines = text.split("\n");
        if (lines.length == 0) return;

        // 计算多行文本最大宽度和总高度
        int maxLineWidth = 0;
        for (String line : lines) {
            maxLineWidth = Math.max(maxLineWidth, metrics.stringWidth(line));
        }
        int totalTextHeight = lines.length * metrics.getHeight();

        // 1. 绘制背景
        if (bgColor != null) {
            g2.setColor(bgColor);
            g2.fillRoundRect(
                    x - padding,
                    y - metrics.getAscent() - padding,
                    maxLineWidth + 2 * padding,
                    totalTextHeight + padding, // 总高+底部内边距
                    cornerRadius, cornerRadius
            );
        }

        // 2. 绘制边框
        if (borderColor != null) {
            g2.setColor(borderColor);
            g2.drawRoundRect(
                    x - padding,
                    y - metrics.getAscent() - padding,
                    maxLineWidth + 2 * padding,
                    totalTextHeight + padding,
                    cornerRadius, cornerRadius
            );
        }

        // 3. 绘制每行文字
        g2.setColor(textColor != null ? textColor : Color.BLACK);
        if (font != null) g2.setFont(font);
        int currentY = y;
        for (String line : lines) {
            g2.drawString(line, x, currentY);
            currentY += metrics.getHeight(); // 下移一行高度
        }
    }

    /**
     * 绘制带渐变背景框的多行文本
     */
    public static void drawMultilineTextWithGradientBackground(Graphics2D g2, Font font, Color textColor,
                                                               String text, int x, int y,
                                                               Color startColor, Color endColor, boolean isVerticalGradient,
                                                               Color borderColor, int cornerRadius, int padding) {
        if (g2 == null || text == null || startColor == null || endColor == null) return;

        FontMetrics metrics = g2.getFontMetrics(font != null ? font : g2.getFont());
        String[] lines = text.split("\n");
        if (lines.length == 0) return;

        int maxLineWidth = 0;
        for (String line : lines) {
            maxLineWidth = Math.max(maxLineWidth, metrics.stringWidth(line));
        }
        int totalTextHeight = lines.length * metrics.getHeight();

        // 1. 绘制渐变背景
        GradientPaint gradientPaint;
        if (isVerticalGradient) {
            gradientPaint = new GradientPaint(x, y, startColor, x, y + totalTextHeight, endColor);
        } else {
            gradientPaint = new GradientPaint(x, y, startColor, x + maxLineWidth, y, endColor);
        }
        g2.setPaint(gradientPaint);
        g2.fillRoundRect(
                x - padding,
                y - metrics.getAscent() - padding,
                maxLineWidth + 2 * padding,
                totalTextHeight + padding,
                cornerRadius, cornerRadius
        );

        // 2. 绘制边框
        if (borderColor != null) {
            g2.setColor(borderColor);
            g2.drawRoundRect(
                    x - padding,
                    y - metrics.getAscent() - padding,
                    maxLineWidth + 2 * padding,
                    totalTextHeight + padding,
                    cornerRadius, cornerRadius
            );
        }

        // 3. 绘制文字
        g2.setColor(textColor != null ? textColor : Color.BLACK);
        if (font != null) g2.setFont(font);
        int currentY = y;
        for (String line : lines) {
            g2.drawString(line, x, currentY);
            currentY += metrics.getHeight();
        }
    }

    /**
     * 绘制带阴影的文字
     */
    public static void drawTextWithShadow(Graphics2D g2, Font font, Color textColor, Color shadowColor,
                                          String text, int x, int y, int shadowOffsetX, int shadowOffsetY) {
        if (g2 == null || text == null || textColor == null || shadowColor == null) return;

        // 1. 先画阴影（偏移位置）
        g2.setColor(shadowColor);
        if (font != null) g2.setFont(font);
        g2.drawString(text, x + shadowOffsetX, y + shadowOffsetY);

        // 2. 再画文字（原位置）
        g2.setColor(textColor);
        g2.drawString(text, x, y);
    }

    // ---------------------- 高级文本绘制（整合所有样式） ----------------------
    /**
     * 高级多行文本绘制：自动换行 + 背景/渐变 + 边框 + 圆角 + 阴影 + 对齐
     */
    public static void drawAdvancedText(Graphics2D g2, Font font, Color textColor,
                                        String text, int maxWidth, int canvasWidth, int canvasHeight,
                                        ImageCombiner.Align align, boolean isVerticalCenter,
                                        Color bgColor, Color gradientStart, Color gradientEnd, boolean isVerticalGradient,
                                        Color borderColor, int cornerRadius, int padding,
                                        Color shadowColor, int shadowOffsetX, int shadowOffsetY) {
        if (g2 == null || text == null) return;

        FontMetrics metrics = g2.getFontMetrics(font != null ? font : g2.getFont());
        // 1. 自动换行
        String[] lines = wrapText(metrics, text, maxWidth);
        if (lines.length == 0) return;

        // 2. 计算文本总宽高
        int totalTextWidth = 0;
        for (String line : lines) {
            totalTextWidth = Math.max(totalTextWidth, metrics.stringWidth(line));
        }
        int lineHeight = metrics.getHeight();
        int totalTextHeight = lines.length * lineHeight;

        // 3. 计算起始位置（X/Y）
        int startX = padding;
        int startY = padding + metrics.getAscent();

        // 水平对齐调整
        if (align == ImageCombiner.Align.CENTER) {
            startX = (canvasWidth - totalTextWidth) / 2;
        } else if (align == ImageCombiner.Align.RIGHT) {
            startX = canvasWidth - totalTextWidth - padding;
        }

        // 垂直居中调整
        if (isVerticalCenter) {
            int contentTotalHeight = totalTextHeight + 2 * padding; // 文本高+上下内边距
            startY = (canvasHeight - contentTotalHeight) / 2 + metrics.getAscent() + padding;
        }

        // 4. 绘制背景（纯色/渐变）
        if (bgColor != null || (gradientStart != null && gradientEnd != null)) {
            int bgX = startX - padding;
            int bgY = startY - metrics.getAscent() - padding;
            int bgWidth = totalTextWidth + 2 * padding;
            int bgHeight = totalTextHeight + padding;

            if (gradientStart != null && gradientEnd != null) {
                // 渐变背景
                GradientPaint gradientPaint = isVerticalGradient
                        ? new GradientPaint(bgX, bgY, gradientStart, bgX, bgY + bgHeight, gradientEnd)
                        : new GradientPaint(bgX, bgY, gradientStart, bgX + bgWidth, bgY, gradientEnd);
                g2.setPaint(gradientPaint);
            } else {
                // 纯色背景
                g2.setColor(bgColor);
            }
            g2.fillRoundRect(bgX, bgY, bgWidth, bgHeight, cornerRadius, cornerRadius);
        }

        // 5. 绘制边框
        if (borderColor != null) {
            int bgX = startX - padding;
            int bgY = startY - metrics.getAscent() - padding;
            int bgWidth = totalTextWidth + 2 * padding;
            int bgHeight = totalTextHeight + padding;
            g2.setColor(borderColor);
            g2.drawRoundRect(bgX, bgY, bgWidth, bgHeight, cornerRadius, cornerRadius);
        }

        // 6. 绘制每行文字（支持阴影）
        g2.setColor(textColor != null ? textColor : Color.BLACK);
        if (font != null) g2.setFont(font);
        int currentY = startY;

        for (String line : lines) {
            int lineX = startX;
            // 单行水平对齐（处理每行宽度不同的情况）
            if (align == ImageCombiner.Align.CENTER) {
                lineX = (canvasWidth - metrics.stringWidth(line)) / 2;
            } else if (align == ImageCombiner.Align.RIGHT) {
                lineX = canvasWidth - metrics.stringWidth(line) - padding;
            }

            // 绘制阴影（如果需要）
            if (shadowColor != null) {
                g2.setColor(shadowColor);
                g2.drawString(line, lineX + shadowOffsetX, currentY + shadowOffsetY);
                g2.setColor(textColor); // 恢复文字颜色
            }

            // 绘制文字
            g2.drawString(line, lineX, currentY);
            currentY += lineHeight; // 下移一行
        }
    }
}