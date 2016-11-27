package arg.modele;

public class Mob {

	private String nom;
	private int HP;
	private int HPmax;
	private int MP;
	private int MPmax;
	private int ATK;
	private int DEF;
	private int INT;
	private String weak = "";
	private String resist = "";
	private String CastMag;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getHP() {
		return HP;
	}

	public void setHP(int hP) {
		HP = hP;
	}

	public int getMP() {
		return MP;
	}

	public void setMP(int mP) {
		MP = mP;
	}

	public int getATK() {
		return ATK;
	}

	public void setATK(int aTK) {
		ATK = aTK;
	}

	public int getDEF() {
		return DEF;
	}

	public void setDEF(int dEF) {
		DEF = dEF;
	}

	public String getWeak() {
		return weak;
	}

	public void setWeak(String weak) {
		this.weak = weak;
	}

	public String getResist() {
		return resist;
	}

	public void setResist(String resist) {
		this.resist = resist;
	}

	public String getCastMag() {
		return CastMag;
	}

	public void setCastMag(String castMag) {
		CastMag = castMag;
	}

	public int getINT() {
		return INT;
	}

	public void setINT(int iNT) {
		INT = iNT;
	}

	public int getHPmax() {
		return HPmax;
	}

	public void setHPmax(int hPmax) {
		HPmax = hPmax;
	}

	public int getMPmax() {
		return MPmax;
	}

	public void setMPmax(int mPmax) {
		MPmax = mPmax;
	}

}
