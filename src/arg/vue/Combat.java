package arg.vue;

import java.io.IOException;
import java.util.Scanner;

import arg.controlleur.Check;
import arg.controlleur.MagieBz;
import arg.controlleur.MobBz;
import arg.controlleur.PlayerBz;
import arg.dao.*;
import arg.modele.Mob;
import arg.modele.Player;
import arg.modele.Magie;

public class Combat {

	public static void Arene(Player joueur, Mob monstre) throws IOException, InterruptedException {
		boolean boucle;
		do {
			boucle = false;
			joueur.setYouTurn(true);
			String choix;
			Scanner sc2;
			ASCIIBuilder.ASCIIBuild("(◣_◢)");
			Sound.PlayMusic("./sounds/youturn.wav");
			Message.Msg2("Vous rencontrez " + monstre.getNom() + " ! ");
			Message.Msg(monstre.getHP() + " HP /  " + monstre.getMP() + " MP / " + monstre.getATK() + " ATK / " + monstre.getDEF() + " DEF / " + monstre.getINT() + " INT  ");
			Message.Msg2("Selectionnez votre action :");
			Message.Msg("		>>> " + joueur.getNom() + " Niv°" + joueur.getNiv() + " <<<");
			Message.Msg("-------------------------------------------------");
			Message.Msg("     A - Attaquer          |     HP: " + joueur.getHP() + "/" + joueur.getHPmax() + "");
			Message.Msg("     M - Magie             |     MP: " + joueur.getMP() + "/" + joueur.getMPmax() + "");
			Message.Msg("     F - Fuir              |     ATK: " + joueur.getATK() + "");
			Message.Msg("     O - Objets (N/A)      |     DEF: " + joueur.getDEF() + "");
			Message.Msg("     Q - Quitter le jeu    |     INT: " + joueur.getINT() + "");
			Message.Msg("-------------------------------------------------");
			sc2 = new Scanner(System.in);
			String scanner = sc2.nextLine();
			choix = (scanner.toUpperCase());
			System.out.print("\033[H\033[2J");
			ASCIIBuilder.ASCIIBuild("(◣_◢)");
			switch (choix) {
			case "A":
				Check.CheckBeforeAct(joueur, monstre, null);
				PlayerBz.PersoAtk(joueur, monstre);
				break;
			case "M":
				Combat.MenuMagie(joueur, monstre);
				break;
			case "F":
				PersoFuite(joueur, monstre);
				break;
			case "V":
				Message.VoirPerso(joueur);
				break;
			case "Q":
				Message.Msg2("Bye-bye !");
				Sound.PlayMusic("./sounds/good.wav");
				Pause.PauseAff(500);
				System.exit(0);
				break;
			default:
				Message.Msg("Veuillez saisir une lettre valable !");
				Message.Confirm();
				Combat.Arene(joueur, monstre);
			}
		} while (boucle == true);
	}

	public static void MenuMagie(Player joueur, Mob monstre) throws IOException, InterruptedException {
		Magie magie = new Magie();
		boolean boucle;
		do {
			boucle = false;
			String choix2 = "";
			Sound.PlayMusic("./sounds/youturn.wav");
			Message.Msg2("Liste de vos magies");
			Message.Msg("----------------------------");
			MagieBz.Brasier(magie);
			Message.Msg("     F - Feu ( " + magie.getMPneed() + " MP)               ");
			MagieBz.Glacier(magie);
			Message.Msg("     G - Glace ( " + magie.getMPneed() + " MP)              ");
			MagieBz.Foudre(magie);
			Message.Msg("     E - Foudre ( " + magie.getMPneed() + " MP)              ");
			MagieBz.Soin(magie);
			Message.Msg("     S - Soin ( " + magie.getMPneed() + " MP)              ");
			MagieBz.Bouclier(magie);
			Message.Msg("     B - Bouclier ( " + magie.getMPneed() + " MP)              ");
			MagieBz.Tremblement(magie);
			Message.Msg("     T - Terre ( " + magie.getMPneed() + " MP)              ");
			MagieBz.Bulles(magie);
			Message.Msg("     W - Eau ( " + magie.getMPneed() + " MP)              ");
			MagieBz.Brise(magie);
			Message.Msg("     V - Vent ( " + magie.getMPneed() + " MP)              ");
			Message.Msg("     A - Annuler                   						   ");
			Message.Msg("----------------------------");
			Scanner sc3;
			sc3 = new Scanner(System.in);
			String scanner3 = sc3.nextLine();
			choix2 = (scanner3.toUpperCase());

			switch (choix2) {
			case "F":
				MagieBz.Brasier(magie);
				Check.CheckBeforeAct(joueur, monstre, null);
				MagieBz.PersoMag(joueur, monstre, magie);
				break;

			case "G":
				MagieBz.Glacier(magie);
				Check.CheckBeforeAct(joueur, monstre, null);
				MagieBz.PersoMag(joueur, monstre, magie);
				break;

			case "E":
				MagieBz.Foudre(magie);
				Check.CheckBeforeAct(joueur, monstre, null);
				MagieBz.PersoMag(joueur, monstre, magie);
				break;

			case "B":
				MagieBz.Bouclier(magie);
				Check.CheckBeforeAct(joueur, monstre, null);
				MagieBz.PersoMag(joueur, monstre, magie);
				break;

			case "S":
				MagieBz.Soin(magie);
				Check.CheckBeforeAct(joueur, monstre, null);
				MagieBz.PersoMag(joueur, monstre, magie);
				break;

			case "T":
				MagieBz.Tremblement(magie);
				Check.CheckBeforeAct(joueur, monstre, null);
				MagieBz.PersoMag(joueur, monstre, magie);
				break;

			case "W":
				MagieBz.Bulles(magie);
				Check.CheckBeforeAct(joueur, monstre, null);
				MagieBz.PersoMag(joueur, monstre, magie);
				break;

			case "V":
				MagieBz.Brise(magie);
				Check.CheckBeforeAct(joueur, monstre, null);
				MagieBz.PersoMag(joueur, monstre, magie);
				break;

			case "A":
				System.out.print("\033[H\033[2J");
				Combat.Arene(joueur, monstre);
				break;
			default:
				Message.Msg("Veuillez saisir une lettre valable !");
				Message.Confirm();
				Combat.Arene(joueur, monstre);
			}
		} while (boucle == true);
	}
	
	public static void PersoFuite(Player joueur, Mob monstre) throws IOException, InterruptedException {
		Message.Msg2("Tentative de fuite !");
		Pause.PauseAff(800);
		int num = 0;
		num = Generator.GenNb(1, 5);
		switch (num) {
		case 1:
			Message.Msg("Vous vous cassez la gueule en tentant de fuir !");
			Pause.PauseAff(800);
			Message.Msg("Cette maladresse vous fait perdre 2 points d'attaque !");
			joueur.setATK(joueur.getATK() - 2);
			Message.Confirm();
			MobBz.MobAtk(joueur, monstre);
			break;

		case 2:
			Message.Msg("Vous avez réussi à fuir !");
			Pause.PauseAff(800);
			MobBz.GenerationMob(joueur, monstre);
			Message.Msg(">>> Preparez-vous pour le prochain ennemi : " + monstre.getNom() + " !");
			Message.Msg("");
			Message.Confirm();
			Combat.Arene(joueur, monstre);

		default:
			Message.Msg("L'ennemi vous rattrape !");
			Pause.PauseAff(1000);
			Message.Msg("Il riposte !");
			Pause.PauseAff(1000);
			MobBz.MobAtk(joueur, monstre);
		}
	}
}