package arg.dao;

import java.io.File;
import java.net.URL;
import java.util.Properties;

import de.quippy.javamod.mixer.Mixer;
import de.quippy.javamod.multimedia.MultimediaContainer;
import de.quippy.javamod.multimedia.MultimediaContainerManager;
import de.quippy.javamod.multimedia.mod.ModContainer;
import de.quippy.javamod.system.Helpers;

public class Music {

	public static synchronized void PlayMusic(String musicfile) { // background
		new Thread(new Runnable() { // background
			public void run() { // background
				boolean boucle = true;
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
						mixer.startPlayback();
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
						System.exit(3);
					} catch (Exception e) {
						e.printStackTrace();
					}
				} while (boucle == true);
			}

		}).start(); // background
	}

	public static void ChoixMusic() {
		int num = 0;
		final String PATH = "./music/";
		String name;
		num = Generator.GenNb(1, 10);
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
}
