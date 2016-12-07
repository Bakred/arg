package arg.vue.swing;

import javax.swing.*;
import java.awt.*;

public class Panneau extends JPanel {
    private int posX = 0;
    private int posY = 0;
    private Color SetColor = Color.blue;
    private int tailleX = 50;
    private int tailleY = 50;

    public void paintComponent(Graphics g) {
        // On choisit une couleur de fond pour le rectangle
        g.setColor(Color.black);
        // On le dessine de sorte qu'il occupe toute la surface
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        // On redéfinit une couleur pour le rond
        g.setColor(SetColor);
        // On le dessine aux coordonnées souhaitées
        g.fillRect(posX, posY, tailleX, tailleY);
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public Color getSetColor() {
        return SetColor;
    }

    public void setSetColor(Color setColor) {
        SetColor = setColor;
    }

    public int getTailleX() {
        return tailleX;
    }

    public void setTailleX(int tailleX) {
        this.tailleX = tailleX;
    }

    public int getTailleY() {
        return tailleY;
    }

    public void setTailleY(int tailleY) {
        this.tailleY = tailleY;
    }

}
