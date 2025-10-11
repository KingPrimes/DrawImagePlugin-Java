package io.github.kingprimes.defaultdraw;

import io.github.kingprimes.image.ImageCombiner;
import io.github.kingprimes.utils.Fonts;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DefaultDrawWarframeSubscribeImage {
    public static byte[] drawWarframeSubscribeImage(Map<Integer, String> subscribe, Map<Integer, String> missionType) {
        // 1. 创建 800×800 的 PNG 画布
        ImageCombiner combiner = new ImageCombiner(800, 800, ImageCombiner.OutputFormat.PNG);

        // 2. 设置字体和颜色（确保 Fonts.FONT_TEXT 是有效字体，如 "Microsoft YaHei" 或 "Arial"）
        combiner.setFont(Fonts.FONT_TEXT)
                .setColor(Color.BLACK);

        // 3. 绘制上半部分 subscribe（宽度 400，每行 3 个）
        int topY = 50;
        drawKeyValuePairs(combiner, subscribe, topY);

        // 4. 绘制下半部分 missionType（宽度 400，每行 3 个）
        int bottomY = 450;
        drawKeyValuePairs(combiner, missionType, bottomY);

        // 5. 合并并输出图片
        combiner.combine();
        try (ByteArrayOutputStream bos = combiner.getCombinedImageOutStream()) {
            return bos.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException("无法获取图像输出流: %s".formatted(e.getMessage()), e);
        }
    }


    /**
     * 绘制 Map 键值对，每行最多 column 个，自动换行
     *
     * @param combiner ImageCombiner
     * @param data     Map 数据
     * @param startY   起始Y坐标
     */
    private static void drawKeyValuePairs(ImageCombiner combiner, Map<Integer, String> data,
                                          int startY) {
        if (data == null || data.isEmpty()) return;

        List<Map.Entry<Integer, String>> entryList = new ArrayList<>(data.entrySet().stream().sorted(Map.Entry.comparingByKey()).toList());
        int itemWidth = 800 / 3; // 每个元素宽度
        int x = 15;
        int y = startY;
        int count = 0;

        for (Map.Entry<Integer, String> entry : entryList) {
            String text = entry.getKey() + " -> " + entry.getValue();
            int textWidth = combiner.getStringWidth(text); // 正确计算文字像素宽度

            // 计算文字水平居中的 X 坐标
            int textX = x + (itemWidth - textWidth) / 2;
            combiner.addText(text, textX, y);

            count++;
            if (count % 3 == 0) { // 满一行，换行
                x = 15;
                y += 30;
            } else { // 否则，下一个键值对右移
                x += itemWidth;
            }
        }
    }
}
