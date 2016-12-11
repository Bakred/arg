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

public class MagieBz {

    public static void Brasier(Magie magie) {
        magie.setNomMagie("Brasier");
        magie.setType("Magie");
        magie.setMPneed(6);
        magie.setMinRange(12);
        magie.setMaxRange(24);
        magie.setMessage("une boule de feu");
        magie.setResult("Cette boule de feu");
        magie.setSndEffect("beatrush.wav");
    }

    public static void Glacier(Magie magie) {
        magie.setNomMagie("Glacier");
        magie.setType("Magie");
        magie.setMPneed(9);
        magie.setMinRange(20);
        magie.setMaxRange(30);
        magie.setMessage("une pique de glaçe");
        magie.setResult("Cette pique de glaçe");
        magie.setSndEffect("ice.wav");

    }

    public static void Foudre(Magie magie) {
        magie.setNomMagie("Foudre");
        magie.setType("Magie");
        magie.setMPneed(3);
        magie.setMinRange(0);
        magie.setMaxRange(72);
        magie.setMessage("un éclair");
        magie.setResult("Cette étincelle");
        magie.setSndEffect("bolt.wav");
    }

    public static void Bulles(Magie magie) {
        magie.setNomMagie("Bulles");
        magie.setType("Magie");
        magie.setMPneed(16);
        magie.setMinRange(40);
        magie.setMaxRange(70);
        magie.setMessage("des bulles d'eau");
        magie.setResult("Ces bulles d'eau");
        magie.setSndEffect("water.wav");
    }

    public static void Tremblement(Magie magie) {
        magie.setNomMagie("Tremblement");
        magie.setType("Magie");
        magie.setMPneed(12);
        magie.setMinRange(24);
        magie.setMaxRange(48);
        magie.setMessage("un tremblement de terre");
        magie.setResult("Ce tremblemment");
        magie.setSndEffect("terre.wav");
    }

    public static void Brise(Magie magie) {
        magie.setNomMagie("Vent");
        magie.setType("Magie");
        magie.setMPneed(10);
        magie.setMinRange(26);
        magie.setMaxRange(36);
        magie.setMessage("une brise");
        magie.setResult("Cette brise");
        magie.setSndEffect("wind.wav");
    }

    public static void Soin(Magie magie) {
        magie.setNomMagie("Soin");
        magie.setType("MagSoin");
        magie.setMPneed(6);
        magie.setMinRange(30);
        magie.setMaxRange(80);
        magie.setMessage("un sort de soin");
        magie.setResult("Ce sort de soin");
        magie.setSndEffect("cure.wav");
    }

    public static void Bouclier(Magie magie) {
        magie.setNomMagie("Bouclier");
        magie.setType("MagBuff");
        magie.setMPneed(15);
        magie.setMinRange(0);
        magie.setMaxRange(0);
        magie.setMessage("un sort de bouclier physique ");
        magie.setResult("Ce bouclier");
        magie.setSndEffect("barrier2.wav");
    }

    public static void Morphée(Magie magie) {
        magie.setNomMagie("Morphée");
        magie.setType("Sleep");
        magie.setMPneed(0);
        magie.setMinRange(0);
        magie.setMaxRange(0);
        magie.setMessage("un sort de sommeil ");
        magie.setResult("Ce sort de sommeil");
        magie.setSndEffect("sleep.wav");
    }

    public static void Cyanure(Magie magie) {
        magie.setNomMagie("Cyanure");
        magie.setType("Poison");
        magie.setMPneed(0);
        magie.setMinRange(0);
        magie.setMaxRange(0);
        magie.setMessage("une bulle empoisonnée ");
        magie.setResult("Cette bulle");
        magie.setSndEffect("poison.wav");
    }

    public static void Folie(Magie magie) {
        magie.setNomMagie("Folie");
        magie.setType("Confu");
        magie.setMPneed(0);
        magie.setMinRange(0);
        magie.setMaxRange(0);
        magie.setMessage("une fumée assez spéciale ");
        magie.setResult("Cette fumée");
        magie.setSndEffect("confu.wav");
    }

    public static void Silence(Magie magie) {
        magie.setNomMagie("Silence");
        magie.setType("Mute");
        magie.setMPneed(0);
        magie.setMinRange(0);
        magie.setMaxRange(0);
        magie.setMessage("un CD de PNL ");
        magie.setResult("Ce CD");
        magie.setSndEffect("poison.wav");
    }

    public static void Furie(Magie magie) {
        magie.setNomMagie("Furie");
        magie.setType("Fury");
        magie.setMPneed(0);
        magie.setMinRange(0);
        magie.setMaxRange(0);
        magie.setMessage("une horrible insulte ");
        magie.setResult("Ce juron");
        magie.setSndEffect("fury.wav");
    }


    public static void LaunchMag(Player joueur, Mob monstre, Magie magie) throws IOException, InterruptedException {
        // Tour du joueur
        if (joueur.isYouTurn()) {
            System.out.print("\033[H\033[2J");
            ASCIIBuilder.ASCIIBuild("(◣_◢)");
            Check.CheckMP(joueur, monstre, magie);
            Message.Msg2("Vous lancez " + magie.getMessage() + " !");
            Pause.PauseAff(1000);
            Sound.PlayMusic("./sounds/" + magie.getSndEffect());
            int num;
            num = Generator.GenNb(joueur.getINT() + magie.getMinRange(), joueur.getINT() + magie.getMaxRange());
            num = Check.CheckWeakResist(joueur, monstre, num, magie.getNomMagie(), magie.getType());

		/* Soin */

            if (magie.getType().equals("MagSoin")) {
                if ((joueur.getHP() + num) >= joueur.getHPmax()) {
                    Message.Msg("Vous regagnez vos HP maximum ! (" + joueur.getHPmax() + ")");
                    joueur.setMP(joueur.getMP() - magie.getMPneed());
                    joueur.setHP(joueur.getHPmax());

                }
                if ((joueur.getHP() + num) < joueur.getHPmax()) {
                    Message.Msg("Vous regagnez " + num + " HP !");
                    joueur.setMP(joueur.getMP() - magie.getMPneed());
                    joueur.setHP(joueur.getHP() + num);
                }
                Pause.PauseAff(800);
                Message.Confirm();
                MobBz.MobAtk(joueur, monstre);
            }

		/* Bouclier */

            if (magie.getType().equals("MagBuff")) {
                double tamp;
                tamp = (double) joueur.getDEF() * ((double) 25 / (double) 100) + (double) joueur.getDEF();
                joueur.setDEF((int) tamp);
                joueur.setMP(joueur.getMP() - (magie.getMPneed() - joueur.getNiv()));
                Message.Msg("Votre défense augmente de 25% ! (" + joueur.getDEF() + ")");
                Pause.PauseAff(800);
                Message.Confirm();
                MobBz.MobAtk(joueur, monstre);
            }

		/* Le reste */

            if (magie.getType().equals("Magie")) {
                Message.Msg(magie.getResult() + " fait " + num + " HP de dommages !");
                joueur.setMP(joueur.getMP() - (magie.getMPneed()));
                if (joueur.getMP() <= 0)
                    joueur.setMP(0);
                monstre.setHP(monstre.getHP() - num);
                if (monstre.getHP() <= 0)
                    monstre.setHP(0);

                Pause.PauseAff(1000);
                Check.CheckHP(joueur, monstre);
                Message.Confirm();
                MobBz.MobAtk(joueur, monstre);
            }
        }

        // Tour du monstre
        if (joueur.isYouTurn() == false) {
            Message.Msg("L'ennemi lance " + magie.getMessage() + " !");
            Pause.PauseAff(800);
            Sound.PlayMusic("./sounds/" + magie.getSndEffect());
            int num;
            num = Generator.GenNb(monstre.getINT() + magie.getMinRange(), monstre.getINT() + magie.getMaxRange());
            num = Check.CheckWeakResist(joueur, monstre, num, magie.getNomMagie(), magie.getType());

		/* Soin */

            if (magie.getType().equals("MagSoin")) {
                if ((monstre.getHP() + num) >= monstre.getHPmax()) {
                    Message.Msg("L'ennemi regagne ses HP maximum ! (" + monstre.getHPmax() + ")");
                    monstre.setMP(monstre.getMP() - magie.getMPneed());
                    monstre.setHP(monstre.getHPmax());

                }
                if ((monstre.getHP() + num) < monstre.getHPmax()) {
                    Message.Msg("L'ennemi regagne " + num + " HP !");
                    monstre.setMP(monstre.getMP() - magie.getMPneed());
                    monstre.setHP(monstre.getHP() + num);
                }
                Pause.PauseAff(800);
                Message.Confirm();
                Combat.Arene(joueur, monstre);
            }

		/* Bouclier */

            if (magie.getType().equals("MagBuff")) {
                double tamp;
                tamp = (double) monstre.getDEF() * ((double) 25 / (double) 100) + (double) monstre.getDEF();
                monstre.setDEF((int) tamp);
                monstre.setMP(joueur.getMP() - (magie.getMPneed() - monstre.getINT()));
                Message.Msg("La défense de l'ennemi augmente de 25% ! ");
                Pause.PauseAff(800);
                Message.Confirm();
                Combat.Arene(joueur, monstre);
            }

		/* Morphée */

            if (magie.getType().equals("Sleep")) {
                int choix;
                choix = Generator.GenNb(1, 2);
                switch (choix) {
                    case 1:
                        Message.Msg(magie.getResult() + " vous fait dormir en plein combat !");
                        joueur.setSleep(true);
                        break;

                    case 2:
                        Message.Msg(magie.getResult() + " ne vous à pas atteint !");
                        break;
                }

                Pause.PauseAff(800);
                Message.Confirm();
                Combat.Arene(joueur, monstre);
            }

		/* Folie */

            if (magie.getType().equals("Confu")) {
                int choix;
                choix = Generator.GenNb(1, 2);
                switch (choix) {
                    case 1:
                        Message.Msg(magie.getResult() + " vous rend confus !");
                        joueur.setConfu(true);
                        break;

                    case 2:
                        Message.Msg(magie.getResult() + " ne vous à pas atteint !");
                        break;
                }

                Pause.PauseAff(800);
                Message.Confirm();
                Combat.Arene(joueur, monstre);
            }

        /* Poison */

            if (magie.getType().equals("Poison")) {
                int choix;
                choix = Generator.GenNb(1, 2);
                switch (choix) {
                    case 1:
                        Message.Msg(magie.getResult() + " vous empoisonne !");
                        joueur.setConfu(true);
                        break;

                    case 2:
                        Message.Msg(magie.getResult() + " ne vous à pas atteint !");
                        break;
                }

                Pause.PauseAff(800);
                Message.Confirm();
                Combat.Arene(joueur, monstre);
            }

		/* Le reste */

            if (magie.getType().equals("Magie")) {
                Message.Msg(magie.getResult() + " vous fait " + num + " HP de dommages !");
                monstre.setMP(monstre.getMP() - (magie.getMPneed()));
                if (monstre.getMP() <= 0)
                    monstre.setMP(0);
                joueur.setHP(joueur.getHP() - num);
                if (joueur.getHP() <= 0)
                    joueur.setHP(0);

                Check.CheckHP(joueur, monstre);
                Message.Confirm();
                Combat.Arene(joueur, monstre);
            }
        }
    }
    }
