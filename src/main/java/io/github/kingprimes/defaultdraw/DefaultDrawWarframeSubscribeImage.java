package io.github.kingprimes.defaultdraw;

import io.github.kingprimes.image.ImageCombiner;
import io.github.kingprimes.image.TextUtils;
import io.github.kingprimes.utils.Fonts;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DefaultDrawWarframeSubscribeImage {

    static final int WIDTH = 1300;
    static final int HEIGHT = 1000;
    static final int MARGIN = 20;
    static final int TITLE_HEIGHT = 50;

    public static byte[] drawWarframeSubscribeImage(Map<Integer, String> subscribe, Map<Integer, String> missionType) {

        // 创建画布
        ImageCombiner combiner = new ImageCombiner(WIDTH, HEIGHT, ImageCombiner.OutputFormat.PNG);

        // 设置主字体
        Font mainFont = Fonts.FONT_TEXT;
        final int TEXT_LINE_HEIGHT = mainFont.getSize();
        combiner.setFont(mainFont)
                .setColor(Color.WHITE)
                .fillRect(0, 0, WIDTH, HEIGHT); // 白色背景

        // ================== 绘制双线圆角边框 ==================
        int borderPadding = 20;
        int innerWidth = WIDTH - borderPadding * 2;
        int innerHeight = HEIGHT - borderPadding * 2;

        // 外层边框（浅灰色）
        combiner.setColor(new Color(0xB1B1B1))
                .setStroke(4)
                .drawRoundRect(borderPadding - 8, borderPadding - 8, innerWidth + 16, innerHeight + 16, 20, 20);

        // 内层边框（深灰色）
        combiner.setColor(new Color(0x333333))
                .setStroke(4)
                .drawRoundRect(borderPadding, borderPadding, innerWidth, innerHeight, 20, 20);

        int y = MARGIN + borderPadding + TITLE_HEIGHT / 2;
        // ================== 标题 ==================
        String title = "---订阅指令表---";
        combiner.setColor(Color.BLACK)
                .setFont(mainFont)
                .addCenteredText(title, y);

        // ================== 命令使用方式 Start ==================

        y += MARGIN + 30;
        int x = MARGIN + 40;
        String usage = "命令使用方式：";
        String subscribeText = "订阅";
        String subscribeTypeText = "[订阅内容类型]";
        String missionTypeText = "[-订阅任务类型]";
        String relicLevelText = "[-订阅遗物等级]";

        combiner.setColor(Color.BLACK)
                .addText(usage, x, y);

        x += TextUtils.getFortWidth(usage, mainFont) + 80;
        combiner.setColor(new Color(0x1c84c6))
                .addText(subscribeText, x, y);
        x += TextUtils.getFortWidth(subscribeText, mainFont);
        combiner.setColor(new Color(0x6110f3)) // 紫色
                .addText(subscribeTypeText, x, y);
        x += TextUtils.getFortWidth(subscribeTypeText, mainFont) + 60;
        combiner.setColor(new Color(0xff0000)) // 红色
                .addText(missionTypeText, x, y);
        x += TextUtils.getFortWidth(missionTypeText, mainFont) + 60;
        combiner.setColor(new Color(0xaf5244)) // 棕色
                .addText(relicLevelText, x, y);
        // ================== 命令使用方式 END ==================


        // ================== 下方的例子 Start ==================
        x = MARGIN + 40;
        y += TEXT_LINE_HEIGHT + MARGIN;
        String example = "下方的例子是指：";
        String subscribeTypeExample = "裂隙";
        String missionTypeExample = "生存模式";
        String relicLevelExample = "后纪";
        combiner.setColor(Color.BLACK)
                .addText(example, x, y);

        x += TextUtils.getFortWidth(example, mainFont) + 80;
        combiner.setColor(new Color(0x1c84c6))
                .addText(subscribeText, x, y);

        x += TextUtils.getFortWidth(subscribeText, mainFont);
        combiner.setColor(new Color(0x6110f3))
                .addText(subscribeTypeExample, x, y);

        x += TextUtils.getFortWidth(subscribeTypeExample, mainFont);
        combiner.setColor(new Color(0xff0000))
                .addText(missionTypeExample, x, y);

        x += TextUtils.getFortWidth(missionTypeExample, mainFont) + 30;
        combiner.setColor(new Color(0xaf5244))
                .addText(relicLevelExample, x, y);
        // ================== 下方的例子 END ==================


        // ================== 指令例子 Start ==================
        x = MARGIN + 40;
        y += TEXT_LINE_HEIGHT + MARGIN;
        String l = "指令例子：";
        String t = "9";
        String f = "-11";
        String r = "-4";
        combiner.setColor(Color.BLACK)
                .addText(l, x, y);

        x += TextUtils.getFortWidth(l, mainFont) + 40;
        combiner.setColor(new Color(0x1c84c6))
                .addText(subscribeText, x, y);

        x += TextUtils.getFortWidth(subscribeText, mainFont);
        combiner.setColor(new Color(0x6110f3))
                .addText(t, x, y);

        x += TextUtils.getFortWidth(t, mainFont);
        combiner.setColor(new Color(0xff0000))
                .addText(f, x, y);

        x += TextUtils.getFortWidth(f, mainFont);
        combiner.setColor(new Color(0xaf5244))
                .addText(r, x, y);
        // ================== 指令例子 END ==================


        // ================== 注意事项 Start ==================
        x = MARGIN + 40;
        y += TEXT_LINE_HEIGHT + MARGIN;
        String note = "注意事项：";
        String rl = "遗物等级";
        String only = "只有在订阅";
        String f3 = "裂隙";
        String useful = "时有用";

        combiner.setColor(Color.BLACK)
                .addText(note, x, y);

        x += TextUtils.getFortWidth(note, mainFont) + 40;
        combiner.setColor(new Color(0xaf5244))
                .addText(rl, x, y);

        x += TextUtils.getFortWidth(rl, mainFont) + 30;
        combiner.setColor(Color.BLACK)
                .addText(only, x, y);

        x += TextUtils.getFortWidth(only, mainFont) + 60;
        combiner.setColor(new Color(0x6110f3))
                .addText(f3, x, y);

        x += TextUtils.getFortWidth(f3, mainFont);
        combiner.setColor(Color.BLACK)
                .addText(useful, x, y);
        // ================== 注意事项 END ==================


        // ================== 订阅内容类型数值 Start==================
        String subscribeTitle = "订阅内容类型数值";
        y += TEXT_LINE_HEIGHT + MARGIN;
        combiner.setColor(new Color(0x6110f3))
                .setFont(mainFont)
                .addCenteredText(subscribeTitle, y);

        y += TextUtils.getFortHeight(subscribeTitle, mainFont) + MARGIN;
        int j = drawTable(combiner, subscribe, y, new Color(0x6110f3), 4);
        y += j / 3 + subscribe.size() * 2;
        // ================== 订阅任务类型数值 ==================
        String missionTypeTitle = "订阅任务类型数值";
        combiner.setColor(new Color(0xff0000))
                .setFont(mainFont)
                .addCenteredText(missionTypeTitle, y);

        y += TextUtils.getFortHeight(missionTypeTitle, mainFont) + MARGIN;
        j = drawTable(combiner, missionType, y, new Color(0xff0000), 4);
        y += j / 3 + missionType.size() * 2;
        // ================== 底部署名 ==================
        String footer = "Posted by: KingPrimes";
        combiner.setColor(Color.BLACK)
                .setFont(mainFont)
                .addCenteredText(footer, y);

        // 合并图像
        combiner.combine();
        try (ByteArrayOutputStream bos = combiner.getCombinedImageOutStream()) {
            return bos.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException("无法获取图像输出流: %s".formatted(e.getMessage()), e);
        }
    }


    /**
     * 绘制表格，每行 column 个项，自动换行
     *
     * @param combiner ImageCombiner 实例
     * @param data     键值对数据
     * @param startY   起始 Y 坐标
     * @param color    文本颜色
     * @param columns  每行列数
     */
    private static int drawTable(ImageCombiner combiner, Map<Integer, String> data, int startY,
                                 Color color, int columns) {
        if (data == null || data.isEmpty()) return startY;

        List<Map.Entry<Integer, String>> entries = new ArrayList<>(data.entrySet());
        entries.sort(Map.Entry.comparingByKey());

        int itemWidth = WIDTH / columns;
        int x = 20;
        int y = startY;
        int count = 0;

        for (Map.Entry<Integer, String> entry : entries) {
            String text = entry.getKey() + " = " + entry.getValue();
            int textWidth = combiner.getStringWidth(text);
            int textX = x + (itemWidth - textWidth) / 2;

            combiner.setColor(color)
                    .addText(text, textX, y);

            count++;
            if (count % columns == 0) {
                x = 20;
                y += TextUtils.getFortHeight(text, combiner.getFont()) + 10;
            } else {
                x += itemWidth;
            }
        }
        return y;
    }
}
