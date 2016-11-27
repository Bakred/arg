package arg.vue;

import java.util.Scanner;

import arg.dao.Pause;
import arg.modele.Player;

public class Message {

	public static void Msg(String Msg) {
		System.out.println(Msg);
	}
	
	
	public static void Msg2(String Msg) {
		Message.Msg("-------------------------------------------------");
		Message.Msg(Msg);
		Message.Msg("-------------------------------------------------");
		Message.Msg("");
	}
	
	public static void Confirm() {
		Message.Msg("Ok ?");
		Scanner sc;
		sc = new Scanner(System.in);
		sc.nextLine();
		System.out.print("\033[H\033[2J");
	}
	
	public static void VuePlayer(String Nom, int HP, int MP, int ATK, int DEF, int INT) throws InterruptedException {
		Message.Msg("Voici les caractéristiques actuelles de votre personnage :");
		Pause.PauseAff(200);
		Message.Msg(">>> Nom du personnage : " + Nom + "");
		Pause.PauseAff(200);
		Message.Msg(">>> Points de vie : " + HP + " HP ");
		Pause.PauseAff(200);
		Message.Msg(">>> Points de magie : " + MP + " MP ");
		Pause.PauseAff(200);
		Message.Msg(">>> Points d'attaque : " + ATK + " ATK ");
		Pause.PauseAff(200);
		Message.Msg(">>> Points de défense : " + DEF + " DEF ");
		Pause.PauseAff(200);
		Message.Msg(">>> Points d'intelligence : " + INT + " INT ");
		Message.Msg("");
	}

	public static void VoirPerso(Player joueur) throws InterruptedException {
		Message.VuePlayer(joueur.getNom(), joueur.getHPmax(), joueur.getMPmax(), joueur.getATK(), joueur.getDEF(),
				joueur.getINT());
		Message.Msg("---Appuyez sur Entrée pour continuer---");
		Scanner sc4 = new Scanner(System.in);
		sc4.nextLine();
		System.out.print("\033[H\033[2J");

	}
}
