package arg.controlleur;

import java.io.IOException;

import arg.dao.ASCIIBuilder;
import arg.dao.Generator;
import arg.dao.Pause;
import arg.dao.Sound;
import arg.modele.Magie;
import arg.modele.Mob;
import arg.modele.Player;
import arg.vue.Combat;
import arg.vue.Message;

public class MobBz {

	public static String GenMob(Mob monstre) {
		String nom = "";
		int num = 0;
		num = Generator.GenNb(1, 25);
		switch (num) {
		case 1:
			nom = "un Goblin";
			monstre.setWeak("Attaque");
			monstre.setResist("Magie");
			monstre.setCastMag("Aucune");
			break;

		case 2:
			nom = "un Chien";
			monstre.setWeak("Aucune");
			monstre.setResist("Aucune");
			monstre.setCastMag("Aucune");
			break;

		case 3:
			nom = "une Grand-mère péssimiste";
			monstre.setWeak("Soin");
			monstre.setResist("Aucune");
			monstre.setCastMag("Aucune");
			break;

		case 4:
			nom = "un Dragon";
			monstre.setWeak("Glace");
			monstre.setResist("Attaque");
			monstre.setCastMag("Feu");
			break;

		case 5:
			nom = "un Rat";
			monstre.setWeak("Terre");
			monstre.setResist("Aucune");
			monstre.setCastMag("Aucune");
			break;

		case 6:
			nom = "un Rat";
			monstre.setWeak("Terre");
			monstre.setResist("Aucune");
			monstre.setCastMag("Aucune");
			break;

		case 7:
			nom = "un Géant de feu";
			monstre.setWeak("Glace");
			monstre.setResist("Feu");
			monstre.setCastMag("Aucune");
			break;

		case 8:
			nom = "un Nain de jardin";
			monstre.setWeak("Foudre");
			monstre.setResist("Aucune");
			monstre.setCastMag("Aucune");
			break;

		case 9:
			nom = "un Chat sauvage";
			monstre.setWeak("Eau");
			monstre.setResist("Aucune");
			monstre.setCastMag("Aucune");
			break;

		case 10:
			nom = "un Alien";
			monstre.setWeak("Eau");
			monstre.setResist("Gravite");
			monstre.setCastMag("Aucune");
			break;

		case 11:
			nom = "un Joker";
			monstre.setWeak("Magie");
			monstre.setResist("Attaque");
			monstre.setCastMag("Folie");
			break;

		case 12:
			nom = "un Lapin rageux";
			monstre.setWeak("Aucune");
			monstre.setResist("Aucune");
			monstre.setCastMag("Aucune");
			break;

		case 13:
			nom = "une Sangsue aquatique";
			monstre.setWeak("Foudre");
			monstre.setResist("Eau");
			monstre.setCastMag("Eau");
			break;

		case 14:
			nom = "une Sorciére des landes";
			monstre.setWeak("Aucune");
			monstre.setResist("Magie");
			monstre.setCastMag("Vent");
			break;

		case 15:
			nom = "une Masse gélantneuse";
			monstre.setWeak("Aucune");
			monstre.setResist("Glace");
			monstre.setCastMag("Aucune");
			break;

		case 16:
			nom = "un Kobold";
			monstre.setWeak("Aucune");
			monstre.setResist("Aucune");
			monstre.setCastMag("Morphée");
			break;

		case 17:
			nom = "un Nuage d'acide";
			monstre.setWeak("Vent");
			monstre.setResist("Attaque");
			monstre.setCastMag("Folie");
			break;

		case 18:
			nom = "une Fée déchue";
			monstre.setWeak("Soin");
			monstre.setResist("Glace");
			monstre.setCastMag("Folie");
			break;

		case 19:
			nom = "une Hyène";
			monstre.setWeak("Aucune");
			monstre.setResist("Aucune");
			monstre.setCastMag("Aucune");
			break;

		case 20:
			nom = "une Plante carnivore";
			monstre.setWeak("Aucune");
			monstre.setResist("Feu");
			monstre.setCastMag("Aucune");
			break;

		case 21:
			nom = "un Guerrier morbide";
			monstre.setWeak("Feu");
			monstre.setResist("Aucune");
			monstre.setCastMag("Aucune");
			break;

		case 22:
			nom = "un Oiseau de fer";
			monstre.setWeak("Vent");
			monstre.setResist("Attaque");
			monstre.setCastMag("Aucune");
			break;

		case 23:
			nom = "un Elementaire de feu";
			monstre.setWeak("Glace");
			monstre.setResist("Feu");
			monstre.setCastMag("Feu");
			break;

		case 24:
			nom = "un Elementaire de foudre";
			monstre.setWeak("Eau");
			monstre.setResist("Foudre");
			monstre.setCastMag("Foudre");
			break;

		case 25:
			nom = "un Elementaire de glace";
			monstre.setWeak("Feu");
			monstre.setResist("Glace");
			monstre.setCastMag("Glace");
			break;
		}
		return nom;
	}

	public static void GenerationMob(Player joueur, Mob monstre) {
		if (joueur.getNiv() < 20) {
			int token = 30;
			monstre.setNom(GenMob(monstre));
			monstre.setHP(Generator.GenNb((joueur.getHP()- token), (joueur.getHP() + joueur.getNiv())));
			monstre.setMP(Generator.GenNb((joueur.getMP() - token), (joueur.getMP() + joueur.getNiv())));
			monstre.setATK(Generator.GenNb((joueur.getATK() - token), (joueur.getATK() + joueur.getNiv())));
			monstre.setDEF(Generator.GenNb((joueur.getDEF() - token), (joueur.getDEF() + joueur.getNiv())));
			monstre.setINT(Generator.GenNb((joueur.getINT()) - token, (joueur.getINT() + joueur.getNiv())));

		}

	}

	public static void MobAtk(Player joueur, Mob monstre) throws IOException, InterruptedException {
		ASCIIBuilder.ASCIIBuild("(◣_◢)");
		Message.Msg2("L'ennemi attaque ! ");
		Pause.PauseAff(800);
		/* Coup critique */
		int choix = 0;
		int num = 0;
		double hit = 0;
		
		/* Check si le monstre à une magie */
		if (monstre.getCastMag() == "Aucune")
			{
			choix = Generator.GenNb(1, 19);	
			}
		
		else
			{
			choix = Generator.GenNb(1, 20);	
			}
		
		switch (choix) {

		case 1:
			Sound.PlayMusic("./sounds/sickle.wav");
			Message.Msg("Coup critique !");
			Pause.PauseAff(800);
			num = (monstre.getATK() * 2);
			num = num - joueur.getDEF();
			hit = Generator.GenNb(-10, 10);
			hit = (double) num * (hit / (double) 100) + (double) num;
			joueur.setHP((joueur.getHP() - (int) hit));
			Message.Msg("Il effectue une attaque de " + (int) hit + " HP !");

			if (joueur.getHP() <= 0) {
				Message.Msg("Par votre courage, vous disposez d'un répit !");
				joueur.setHP(1);
			}
			break;

		case 2:
			Sound.PlayMusic("./sounds/hit2.wav");
			Message.Msg("Attaque raté !");
			Pause.PauseAff(800);
			break;
			
			/* Magie */
		case 20:
			String nomMagie = monstre.getCastMag();
			Magie magie = new Magie();	
				if (monstre.getMP() >= (magie.getMPneed())) {
					Sound.PlayMusic("./sounds/limit.wav");
				}

			if (monstre.getMP() < (magie.getMPneed())) {
				Message.Msg2("L'ennemi n'a plus assez d'MP !");
				Message.Confirm();
				MobBz.MobAtk(joueur, monstre);
			}

			switch (nomMagie) {
			case "Feu":
				MagieBz.Brasier(magie);
				MagieBz.MobMag(joueur, monstre, magie);
				break;
			case "Glace":
				MagieBz.Glacier(magie);
				MagieBz.MobMag(joueur, monstre, magie);
				break;
			case "Foudre":
				MagieBz.Foudre(magie);
				MagieBz.MobMag(joueur, monstre, magie);
				break;
			case "Soin":
				MagieBz.Soin(magie);
				MagieBz.MobMag(joueur, monstre, magie);
				break;
			case "Bouclier":
				MagieBz.Bouclier(magie);
				MagieBz.MobMag(joueur, monstre, magie);
				break;
			case "Terre":
				MagieBz.Tremblement(magie);
				MagieBz.MobMag(joueur, monstre, magie);
				break;
			case "Eau":
				MagieBz.Foudre(magie);
				MagieBz.MobMag(joueur, monstre, magie);
				break;
			case "Vent":
				MagieBz.Foudre(magie);
				MagieBz.MobMag(joueur, monstre, magie);
				break;
			case "Morphée":
				MagieBz.Morphée(magie);
				MagieBz.MobMag(joueur, monstre, magie);
			case "Folie":
				MagieBz.Folie(magie);
				MagieBz.MobMag(joueur, monstre, magie);
				
				break;
			}
			break;

		default:
			Sound.PlayMusic("./sounds/hit.wav");

			if (monstre.getATK() - joueur.getDEF() > 0) {
				num = (monstre.getATK());
				num = num - joueur.getDEF();
				hit = Generator.GenNb(-10, 10);
				hit = (double) num * (hit / (double) 100) + (double) num;
				joueur.setHP((joueur.getHP() - (int) hit));
				Message.Msg("Il effectue une attaque de " + (int) hit + " HP !");
			}

			if (monstre.getATK() - joueur.getDEF() <= 0) {
				Message.Msg("Votre armume absorde ses dégats ! ");
				Message.Msg("Attention, l'ennemi s'énerve ! sa puisance d'attaque augmente !");
				monstre.setATK((int) (monstre.getATK() * 1.5));
			}
			if (joueur.getHP() <= 0)
				joueur.setHP(0);
			Pause.PauseAff(800);
			Check.CheckHP(joueur, monstre);
			Message.Msg("Il vous reste " + joueur.getHP() + " HP !");

		}
		Message.Confirm();
		Combat.Arene(joueur, monstre);
	}
}