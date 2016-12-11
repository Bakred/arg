package arg.controlleur;

import arg.dao.*;
import arg.modele.Mob;
import arg.modele.Player;
import arg.vue.MenuWorld;
import arg.vue.Message;

import java.io.IOException;
import java.util.Scanner;

public class PlayerBz {

    public static void CreationPerso(Player joueur) throws IOException, InterruptedException {
        String choix2 = "";
        Message.Msg2("Saissisez le nom de votre personnage :");
        Scanner sc4 = new Scanner(System.in);
        String scanner = sc4.nextLine();
        String nom = (scanner);
        joueur.setNom(nom);
        if (nom.equals(choix2)) {
            Message.Msg2("Veuillez saisir un nom de personnage !");
            Message.Confirm();
            MenuWorld.CarteDuMonde();
        }
        System.out.print("\033[H\033[2J");
        Music.StopMusic();
        Sound.PlayMusic("./sounds/youturn.wav");
        ASCIIBuilder.ASCIIBuild("(◕_◕)");
        Message.Msg2("Bonjour " + joueur.getNom() + " !");
        Pause.PauseAff(800);
        Message.Msg2("Génération des caractéristiques....");
        joueur.setHP(Generator.GenNb(110, 160));
        joueur.setHPmax(joueur.getHP());
        joueur.setMP(Generator.GenNb(20, 50));
        joueur.setMPmax(joueur.getMP());
        joueur.setATK(Generator.GenNb(15, 25));
        joueur.setDEF(Generator.GenNb(5, 10));
        joueur.setINT(Generator.GenNb(5, 15));
        Message.VoirPerso(joueur);
        System.out.print("\033[H\033[2J");

    }

    public static void PersoAtk(Player joueur, Mob monstre) throws IOException, InterruptedException {
        String type = "Attaque";
        Message.Msg2("Tentative d'attaque!");
        Sound.PlayMusic("./sounds/goatk.wav");
        Pause.PauseAff(800);


        int crit;
        int num;
        double hit;
        crit = Generator.GenNb(1, 20);
        switch (crit) {
            // Coup critique
            case 1:
                Sound.PlayMusic("./sounds/sickle.wav");
                Message.Msg("Coup critique !");
                Pause.PauseAff(800);
                num = (joueur.getATK()) * 2;
                num = num - monstre.getDEF();
                num = Check.CheckWeakResist(joueur, monstre, num, "", type);
                hit = Generator.GenNb(0, 10);
                hit = (double) num * (hit / (double) 100) + (double) num;
                monstre.setHP((monstre.getHP() - (int) hit));
                Message.Msg("Vous effectuez une attaque de " + (int) hit + " HP !");
                if (monstre.getHP() <= 0)
                    monstre.setHP(0);
                Pause.PauseAff(800);
                Check.CheckHP(joueur, monstre);
                break;
            // Attaque raté
            case 2:
                Sound.PlayMusic("./sounds/miss.wav");
                Message.Msg("Attaque raté !");
                Pause.PauseAff(800);
                break;
            // Attaque normale
            default:
                Sound.PlayMusic("./sounds/hit3.wav");

                num = joueur.getATK();
                num = num - monstre.getDEF();
                num = Check.CheckWeakResist(joueur, monstre, num, "", type);
                hit = Generator.GenNb(0, 100);
                hit = (double) num * (hit / (double) 100) + (double) num;
                monstre.setHP((monstre.getHP() - (int) hit));
                Message.Msg("Vous effectuez une attaque de " + (int) hit + " HP !");

                if (monstre.getHP() <= 0)
                    monstre.setHP(0);
                Pause.PauseAff(800);
                Check.CheckHP(joueur, monstre);
                Message.Msg("Il reste " + monstre.getHP() + " HP à l'ennemi !");
        }
        Message.Confirm();
        MobBz.MobAtk(joueur, monstre);
    }

}