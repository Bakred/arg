package arg.dao;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class ASCIIBuilder {

    public static void ASCIIBuild(String nomASCII) throws IOException {
        BufferedImage image = new BufferedImage(244, 32, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.setFont(new Font("Dialog", Font.PLAIN, 14));
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics.drawString(nomASCII, 6, 24);

        for (int y = 0; y < 32; y++) {
            StringBuilder sb = new StringBuilder();
            for (int x = 0; x < 244; x++)
                sb.append(image.getRGB(x, y) == -16777216 ? " " : image.getRGB(x, y) == -1 ? "●" : "●");
            if (sb.toString().trim().isEmpty())
                continue;
            System.out.println(sb);
        }
    }
}
