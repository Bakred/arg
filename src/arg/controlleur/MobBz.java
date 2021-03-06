package arg.controlleur;

import arg.dao.*;
import arg.modele.Magie;
import arg.modele.Mob;
import arg.modele.Player;
import arg.vue.Combat;
import arg.vue.Message;

import java.io.IOException;

public class MobBz {

    public static String GenMob(Mob monstre) {
        String nom = "";
        int num;
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
                monstre.setCastMag("Morphée");
                break;

            case 4:
                nom = "un Dragon";
                monstre.setWeak("Glacier");
                monstre.setResist("Attaque");
                monstre.setCastMag("Brasier");
                break;

            case 5:
                nom = "un Rat";
                monstre.setWeak("Tremblement");
                monstre.setResist("Aucune");
                monstre.setCastMag("Aucune");
                break;

            case 6:
                nom = "un Rat";
                monstre.setWeak("Tremblement");
                monstre.setResist("Aucune");
                monstre.setCastMag("Aucune");
                break;

            case 7:
                nom = "un Géant de feu";
                monstre.setWeak("Glacier");
                monstre.setResist("Brasier");
                monstre.setCastMag("Brasier");
                break;

            case 8:
                nom = "un Nain de jardin";
                monstre.setWeak("Foudre");
                monstre.setResist("Aucune");
                monstre.setCastMag("Folie");
                break;

            case 9:
                nom = "un Chat sauvage";
                monstre.setWeak("Bulles");
                monstre.setResist("Aucune");
                monstre.setCastMag("Aucune");
                break;

            case 10:
                nom = "un Alien";
                monstre.setWeak("Bulles");
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
                monstre.setResist("Bulles");
                monstre.setCastMag("Bulles");
                break;

            case 14:
                nom = "une Sorciére des landes";
                monstre.setWeak("Aucune");
                monstre.setResist("Magie");
                monstre.setCastMag("Brise");
                break;

            case 15:
                nom = "une Masse gélantneuse";
                monstre.setWeak("Attaque");
                monstre.setResist("Glacier");
                monstre.setCastMag("Soin");
                break;

            case 16:
                nom = "un Kobold";
                monstre.setWeak("Aucune");
                monstre.setResist("Aucune");
                monstre.setCastMag("Morphée");
                break;

            case 17:
                nom = "un Nuage d'acide";
                monstre.setWeak("Brise");
                monstre.setResist("Attaque");
                monstre.setCastMag("Morphée");
                break;

            case 18:
                nom = "une Fée déchue";
                monstre.setWeak("Brise");
                monstre.setResist("Glacier");
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
                monstre.setWeak("Brasier");
                monstre.setResist("Bulles");
                monstre.setCastMag("Aucune");
                break;

            case 21:
                nom = "un Guerrier morbide";
                monstre.setWeak("Brasier");
                monstre.setResist("Aucune");
                monstre.setCastMag("Aucune");
                break;

            case 22:
                nom = "un Oiseau de fer";
                monstre.setWeak("Brise");
                monstre.setResist("Attaque");
                monstre.setCastMag("Brise");
                break;

            case 23:
                nom = "un Elementaire de feu";
                monstre.setWeak("Glacier");
                monstre.setResist("Brasier");
                monstre.setCastMag("Brasier");
                break;

            case 24:
                nom = "un Elementaire de foudre";
                monstre.setWeak("Bulles");
                monstre.setResist("Foudre");
                monstre.setCastMag("Foudre");
                break;

            case 25:
                nom = "un Elementaire de glace";
                monstre.setWeak("Brasier");
                monstre.setResist("Glacier");
                monstre.setCastMag("Glacier");
                break;
        }
        return nom;
    }

    public static void GenerationMob(Player joueur, Mob monstre) throws IOException {
        if (joueur.getNiv() < 20) {

            monstre.setNom(GenMob(monstre));

			/* HP */
            double tokenHPmin = -70 + joueur.getNiv();
            double tokenHPmax = -50 + joueur.getNiv();
            double tamp = Generator.GenNbDouble((joueur.getHPmax() * (tokenHPmin / 100) + (double) joueur.getHPmax()),
                    (joueur.getHPmax() * (tokenHPmax / 100) + (double) joueur.getHPmax()));
            monstre.setHP((int) tamp);

			/* MP */
            double tokenMPmin = -20 + joueur.getNiv();
            double tokenMPmax = 20 + joueur.getNiv();
            tamp = Generator.GenNbDouble((joueur.getMPmax() * (tokenMPmin / 100) + (double) joueur.getMPmax()),
                    (joueur.getMPmax() * (tokenMPmax / 100) + (double) joueur.getMPmax()));
            monstre.setMP((int) tamp);

			/* ATK */
            double tokenATKmin = 0 + joueur.getNiv();
            double tokenATKmax = 10 + joueur.getNiv();
            tamp = Generator.GenNbDouble((joueur.getATK() * (tokenATKmin / 100) + (double) joueur.getATK()),
                    (joueur.getATK() * (tokenATKmax / 100) + (double) joueur.getATK()));
            monstre.setATK((int) tamp);

			/* DEF */
            double tokenDEFmin = -30 + joueur.getNiv();
            double tokenDEFmax = -20 + joueur.getNiv();
            if (tokenDEFmax >= 0) {
                tokenDEFmax = 0;
            }

            if (tokenDEFmin >= 0) {
                tokenDEFmin = 0;
            }
            tamp = Generator.GenNbDouble((joueur.getDEF() * (tokenDEFmin / 100) + (double) joueur.getDEF()),
                    (joueur.getDEF() * (tokenDEFmax / 100) + (double) joueur.getDEF()));
            monstre.setDEF((int) tamp);

			/* INT */
            double tokenINTmin = -20 + joueur.getNiv();
            double tokenINTmax = 20 + joueur.getNiv();
            tamp = Generator.GenNbDouble((joueur.getINT() * (tokenINTmin / 100) + (double) joueur.getINT()),
                    (joueur.getINT() * (tokenINTmax / 100) + (double) joueur.getINT()));
            monstre.setINT((int) tamp);
            // prixTTC = prixHT * ( 23 / 100 ) + prixHT;
        }

        if (joueur.getNiv() == 20) {
            Music.StopMusic();
            Music.PlayMusic("./music/end.XM");
            ASCIIBuilder.ASCIIBuild("; )");
            Message.Msg2("Vous avez gagné la partie !");
            Message.Confirm();
            System.exit(3);
        }
    }

    public static void MobAtk(Player joueur, Mob monstre) throws IOException, InterruptedException {
        ASCIIBuilder.ASCIIBuild("(◣_◢)");
        Message.Msg2("L'ennemi attaque ! ");
        joueur.setYouTurn(false);
        Pause.PauseAff(800);
        int choix;
        int num;
        double hit;

        // Check si le monstre à une magie
        if (monstre.getCastMag().equals("Aucune")) {
            choix = Generator.GenNb(1, 19);
        } else {
            choix = Generator.GenNb(1, 20);
        }

        switch (choix) {
            // Critique
            case 1:
                Sound.PlayMusic("./sounds/sickle.wav");
                Message.Msg("Coup critique !");
                Pause.PauseAff(800);
                num = (monstre.getATK() * 2);
                num = num - joueur.getDEF();
                hit = Generator.GenNb(0, 10);
                hit = (double) num * (hit / (double) 100) + (double) num;
                joueur.setHP((joueur.getHP() - (int) hit));
                Message.Msg("Il effectue une attaque de " + (int) hit + " HP !");
                Pause.PauseAff(800);

                if (joueur.getHP() <= 0) {
                    Message.Msg("Par votre courage, vous disposez d'un répit !");
                    joueur.setHP(1);
                }
                break;
            // Raté
            case 2:
                Sound.PlayMusic("./sounds/hit2.wav");
                Message.Msg("Attaque raté !");
                Pause.PauseAff(800);
                break;

            // Magie
            case 20:
                String nomMagie = monstre.getCastMag();
                Magie magie = new Magie();
                Check.CheckMP(joueur, monstre, magie);

                switch (nomMagie) {
                    case "Brasier":
                        MagieBz.Brasier(magie);
                        MagieBz.LaunchMag(joueur, monstre, magie);
                        break;
                    case "Glacier":
                        MagieBz.Glacier(magie);
                        MagieBz.LaunchMag(joueur, monstre, magie);
                        break;
                    case "Foudre":
                        MagieBz.Foudre(magie);
                        MagieBz.LaunchMag(joueur, monstre, magie);
                        break;
                    case "Soin":
                        MagieBz.Soin(magie);
                        MagieBz.LaunchMag(joueur, monstre, magie);
                        break;
                    case "Bouclier":
                        MagieBz.Bouclier(magie);
                        MagieBz.LaunchMag(joueur, monstre, magie);
                        break;
                    case "Tremblement":
                        MagieBz.Tremblement(magie);
                        MagieBz.LaunchMag(joueur, monstre, magie);
                        break;
                    case "Bulles":
                        MagieBz.Bulles(magie);
                        MagieBz.LaunchMag(joueur, monstre, magie);
                        break;
                    case "Brise":
                        MagieBz.Brise(magie);
                        MagieBz.LaunchMag(joueur, monstre, magie);
                        break;
                    case "Morphée":
                        MagieBz.Morphée(magie);
                        MagieBz.LaunchMag(joueur, monstre, magie);
                    case "Folie":
                        MagieBz.Folie(magie);
                        MagieBz.LaunchMag(joueur, monstre, magie);

                        break;
                }
                break;
            // Attaque normale
            default:
                Sound.PlayMusic("./sounds/hit.wav");

                if (monstre.getATK() - joueur.getDEF() > 0) {
                    num = (monstre.getATK());
                    num = num - joueur.getDEF();
                    hit = Generator.GenNb(0, 100);
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