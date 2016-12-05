package arg.modele;

public class Player {

	private String nom;
	private int HP;
	private int HPmax;
	private int MP;
	private int MPmax;
	private int ATK;
	private int DEF;
	private int INT;
	private int Niv = 1;
	private boolean youTurn = true;

	private boolean isPoison = false;
	private boolean isSleep = false;
	private boolean isConfu = false;
	private boolean isPara = false;
	private boolean isFury = false;
	private boolean isMute = false;

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

	public int getNiv() {
		return Niv;
	}

	public void setNiv(int niv) {
		Niv = niv;
	}

	public int getINT() {
		return INT;
	}

	public void setINT(int iNT) {
		INT = iNT;
	}

	public boolean isPoison() {
		return isPoison;
	}

	public void setPoison(boolean isPoison) {
		this.isPoison = isPoison;
	}

	public boolean isSleep() {
		return isSleep;
	}

	public void setSleep(boolean isSleep) {
		this.isSleep = isSleep;
	}

	public boolean isConfu() {
		return isConfu;
	}

	public void setConfu(boolean isConfu) {
		this.isConfu = isConfu;
	}

	public boolean isPara() {
		return isPara;
	}

	public void setPara(boolean isPara) {
		this.isPara = isPara;
	}

	public boolean isFury() {
		return isFury;
	}

	public void setFury(boolean isFury) {
		this.isFury = isFury;
	}

	public boolean isMute() {
		return isMute;
	}

	public void setMute(boolean isMute) {
		this.isMute = isMute;
	}

	public boolean isYouTurn() {
		return youTurn;
	}

	public void setYouTurn(boolean youTurn) {
		this.youTurn = youTurn;
	}
}
