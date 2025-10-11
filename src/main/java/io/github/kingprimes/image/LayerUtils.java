package io.github.kingprimes.image;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public final class LayerUtils {
    private static final List<Layer> layers = new ArrayList<>();

    private LayerUtils() {}

    public static void addLayer(BufferedImage image, int x, int y, float alpha, Composite composite) {
        layers.add(new Layer(image, x, y, alpha, composite));
    }

    public static void removeLayer(int index) {
        if (index >= 0 && index < layers.size()) {
            layers.remove(index);
        }
    }

    public static void moveLayerTo(int fromIndex, int toIndex) {
        if (fromIndex >= 0 && fromIndex < layers.size() && toIndex >= 0 && toIndex < layers.size()) {
            Layer layer = layers.remove(fromIndex);
            layers.add(toIndex, layer);
        }
    }

    public static BufferedImage renderLayers(int width, int height, Color bgColor) {
        BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = result.createGraphics();
        GraphicsUtils.setQualityRenderingHints(g2);
        if (bgColor != null) {
            g2.setColor(bgColor);
            g2.fillRect(0, 0, width, height);
        }
        for (Layer layer : layers) {
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, layer.alpha));
            g2.drawImage(layer.image, layer.x, layer.y, null);
        }
        g2.dispose();
        return result;
    }

    public static void clearLayers() {
        layers.clear();
    }

    public record Layer(BufferedImage image, int x, int y, float alpha, Composite composite) {}
}