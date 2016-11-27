package arg.dao;

import java.io.File;
import java.net.URL;
import java.util.Properties;

import de.quippy.javamod.mixer.Mixer;
import de.quippy.javamod.multimedia.MultimediaContainer;
import de.quippy.javamod.multimedia.MultimediaContainerManager;
import de.quippy.javamod.system.Helpers;

public class Sound {

	public static synchronized void PlayMusic(String musicfile) { // background
		new Thread(new Runnable() { // background
			public void run() { // background
				boolean boucle = false;
				do {
					try {
						Helpers.registerAllClasses();
						File music = new File(musicfile);
						Properties props = new Properties();
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

}
