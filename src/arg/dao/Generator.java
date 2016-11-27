package arg.dao;

import java.util.Random;

public class Generator {

	public static int GenNb(int min, int max) {
		Random rn = new Random();
		int num = rn.nextInt(max - min + 1) + min;
		return num;

	}

}
