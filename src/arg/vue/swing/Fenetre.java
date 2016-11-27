package arg.vue.swing;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Dimension;

public class Fenetre extends JFrame {
	private Panneau pan = new Panneau();

	public Fenetre() {
		this.setTitle("ARG with SWING");
		this.setSize(400, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		this.setAlwaysOnTop(true);
		this.setContentPane(pan);
		this.setVisible(true);
		go();
	}

	private void go() {
		int x = pan.getPosX(), y = pan.getPosY();
		int ballex = pan.getTailleX(), balley = pan.getTailleY();
		boolean boucle = false;
		while (true) {
			if (boucle == false)
			{
			if (y== 0)
			{
			
			while (x < 350) {
				pan.setSetColor(Color.blue);
				x++;
				y++;
				ballex++;
				balley++;
				Print(pan, x, y);
			}
			}
			
			if (x== 350)
			{
			
			while (y < 420) {
				pan.setSetColor(Color.green);
				x--;
				y++;
				ballex++;
				balley++;
				Print(pan, x, y);
			}
			}
			
			if (y== 420)
			{
			
			while (x > 0) {
				pan.setSetColor(Color.red);
				x--;
				y--;
				ballex++;
				balley++;
				Print(pan, x, y);
			}
			}
			
			if (x== 0)
			{
			
			while (y > 0) {
				pan.setSetColor(Color.yellow);
				x++;
				y--;
				ballex++;
				balley++;
				Print(pan, x, y);
				
				if (x== 350)
				{
				
				while (y > 0) {
					pan.setSetColor(Color.pink);
					x--;
					y--;
					ballex++;
					balley++;
					Print(pan, x, y);
				}
				boucle = true;
				System.out.println(boucle);
				}
			}
			}
			
			if (boucle == true)
			{
			
			if (y== 0)
			{
			
			while (x > 0) {
				pan.setSetColor(Color.gray);
				x--;
				y++;
				ballex++;
				balley++;
				Print(pan, x, y);
			}
			}
			
			if (x== 0)
			{
			
			while (y < 420) {
				pan.setSetColor(Color.red);
				x++;
				y++;
				ballex++;
				balley++;
				Print(pan, x, y);
			}
			}
			
			if (y== 420)
			{
			
			while (x < 350) {
				pan.setSetColor(Color.yellow);
				x++;
				y--;
				ballex++;
				balley++;
				Print(pan, x, y);
			}
			}
			
			if (x== 350)
			{
			
			while (y > 0) {
				pan.setSetColor(Color.white);
				x--;
				y--;
				ballex++;
				balley++;
				Print(pan, x, y);
			}
			}
			
			if (y== 0)
			{
			
			while (x > 0) {
				pan.setSetColor(Color.cyan);
				x--;
				y++;
				ballex++;
				balley++;
				Print(pan, x, y);
			}
			boucle = false;
			System.out.println(boucle);
			}
			
			}
			}
		}
	}

	private static void Print(Panneau pan, int x, int y) {
		pan.setPosX(x);
		System.out.println("X : " + x + " Y : " + y);
		pan.setPosY(y);
		pan.repaint();
		try {
			Thread.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}