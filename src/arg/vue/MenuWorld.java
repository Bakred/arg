package arg.vue;

import arg.controlleur.MobBz;
import arg.controlleur.PlayerBz;
import arg.modele.Mob;
import arg.modele.Player;

import java.io.IOException;

public class MenuWorld {

    public static void CarteDuMonde() throws IOException, InterruptedException {
        Player joueur = new Player();
        PlayerBz.CreationPerso(joueur);
        Mob monstre = new Mob();
        MobBz.GenerationMob(joueur, monstre);
        Combat.Arene(joueur, monstre);
    }
}
