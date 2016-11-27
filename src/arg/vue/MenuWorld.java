package arg.vue;

import java.io.IOException;

import arg.controlleur.*;
import arg.modele.Mob;
import arg.modele.Player;

public class MenuWorld {

	public static void CarteDuMonde() throws IOException, InterruptedException {
		Player joueur = new Player();
		PlayerBz.CreationPerso(joueur);
		Mob monstre = new Mob();
		MobBz.GenerationMob(joueur, monstre);
		Combat.Arene(joueur, monstre);
	}
}
