package arg.dao;

import de.quippy.javamod.mixer.Mixer;
import de.quippy.javamod.multimedia.MultimediaContainer;
import de.quippy.javamod.multimedia.MultimediaContainerManager;
import de.quippy.javamod.multimedia.mod.ModContainer;
import de.quippy.javamod.system.Helpers;

import java.io.File;
import java.net.URL;
import java.util.Properties;

public class Music {
    protected static boolean play = true;

    public boolean stop = false;

    public static synchronized void PlayMusic(String musicfile) { // background
        new Thread(new Runnable() { // background
            public void run() { // background
                boolean boucle = true;
                while (play) {
                    do {
                        try {
                            Helpers.registerAllClasses();
                            File music = new File(musicfile);
                            Properties props = new Properties();
                            props.setProperty(ModContainer.PROPERTY_PLAYER_ISP, "2");
                            props.setProperty(ModContainer.PROPERTY_PLAYER_STEREO, "2");
                            props.setProperty(ModContainer.PROPERTY_PLAYER_WIDESTEREOMIX, "FALSE");
                            props.setProperty(ModContainer.PROPERTY_PLAYER_NOISEREDUCTION, "TRUE");
                            props.setProperty(ModContainer.PROPERTY_PLAYER_MEGABASS, "TRUE");
                            props.setProperty(ModContainer.PROPERTY_PLAYER_BITSPERSAMPLE, "8");
                            props.setProperty(ModContainer.PROPERTY_PLAYER_FREQUENCY, "44100");
                            MultimediaContainerManager.configureContainer(props);
                            URL modUrl = music.toURI().toURL();
                            MultimediaContainer multimediaContainer = MultimediaContainerManager
                                    .getMultimediaContainer(modUrl);
                            Mixer mixer = multimediaContainer.createNewMixer();
                            StartMixer(mixer);
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                            System.exit(3);
                        } catch (Exception e) {
                            e.printStackTrace();
                            System.exit(3);
                        }
                    } while (boucle);
                }
            }

        }).start(); // background
    }


    public static void StartMixer(Mixer mixer) {
        mixer.startPlayback();
    }



    public static void ChoixMusic() {
        int num;
        final String PATH = "./music/";
        String name;
        num = Generator.GenNb(6, 6);
        switch (num) {
            case 1:
                name = "sun.xm";
                break;
            case 2:
                name = "sky.xm";
                break;
            case 3:
                name = "distant_lullaby.ogg";
                break;
            case 4:
                name = "GhildaPop.xm";
                break;
            case 5:
                name = "sad.xm";
                break;
            case 6:
                name = "strangehold.xm";
                break;
            default:
                name = "distant_lullaby.ogg";
        }
        Music.PlayMusic(PATH + name);
    }

    public static void StopMusic() {
        play = false;
    }
}
