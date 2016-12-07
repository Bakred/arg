package arg.controlleur;

import arg.dao.ASCIIBuilder;
import arg.dao.Generator;
import arg.dao.Pause;
import arg.dao.Sound;
import arg.modele.Magie;
import arg.modele.Mob;
import arg.modele.Player;
import arg.vue.Combat;
import arg.vue.Message;

import java.io.IOException;

public class Check {

    public static void CheckHP(Player joueur, Mob monstre) throws IOException, InterruptedException {
        if (joueur.getHP() <= 0) {
            Message.Msg("Vous avez été vaincu par l'ennemi !");
            Pause.PauseAff(800);
            Message.Confirm();
            ASCIIBuilder.ASCIIBuild("(*_*)");
            Message.Msg2("Vous avez perdu la partie...");
            Message.Msg2("Votre niveau : " + joueur.getNiv());
            System.exit(0);
        }
        if (monstre.getHP() <= 0) {
            Pause.PauseAff(200);
            Message.Msg("L'ennemi à été vaincu !");
            Sound.PlayMusic("./sounds/death.wav");
            Message.Confirm();
            Sound.PlayMusic("./sounds/good.wav");
            ASCIIBuilder.ASCIIBuild("; )");
            Message.Msg2("Vous avez gagné le combat !");
            Pause.PauseAff(800);
            int num = Generator.GenNb(1, 5);
            switch (num) {
                case 1:
                    Message.Msg(">>> Vous trouvez une potion étrange, vous regagnez tous vos MP !");
                    Message.Msg("");
                    Pause.PauseAff(800);
                    joueur.setMP(joueur.getMPmax());
                    break;
                case 2:
                    Message.Msg(">>> Vous trouvez un poulet rôti, vous regagnez tous vos HP !");
                    Message.Msg("");
                    Pause.PauseAff(800);
                    joueur.setHP(joueur.getHPmax());
                    break;
                case 3:
                    Message.Msg(">>> Vous trouvez un fortifiant, vous gagnez +25% points d'attaque !");
                    Message.Msg("");
                    Pause.PauseAff(800);
                    double tamp;
                    tamp = (double) joueur.getATK() * ((double) 25 / (double) 100) + (double) joueur.getATK();
                    // prixTTC = prixHT * ( 23 / 100 ) + prixHT;
                    joueur.setATK((int) tamp);
                    break;
                case 4:
                    Message.Msg(">>> Vous trouvez un chapeau rigolo, vous gagnez +25% points de défense !");
                    Message.Msg("");
                    Pause.PauseAff(800);
                    tamp = (double) joueur.getDEF() * ((double) 25 / (double) 100) + (double) joueur.getDEF();
                    // prixTTC = prixHT *( 23 / 100) + prixHT;
                    joueur.setDEF((int) tamp);
                    break;
                default:
            }
            joueur.setNiv(joueur.getNiv() + 1);

            Message.Msg(">>> Niveau " + joueur.getNiv() + " ! <<<");
            Pause.PauseAff(800);

            int tamp = joueur.getHPmax();
            int tamp2 = (joueur.getHPmax() + Generator.GenNb(joueur.getNiv() + 30, joueur.getNiv() + 50
            )); // 30
            joueur.setHPmax(tamp2); // 30
            tamp = tamp2 - tamp; // 4
            Message.Msg(" + " + tamp + " HP Max !");
            joueur.setHP(joueur.getHP() + tamp);
            Pause.PauseAff(200);

            tamp = joueur.getMPmax();
            tamp2 = (joueur.getMPmax() + Generator.GenNb(joueur.getNiv() + 4, joueur.getNiv() + 6));
            joueur.setMPmax(tamp2);
            tamp = tamp2 - tamp;
            Message.Msg(" + " + tamp + " MP Max !");
            joueur.setMP(joueur.getMP() + tamp);
            Pause.PauseAff(200);

            tamp = joueur.getATK();
            tamp2 = (joueur.getATK() + Generator.GenNb(joueur.getNiv() - 1, joueur.getNiv()));
            joueur.setATK(tamp2);
            tamp = tamp2 - tamp;
            Message.Msg(" + " + tamp + " ATK !");
            Pause.PauseAff(200);

            tamp = joueur.getDEF();
            tamp2 = (joueur.getDEF() + Generator.GenNb(joueur.getNiv() - 1, joueur.getNiv()));
            joueur.setDEF(tamp2);
            tamp = tamp2 - tamp;
            Message.Msg(" + " + tamp + " DEF !");
            Pause.PauseAff(200);

            tamp = joueur.getINT();
            tamp2 = (joueur.getINT() + Generator.GenNb(joueur.getNiv() - 1, joueur.getNiv()));
            joueur.setINT(tamp2);
            tamp = tamp2 - tamp;
            Message.Msg(" + " + tamp + " INT !");
            Pause.PauseAff(400);

            Message.Msg("");
            Message.VuePlayer(joueur.getNom(), joueur.getHP(), joueur.getMP(), joueur.getATK(), joueur.getDEF(),
                    joueur.getINT());
            MobBz.GenerationMob(joueur, monstre);
            Message.Msg(">>> Preparez-vous pour le prochain ennemi : " + monstre.getNom() + " !");
            Message.Msg("");
            Message.Confirm();
            Combat.Arene(joueur, monstre);
        }
    }

    public static void CheckMP(Player joueur, Mob monstre, Magie magie) throws IOException, InterruptedException {
        if (joueur.getMP() >= (magie.getMPneed())) {
            Sound.PlayMusic("./sounds/limit.wav");
        }

        if (joueur.getMP() < (magie.getMPneed())) {
            Message.Msg2("Pas assez d'MP !");
            Message.Confirm();
            Combat.Arene(joueur, monstre);
        }

    }

    public static int CheckWeakResist(Player joueur, Mob monstre, int num, String nomMagie, String type)
            throws IOException, InterruptedException {
        if (joueur.isYouTurn() == true) {
            if (type == "Magie") {
                if (monstre.getWeak().equals(nomMagie) == true || monstre.getWeak().equals(type) == true) {
                    num = num * 2;
                    Message.Msg("C'est trés éfficace ! ");
                }
                if (monstre.getResist().equals(nomMagie) == true || monstre.getResist().equals(type) == true) {
                    double tamp;
                    tamp = ((double) num / ((double) 2));
                    num = ((int) tamp);
                    Message.Msg("C'est peu éfficace... ");
                }
            }
        }


        if (joueur.isYouTurn() == true) {
            if (type == "Attaque") {
                if (monstre.getWeak().equals(type) == true) {
                    num = num * 2;
                    Message.Msg("C'est trés éfficace ! ");
                }
                if (monstre.getResist().equals(type) == true) {
                    double tamp;
                    tamp = ((double) num / ((double) 2));
                    num = ((int) tamp);
                    Message.Msg("C'est peu éfficace... ");
                }
            }
        }
        return num;
    }

    public static void CheckBeforeAct(Player joueur, Mob monstre, String type) throws InterruptedException, IOException {
        /* Sommeil */
        if (joueur.isSleep() == true) {

            Sound.PlayMusic("./sounds/sleep.wav");
            System.out.print("Vous êtes endormi... ");
            Pause.PauseAff(1000);
            System.out.print(" ... ");
            Pause.PauseAff(1000);
            int num = Generator.GenNb(1, 2);
            switch (num) {
                case 1:
                    System.out.print("... et ça dure !");
                    Pause.PauseAff(1000);
                    System.out.print("\033[H\033[2J");
                    MobBz.MobAtk(joueur, monstre);
                    break;

                case 2:
                    Message.Msg("vous vous réveillez ! ");
                    joueur.setSleep(false);
                    Pause.PauseAff(1000);
                    System.out.print("\033[H\033[2J");
                    MobBz.MobAtk(joueur, monstre);
                    break;
            }
        }
		/* Confusion */
        if (joueur.isConfu() == true) {

            Sound.PlayMusic("./sounds/confu.wav");
            Message.Msg2("Vous êtes confus ! ");
            Pause.PauseAff(1000);
            System.out.print(" ... ");
            Pause.PauseAff(1000);
            int num = Generator.GenNb(1, 3);
            switch (num) {
                case 1:
                    Sound.PlayMusic("./sounds/hit3.wav");
                    int hit = Generator.GenNb(-10 + joueur.getATK(), 10 + joueur.getATK());
                    joueur.setHP((joueur.getHP() - hit));
                    Message.Msg("Vous vous infilgez" + hit + " HP de dommages !");
                    Message.Confirm();
                    MobBz.MobAtk(joueur, monstre);
                    break;

                case 2:
                    System.out.print("Vous reprenez vos esprits ! ");
                    joueur.setConfu(false);
                    Message.Confirm();
                    if (type == "Attaque") {
                        PlayerBz.PersoAtk(joueur, monstre);
                    }
                    break;

                case 3:
                    Message.Msg("Vous attaquez malgré votre confusion ! ");
                    Pause.PauseAff(1000);
                    ASCIIBuilder.ASCIIBuild("(◣_◢)");
                    if (type == "Attaque") {
                        PlayerBz.PersoAtk(joueur, monstre);
                    }
                    break;
            }
        }
    }
}
