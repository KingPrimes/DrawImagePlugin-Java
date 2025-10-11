package io.github.kingprimes.defaultdraw;

import io.github.kingprimes.image.ImageCombiner;
import io.github.kingprimes.utils.Fonts;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.List;

public class DefaultDrawHelpImage {

    public static byte[] drawHelpImage(List<String> helpInfo) {
        BufferedImage image = new BufferedImage(1000, 1400, BufferedImage.TYPE_INT_ARGB_PRE);
        Graphics graphics = image.getGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, image.getWidth(), image.getHeight());
        ImageCombiner combiner = new ImageCombiner(image, ImageCombiner.OutputFormat.PNG);
        combiner.setFont(Fonts.FONT_TEXT)
        ;
        final int[] y = {10};
        helpInfo.forEach(s->{
            combiner.setColor(Color.BLACK).addCenteredText(s, y[0]+30);
            y[0] += 30;
        });
        combiner.combine();
        try (ByteArrayOutputStream bos = combiner.getCombinedImageOutStream()) {
            return bos.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException("无法获取图像输出流: %s".formatted(e.getMessage()), e);
        }
    }

}
