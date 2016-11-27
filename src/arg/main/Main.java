package arg.main;

import arg.dao.Music;
import arg.vue.MenuPrincipal;
import arg.vue.swing.Fenetre;

public class Main {
	public static void main(String[] args) throws Exception {
		System.setProperty("sun.java2d.opengl", "true");
		Fenetre fen = new Fenetre();
		Music.ChoixMusic();
		// Music.PlayMusic("./music/distant_lullaby.ogg");
		MenuPrincipal.Title();
	}
}
